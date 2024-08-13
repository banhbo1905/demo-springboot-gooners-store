package com.laptrinhjavaweb.dto;

public class CartDTO {
	
	private long id;
	private UserDTO userDTO;
	private ProductDTO productDTO;
	private int quantity;
	
	public CartDTO() {
		// TODO Auto-generated constructor stub
	}

	public CartDTO(long id, UserDTO userDTO, ProductDTO productDTO, int quantity) {
		super();
		this.id = id;
		this.userDTO = userDTO;
		this.productDTO = productDTO;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	
	
	
}
