package com.pay.aphrodite.model.result;

/**
 * @ClassName:ResultCodeInterface
 * @Author: yangyang.wang
 * @Date: 2018-03-31 2:08
 * @Version: 1.0
 * @Description: 返回码接口
 **/
public interface ResultCodeInterface {

    /* @Comment: 状态 */
    public String getStatus();

    /* @Comment: 返回码*/
    public String getCode();

    /* @Comment: 描述信息*/
    public String getMessage();
}
