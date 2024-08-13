package com.laptrinhjavaweb.dto;

import java.util.List;

public class CategoryDTO extends AbstractDTO<CategoryDTO> {

	private String code;
	private String name;
	private List<ProductDTO> productDTOs;
	
	public CategoryDTO() {
		// TODO Auto-generated constructor stub
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductDTO> getProductDTOs() {
		return productDTOs;
	}

	public void setProductDTOs(List<ProductDTO> productDTOs) {
		this.productDTOs = productDTOs;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
