package com.freitas.microservice_products.services;

import com.freitas.microservice_products.models.Product;
import com.freitas.microservice_products.repository.ProductRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.util.Collection;

@ApplicationScoped
public class ProductService {

	@Inject
	ProductRepository repository;

	public Collection<Product> findAll() {
		return repository.listAll();
	}
}
