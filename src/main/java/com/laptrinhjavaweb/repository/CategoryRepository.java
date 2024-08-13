package com.laptrinhjavaweb.repository;

import com.laptrinhjavaweb.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.CategoryEntity;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CategoryEntity, Long>{
	CategoryEntity findOneByCode(String categoryCode);

	List<CategoryEntity> findAll();

	CategoryEntity findById(long categoryId);
}
