package com.epcompany.emepeAPI.model;

public class CliRes {
	private Cliente cliente;
	private Restaurante restaurante;
	private boolean favorito;
	private float valoracion;
	
	public CliRes(Cliente cliente, Restaurante restaurante, boolean favorito, float valoracion) {
		super();
		this.cliente = cliente;
		this.restaurante = restaurante;
		this.favorito = favorito;
		this.valoracion = valoracion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	public boolean isFavorito() {
		return favorito;
	}

	public void setFavorito(boolean favorito) {
		this.favorito = favorito;
	}

	public float getValoracion() {
		return valoracion;
	}

	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}
	
	
	
}
