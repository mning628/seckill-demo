package com.example.demo.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ProductDoRepository extends JpaRepository<ProductDo, String>
{
    @Query(value = "update ProductDo set productNum = productNum-1 where id=?1")
    @Modifying
    @Transactional
    int updateProductNum(String productId);

}