package com.pay.aphrodite.query.controller;


import com.pay.aphrodite.model.result.ResultBody;
import com.pay.aphrodite.model.result.ResultCode;
import com.pay.aphrodite.query.service.HqlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:HiveController
 * @Author: yangyang.wang
 * @Date: 2018-03-30 18:37
 * @Version: 1.0
 * @Description: 进行 Hive 查询的入口
 **/

@SuppressWarnings("ALL")
@RestController
@RequestMapping("/hive")
public class HiveController {
    private static final Logger logger = LoggerFactory.getLogger(HiveController.class);


    /* @Comment: 处理Hql */
    @Autowired
    private HqlService hqlService;

    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-30 18:38
     * @Param: [hql]
     * @Return: java.lang.String
     * @Description:
     * @Modifyby:yangyang.wang
     **/
    @PostMapping(value = "/hql/query")
    @ResponseBody()
    public ResultBody hqlQuery(String hql) {
        StopWatch sw = new StopWatch(" query ");
        sw.start();
        List<Map<String, String>> list = hqlService.select(hql);

        list.forEach((m) -> {
            m.entrySet().forEach((e) -> {
                logger.debug("result=[{}:{}]", e.getKey(), e.getValue());
            });
        });
        sw.stop();

        logger.debug(sw.prettyPrint());
        return new ResultBody(ResultCode.OK);
    }


    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-30 18:38
     * @Param: [hql, path]
     * @Return: java.lang.String
     * @Description: TODO
     * @Modifyby:babos
     **/
    @PostMapping(value = "/hql/download")
    @ResponseBody
    public ResultBody hqlDownload(String hql, String path, String task) {
        StopWatch sw = new StopWatch();
        sw.start("hqlDownload");
        // 下载数据到本地目录
        List<Map<String, String>> list = hqlService.load(hql, path);
        sw.stop();
        // 上传数据到LFS目录

        logger.debug(sw.prettyPrint());
        return new ResultBody(ResultCode.OK);
    }
}