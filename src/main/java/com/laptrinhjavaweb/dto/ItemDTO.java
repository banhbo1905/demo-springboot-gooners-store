package com.laptrinhjavaweb.dto;

public class ItemDTO {
	
	private long id;
	private ProductDTO productDTO;
	private float unitPrice;
	private int quantity;
	private OrderDTO orderDTO;
	
	public ItemDTO() {
		// TODO Auto-generated constructor stub
	}

	public ItemDTO(long id, ProductDTO productDTO, float unitPrice, int quantity, OrderDTO orderDTO) {
		this.id = id;
		this.productDTO = productDTO;
		this.unitPrice = unitPrice;
		this.quantity = quantity;
		this.orderDTO = orderDTO;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	public float getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public OrderDTO getOrderDTO() {
		return orderDTO;
	}

	public void setOrderDTO(OrderDTO orderDTO) {
		this.orderDTO = orderDTO;
	}

	
	
	
}
