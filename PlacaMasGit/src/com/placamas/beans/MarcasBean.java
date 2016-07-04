package com.placamas.beans;

public class MarcasBean {
	
	private String idMarcas;
	private String Descripcion;
	
	//CONSTRUCTOR//
	
	public String getIdMarcas() {
		return idMarcas;
	}

	public void setIdMarcas(String idMarcas) {
		this.idMarcas = idMarcas;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public MarcasBean(String idMarcas, String descripcion) {
		super();
		this.idMarcas = idMarcas;
		this.Descripcion = descripcion;
	}

	public MarcasBean() {

	}
	


}
