package com.nuite.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: yangchuang
 * @Date: 2018/6/28 17:36
 * @Version: 1.0
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class YmlConfigTest {

    @Autowired
    YmlConfig ymlConfig;

    @Test
    public void test(){
        System.out.println(ymlConfig.getDir());
    }
}
