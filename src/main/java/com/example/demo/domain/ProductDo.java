package com.example.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_seckill_product_info")
public class ProductDo
{
    @Id
    private String id;

    @Column(name = "product_name")
    private String productName;

    @Column(name = "product_num")
    private Long productNum;

    public String getId()
    {
        return id;
    }

    public void setId(String id)
    {
        this.id = id;
    }

    public String getProductName()
    {
        return productName;
    }

    public void setProductName(String productName)
    {
        this.productName = productName;
    }

    public Long getProductNum()
    {
        return productNum;
    }

    public void setProductNum(Long productNum)
    {
        this.productNum = productNum;
    }

    @Override
    public String toString()
    {
        return "ProductDo{" +
                "id='" + id + '\'' +
                ", productName='" + productName + '\'' +
                ", productNum=" + productNum +
                '}';
    }
}
