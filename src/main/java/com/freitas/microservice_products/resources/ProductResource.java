package com.freitas.microservice_products.resources;

import com.freitas.microservice_products.dto.ProductDTO;
import com.freitas.microservice_products.models.Product;
import com.freitas.microservice_products.parsers.ProductParser;
import com.freitas.microservice_products.services.ProductService;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.net.URI;
import java.util.Collection;
import java.util.stream.Collectors;

@Path("/products")
public class ProductResource {

	@Inject
	ProductService service;

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response create(ProductDTO productDTO) {
		Product product = ProductParser.toModel(productDTO);
		service.save(product);
		return Response.created(URI.create("/products/" + product.getId()))
				       .build();
	}

	@GET
	@Path("/{productId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response findById(@PathParam("productId") Long productId) {
		ProductDTO productDTO = ProductParser.toDTO(service.find(productId));
		return Response.ok(productDTO).build();
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response findAll() {
		Collection<ProductDTO> products = service.findAll()
				                                 .stream()
				                                 .map(ProductParser::toDTO)
				                                 .collect(Collectors.toList());
		return Response.ok(products).build();
	}

	@PUT
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@PathParam("id") Long id, ProductDTO productDTO) {
		Product product = ProductParser.toModel(productDTO, id);
		service.update(product);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response delete(@PathParam("id") Long id) {
		service.delete(id);
		return Response.noContent().build();
	}

}