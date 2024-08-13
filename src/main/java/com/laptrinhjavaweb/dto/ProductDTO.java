package com.laptrinhjavaweb.dto;

public class ProductDTO extends AbstractDTO<ProductDTO> {

//	private Long id;
	private String name;
	private String code;
	private float price;
	private int quantity;
	private String description;
	private String image;

	private String categoryCode;

//	private CategoryDTO categoryDTO;
	
	
//	public ProductDTO() {
//		// TODO Auto-generated constructor stub
//	}
//
//
//	public ProductDTO(long id, String name, float price, int quantity, String description, String image,
//			CategoryDTO categoryDTO) {
//		super();
//		this.id = id;
//		this.name = name;
//		this.price = price;
//		this.quantity = quantity;
//		this.description = description;
//		this.image = image;
//		this.categoryDTO = categoryDTO;
//	}


//	public Long getId() {
//		return id;
//	}
//
//
//	public void setId(Long id) {
//		this.id = id;
//	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getPrice() {
		return price;
	}


	public void setPrice(float price) {
		this.price = price;
	}


	public int getQuantity() {
		return quantity;
	}


	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}

//
//	public CategoryDTO getCategoryDTO() {
//		return categoryDTO;
//	}
//
//
//	public void setCategoryDTO(CategoryDTO categoryDTO) {
//		this.categoryDTO = categoryDTO;
//	}


	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCategoryCode() {
		return categoryCode;
	}

	public void setCategoryCode(String categoryCode) {
		this.categoryCode = categoryCode;
	}
}
