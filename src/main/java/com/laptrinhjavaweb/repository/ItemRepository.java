package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.ItemEntity;

import java.util.List;

public interface ItemRepository extends JpaRepository<ItemEntity, Long>{
    ItemEntity save(ItemEntity item);

    List<ItemEntity> findAllByOrderId(long orderId);

    ItemEntity findById(long itemId);
}
