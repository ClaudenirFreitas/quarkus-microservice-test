package com.freitas.microservice_products.models;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity(name = "T_PRODUCT")
public class Product extends PanacheEntity {

	public Product(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public Product() {
	}

	@Column(name = "TXT_NAME")
	private String name;

	@Column(name = "TXT_DESCRIPTION")
	private String description;

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

}
