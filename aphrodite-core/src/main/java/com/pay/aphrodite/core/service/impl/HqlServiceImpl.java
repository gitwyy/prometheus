package com.pay.aphrodite.core.service.impl;

import com.pay.aphrodite.core.dao.hive.HqlExecuteDao;
import com.pay.aphrodite.core.dao.mysql.HqlTaskLogDao;
import com.pay.aphrodite.core.service.HqlService;
import com.pay.aphrodite.core.service.HqlTaskLogService;
import com.pay.aphrodite.core.service.HqlTaskService;
import com.pay.aphrodite.model.entity.HqlTask;
import com.pay.aphrodite.model.entity.HqlTaskLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

@Service
public class HqlServiceImpl implements HqlService {

    @Value("aphrodite.lfs.hive.path")
    private String lfsHivePath;
    @Value("aphrodite.local.hive.path")
    private String localHivePath;

    @Autowired
    private HqlExecuteDao hqlDao;

    @Autowired
    private HqlTaskLogService hqlTaskLogService;

    @Override
    public List<Map<String, String>> select(String hql) {
        return hqlDao.select(hql);
    }

    /**
     * @Author: yangyang.wang
     * @Date: 2018-04-20 10:24
     * @Param: [hql, localPath] :
     * @Return: java.util.List<java.util.Map<java.lang.String,java.lang.String>> :
     * @Description: 将数据导出到文件 并上传到 LFS 系统。
     * 文件下载到本地上传LFS是一个组合操作，尽量让文件最总落地在分布式文件系统，方便后面管理。
     **/
    @Override
    public void load(HqlTask hqlTask) {

        String localPath = createFilePath(hqlTask, localHivePath);
        hqlDao.load(hqlTask.getFinalHql(),localPath);
        // 数据下载到指定目录 目录格式 类似于 path/000000_0
        /* TODO 处理下载的文件 生成一个文件 （根据需要进行格式转换）*/
        String lfsPath = createFilePath(hqlTask, lfsHivePath);

        /* TODO 将上传LFS 的文件地址写入 HIVE_TASK_LOG 表, 用于后续通知以及下载任务*/
        HqlTaskLog log = new HqlTaskLog();
        hqlTaskLogService.insert(log);




    }

    private String createFilePath(HqlTask hqlTask,String pathPrefix){
        String taskName = hqlTask.getTaskName();
        String timestamp= LocalDateTime.now()
                .format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return new StringJoiner("_",pathPrefix,timestamp)
                .add(taskName).toString();
    }

}
