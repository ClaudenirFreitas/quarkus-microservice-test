package com.freitas.microservice_products.parsers;

import com.freitas.microservice_products.dto.ProductDTO;
import com.freitas.microservice_products.models.Product;

public class ProductParser {

	public static ProductDTO toDTO(final Product product) {
		return new ProductDTO(product.getName(), product.getDescription());
	}

	public static Product toModel(final ProductDTO productDTO) {
		return new Product(productDTO.getName(), productDTO.getDescription());
	}

}