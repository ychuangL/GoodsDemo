package com.nuite.common.utils;

/**
 * @Author: yangchuang
 * @Date: 2018/6/28 8:50
 * @Version: 1.0
 * @Description:
 */
public class StringParseUtils {

    /**
     * 将字符串以,分割，返回字符串数组
     * @param str
     * @return
     */
    public static String[] parseString(String str){

        if (str == null){
            return  null;
        }

        return str.split(",");
    }
}
