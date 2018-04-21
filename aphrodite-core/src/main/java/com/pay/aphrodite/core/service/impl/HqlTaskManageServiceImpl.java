package com.pay.aphrodite.core.service.impl;

import com.pay.aphrodite.core.dao.mysql.HqlTaskManageDao;
import com.pay.aphrodite.core.service.DataProcessService;
import com.pay.aphrodite.core.service.HqlExecuteService;
import com.pay.aphrodite.core.service.HqlTaskLogService;
import com.pay.aphrodite.core.service.HqlTaskManageService;
import com.pay.aphrodite.model.constant.HqlTaskContant;
import com.pay.aphrodite.model.entity.HqlTask;
import com.pay.aphrodite.model.entity.HqlTaskLog;
import com.pay.aphrodite.model.entity.HqlTaskManage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:HqlTaskManageServiceImpl
 * @Author: yangyang.wang
 * @Date: 2018-04-21 1:41
 * @Version: 1.0
 * @Description: Task 任务流程的管理  开始一个任务 ->
 **/
@Service
public class HqlTaskManageServiceImpl implements HqlTaskManageService {

    private final Logger log = LoggerFactory.getLogger(HqlTaskManageServiceImpl.class);

    @Value("${aphrodite.local.hive.path}")
    private String localPath;

    @Value("${aphrodite.lfs.hive.path}")
    private String lfsPath;


    @Autowired
    /* @Comment: 任务管理表操作 */
    private HqlTaskManageDao hqlTaskManageDao;

    @Autowired
    /* @Comment: 执行 hql 任务 */
    private HqlExecuteService hqlExecuteService;

    @Autowired
    /* @Comment: 记录任务日志 */
    private HqlTaskLogService hqlTaskLogService;

    @Autowired
    /* @Comment: 数据处理器 */
    private DataProcessService dataProcessService;

    @Override
    public List<Map<String, String>> startSelectTask(HqlTask hqlTask) {
        HqlTaskManage hqlTaskManage = new HqlTaskManage().setTaskNo(hqlTask.getTaskNo())
                .setTaskStatus(HqlTaskContant.INIT)
                .setOperator(hqlTask.getOperator());
        this.insert(hqlTaskManage);
        log.info("[QUERY] hqlTask[{}] hqlTaskManage[{}]",hqlTask,hqlTaskManage);
        List<Map<String, String>> maps = hqlExecuteService.select(hqlTask.getFinalHql());

        this.update(hqlTaskManage.setCompleteTime(new Date())
                .setTaskStatus(HqlTaskContant.SELECT_COMPLETE)
                .setRemark(CollectionUtils.isEmpty(maps)?"SELECT RESULT IS EMPTY":
                                String.format("SELECT RESULT DATA SET SIZE [%d]",maps.size())));
        return maps;
    }

    @Override
    public void startDownLoadTask(HqlTask hqlTask) {
        HqlTaskManage hqlTaskManage = new HqlTaskManage().setTaskNo(hqlTask.getTaskNo())
                .setTaskStatus(HqlTaskContant.INIT).setOperator(hqlTask.getOperator());
        this.insert(hqlTaskManage);
        log.info("[DOWNLOAD] hqlTask[{}] hqlTaskManage[{}]",hqlTask,hqlTaskManage);
        String localFile = localPath+hqlTask.getTaskNo();
        String lfsFile = lfsPath+hqlTask.getTaskNo();

        hqlExecuteService.download(hqlTask.getFinalHql(),localFile);
        this.update(hqlTaskManage.setTaskStatus(HqlTaskContant.HIVE_DOWNLOAD_COMPLETE));

        dataProcessService.processData(localFile);
        this.update(hqlTaskManage.setTaskStatus(HqlTaskContant.DATA_PROCESS_COMPLETE));

        dataProcessService.uploadData(localFile,lfsFile);
        this.update(hqlTaskManage.setTaskStatus(HqlTaskContant.DATA_UP_LFS_COMPLETE));

    }

    @Override
    @Transactional
    public Long insert(HqlTaskManage hqlTaskManage) {
        hqlTaskLogService.insert(new HqlTaskLog().setTaskNo(hqlTaskManage.getTaskNo()).setTaskStep(hqlTaskManage.getTaskStatus()).setOperator(hqlTaskManage.getOperator()).setRemark("任务开始"));
        Long id = hqlTaskManageDao.insert(hqlTaskManage);
        return id;
    }

    @Override
    @Transactional
    public void update(HqlTaskManage hqlTaskManage) {
        hqlTaskLogService.insert(new HqlTaskLog()
                .setTaskNo(hqlTaskManage.getTaskNo())
                .setTaskStep(hqlTaskManage.getTaskStatus())
                .setOperator(hqlTaskManage.getOperator())
                .setRemark(hqlTaskManage.getRemark())
                .setLfsPath(hqlTaskManage.getLfsPath())
        );
        hqlTaskManageDao.updateByPrimaryKeySelective(hqlTaskManage);
    }
}