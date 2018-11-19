package com.nuite.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

/**
 * @Author: yangchuang
 * @Date: 2018/6/28 17:30
 * @Version: 1.0
 * @Description:
 */

@Data
@Configuration
@ConfigurationProperties("log.noPayRecord")
public class YmlConfig {

    private String dir;


}
