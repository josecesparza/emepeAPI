package com.epcompany.emepeAPI.model;

public class TarjCredito {
	private int id;
	private int numero;
	private Cliente cliente;
	
	
	public TarjCredito(int id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	public TarjCredito(int id, int numero, Cliente cliente) {
		super();
		this.id = id;
		this.numero = numero;
		this.cliente = cliente;
	}

	public TarjCredito(int numero) {
		super();
		this.numero = numero;
	}

	public TarjCredito(int numero, Cliente cliente) {
		super();
		this.numero = numero;
		this.cliente = cliente;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	@Override
	public String toString() {
		return "TarjCredito [id=" + id + ", numero=" + numero + ", cliente=" + cliente + "]";
	}
	
	
}
