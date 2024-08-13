package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ItemEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.OrderEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.sql.Date;
import java.util.List;

public interface OrderRepository extends JpaRepository<OrderEntity, Long>{
    OrderEntity save(OrderEntity order);

//    List<OrderEntity> findById(long userId);

    OrderEntity findById(long OrderId);

    List<OrderEntity> findAllByUserIdOrderByBuyDateDesc(long userId);

    Page<OrderEntity> findAll(Pageable pageable);

    @Query("select o from OrderEntity o where o.buyDate =:keyword or o.user.userName like %?1%")
    Page<OrderEntity> searchOrder(String keyword, Pageable pageable);

    @Query("select o from OrderEntity o where o.buyDate =:keyword or o.user.userName like %?1%")
    List<OrderEntity> searchOrder(String keyword);

//    @Query("select o from OrderEntity o where o.priceTotal =:keywordPricetotal  or o.id =:keywordID or o.buyDate =:keywordDate or o.user.userName like %?1%")
//    List<OrderEntity> searchOrder(String keyword, long keywordID, Date keywordDate, float keywordPricetotal);

}
