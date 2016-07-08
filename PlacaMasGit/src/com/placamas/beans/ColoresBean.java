package com.placamas.beans;

public class ColoresBean {
	
	//PROBANDO
	
	private String idColor;
	private String Descripcion;
	private String Match_Tab;
	private String Match_Can;
	
	
	public ColoresBean(String idColor, String descripcion,String match_Tab,String match_Can) {
		super();
		this.idColor = idColor;
		Descripcion = descripcion;
		Match_Tab = match_Tab;
		Match_Can = match_Can;
	}
	
	public String getIdColor() {
		return idColor;
	}
	public void setIdColor(String idColor) {
		this.idColor = idColor;
	}
	
	public String getDescripcion() {
		return Descripcion;
	}
	
	public void setDescripcion(String descripcion) {
		Descripcion = descripcion;
	}

	public String getMatch_tab() {
		return Match_Tab;
	}
	
	public void setMatch_tab(String match_tab) {
		this.Match_Tab = match_tab;
	}
	
	public String getMatch_can() {
		return Match_Can;
	}
	
	public void setMatch_can(String match_can) {
		this.Match_Can = match_can;
	}
	
	public ColoresBean() {

	}

}
