package com.freitas.microservice_products.models;

import java.time.MonthDay;

public final class Signo {

	private final MonthDay inicio;
	private final MonthDay fim;
	private final String nome;

	public Signo(MonthDay inicio, MonthDay fim, String nome) {
		this.inicio = inicio;
		this.fim = fim;
		this.nome = nome;
	}

	public MonthDay getInicio() {
		return inicio;
	}

	public MonthDay getFim() {
		return fim;
	}

	public String getNome() {
		return nome;
	}

}
