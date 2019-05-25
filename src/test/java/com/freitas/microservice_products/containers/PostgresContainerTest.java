package com.freitas.microservice_products.containers;

import static com.github.dockerjava.api.model.Ports.Binding.bindPort;

import org.testcontainers.containers.PostgreSQLContainer;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;

public class PostgresContainerTest extends PostgreSQLContainer<PostgresContainerTest> {

	public PostgresContainerTest() {
		super("postgres:9.6");
		withUsername("postgres");
		withPassword("password");
		withDatabaseName("devtest");
		withExposedPorts(POSTGRESQL_PORT);
		withCreateContainerCmdModifier(consumer ->
			{
				consumer.withName("tdcsp2019")
				        .withHostName("tdcsp2019")
						.withPortBindings(new PortBinding(bindPort(POSTGRESQL_PORT), new ExposedPort(POSTGRESQL_PORT)));
			});
	}

}