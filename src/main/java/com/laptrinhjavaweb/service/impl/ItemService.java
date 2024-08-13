package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.ItemConverter;
import com.laptrinhjavaweb.converter.OrderConverter;
import com.laptrinhjavaweb.dto.ItemDTO;
import com.laptrinhjavaweb.dto.ItemDTO;
import com.laptrinhjavaweb.entity.ItemEntity;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.ItemRepository;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.service.IItemService;
import com.laptrinhjavaweb.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;


    @Autowired
    private ItemConverter itemConverter;


    @Override
    public List<ItemDTO> findAllByOrderId(long orderId) {
        List<ItemDTO> results = new ArrayList<>();
        List<ItemEntity> entities = itemRepository.findAllByOrderId(orderId);
        System.out.println(entities.toArray().length);

        for (ItemEntity item: entities) {
            ItemDTO itemDTO = itemConverter.convertToDto(item);
            results.add(itemDTO);


        }
        return results;

    }

    @Override
    public ItemDTO findById(long itemId) {
        ItemDTO itemDTO = new ItemDTO();
        ItemEntity itemEntity = itemRepository.findById(itemId);
        itemDTO = itemConverter.convertToDto(itemEntity);
        return itemDTO;
    }
}
