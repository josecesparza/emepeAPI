package com.epcompany.emepeAPI.model;

import java.sql.Date;
import java.util.ArrayList;

public class Cliente {

	private int id;
	private String usuario;
	private String pass;
	private boolean registrado;
	private String nombre;
	private String apellidos;
	private Date fechaNac;
	private boolean genero;
	private String localidad;
	private String correo;
	private TarjCredito tarjCredito;
	private ArrayList<ResCli> restaurantes;
	
	public Cliente() {
		super();
	}

	public Cliente(int id, String usuario, String pass, boolean registrado) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pass = pass;
		this.registrado = registrado;
	}

	public Cliente(int id, String usuario, String pass, boolean registrado, String nombre, String apellidos,
			Date fechaNac, boolean genero, String localidad, String correo, TarjCredito tarjCredito, ArrayList<ResCli> restaurantes) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.pass = pass;
		this.registrado = registrado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.localidad = localidad;
		this.correo = correo;
		this.tarjCredito = tarjCredito;
		this.restaurantes = restaurantes;
	}
	
	

	public Cliente(boolean registrado, String nombre, String apellidos, Date fechaNac, boolean genero, String localidad,
			String correo) {
		super();
		this.registrado = registrado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.fechaNac = fechaNac;
		this.genero = genero;
		this.localidad = localidad;
		this.correo = correo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public boolean isRegistrado() {
		return registrado;
	}

	public void setRegistrado(boolean registrado) {
		this.registrado = registrado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Date getFechaNac() {
		return fechaNac;
	}

	public void setFechaNac(Date fechaNac) {
		this.fechaNac = fechaNac;
	}

	public boolean isGenero() {
		return genero;
	}

	public void setGenero(boolean genero) {
		this.genero = genero;
	}

	public String getLocalidad() {
		return localidad;
	}

	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public TarjCredito getTarjCredito() {
		return tarjCredito;
	}

	public void setTarjCredito(TarjCredito tarjCredito) {
		this.tarjCredito = tarjCredito;
	}

	public ArrayList<ResCli> getRestaurantes() {
		return restaurantes;
	}

	public void setRestaurantes(ArrayList<ResCli> restaurantes) {
		this.restaurantes = restaurantes;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", usuario=" + usuario + ", pass=" + pass + ", registrado=" + registrado
				+ ", nombre=" + nombre + ", apellidos=" + apellidos + ", fechaNac=" + fechaNac + ", genero=" + genero
				+ ", localidad=" + localidad + ", correo=" + correo + ", tarjCredito=" + tarjCredito + "]";
	}
	
}
