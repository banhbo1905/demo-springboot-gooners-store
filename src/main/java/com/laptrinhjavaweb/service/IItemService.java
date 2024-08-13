package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.ItemDTO;
import com.laptrinhjavaweb.dto.OrderDTO;

import java.util.List;

public interface IItemService {
    List<ItemDTO> findAllByOrderId(long orderId);
    ItemDTO findById(long itemId);

}
