package com.laptrinhjavaweb.entity;

import java.sql.Date;

import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "order_user")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "buydate")
	private Date buyDate;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "pricetotal")
	private float priceTotal;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private UserEntity user;
	
	@OneToMany(mappedBy = "order")
	private List<ItemEntity> items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Date getBuyDate() {
		return buyDate;
	}

	public void setBuyDate(Date buyDate) {
		this.buyDate = buyDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPriceTotal() {
		return priceTotal;
	}

	public void setPriceTotal(float priceTotal) {
		this.priceTotal = priceTotal;
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public List<ItemEntity> getItems() {
		return items;
	}

	public void setItems(List<ItemEntity> items) {
		this.items = items;
	}
	
	
	
}
