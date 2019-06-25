package com.freitas.microservice_products.unit.service;

import com.freitas.microservice_products.models.Signo;
import com.freitas.microservice_products.services.JoaoBiduService;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class JoaoBiduServiceTest {

    @Test
    public void signoDeCancer() {
        Signo signo = JoaoBiduService.getSigno(LocalDate.of(1994, Month.JULY, 5));

        Assert.assertEquals("Câncer", signo.getNome());
    }

    @Test
    public void signoDeJegue() {
        NullPointerException thrown =
                assertThrows(NullPointerException.class,
                        () -> JoaoBiduService.getSigno(null),
                        "birthDate must not be null");

        Assert.assertTrue(thrown.getMessage().contains("birthDate must not be null"));
    }

}
