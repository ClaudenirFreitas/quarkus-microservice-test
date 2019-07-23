package com.freitas.microservice_products.integration;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import javax.servlet.http.HttpServletResponse;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.freitas.microservice_products.containers.MySqlContainerTest;

import io.quarkus.test.junit.QuarkusTest;
import io.restassured.http.ContentType;

@QuarkusTest
public class ProductResourceIntegrationTest {

	private static final MySqlContainerTest CONTAINER = new MySqlContainerTest();

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
			.when()
				.get("/products")
			.then()
				.statusCode(HttpServletResponse.SC_OK)
				.body("size()", equalTo(100))
				.contentType(ContentType.JSON);
	}

}