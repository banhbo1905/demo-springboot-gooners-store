package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.ItemDTO;
import com.laptrinhjavaweb.dto.OrderDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.entity.OrderEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.service.impl.ProductService;
import com.laptrinhjavaweb.service.impl.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserService userService;

    public OrderDTO convertToDto (OrderEntity entity){
        OrderDTO result = modelMapper.map(entity, OrderDTO.class);

        UserEntity userEntity = (entity.getUser());
        UserDTO user = userService.findById( userEntity.getId());

        result.setUserDTO(user);
        return result;
    }

    public OrderEntity convertToEntity (OrderDTO dto){
        OrderEntity result = modelMapper.map(dto, OrderEntity.class);
        return result;
    }

    public OrderEntity convertToEntity (OrderDTO dto, OrderEntity entity) {
        entity.setId(dto.getId());
        entity.setBuyDate(dto.getBuyDate());
        entity.setStatus(dto.getStatus());
        entity.setPriceTotal(dto.getPriceTotal());
        return entity;
    }
}
