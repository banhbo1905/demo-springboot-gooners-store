package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import com.laptrinhjavaweb.entity.ProductEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ProductRepository extends JpaRepository<ProductEntity, Long>{
	Page<ProductEntity> findAll(Pageable pageable);

	List<ProductEntity> findAll();
	ProductEntity findById(long productId);
	ProductEntity findByCode(String productCode);
	List<ProductEntity> findAllByCategoryId(long categoryId);
	List<ProductEntity> findAllByCategoryId(long categoryId, Pageable pageable);
	List<ProductEntity> findAllByCategoryCode(String categoryCode, Pageable pageable);
	List<ProductEntity> findAllByCategoryCode(String categoryCode);

	@Query("select p from ProductEntity p where p.name like %?1%")
	Page<ProductEntity> searchProducts(String keyword, Pageable pageable);

	@Query("select count(p) as CountProduct from ProductEntity p where p.name like %?1%")
	int countProducts(String keyword);
}

