package com.placamas.beans;

public class MaterialBean {

	private String idMaterial;
	private String Descripcion;
	public String getIdMaterial() {
		return idMaterial;
	}
	public void setIdMaterial(String idMaterial) {
		this.idMaterial = idMaterial;
	}
	public String getDescripcion() {
		return Descripcion;
	}
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}
	
	// CONSTRUCTOR//
	public MaterialBean(String idMaterial, String descripcion) {
		super();
		this.idMaterial = idMaterial;
		Descripcion = descripcion;
	}

	public MaterialBean() {

	}

	
}
