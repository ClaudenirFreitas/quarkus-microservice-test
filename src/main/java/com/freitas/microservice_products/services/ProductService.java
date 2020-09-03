package com.freitas.microservice_products.services;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

import com.freitas.microservice_products.models.Product;
import com.freitas.microservice_products.repository.ProductRepository;

@ApplicationScoped
public class ProductService {

	@Inject
	ProductRepository repository;

	public List<Product> findAll() {
		return repository.listAll();
	}

	public Product find(Long id) {
		return getProduct(id);
	}

	@Transactional
	public void save(Product product) {
		repository.persist(product);
	}

	@Transactional
	public void update(Product product) {
		Product productDB = getProduct(product.getId());

		productDB.setName(product.getName());
		productDB.setDescription(product.getDescription());
		productDB.setPrice(product.getPrice());
		repository.persist(productDB);
	}

	@Transactional
	public void delete(Long id) {
		Product product = getProduct(id);
		repository.delete(product);
	}

	private Product getProduct(final Long id) {
		return repository.findByIdOptional(id)
                         .orElseThrow(() -> new IllegalArgumentException("Product not found!"));
	}

}