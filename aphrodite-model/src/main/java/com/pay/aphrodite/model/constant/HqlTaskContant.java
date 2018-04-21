package com.pay.aphrodite.model.constant;

/**
 * @ClassName:HqlTaskContant
 * @Author: yangyang.wang
 * @Date: 2018-04-20 18:23
 * @Version: 1.0
 * @Description: TODO
 **/
public class HqlTaskContant {

    /* @Comment: 任务初始 */
    public static final String INIT = "INIT";
    /* @Comment: 钉钉审核 */
    public static final String DING_AUDIT = "DING_AUDIT";
    /* @Comment: 钉钉审核通过 */
    public static final String DING_AUDIT_PASS = "DING_AUDIT_PASS";
    /* @Comment: 钉钉审核拒绝 */
    public static final String DING_AUDIT_REJECT = "DING_AUDIT_REJECT";
    /* @Comment: 完成 */
    public static final String DONE = "DONE";
    /* @Comment: 查询任务完成 */
    public static final String SELECT_COMPLETE = "SELECT_COMPLETE";
    /* @Comment: 查询任务失败 */
    public static final String SELECT_ERROR = "SELECT_ERROR";
    /* @Comment: HIVE 数据下载本地完成 */
    public static final String HIVE_DOWNLOAD_COMPLETE = "HIVE_DOWNLOAD_COMPLETE";
    /* @Comment: HIVE 数据下载本地失败 */
    public static final String DOWNLOAD_ERROR = "HIVE_DOWNLOAD_ERROR";
    /* @Comment: 本地数据处理完成 */
    public static final String DATA_PROCESS_COMPLETE = "DATA_PROCESS_COMPLETE";
    /* @Comment: 数据上传 LFS 系统完成 */
    public static final String DATA_UP_LFS_COMPLETE = "DATA_UP_LFS_COMPLETE";

}