package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.OrderEntity;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IOrderService {
    List<OrderDTO> findAllByUserId(long userId);

    OrderDTO findById(long orderId);

    List<OrderDTO> findAll(Pageable pageable);
    int getTotalItem(Pageable pageable);

    OrderDTO save(OrderDTO orderDTO);

    List<OrderDTO> searchOrder(String keyword, Pageable pageable);

    int getTotalItem(String keyword);
}
