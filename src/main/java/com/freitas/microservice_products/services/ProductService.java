package com.freitas.microservice_products.services;

import com.freitas.microservice_products.models.Product;
import com.freitas.microservice_products.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.List;

@ApplicationScoped
public class ProductService {

	@Inject
	ProductRepository repository;

	public List<Product> findAll() {
		return repository.listAll();
	}
}
