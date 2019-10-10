package com.freitas.microservice_products.integration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.flywaydb.core.Flyway;
import org.jboss.resteasy.util.HttpHeaderNames;
import org.junit.Assert;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.freitas.microservice_products.containers.MySqlContainerTest;
import com.freitas.microservice_products.dto.ProductDTO;
import com.freitas.microservice_products.models.Product;
import com.freitas.microservice_products.services.ProductService;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class ProductResourceIntegrationTest {

	private static final MySqlContainerTest CONTAINER = new MySqlContainerTest();
	
	@Inject
	ProductService service;

	@BeforeAll
	public static void init() {
		CONTAINER.start();

		Flyway.configure()
		      .dataSource(CONTAINER.getJdbcUrl(), CONTAINER.getUsername(), CONTAINER.getPassword())
		      .load()
			  .migrate();
	}

	@AfterAll
	public static void teardown() {
		CONTAINER.stop();
	}

	@Test
	public void testGetSuccess() {
		given()
			.accept(ContentType.JSON)
		.when()
			.get("/products")
		.then()
			.statusCode(HttpServletResponse.SC_OK)
			.body("size()", equalTo(100))
			.contentType(ContentType.JSON);
	}

	@Test
	public void testCreateSuccess() {
		
		ProductDTO product = new ProductDTO();
		product.setName("test product 1");
		product.setDescription("description product 1");
		product.setPrice(10D);
		
		String headerLocation = given()
									.contentType(ContentType.JSON)
									.body(product)
								.when()
									.post("/products")
								.then()
									.statusCode(HttpServletResponse.SC_CREATED)
									.header(HttpHeaderNames.LOCATION, containsString("products/"))
									.extract()
									.header(HttpHeaderNames.LOCATION);

		// clear data
		String[] splitLocation = headerLocation.split("/");
		String productId = splitLocation[splitLocation.length - 1];
		service.delete(Long.valueOf(productId));
		
	}

	@Test
	public void testUpdateSuccess() {
		
		ProductDTO product = new ProductDTO();
		product.setName("update name 1");
		product.setDescription("update desc 1");
		product.setPrice(1000D);
		
		given()
			.contentType(ContentType.JSON)
			.body(product)
		.when()
			.put("/products/50")
		.then()
			.statusCode(HttpServletResponse.SC_OK);

		Product updated = service.find(50L);
		Assert.assertEquals("update name 1", updated.getName());
		Assert.assertEquals("update desc 1", updated.getDescription());
		Assert.assertEquals(1000D, updated.getPrice(), 0);
		
	}

	@Test
	public void testDeleteSuccess() {
		
		ProductDTO product = new ProductDTO();
		product.setName("test product to delete");
		product.setDescription("description product to delete");
		product.setPrice(10D);
		
		String headerLocation = given()
									.contentType(ContentType.JSON)
									.body(product)
								.when()
									.post("/products")
								.then()
									.statusCode(HttpServletResponse.SC_CREATED)
									.extract()
									.header(HttpHeaderNames.LOCATION);

		// clear data
		String[] splitLocation = headerLocation.split("/");
		String productId = splitLocation[splitLocation.length - 1];
		
		given()
		.when()
			.delete("/products/" + productId)
		.then()
			.statusCode(HttpServletResponse.SC_NO_CONTENT);
			
	}

}