package com.freitas.microservice_products;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.inject.Inject;
import javax.servlet.http.HttpServletResponse;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Test;

import com.freitas.microservice_products.containers.PostgresContainerTest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class ProductResourceTest {

	private final static PostgresContainerTest DATABASE = new PostgresContainerTest();

	@Inject
	Flyway flyway;
	
	@Test
	public void testGetSuccess() throws InterruptedException {

		// TODO switch to boot
		DATABASE.start();
		flyway.migrate();

		given()
			.when()
				.get("/products")
			.then()
				.statusCode(HttpServletResponse.SC_OK)
				.body("size()", equalTo(1))
				.contentType(ContentType.JSON);
		
	}

}