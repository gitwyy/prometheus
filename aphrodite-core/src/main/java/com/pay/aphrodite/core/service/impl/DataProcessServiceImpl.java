package com.pay.aphrodite.core.service.impl;

import com.pay.aphrodite.core.service.DataProcessService;
import jdk.nashorn.internal.objects.DataPropertyDescriptor;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;

/**
 * @ClassName: DataProcessServiceImpl
 * @Author: yangyang.wang
 * @Date:  
 * @Version: 1.0
 * @Description: 数据处理业务类
 *
 **/
@Service
public class DataProcessServiceImpl implements DataProcessService {

    @Override
    public File processData(String localFile) {
        File file = new File(localFile);
        if(file.isDirectory()){

        }else if(file.isFile()){

        }


        return null;
    }

    @Override
    public void uploadData(String localFile, String lfsFile) {

    }
}