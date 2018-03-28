package com.pay.aphrodite.model.enums;

public enum Result {

    SUCCESS("SUCCESS","00","处理成功"),ERROR("ERROR","99","处理失败");

    private String status;
    private String code;
    private String message;

    Result(String status, String code, String message) {
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
        return "{" +
                "status='" + status + '\'' +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
