package com.freitas.microservice_products.unit;

import com.freitas.microservice_products.models.Product;
import com.freitas.microservice_products.repository.ProductRepository;
import com.freitas.microservice_products.services.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceUnitTest {

    @Inject
    @InjectMocks
    ProductService service;

    @Mock
    ProductRepository repository;

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void mockTest() {

        // Given
        Mockito.when(repository.listAll())
                .thenReturn(Arrays.asList(new Product(
                        "IPhone XR"
                )));

        // When
        List<Product> result = service.findAll();

        // Then
        verify(repository, times(1)).listAll();
        Assert.assertEquals(1, result.size());
        Assert.assertEquals("IPhone XR", result.get(0).getName());
    }
}
