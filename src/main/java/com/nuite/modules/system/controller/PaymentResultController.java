package com.nuite.modules.system.controller;

import com.nuite.modules.system.service.ValidatePaymentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: yangchuang
 * @Date: 2018/6/27 14:37
 * @Version: 1.0
 * @Description:
 */

@RestController
@RequestMapping("/goods")
public class PaymentResultController {

    @Autowired
    ValidatePaymentStateService vService;

    /**
     *
     * @param str 传入编号字符串
     * @return -1 传入的字符串为空； 0 支付正常 ； >0 未支付数量
     */
    @RequestMapping("/getPaymentResult")
    public Integer getPaymentStateResult(@RequestParam(value="epcStr",required = false) String str){
        if (str == null || str ==""){
//            System.out.println("传入的字符串为空");
            return -1;
        }
         return   vService.queryPaymentState(str);
    }
}
