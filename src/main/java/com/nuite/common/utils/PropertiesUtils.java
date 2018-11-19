package com.nuite.common.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * properties文件的读写
 *
 * @Author: yangchuang
 * @Date: 2018/6/28 14:16
 * @Version: 1.0
 * @Description:
 */
public class PropertiesUtils {

    private static final String PROPFILENAME="record.properties";

    public static String readFromFile(String key){

        InputStream in=PropertiesUtils.class.getClassLoader().getResourceAsStream(PROPFILENAME);
        Properties prop=new Properties();
        try {
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

       String value=prop.getProperty(key);

        return value;
    };
}
