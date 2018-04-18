package com.pay.aphrodite.portal.hql.exception;

import java.io.Serializable;

/**
 * @ClassName:SqlWhereItemException
 * @Author: yangyang.wang
 * @Date: 2018-04-18 9:35
 * @Version: 1.0
 * @Description: sql where 元素异常类
 **/
public class SqlWhereItemException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public SqlWhereItemException() {
    }

    public SqlWhereItemException(String message) {
        super(message);
    }

    public SqlWhereItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlWhereItemException(Throwable cause) {
        super(cause);
    }

    public SqlWhereItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
