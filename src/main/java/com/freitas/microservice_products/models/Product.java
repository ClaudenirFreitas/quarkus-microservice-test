package com.freitas.microservice_products.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "T_PRODUCT")
public class Product extends PanacheEntity {

	@Column(name = "TXT_NAME")
	private String name;

	@Column(name = "TXT_DESCRIPTION")
	private String description;

	@Column(name = "NUM_PRICE")
	private Double price;

	public Product() {
	}

	public Product(Long id, String name, String description, Double price) {
		this(name, description, price);
		this.id = id;
	}

	public Product(String name, String description, Double price) {
		this.name = name;
		this.description = description;
		this.price = price;
	}

	public Product(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
