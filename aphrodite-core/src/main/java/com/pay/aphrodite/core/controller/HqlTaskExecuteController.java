package com.pay.aphrodite.core.controller;

import com.pay.aphrodite.core.service.HqlService;
import com.pay.aphrodite.model.entity.HqlTask;
import com.pay.aphrodite.model.result.ResultBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @ClassName:HqlTaskExecuteController
 * @Author: yangyang.wang
 * @Date: 2018-04-20 14:14
 * @Version: 1.0
 * @Description: 执行任务的控制器
 **/
@RestController
@RequestMapping("/hive/task")
public class HqlTaskExecuteController {

    @Autowired
    private HqlService hqlService;


    /* 执行任务 不返回信息 异步进行通知  */
    @PostMapping("/load")
    public void loadTask(@RequestParam("hqlTask") HqlTask hqlTask){
        hqlService.load(hqlTask);
    }
}