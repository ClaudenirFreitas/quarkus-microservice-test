package com.freitas.microservice_products.unit;

import com.freitas.microservice_products.models.Product;
import com.freitas.microservice_products.repository.ProductRepository;
import com.freitas.microservice_products.services.ProductService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Tag;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

import static com.freitas.microservice_products.util.Tests.UNIT;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
@Tag(value = UNIT)
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
        Mockito.when(repository.listAll())
                .thenReturn(Arrays.asList(new Product(
                        "iPhone",
                        "iPhone XR 64GB Preto Tela 6.1” iOS 12 4G 12MP - Apple"
                )));

        List<Product> result = service.findAll();

        verify(repository, atLeast(1)).listAll();
        verify(repository, times(1)).listAll();

        Assert.assertEquals(1, result.size());
        Assert.assertEquals("iPhone", result.get(0).getName());
    }
}
