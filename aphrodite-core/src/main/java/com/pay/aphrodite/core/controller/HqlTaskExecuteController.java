package com.pay.aphrodite.core.controller;

import com.pay.aphrodite.core.service.HqlTaskManageService;
import com.pay.aphrodite.model.entity.HqlTask;
import com.pay.aphrodite.model.result.ResultBody;
import com.pay.aphrodite.model.result.ResultCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @ClassName:HqlTaskController
 * @Author: yangyang.wang
 * @Date: 2018-04-19 19:52
 * @Version: 1.0
 * @Description: 管理任务的控制器 portal 提交一个任务调用 core 在任务管理表新增一个任务
 * 新增的任务此时为新提交状态，调用 任务管理的 业务层 处理任务流程 完成一次任务的处理流程
 **/
@RestController
@RequestMapping("/hive/task/manage")
public class HqlTaskExecuteController {

    private static final Logger logger = LoggerFactory.getLogger(HqlTaskExecuteController.class);


    /* @Comment: 处理Hql */
    @Autowired
    private HqlTaskManageService hqlTaskManageService;

    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-30 18:38
     * @Param: [hql]
     * @Return: java.lang.String
     * @Description:
     * @Modifyby:yangyang.wang
     **/
    @PostMapping(value = "/query")
    public ResultBody query(HqlTask hqlTask) {
        StopWatch sw = new StopWatch(" query ");
        sw.start("query");
        List<Map<String, String>> list = hqlTaskManageService.startSelectTask(hqlTask);
        sw.stop();
        logger.debug(sw.prettyPrint());
        return new ResultBody(ResultCode.OK).setResult(list);
    }


    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-30 18:38
     * @Param: [hql, path]
     * @Return: java.lang.String
     * @Description:
     **/
    @PostMapping(value = "/download")
    public ResultBody download(HqlTask hqlTask) {
        // 处理文件下载逻辑
        hqlTaskManageService.startDownLoadTask(hqlTask);
        return new ResultBody(ResultCode.OK);
    }
}
