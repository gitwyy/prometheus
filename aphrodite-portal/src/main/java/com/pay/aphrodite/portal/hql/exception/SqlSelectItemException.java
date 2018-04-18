package com.pay.aphrodite.portal.hql.exception;

import java.io.Serializable;

/**
 * @ClassName:SqlSelectException
 * @Author: yangyang.wang
 * @Date: 2018-04-18 9:01
 * @Version: 1.0
 * @Description: select item 异常类
 **/
public class SqlSelectItemException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public SqlSelectItemException(){
        super();
    }

    public SqlSelectItemException(String message){
        super(message);
    }

    public SqlSelectItemException(String message,Throwable e){
        super(message,e);
    }
}
