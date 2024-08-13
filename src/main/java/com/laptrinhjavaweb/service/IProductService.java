package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.entity.UserEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.laptrinhjavaweb.dto.ProductDTO;

public interface IProductService {
	ProductDTO save(ProductDTO productDTO);

	ProductDTO findById(long productId);
	ProductDTO findByCode(String productCode);
	void delete(long[] ids);
//	void delete(long id);
	List<ProductDTO> findAll(Pageable pageable);


	List<ProductDTO> searchProducts(String keyword, Pageable pageable);

//	Page<ProductDTO> findAll(Integer pageNo);
	List<ProductDTO> findAll();
	List<ProductDTO> findAllByCategoryId(long categoryId);
	List<ProductDTO> findAllByCategoryId(long categoryId, Pageable pageable);
	List<ProductDTO> findAllByCategoryCode(String categoryCode, Pageable pageable);
	List<ProductDTO> findAllByCategoryCode(String categoryCode);
	int getTotalItem(Pageable pageable);
	int getTotalItem(String keyword);

}
