package com.epcompany.emepeAPI.model;

import java.util.ArrayList;

public class Restaurante {
	private int id;
	private String nombre;
	private String tipo;
	private String descripcion;
	private String horario;
	private String codEmpresa;
	private String pass;
	private String adreza;
	private float latitud;
	private float longitud;
	private String telefono;
	private String mail;
	private ArrayList<CliRes> clientes;
	ArrayList<Producto> productos;
	
	
	
	public Restaurante(int id, String nombre, String tipo, String descripcion, String horario, String codEmpresa,
			String pass, String adreza, float latitud, float longitud, String telefono, String mail) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.horario = horario;
		this.codEmpresa = codEmpresa;
		this.pass = pass;
		this.adreza = adreza;
		this.latitud = latitud;
		this.longitud = longitud;
		this.telefono = telefono;
		this.mail = mail;
		clientes = new ArrayList<CliRes>();
	}

	public Restaurante(String nombre, String codEmpresa, String pass, String adreza, float latitud, float longitud,
			String telefono) {
		super();
		this.nombre = nombre;
		this.codEmpresa = codEmpresa;
		this.pass = pass;
		this.adreza = adreza;
		this.latitud = latitud;
		this.longitud = longitud;
		this.telefono = telefono;
		clientes = new ArrayList<CliRes>();
	}

	public Restaurante(String nombre, String tipo, String descripcion, String horario, String codEmpresa, String pass,
			String adreza, float latitud, float longitud, String telefono, String mail) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.horario = horario;
		this.codEmpresa = codEmpresa;
		this.pass = pass;
		this.adreza = adreza;
		this.latitud = latitud;
		this.longitud = longitud;
		this.telefono = telefono;
		this.mail = mail;
		clientes = new ArrayList<CliRes>();
	}

	public Restaurante(String nombre, String tipo, String descripcion, String horario, String codEmpresa, String pass,
			String adreza, float latitud, float longitud, String telefono, String mail, ArrayList<CliRes> clientes,
			ArrayList<Producto> productos) {
		super();
		this.nombre = nombre;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.horario = horario;
		this.codEmpresa = codEmpresa;
		this.pass = pass;
		this.adreza = adreza;
		this.latitud = latitud;
		this.longitud = longitud;
		this.telefono = telefono;
		this.mail = mail;
		this.clientes = clientes;
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

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getHorario() {
		return horario;
	}

	public void setHorario(String horario) {
		this.horario = horario;
	}

	public String getCodEmpresa() {
		return codEmpresa;
	}

	public void setCodEmpresa(String codEmpresa) {
		this.codEmpresa = codEmpresa;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getAdreza() {
		return adreza;
	}

	public void setAdreza(String adreza) {
		this.adreza = adreza;
	}

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongitud() {
		return longitud;
	}

	public void setLongitud(float longitud) {
		this.longitud = longitud;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public ArrayList<CliRes> getClientes() {
		return clientes;
	}

	public void setClientes(ArrayList<CliRes> clientes) {
		this.clientes = clientes;
	}

	public ArrayList<Producto> getProductos() {
		return productos;
	}

	public void setProductos(ArrayList<Producto> productos) {
		this.productos = productos;
	}

	@Override
	public String toString() {
		return "Restaurante [id=" + id + ", nombre=" + nombre + ", tipo=" + tipo + ", descripcion=" + descripcion
				+ ", horario=" + horario + ", codEmpresa=" + codEmpresa + ", pass=" + pass + ", adreza=" + adreza
				+ ", latitud=" + latitud + ", longitud=" + longitud + ", telefono=" + telefono + ", mail=" + mail
				+ ", clientes=" + clientes + ", productos=" + productos + "]";
	}
	
	
}
