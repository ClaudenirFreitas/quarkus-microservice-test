package com.freitas.microservice_products.services;

import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import com.freitas.microservice_products.models.Product;
import com.freitas.microservice_products.repository.ProductRepository;

@ApplicationScoped
public class ProductService {

	@Inject
	ProductRepository repository;

	public Collection<Product> findAll() {
		return repository.listAll();
	}

}
