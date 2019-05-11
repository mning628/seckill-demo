package com.example.demo.rabbitmq;

import com.example.demo.domain.OrderDo;
import com.example.demo.service.OrderService;
import com.example.demo.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Receiver
{

    private final static Logger log = LoggerFactory.getLogger(Receiver.class);

    @Autowired
    ProductService productService;

    @Autowired
    OrderService orderService;

    /**
     * 消息出列，即真正秒杀到商品的用户保存到订单表中，且减少秒杀商品的数量
     */
    @RabbitListener(queues = RabbitMqConfig.QUEUE)
    public void receive(String message)
    {
        log.info("receive seckill request,product id:{}.", message);
        Long productNum = productService.getProductNum(message);
        log.info("product num:{}", productNum);
        if (productNum > 0)
        {
            productService.updateProductNum(message);
            OrderDo orderDo = new OrderDo();
            orderDo.setProductId(message);
            orderDo.setUserId("mn");
            orderService.insertOrderDo(orderDo);
        }
    }
}