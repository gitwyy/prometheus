package com.pay.aphrodite.model.filter;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.pay.aphrodite.model.result.ResultBody;
import com.pay.aphrodite.model.result.ResultCode;
import com.pay.aphrodite.util.Base64Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.regex.Pattern;

/**
 * @ClassName:AuthFilter
 * @Author: yangyang.wang
 * @Date: 2018-03-31 1:01
 * @Version: 1.0
 * @Description: TODO
 **/
public class AuthFilter implements Filter {

    /* @Comment: json 格式传输 权限组数据 */
    public static final String AUTH_PARAMS = "authParams";
    public static final String IS_PASSWORD = "isPassword";
    private final Logger log = LoggerFactory.getLogger(AuthFilter.class);
    private AtomicBoolean isPassword;

    private Map<String, String> authStore;

    @Override
    public void init(FilterConfig config) throws ServletException {
        try {
            log.debug("init AuthFilter config {}", config);
            String parameter = config.getInitParameter(AUTH_PARAMS);
            String isPass = config.getInitParameter(IS_PASSWORD);
            isPassword = new AtomicBoolean("Y".equals(isPass));
            ObjectMapper mapper = new ObjectMapper();
            authStore = mapper.readValue(parameter, Map.class);
        } catch (Exception e) {
            log.warn("init AuthFilter Exception {}", e);
        }
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        ResultCode resultCode = checkHTTPBasicAuthorize(request);
        if (resultCode != ResultCode.OK) {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setCharacterEncoding("UTF-8");
            httpResponse.setContentType("application/json; charset=utf-8");
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            ObjectMapper mapper = new ObjectMapper();
            ResultBody resultBody = new ResultBody(resultCode);
            httpResponse.getWriter().write(mapper.writeValueAsString(resultBody));
            return;
        } else {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {
        log.debug("i am going to dead please don't miss me in the future ~ ~");
    }


    private ResultCode checkHTTPBasicAuthorize(ServletRequest request) {
        try {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            String auth = httpRequest.getHeader("Authorization");
            if ((auth != null) && (auth.length() > 6)) {
                String HeadStr = auth.substring(0, 5).toLowerCase();
                if (HeadStr.compareTo("basic") == 0) {
                    auth = auth.substring(6, auth.length());
                    String decodedAuth = Base64Util.encode(auth);
                    if (decodedAuth != null) {
                        String[] UserArray = decodedAuth.split(":");

                        if (UserArray != null && UserArray.length == 2) {
                            if (authStore.containsKey(UserArray[0])
                                    && UserArray[1].compareTo(authStore.get(UserArray[0])) == 0) {
                                return ResultCode.OK;
                            }
                        }
                    }
                }
            }
            return ResultCode.PERMISSION_DENIED;
        } catch (Exception ex) {
            log.error("checkHTTPBasicAuthorize error {}", ex);
            return ResultCode.PERMISSION_DENIED;
        }
    }

    private ResultCode checkHTTPBasicIpUrl(ServletRequest request) {
        try {
            String remoteHost = request.getRemoteHost();
            String remoteAddr = request.getRemoteAddr();
            log.debug("remote host : [{}],remote addr : [{}]", remoteHost, remoteAddr);

            Boolean pass = authStore.keySet().stream()
                    .map(ip -> {
                        log.debug("check uri {} & ip {}",remoteAddr,remoteHost);
                        if (ip.equals(remoteHost) || "*.*.*.*".equals(remoteHost)) {
                            return true;
                        } else if (ip.contains("*")) {
                            String uri = authStore.get(ip);
                            return uri.equals(remoteAddr) &&
                                    Pattern.compile(ip.replace(".", "\\.").replace("*", ".*"))
                                            .matcher(ip).group(0).equals(ip);
                        } else {
                            return false;
                        }
                    }).reduce(false, (b, a) -> b |= a);
            return ResultCode.OK;
        } catch (Exception e) {
            log.error("checkHTTPBasicIpUrl error {}", e);
            return ResultCode.PERMISSION_DENIED;
        }
    }
}