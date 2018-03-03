package com.epcompany.emepeAPI.model;

import java.util.ArrayList;

public class CliRes {
	private ArrayList<Cliente> clientes;
	private boolean favorito;
	private float valoracion;
	
	public CliRes(ArrayList<Cliente> clientes, boolean favorito, float valoracion) {
		super();
		this.clientes = clientes;
		this.favorito = favorito;
		this.valoracion = valoracion;
	}

	public ArrayList<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<Cliente> clientes) {
		this.clientes = clientes;
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

	@Override
	public String toString() {
		return "CliRes [clientes=" + clientes + ", favorito=" + favorito + ", valoracion=" + valoracion + "]";
	}
	
}
