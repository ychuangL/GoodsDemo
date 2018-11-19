package com.nuite.utils;

import com.nuite.common.utils.StringParseUtils;
import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: yangchuang
 * @Date: 2018/6/28 8:57
 * @Version: 1.0
 * @Description:
 */
public class StringParseUtilsTest {

    @Test
    public  void testParseString(){
        //000000000340781000000000,000000000340776000000000,000000000340780000000000
        String str="000000000340781000000000";

        Arrays.stream(StringParseUtils.parseString(str)).forEach(System.out::println);

    }

    @Test
    public void test1(){
      Integer a=-1;

        System.out.println(a);


    }
}
