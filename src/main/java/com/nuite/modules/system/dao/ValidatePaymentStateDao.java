package com.nuite.modules.system.dao;

import org.apache.ibatis.annotations.Param;

/**
 * 验证商品是否付款
 *
 * @Author: yangchuang
 * @Date: 2018/6/26 17:42
 * @Version: 1.0
 * @Description:
 */


public interface ValidatePaymentStateDao {

    /**
     *
     * @param rfidCord
     * @return
     */
    Integer selectIsRemove(@Param("rfidCord") String rfidCord);


    Integer selectPaymentState(@Param("rfidCord") String rfidCord);


}
