package com.freitas.microservice_products.containers;

import static com.github.dockerjava.api.model.Ports.Binding.bindPort;

import org.testcontainers.containers.MySQLContainer;

import com.github.dockerjava.api.model.ExposedPort;
import com.github.dockerjava.api.model.PortBinding;

public class MySqlContainerTest extends MySQLContainer<MySqlContainerTest> {

	public MySqlContainerTest() {
		withUsername("user");
		withPassword("password");
		withDatabaseName("devtest");
		withCreateContainerCmdModifier(consumer ->
			{
				consumer.withName("mysql-5.7.22-test");
				consumer.withPortBindings(new PortBinding(bindPort(MYSQL_PORT), new ExposedPort(MYSQL_PORT)));
			});
	}

}
