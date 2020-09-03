package com.freitas.microservice_products.parsers;

import com.freitas.microservice_products.dto.ProductDTO;
import com.freitas.microservice_products.models.Product;

public class ProductParser {

	private ProductParser() {
	}

	public static ProductDTO toDTO(final Product product) {
		return new ProductDTO(product.getId(), product.getName(), product.getDescription(), product.getPrice());
	}

	public static Product toModel(final ProductDTO productDTO) {
		return new Product(productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
	}

	public static Product toModel(final ProductDTO productDTO, final Long productId) {
		return new Product(productId, productDTO.getName(), productDTO.getDescription(), productDTO.getPrice());
	}

}