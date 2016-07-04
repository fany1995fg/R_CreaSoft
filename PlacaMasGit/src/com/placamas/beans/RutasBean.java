package com.placamas.beans;

public class RutasBean {

	private String idRutas;
	private String Rutas;
	
	
	
	public String getIdRutas() {
		return idRutas;
	}
	public void setIdRutas(String idRutas) {
		this.idRutas = idRutas;
	}
	public String getRutas() {
		return Rutas;
	}
	public void setRutas(String rutas) {
		Rutas = rutas;
	}
	
	public RutasBean(String idRutas, String rutas) {
		super();
		this.idRutas = idRutas;
		Rutas = rutas;
	}
	
	public RutasBean() {

	}
}
