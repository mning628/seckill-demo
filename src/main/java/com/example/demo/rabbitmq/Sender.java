package com.example.demo.rabbitmq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Sender
{

    private static final Logger log = LoggerFactory.getLogger(Sender.class);

    @Autowired
    AmqpTemplate amqpTemplate;

    /**
     * 消息入队-在需要的时候调用即可
     * msg此为商品的id，根据此id在消费消息时验证Redis中商品的库存是否充足
     */
    public void sendDirectQueue(String msg)
    {
        log.debug("seckill requeset has send, product id:{}", msg);
        try
        {
            amqpTemplate.convertAndSend(RabbitMqConfig.QUEUE, msg);
        }
        catch (AmqpException e)
        {
            log.error("请求发送异常.", e);
        }
    }
}
