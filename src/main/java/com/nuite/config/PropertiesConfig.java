package com.nuite.config;

import lombok.Data;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author: yangchuang
 * @Date: 2018/6/28 16:04
 * @Version: 1.0
 * @Description:
 */

@Data
@Component
@PropertySource(name = "abc",value = "classpath:record.properties",ignoreResourceNotFound = false,encoding = "utf-8")
@ConfigurationProperties(prefix = "noPayRecord.log")
public class PropertiesConfig {

//    public String typeAliasesPackage;

//    @Value("${noPayRecord.log.dir}")
    public String  dir;

    public String mapperLocations;

    public Integer i;


}
