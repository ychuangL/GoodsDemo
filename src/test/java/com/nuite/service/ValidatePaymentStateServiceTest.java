package com.nuite.service;

import com.nuite.config.PropertiesConfig;
import com.nuite.modules.system.service.ValidatePaymentStateService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: yangchuang
 * @Date: 2018/6/27 13:35
 * @Version: 1.0
 * @Description:
 */

@RunWith(SpringRunner.class)
@SpringBootTest
//@ComponentScan(basePackages = "com.nuite.modules.system.service.**")
public class ValidatePaymentStateServiceTest {

    @Autowired
    ValidatePaymentStateService vService;

    @Autowired
    PropertiesConfig myConfig;

    @Test
    public void testQueryPaymentState(){
        System.out.println("宝塔镇河妖"+vService);
       Integer state= vService.queryPaymentState("0000000003407810d00000000");
        System.out.println("是否付款："+state);
    }


}
