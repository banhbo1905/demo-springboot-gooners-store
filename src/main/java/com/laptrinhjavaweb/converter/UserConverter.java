package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.dto.UserDTO;
import com.laptrinhjavaweb.entity.UserEntity;
import com.laptrinhjavaweb.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserConverter {

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO convertToDto (UserEntity entity){
        UserDTO result = modelMapper.map(entity, UserDTO.class);
        return result;
    }

    public UserEntity convertToEntity (UserDTO dto){
        UserEntity result = modelMapper.map(dto, UserEntity.class);
        return result;

    }

    public UserEntity convertToEntity (UserDTO dto, UserEntity entity) {
        entity.setUserName(dto.getUserName());
        entity.setFullName(dto.getFullName());
        entity.setEmail(dto.getEmail());
        entity.setPassword(dto.getPassword());
        entity.setStatus(dto.getStatus());
        entity.setAddress(dto.getAddress());
        entity.setPhone(dto.getPhone());
        return entity;
    }
}
