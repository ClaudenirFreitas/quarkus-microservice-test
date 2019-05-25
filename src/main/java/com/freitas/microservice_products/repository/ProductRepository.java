package com.freitas.microservice_products.repository;

import javax.enterprise.context.ApplicationScoped;

import com.freitas.microservice_products.models.Product;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ProductRepository implements PanacheRepository<Product> {

}