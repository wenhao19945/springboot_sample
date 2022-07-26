package com.sutpc.its.listener;

import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.KeyExpirationEventMessageListener;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;

/**
 * @Author:wenhao
 * @Data: Created in 15:14 2021/4/29.
 * @Description:
 */
@Slf4j
public class KeyExpiredListener extends KeyExpirationEventMessageListener {

    @Autowired
    private RedisTemplate redisTemplate;

    public KeyExpiredListener(RedisMessageListenerContainer listenerContainer) {
        super(listenerContainer);
    }

    @Override
    public void onMessage(Message message, byte[] pattern) {
        if (Objects.nonNull(message)) {
            log.info("过期key:" + message.toString());
        }
    }
}
