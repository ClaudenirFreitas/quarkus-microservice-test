package com.freitas.microservice_products.resources;

import java.util.Collection;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.freitas.microservice_products.dto.ProductDTO;
import com.freitas.microservice_products.parsers.ProductParser;
import com.freitas.microservice_products.services.ProductService;

@Path("/products")
public class ProductResource {

	@Inject
	ProductService service;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		Collection<ProductDTO> products = service.findAll()
				                                 .stream()
				                                 .map(ProductParser::toDTO)
				                                 .collect(Collectors.toList());
		return Response.ok(products).build();
	}

}