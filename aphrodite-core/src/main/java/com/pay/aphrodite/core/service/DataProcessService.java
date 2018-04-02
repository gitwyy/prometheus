package com.pay.aphrodite.core.service;

/**
 * @ClassName:DataProcessService
 * @Author: yangyang.wang
 * @Date: 2018-03-30 19:44
 * @Version: 1.0
 * @Description: 数据处理Service,hive导出的数据是固定格式的文本文件
 *               需要将文本文件做处理导出。
 *
 **/
public interface DataProcessService {
    Excel toExcel(String path);
}
