package com.example.demo.controller;

import com.example.demo.service.KillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class KillController
{

    @Autowired
    KillService killService;

    /**
     * 秒杀入口
     */
    @RequestMapping(value = "secondsKill", method = RequestMethod.GET)
    public void secondsKill(@RequestParam("product_id") String productId)
    {
        killService.secondsKill(productId);
    }

}
