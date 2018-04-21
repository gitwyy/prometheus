package com.pay.aphrodite.portal.controller;

import com.pay.aphrodite.portal.service.HqlTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @ClassName:HqlTaskManageControler
 * @Author: yangyang.wang
 * @Date: 2018-04-21 20:59
 * @Version: 1.0
 * @Description: Hive 任务管理控制器
 **/
@Controller
public class HqlTaskManageController {

    @Autowired
    private HqlTaskService hqlTaskService;
}
