package com.pay.aphrodite.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @ClassName:HqlTaskController
 * @Author: yangyang.wang
 * @Date: 2018-04-19 19:52
 * @Version: 1.0
 * @Description: 处理HQL任务控制器
 **/
@RestController
@RequestMapping("/hive/task")
public class HqlTaskController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/testRest")
    public String testRest(){
        String forObject = restTemplate.getForObject("http://wwww.baidu.com", String.class);
        System.out.println(forObject);
        return "aaaaa";
    }
}
