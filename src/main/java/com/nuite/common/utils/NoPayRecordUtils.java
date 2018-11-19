package com.nuite.common.utils;

import com.nuite.config.YmlConfig;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.Properties;

/**
 * 未支付记录日志工具
 *
 * @Author: yangchuang
 * @Date: 2018/6/28 10:21
 * @Version: 1.0
 * @Description:
 */

public class NoPayRecordUtils {

    private static String BASELOGDIR;

    static{
        BASELOGDIR = PropertiesUtils.readFromFile("noPayRecord.log.dir");
    }

    public static void wirteToLogTxt(String identifier){

        File dir=new File(BASELOGDIR);
        if (!dir.exists()){
            dir.mkdirs();
        }

        String currDate=DateUtils.format(new Date(),DateUtils.TIME_PATTERN);
        String filenameDate=DateUtils.format(new Date());

        String filename=filenameDate+".txt";

        File recordFile=new File(dir,filename);

        try (BufferedWriter fw=new BufferedWriter(new FileWriter(recordFile,true));){
            fw.write(identifier+" "+currDate);
            fw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("===============未付款记录日志写入失败=================");
        }

    }

}
