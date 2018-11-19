package com.nuite.modules.system.service.impl;

import com.nuite.common.utils.NoPayRecordUtils;
import com.nuite.common.utils.StringParseUtils;
import com.nuite.modules.system.dao.ValidatePaymentStateDao;
import com.nuite.modules.system.service.ValidatePaymentStateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: yangchuang
 * @Date: 2018/6/27 13:23
 * @Version: 1.0
 * @Description:
 */

@Service
public class ValidatePaymentStateServiceImpl implements ValidatePaymentStateService {

    @Autowired
    ValidatePaymentStateDao vDao;

    /**
     *
     * @param str 一串字符码
     * @return 0表示正常、已付款 ，  >0 表示未付款商品数量
     */
    @Override
    public Integer queryPaymentState(String str) {

        String[] arr= StringParseUtils.parseString(str);
        //未支付数量统计
        int noPayCount=0;

        for (String code : arr){
            Integer ismove=vDao.selectIsRemove(code);
            //先判断该号是否存在
            if (ismove != null){
                if (ismove == 0){
                    //该编号未移除，可能存在已付款
                    Integer paymentState= vDao.selectPaymentState(code);
                    if (paymentState == null || paymentState==0){
                        //如果不存在支付记录，或未支付
                        noPayCount++;
                        //写入记录文件
                        NoPayRecordUtils.wirteToLogTxt(code);
                    }
                    //paymentState == 1 已支付
                };

                //if (ismove == 1) //该编号移除，表示已付款，返回0
            }
        }
//        System.out.println("===============未付款："+noPayCount+"==================");
        return noPayCount;
    }
}
