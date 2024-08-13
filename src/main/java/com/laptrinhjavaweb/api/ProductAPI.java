package com.laptrinhjavaweb.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.dto.ProductDTO;
import com.laptrinhjavaweb.service.IProductService;

@CrossOrigin
@RestController
public class ProductAPI {
	
	@Autowired
	private IProductService productService;
	
//	@GetMapping(value = "/product")
//	public ProductOutput showNew(@RequestParam("page") int page,
//							 @RequestParam("limit") int limit) {
//		ProductOutput result = new ProductOutput();
//		result.setPage(page);
//		Pageable pageable = new PageRequest(page - 1, limit);
//		result.setListResult(newService.findAll(pageable));
//		result.setTotalPage((int) Math.ceil((double) (newService.totalItem()) / limit));
//		return result;
//	}

	@PostMapping(value = "/product")
	public ProductDTO createProduct(@RequestBody ProductDTO model) {
		return productService.save(model);
	}
	
	@PutMapping(value = "/product/{id}")
	public ProductDTO updateProduct(@RequestBody ProductDTO model, @PathVariable("id") long id) {
		model.setId(id);
		return productService.save(model);
	}
	
	@DeleteMapping(value = "/product")
	public void deleteProduct(@RequestBody long[] ids) {
		productService.delete(ids);
	}
}
