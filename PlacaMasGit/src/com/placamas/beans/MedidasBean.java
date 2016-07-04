package com.placamas.beans;

public class MedidasBean {
	
	private String idMedidas;
	private String Medidas;
	private String Match_Tab;
	private String Match_Can;
	
	

	public String getIdMedidas() {
		return idMedidas;
	}
	public void setIdMedidas(String idMedidas) {
		this.idMedidas = idMedidas;
	}
	public String getMedidas() {
		return Medidas;
	}
	public void setMedidas(String medidas) {
		Medidas = medidas;
	}
	public String getMatch_Tab() {
		return Match_Tab;
	}
	public void setMatch_Tab(String match_Tab) {
		Match_Tab = match_Tab;
	}
	public String getMatch_Can() {
		return Match_Can;
	}
	public void setMatch_Can(String match_Can) {
		Match_Can = match_Can;
	}

	
	
	public MedidasBean(String idMedidas, String medidas) {
		super();
		this.idMedidas = idMedidas;
		Medidas = medidas;
	}
	
	
	

}
