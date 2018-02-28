package com.epcompany.emepeAPI.model;

public class Opinion {
	private int id;
	private String opinion;
	private float valoracion;
	private Opinion opinionAnt;
	private Cliente cliente;
	private Producto producto;
	
	public Opinion(String opinion, Cliente cliente, Producto producto) {
		super();
		this.opinion = opinion;
		this.cliente = cliente;
		this.producto = producto;
	}
	
	

	public Opinion(String opinion, Opinion opinionAnt, Cliente cliente, Producto producto) {
		super();
		this.opinion = opinion;
		this.opinionAnt = opinionAnt;
		this.cliente = cliente;
		this.producto = producto;
	}


	public Opinion(String opinion, float valoracion, Opinion opinionAnt, Cliente cliente, Producto producto) {
		super();
		this.opinion = opinion;
		this.valoracion = valoracion;
		this.opinionAnt = opinionAnt;
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



	public Opinion getOpinionAnt() {
		return opinionAnt;
	}



	public void setOpinionAnt(Opinion opinionAnt) {
		this.opinionAnt = opinionAnt;
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
		return "Opinion [id=" + id + ", opinion=" + opinion + ", valoracion=" + valoracion + ", opinionAnt="
				+ opinionAnt + ", cliente=" + cliente + ", producto=" + producto + "]";
	}
			
}
