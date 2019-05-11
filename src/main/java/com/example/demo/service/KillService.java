package com.example.demo.service;

import com.example.demo.exception.ServerBizException;
import com.example.demo.rabbitmq.Sender;
import com.example.demo.redis.RedisUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class KillService
{

    private static final Logger log = LoggerFactory.getLogger(KillService.class);

    @Autowired
    RedisUtils redisUtils;

    @Autowired
    Sender sender;


    /**
     * 根据商品id获取Redis中的库存数量
     * 1）若商品数量小于等于0，说明商品已经被抢购完了，不再插入消息队列
     * 2）若商品数量大于0，说明商品还有，对数量进行减少，并且插入消息队列
     */
    public void secondsKill(String productId)
    {
        log.debug("second kill product id: {}.");
        //TODO 可以增加每个用户只可秒杀一件商品的限制
        String num = redisUtils.get(productId);
        int productNum = Integer.parseInt(num);
        if (productNum <= 0)
        {
            throw new ServerBizException("400");
        }
        else
        {
            redisUtils.decr(productId);
        }
        sender.sendDirectQueue(productId);
    }

}
