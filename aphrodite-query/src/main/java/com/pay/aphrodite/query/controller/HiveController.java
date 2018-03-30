package com.pay.aphrodite.query.controller;


import com.pay.aphrodite.model.enums.Result;
import com.pay.aphrodite.query.service.HqlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:HiveController
 * @Author: yangyang.wang
 * @Date: 2018-03-30 18:37
 * @Version: 1.0
 * @Description: 进行 Hive 查询的入口
 *
 **/

@Controller
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
     * @Description: TODO
     * @Modifyby:yangyang.wang
     **/
    @RequestMapping(value="/hql/query",method = RequestMethod.POST)
    @ResponseBody
    public String hqlQuery(String hql){
        StopWatch sw = new StopWatch();
        List<Map<String, String>> list = hqlService.get(hql);

        list.forEach((m)->{m.entrySet().forEach((e)->{
            logger.debug("result=[{}:{}]",e.getKey(),e.getValue());
        });});
        sw.stop();

        logger.debug(sw.prettyPrint());
        return Result.SUCCESS.toJson("detail","executeHQL");
    }


    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-30 18:38
     * @Param: [hql, path]
     * @Return: java.lang.String
     * @Description: TODO
     * @Modifyby:babos
     **/
    @RequestMapping(value="/hql/download",method = RequestMethod.POST)
    @ResponseBody
    public String hqlDownload(String hql,String path){
        StopWatch sw = new StopWatch();
        sw.start("hqlDownload");
        List<Map<String, String>> list = hqlService.load(hql, path);
        sw.stop();
        logger.debug(sw.prettyPrint());
        list.forEach((m)->{m.entrySet().forEach((e)->{
            logger.debug("result=[{}:{}]",e.getKey(),e.getValue());
        });});
        return Result.SUCCESS.toJson("detail","hqlDownload");
    }
}