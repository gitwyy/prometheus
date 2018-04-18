package com.pay.aphrodite.portal.hql.exception;

import java.io.Serializable;

/**
 * @ClassName:SqlFromItemException
 * @Author: yangyang.wang
 * @Date: 2018-04-18 9:35
 * @Version: 1.0
 * @Description: TODO
 **/
public class SqlFromItemException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public SqlFromItemException() {
    }

    public SqlFromItemException(String message) {
        super(message);
    }

    public SqlFromItemException(String message, Throwable cause) {
        super(message, cause);
    }

    public SqlFromItemException(Throwable cause) {
        super(cause);
    }

    public SqlFromItemException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
