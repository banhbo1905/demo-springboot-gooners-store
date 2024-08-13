package com.laptrinhjavaweb.entity;



import java.util.List;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class CategoryEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "code")
	private String code;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "category")
	private List<ProductEntity> products;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<ProductEntity> getProducts() {
		return products;
	}

	public void setProducts(List<ProductEntity> products) {
		this.products = products;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
