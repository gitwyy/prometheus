package com.pay.aphrodite.model.result;

import com.sun.org.apache.regexp.internal.RE;

/**
 * 返回体
 *
 * Created by bysocket on 14/03/2017.
 */
public class ResultBody {
    /**
     * 响应代码
     */
    private String code;
    /**
     * 响应消息
     */
    private String message;

    /* @Comment: 响应状态 */
    private String status;

    /**
     * 响应结果
     */
    private Object result;

    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-31 12:00
     * @Param: [resultCode] :
     * @Return:  :
     * @Description: 异常结果 传入异常 返回码
     * @Modifyby:
     **/
    public ResultBody(ResultCodeInterface resultCode) {
        this.code = resultCode.getCode();
        this.message = resultCode.getMessage();
        this.status = resultCode.getStatus();
    }

    /**
     * @Author: yangyang.wang
     * @Date: 2018-03-31 2:20
     * @Param: [result] :
     * @Return:  :
     * @Description: 正常结果直接返回对象
     * @Modifyby:
     **/
    public ResultBody(Object result) {
        this.code = ResultCode.SUCCESS.getCode();
        this.message = ResultCode.SUCCESS.getMessage();
        this.status = ResultCode.SUCCESS.getStatus();
        this.result = result;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public void setStatus(String status) { this.status = status; }

    public String getStatus() { return status; }

    @Override
    public String toString() {
        return "ResultBody{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", status='" + status + '\'' +
                ", result=" + result +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ResultBody)) return false;

        ResultBody that = (ResultBody) o;

        if (code != null ? !code.equals(that.code) : that.code != null) return false;
        if (message != null ? !message.equals(that.message) : that.message != null) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        return result != null ? result.equals(that.result) : that.result == null;
    }

    @Override
    public int hashCode() {
        int result1 = code != null ? code.hashCode() : 0;
        result1 = 31 * result1 + (message != null ? message.hashCode() : 0);
        result1 = 31 * result1 + (status != null ? status.hashCode() : 0);
        result1 = 31 * result1 + (result != null ? result.hashCode() : 0);
        return result1;
    }
}