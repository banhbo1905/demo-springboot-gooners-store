package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.dto.CategoryDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
	CategoryDTO save(CategoryDTO categoryDTO);

	CategoryDTO findById(long categoryId);

	CategoryDTO findOneByCode(String categoryCode);

	void delete(long[] ids);

	List<CategoryDTO> findAll();

}
