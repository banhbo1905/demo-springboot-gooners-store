package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.converter.ProductConverter;
import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.entity.ProductEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;

import com.laptrinhjavaweb.repository.ProductRepository;
import com.laptrinhjavaweb.service.IProductService;

@Service
public class ProductService implements IProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductConverter productConverter;

	@Override
	public ProductDTO save(ProductDTO productDTO) {
		ProductEntity productEntity = new ProductEntity();
		if (productDTO.getId() != null) {
			ProductEntity oldProductEntity = productRepository.findById(productDTO.getId()).orElse(null);
			productEntity = productConverter.convertToEntity(productDTO, oldProductEntity);
		} else {
			productEntity = productConverter.convertToEntity(productDTO);
		}
		CategoryEntity categoryEntity = categoryRepository.findOneByCode(productDTO.getCategoryCode());
		productEntity.setCategory(categoryEntity);
		productEntity = productRepository.save(productEntity);
		return productConverter.convertToDto(productEntity);
	}

	@Override
	public ProductDTO findById(long productId) {
		ProductDTO productDTO = new ProductDTO();
		ProductEntity productEntity = productRepository.findById(productId);
		productDTO = productConverter.convertToDto(productEntity);
		return productDTO;
	}

	@Override
	public ProductDTO findByCode(String productCode) {
		ProductDTO productDTO = new ProductDTO();
		ProductEntity productEntity = productRepository.findByCode(productCode);
		productDTO = productConverter.convertToDto(productEntity);
		return productDTO;
	}

	@Override
	public void delete(long[] ids) {
		for(long item: ids) {
			productRepository.deleteById(item);
		}
	}

//	@Override
//	public Page<ProductDTO> findAll(Integer pageNo) {
//		Pageable pageable = PageRequest.of(pageNo-1, 4);
//		List<ProductDTO> results = new ArrayList<>();
//		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
//		for (ProductEntity item: entities) {
//			ProductDTO productDTO = productConverter.convertToDto(item);
//			results.add(productDTO);
//		}
//		return results;
//	}

	@Override
	public List<ProductDTO> findAll(Pageable pageable) {
		List<ProductDTO> results = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll(pageable).getContent();
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.convertToDto(item);
			results.add(productDTO);
		}
		return results;
	}

	@Override
	public List<ProductDTO> searchProducts(String keyword, Pageable pageable) {
		List<ProductDTO> results = new ArrayList<>();
		List<ProductEntity> entities = productRepository.searchProducts(keyword, pageable).getContent();
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.convertToDto(item);
			results.add(productDTO);
		}
		return results;
	}

	@Override
	public List<ProductDTO> findAll() {
		List<ProductDTO> results = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAll();
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.convertToDto(item);
			results.add(productDTO);
		}
		return results;
	}

	@Override
	public List<ProductDTO> findAllByCategoryId(long categoryId) {
		List<ProductDTO> results = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAllByCategoryId(categoryId);
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.convertToDto(item);
			results.add(productDTO);
		}
		return results;
	}

	@Override
	public List<ProductDTO> findAllByCategoryId(long categoryId, Pageable pageable) {
		List<ProductDTO> results = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAllByCategoryId(categoryId, pageable);
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.convertToDto(item);
			results.add(productDTO);
		}
		return results;
	}

	@Override
	public List<ProductDTO> findAllByCategoryCode(String categoryCode, Pageable pageable) {
		List<ProductDTO> results = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAllByCategoryCode(categoryCode, pageable);
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.convertToDto(item);
			results.add(productDTO);
		}
		return results;
	}

	@Override
	public List<ProductDTO> findAllByCategoryCode(String categoryCode) {
		List<ProductDTO> results = new ArrayList<>();
		List<ProductEntity> entities = productRepository.findAllByCategoryCode(categoryCode);
		for (ProductEntity item: entities) {
			ProductDTO productDTO = productConverter.convertToDto(item);
			results.add(productDTO);
		}
		return results;
	}

    @Override
    public int getTotalItem(Pageable pageable) {
		return (int) productRepository.count();
    }

	@Override
	public int getTotalItem(String keyword) {
        int entities = productRepository.countProducts(keyword);
		return entities;
	}
}
