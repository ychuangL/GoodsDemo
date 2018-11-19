package com.nuite.dao;

import com.nuite.modules.system.dao.ValidatePaymentStateDao;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: yangchuang
 * @Date: 2018/6/26 18:09
 * @Version: 1.0
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class ValidatePaymentStateDaoTest {

    @Autowired
    ValidatePaymentStateDao validatePaymentStateDao;

    String dir;

    @Test
    public void testSelectIsRemove(){
//        Integer ismove=vDao.selectIsRemove("000000000340763000000000");
        Integer ismove=validatePaymentStateDao.selectIsRemove("000000000340781000000000");


        System.out.println("是否移除："+ismove);
    }

}
