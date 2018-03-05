package com.epcompany.emepeAPI.model;

public class TarjCredito {
	private int id;
	private int numero;
		
	
	public TarjCredito(int id, int numero) {
		super();
		this.id = id;
		this.numero = numero;
	}

	public TarjCredito(int numero) {
		super();
		this.numero = numero;
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

	@Override
	public String toString() {
		return "TarjCredito [id=" + id + ", numero=" + numero + "]";
	}
	
	
}
