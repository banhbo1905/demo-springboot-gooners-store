package com.laptrinhjavaweb.converter;

import com.laptrinhjavaweb.dto.ItemDTO;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.ItemEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.service.impl.ProductService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemConverter {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ProductService productService;

    public ItemDTO convertToDto (ItemEntity entity){
        ItemDTO result = modelMapper.map(entity, ItemDTO.class);
//        return result;

        ProductEntity productEntity = (entity.getProduct());
        ProductDTO product = productService.findById( productEntity.getId());

        result.setProductDTO(product);
        return result;
    }

    public ItemEntity convertToEntity (ItemDTO dto){
        ItemEntity result = modelMapper.map(dto, ItemEntity.class);
        return result;
    }
}
