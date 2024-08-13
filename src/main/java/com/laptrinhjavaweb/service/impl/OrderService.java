package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.OrderConverter;
import com.laptrinhjavaweb.converter.UserConverter;
import com.laptrinhjavaweb.dto.*;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.entity.*;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.repository.OrderRepository;
import com.laptrinhjavaweb.repository.RoleRepository;
import com.laptrinhjavaweb.repository.UserRepository;
import com.laptrinhjavaweb.service.IOrderService;
import com.laptrinhjavaweb.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class OrderService implements IOrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private OrderConverter orderConverter;


    @Override
    public List<OrderDTO> findAllByUserId(long userId) {
        List<OrderDTO> results = new ArrayList<>();
        List<OrderEntity> entities = orderRepository.findAllByUserIdOrderByBuyDateDesc(userId);
//        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

        for (OrderEntity item: entities) {
            OrderDTO orderDTO = orderConverter.convertToDto(item);
            results.add(orderDTO);
        }
        return results;
    }

    @Override
    public OrderDTO findById(long orderId) {
        OrderDTO orderDTO = new OrderDTO();
        OrderEntity orderEntity = orderRepository.findById(orderId);
        orderDTO = orderConverter.convertToDto(orderEntity);
        return orderDTO;
    }

    @Override
    public List<OrderDTO> findAll(Pageable pageable) {
        List<OrderDTO> results = new ArrayList<>();
        List<OrderEntity> entities = orderRepository.findAll(pageable).getContent();
        for (OrderEntity item: entities) {
            OrderDTO orderDTO = orderConverter.convertToDto(item);
            results.add(orderDTO);
        }
        return results;
    }

    @Override
    public int getTotalItem(Pageable pageable) {
        return (int) orderRepository.count();
    }

    @Override
    public OrderDTO save(OrderDTO orderDTO) {
        OrderEntity orderEntity = new OrderEntity();
        if (orderDTO.getId() != null) {
            OrderEntity oldOrderEntity = orderRepository.findById(orderDTO.getId()).orElse(null);
            orderEntity = orderConverter.convertToEntity(orderDTO, oldOrderEntity);
        } else {
            orderEntity = orderConverter.convertToEntity(orderDTO);
        }

        UserEntity userEntity = userRepository.findOneById(orderDTO.getUserDTO().getId());
        orderEntity.setUser(userEntity);
        orderEntity = orderRepository.save(orderEntity);
        return orderConverter.convertToDto(orderEntity);
    }

    @Override
    public List<OrderDTO> searchOrder(String keyword, Pageable pageable) {
        List<OrderDTO> results = new ArrayList<>();
        List<OrderEntity> entities = orderRepository.searchOrder(keyword, pageable).getContent();
        for (OrderEntity item: entities) {
            OrderDTO orderDTO = orderConverter.convertToDto(item);
            results.add(orderDTO);
        }
        return results;
    }

    @Override
    public int getTotalItem(String keyword) {
        List<OrderEntity> entities = orderRepository.searchOrder(keyword);
        return entities.size();
    }


}
