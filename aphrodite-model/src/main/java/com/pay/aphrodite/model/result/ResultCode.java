package com.pay.aphrodite.model.result;

/**
 * @ClassName:ResultStatusCode
 * @Author: yangyang.wang
 * @Date: 2018-03-31 2:01
 * @Version: 1.0
 * @Description: TODO
 **/
public enum ResultCode implements ResultCodeInterface{

    SUCCESS("SUCCESS","00","处理成功"),ERROR("ERROR","99","处理失败"),
    OK("OK","200","请求成功"),PERMISSION_DENIED("PERMISSION_DENIED","401","没有访问权限");
    private String status;
    private String code;
    private String message;

    ResultCode(String status, String code, String message) {
        this.status = status;
        this.code = code;
        this.message = message;
    }


    public String getStatus() {
        return status;
    }


    public String getCode() {
        return code;
    }


    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return "Result{" +
                "status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
