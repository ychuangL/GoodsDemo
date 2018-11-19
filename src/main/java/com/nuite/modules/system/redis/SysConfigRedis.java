package com.nuite.modules.system.redis;

import com.nuite.common.utils.RedisKeys;
import com.nuite.common.utils.RedisUtils;
import com.nuite.modules.system.entity.SystemConfigEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 系统配置Redis
 *
 * @author chenshun
 * @email sunlightcs@gmail.com
 * @date 2017/7/18 21:08
 */
@Component
public class SysConfigRedis {
    @Autowired
    private RedisUtils redisUtils;

    public void saveOrUpdate(SystemConfigEntity config) {
        if (config == null) {
            return;
        }
        String key = RedisKeys.getSysConfigKey(config.getKey());
        redisUtils.set(key, config);
    }

    public void delete(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        redisUtils.delete(key);
    }

    public SystemConfigEntity get(String configKey) {
        String key = RedisKeys.getSysConfigKey(configKey);
        return redisUtils.get(key, SystemConfigEntity.class);
    }
}
