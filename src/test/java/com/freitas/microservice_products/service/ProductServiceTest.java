package com.freitas.microservice_products.service;

import static com.freitas.microservice_products.util.Tests.SERVICE;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Tag;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

@Tag(value = SERVICE)
@RunWith(JUnitPlatform.class)
public class ProductServiceTest {

	@Test
	@Disabled(value = "Add tests")
	public void testSuccess() {
		Assert.assertTrue(true);
	}

}
