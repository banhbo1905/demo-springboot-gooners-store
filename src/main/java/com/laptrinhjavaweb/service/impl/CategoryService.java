package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.converter.CategoryConverter;
import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;
import com.laptrinhjavaweb.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private CategoryConverter categoryConverter;

	@Override
	public CategoryDTO save(CategoryDTO categoryDTO) {
		CategoryEntity categoryEntity = new CategoryEntity();
		if (categoryDTO.getId() != null) {
			CategoryEntity oldCategoryEntity = categoryRepository.findById(categoryDTO.getId()).orElse(null);
			categoryEntity = categoryConverter.convertToEntity(categoryDTO, oldCategoryEntity);
		} else {
			categoryEntity = categoryConverter.convertToEntity(categoryDTO);
		}
		return categoryConverter.convertToDto(categoryEntity);
	}

	@Override
	public CategoryDTO findById(long categoryId) {
		CategoryDTO categoryDTO = new CategoryDTO();
		CategoryEntity categoryEntity = categoryRepository.findById(categoryId);
		categoryDTO = categoryConverter.convertToDto(categoryEntity);
		return categoryDTO;
	}

	@Override
	public CategoryDTO findOneByCode(String categoryCode) {
		CategoryDTO categoryDTO = new CategoryDTO();
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(categoryCode);
		categoryDTO = categoryConverter.convertToDto(categoryEntity);
		return categoryDTO;
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			categoryRepository.deleteById(item);
		}
	}

	@Override
	public List<CategoryDTO> findAll() {
		List<CategoryDTO> results = new ArrayList<>();
		List<CategoryEntity> entities = categoryRepository.findAll();
		for (CategoryEntity item: entities) {
			CategoryDTO categoryDTO = categoryConverter.convertToDto(item);
			results.add(categoryDTO);
		}
		return results;
	}

}
