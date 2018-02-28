package com.epcompany.emepeAPI.model;

import java.util.ArrayList;

public class ResCli {
	private ArrayList<Restaurante> restaurantes;
	private boolean favorito;
	private float valoracion;
	
	public ResCli(ArrayList<Restaurante> restaurantes, boolean favorito, float valoracion) {
		super();
		this.restaurantes = restaurantes;
		this.favorito = favorito;
		this.valoracion = valoracion;
	}

	public ArrayList<Restaurante> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(ArrayList<Restaurante> restaurantes) {
		this.restaurantes = restaurantes;
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
		return "ResCli [restaurantes=" + restaurantes + ", favorito=" + favorito + ", valoracion=" + valoracion + "]";
	}
		
}
