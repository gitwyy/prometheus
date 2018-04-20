package com.pay.aphrodite.core.controller;

import com.pay.aphrodite.core.service.HqlService;
import com.pay.aphrodite.core.service.HqlTaskService;
import com.pay.aphrodite.model.entity.HqlTask;
import com.pay.aphrodite.model.result.ResultBody;
import com.pay.aphrodite.model.result.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName:HqlTaskController
 * @Author: yangyang.wang
 * @Date: 2018-04-19 19:52
 * @Version: 1.0
 * @Description: 管理任务的控制器
 **/
@Controller
@RequestMapping("/hive/task/manage")
public class HqlTaskMangeController {

    @Autowired
    private HqlTaskService hqlTaskService;


    @PostMapping("/task")
    public String addTask(HqlTask hqlTask){
        hqlTaskService.insert(hqlTask);
        return "";
    }


    @PutMapping("/task")
    public ResultBody updateTask(HqlTask hqlTask){
        hqlTaskService.update(hqlTask);
        return new ResultBody(ResultCode.OK);
    }

    @DeleteMapping("/task")
    public ResultBody deleteTask(HqlTask hqlTask){
        hqlTaskService.delete(hqlTask.getId());
        return new ResultBody(ResultCode.OK);
    }


    @GetMapping("/task")
    public ResultBody getTask(HqlTask hqlTask){
        hqlTaskService.insert(hqlTask);
        return new ResultBody(ResultCode.OK);
    }

}
