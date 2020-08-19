package com.freitas.microservice_products.config;

import java.util.HashMap;
import java.util.Map;

import org.flywaydb.core.Flyway;
import org.testcontainers.containers.MySQLContainer;

import io.quarkus.test.common.QuarkusTestResourceLifecycleManager;

public final class DatabaseConfig implements QuarkusTestResourceLifecycleManager {

	private static final MySQLContainer<?> CONTAINER = new MySQLContainer<>();

	@Override
	public Map<String, String> start() {
		CONTAINER.start();
		
		Flyway.configure()
	          .dataSource(CONTAINER.getJdbcUrl(), CONTAINER.getUsername(), CONTAINER.getPassword())
	          .load()
		      .migrate();
		
		Map<String, String> properties = new HashMap<>();
		properties.put("quarkus.datasource.url", CONTAINER.getJdbcUrl());
		properties.put("quarkus.datasource.username", CONTAINER.getUsername());
		properties.put("quarkus.datasource.password", CONTAINER.getPassword());

		return properties;
	}

	@Override
	public void stop() {
		if (CONTAINER.isRunning()) {
			CONTAINER.stop();
		}
	}

}
