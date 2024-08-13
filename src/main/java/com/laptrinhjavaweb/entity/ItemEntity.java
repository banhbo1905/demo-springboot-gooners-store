package com.laptrinhjavaweb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item")
public class ItemEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "product_id")
	private ProductEntity product;
	
	@Column(name = "unitprice")
	private float unitPrice;
	
	@Column(name = "quantity")
	private int quantity;
	
	@ManyToOne
	@JoinColumn(name = "order_id")
	private OrderEntity order;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
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

	public OrderEntity getOrder() {
		return order;
	}

	public void setOrder(OrderEntity order) {
		this.order = order;
	}
	
	
}
