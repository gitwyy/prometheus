package com.pay.aphrodite.util;

import org.apache.commons.lang3.RandomUtils;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringJoiner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

/**
 * @ClassName:GenerateNo
 * @Author: yangyang.wang
 * @Date: 2018-04-20 17:27
 * @Version: 1.0
 * @Description: 随机数生成一般使用的编号
 **/
public class GenerateNoUtils {

    public static String generateDateRandomNo(Integer len) {
        return new StringBuilder()
                .append(LocalDate.now().format(DateTimeFormatter.BASIC_ISO_DATE))
                .append(RandomUtils.nextLong()).substring(0, len).toString();
    }

}
