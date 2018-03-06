package com.epcompany.emepeAPI.model;

public class Opinion {
	private int id;
	private String opinion;
	private float valoracion;
	private Cliente cliente;
	private Producto producto;
	
	
	
	public Opinion(int id, String opinion, float valoracion) {
		super();
		this.id = id;
		this.opinion = opinion;
		this.valoracion = valoracion;
	}



	public Opinion(String opinion, Cliente cliente, Producto producto) {
		super();
		this.opinion = opinion;
		this.cliente = cliente;
		this.producto = producto;
	}
	
	

	public Opinion(String opinion, float valoracion, Cliente cliente, Producto producto) {
		super();
		this.opinion = opinion;
		this.valoracion = valoracion;
		this.cliente = cliente;
		this.producto = producto;
	}

	


	public Opinion(int id, String opinion, float valoracion, Cliente cliente, Producto producto) {
		super();
		this.id = id;
		this.opinion = opinion;
		this.valoracion = valoracion;
		this.cliente = cliente;
		this.producto = producto;
	}


	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getOpinion() {
		return opinion;
	}



	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}



	public float getValoracion() {
		return valoracion;
	}



	public void setValoracion(float valoracion) {
		this.valoracion = valoracion;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Producto getProducto() {
		return producto;
	}



	public void setProducto(Producto producto) {
		this.producto = producto;
	}



	@Override
	public String toString() {
		return "Opinion [id=" + id + ", opinion=" + opinion + ", valoracion=" + valoracion + ", cliente=" + cliente + ", producto=" + producto + "]";
	}
			
}
