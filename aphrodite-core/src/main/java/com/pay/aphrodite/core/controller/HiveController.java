package com.pay.aphrodite.core.controller;


import com.pay.aphrodite.core.service.HqlService;
import com.pay.aphrodite.model.result.ResultBody;
import com.pay.aphrodite.model.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:HiveController
 * @Author: yangyang.wang
 * @Date: 2018-03-30 18:37
 * @Version: 1.0
 * @Description: 进行 Hive 查询的入口
 **/

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
    public ResultBody hqlQuery(String hql) {
        StopWatch sw = new StopWatch(" query ");
        sw.start();
        List<Map<String, String>> list = hqlService.select(hql);

        list.forEach((m) -> {
            m.entrySet().forEach((e) -> {
                logger.debug(">>>>>>>>>>>>>>>>>>>>>result=[{}:{}]", e.getKey(), e.getValue());
            });
        });
        sw.stop();

        logger.debug(sw.prettyPrint());
        return new ResultBody(ResultCode.OK).setResult(list);
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
    public ResultBody hqlDownload(@RequestParam("hql")String hql, @RequestParam("path")String path, @RequestParam("taskName")String taskName, @RequestParam("operator")String operator) {
        // 处理文件下载逻辑
        hqlService.load(hql, path);
        return new ResultBody(ResultCode.OK);
    }
}