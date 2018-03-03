package com.epcompany.emepeAPI.model;

import java.sql.Date;
import java.util.ArrayList;

public class Producto {
	private int id;
	private String nombre;
	private float precio;
	private float peso;
	private String descripcion;
	private Date fechaElab;
	private Date fechaCad;
	private ArrayList<Ingrediente> ingredientes;
	private Restaurante restaurante;
	
	public Producto(String nombre, float precio, Date fechaElab, Date fechaCad, ArrayList<Ingrediente> ingredientes,
			Restaurante restaurante) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.fechaElab = fechaElab;
		this.fechaCad = fechaCad;
		this.ingredientes = ingredientes;
		this.restaurante = restaurante;
	}

	public Producto(String nombre, float precio, float peso, String descripcion, Date fechaElab, Date fechaCad,
			ArrayList<Ingrediente> ingredientes, Restaurante restaurante) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.peso = peso;
		this.descripcion = descripcion;
		this.fechaElab = fechaElab;
		this.fechaCad = fechaCad;
		this.ingredientes = ingredientes;
		this.restaurante = restaurante;
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

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getPeso() {
		return peso;
	}

	public void setPeso(float peso) {
		this.peso = peso;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaElab() {
		return fechaElab;
	}

	public void setFechaElab(Date fechaElab) {
		this.fechaElab = fechaElab;
	}

	public Date getFechaCad() {
		return fechaCad;
	}

	public void setFechaCad(Date fechaCad) {
		this.fechaCad = fechaCad;
	}

	public ArrayList<Ingrediente> getIngredientes() {
		return ingredientes;
	}

	public void setIngredientes(ArrayList<Ingrediente> ingredientes) {
		this.ingredientes = ingredientes;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", peso=" + peso + ", descripcion="
				+ descripcion + ", fechaElab=" + fechaElab + ", fechaCad=" + fechaCad + ", ingredientes=" + ingredientes
				+ ", restaurante=" + restaurante + "]";
	}
		
}
