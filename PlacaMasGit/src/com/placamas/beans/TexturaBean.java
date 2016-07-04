package com.placamas.beans;

public class TexturaBean {

	private String idTextura;
	private String Descripcion;
	
	
	public String getIdTextura() {
		return idTextura;
	}
	public void setIdTextura(String idTextura) {
		this.idTextura = idTextura;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	
	public TexturaBean(String idMarcas, String descripcion) {
		super();
		this.idTextura = idMarcas;
		this.Descripcion = descripcion;
	}

	public TexturaBean() {

	}
	
}
