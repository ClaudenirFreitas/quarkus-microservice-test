package com.freitas.microservice_products.integration;

import static com.freitas.microservice_products.util.Tests.INTEGRATION;
import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import com.freitas.microservice_products.containers.PostgresContainerTest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
@Tag(value = INTEGRATION)
public class ProductResourceTest {
	
	private static final PostgresContainerTest DB = new PostgresContainerTest();

	static {
		DB.start();

		Flyway.configure()
		      .dataSource(DB.getJdbcUrl(), DB.getUsername(), DB.getPassword())
		      .load()
		      .migrate();
	}

	@Test
	public void testGetSuccess() {
		given()
			.when()
				.get("/products")
			.then()
				.statusCode(HttpServletResponse.SC_OK)
				.body("size()", equalTo(1))
				.contentType(ContentType.JSON);
	}

}