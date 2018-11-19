package com.nuite.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: yangchuang
 * @Date: 2018/6/28 18:39
 * @Version: 1.0
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class PropertiesConfigTest {

    @Autowired
    PropertiesConfig propertiesConfig;

    @Test
    public  void  test(){

        System.out.println("测试结果："+propertiesConfig.getDir());
    }
}
