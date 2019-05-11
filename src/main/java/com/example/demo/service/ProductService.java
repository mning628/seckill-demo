package com.example.demo.service;

import com.example.demo.domain.ProductDo;
import com.example.demo.domain.ProductDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService
{

    @Autowired
    ProductDoRepository productDoRepository;

    public Long getProductNum(String productId)
    {
        ProductDo productDo = productDoRepository.findOne(productId);
        if (productDo != null)
        {
            return productDo.getProductNum();
        }
        else
        {
            return null;
        }
    }


    public void updateProductNum(String productId)
    {
        productDoRepository.updateProductNum(productId);
    }
}
