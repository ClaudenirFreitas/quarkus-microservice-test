package com.freitas.microservice_products.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class ProductDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String name;
	private final String description;

	public ProductDTO(String name, String description) {
		this.name = name;
		this.description = description;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
