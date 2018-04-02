package com.pay.aphrodite.util;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import java.util.Base64;

/**
 * @ClassName:Base64Util
 * @Author: yangyang.wang
 * @Date: 2018-04-01 3:33
 * @Version: 1.0
 * @Description: 使用ThreadLocal 线程安全的 Base64 工具类
 **/
public class Base64Util {

    public static String decode(String s) {
        if (s == null) return null;
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] b = decoder.decodeBuffer(s);
            return new String(b);
        } catch (Exception e) {
            return null;
        }
    }

    public static String encode(String s) {
        if (s == null) return null;
        BASE64Encoder encoder = new BASE64Encoder();
        try {
            return encoder.encode(s.getBytes());
        } catch (Exception e) {
            return null;
        }
    }
}
