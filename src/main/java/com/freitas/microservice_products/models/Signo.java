package com.freitas.microservice_products.models;

import java.time.MonthDay;

public class Signo {
    private MonthDay inicio;
    private MonthDay fim;
    private String nome;

    public Signo(MonthDay inicio, MonthDay fim, String nome) {
        this.inicio = inicio;
        this.fim = fim;
        this.nome = nome;
    }

    public MonthDay getInicio() {
        return inicio;
    }

    public void setInicio(MonthDay inicio) {
        this.inicio = inicio;
    }

    public MonthDay getFim() {
        return fim;
    }

    public void setFim(MonthDay fim) {
        this.fim = fim;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
