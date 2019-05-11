package com.example.demo.service;

import com.example.demo.domain.OrderDo;
import com.example.demo.domain.OrderDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService
{

    @Autowired
    OrderDoRepository orderDoRepository;

    public void insertOrderDo(OrderDo orderDo)
    {
        orderDoRepository.saveAndFlush(orderDo);
    }
}
