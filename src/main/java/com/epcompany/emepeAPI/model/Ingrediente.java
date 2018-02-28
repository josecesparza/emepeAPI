package com.epcompany.emepeAPI.model;

import java.util.ArrayList;

public class Ingrediente {

	private int id;
	private String nombre;
	private boolean vegano;
	private boolean vegetariano;
	private boolean gluten;
	private boolean lactosa;
	ArrayList<Producto> productos;
	
	public Ingrediente() {
		
	}

	
	public Ingrediente(String nombre) {
		super();
		this.nombre = nombre;
	}


	public Ingrediente(String nombre, boolean vegano, boolean vegetariano, boolean gluten, boolean lactosa) {
		super();
		this.nombre = nombre;
		this.vegano = vegano;
		this.vegetariano = vegetariano;
		this.gluten = gluten;
		this.lactosa = lactosa;
	}

	public Ingrediente(int id, String nombre, boolean vegano, boolean vegetariano, boolean gluten, boolean lactosa) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.vegano = vegano;
		this.vegetariano = vegetariano;
		this.gluten = gluten;
		this.lactosa = lactosa;
	}
		
	public Ingrediente(String nombre, ArrayList<Producto> productos) {
		super();
		this.nombre = nombre;
		this.productos = productos;
	}

	public Ingrediente(String nombre, boolean vegano, boolean vegetariano, boolean gluten, boolean lactosa,
			ArrayList<Producto> productos) {
		super();
		this.nombre = nombre;
		this.vegano = vegano;
		this.vegetariano = vegetariano;
		this.gluten = gluten;
		this.lactosa = lactosa;
		this.productos = productos;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isVegano() {
		return vegano;
	}

	public void setVegano(boolean vegano) {
		this.vegano = vegano;
	}

	public boolean isVegetariano() {
		return vegetariano;
	}

	public void setVegetariano(boolean vegetariano) {
		this.vegetariano = vegetariano;
	}

	public boolean isGluten() {
		return gluten;
	}

	public void setGluten(boolean gluten) {
		this.gluten = gluten;
	}

	public boolean isLactosa() {
		return lactosa;
	}

	public void setLactosa(boolean lactosa) {
		this.lactosa = lactosa;
	}

	@Override
	public String toString() {
		return "Ingrediente [id=" + id + ", nombre=" + nombre + ", vegano=" + vegano + ", vegetariano=" + vegetariano
				+ ", gluten=" + gluten + ", lactosa=" + lactosa + "]";
	}
	
	
}
