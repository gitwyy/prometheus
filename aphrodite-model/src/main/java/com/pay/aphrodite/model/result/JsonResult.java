package com.pay.aphrodite.model.result;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName:JsonResult
 * @Author: yangyang.wang
 * @Date: 2018-04-20 0:27
 * @Version: 1.0
 * @Description: json 结果
 **/
public class JsonResult implements Serializable {

    private int code;   //返回码 非0即失败
    private String msg; //消息提示
    private Map<String, Object> data; //返回的数据

    public JsonResult(){};

    public JsonResult(int code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public static String success() throws JsonProcessingException {
        return success(new HashMap<>(0));
    }
    public static String success(Map<String, Object> data) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new JsonResult(0, "解析成功", data));
    }

    public static String failed() throws JsonProcessingException {
        return failed("解析失败");
    }
    public static String failed(String msg) throws JsonProcessingException {
        return failed(-1, msg);
    }
    public static String failed(int code, String msg) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(new JsonResult(code, msg, new HashMap<>(0)));
    }

}
