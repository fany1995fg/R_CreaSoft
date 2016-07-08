package com.placamas.beans;

public class ReglasBean {

	private String idRules;
	private String Detalle;
	private String Val_Numer;
	private String Val_Logic;
	private String Val_Char1;
	private String Val_Char2;
	
	
	public String getIdRules() {
		return idRules;
	}
	public void setIdRules(String idRules) {
		this.idRules = idRules;
	}
	public String getDetalle() {
		return Detalle;
	}
	public void setDetalle(String detalle) {
		Detalle = detalle;
	}
	public String getVal_Numer() {
		return Val_Numer;
	}
	public void setVal_Numer(String val_Numer) {
		Val_Numer = val_Numer;
	}
	public String getVal_Logic() {
		return Val_Logic;
	}
	public void setVal_Logic(String val_Logic) {
		Val_Logic = val_Logic;
	}
	public String getVal_Char1() {
		return Val_Char1;
	}
	public void setVal_Char1(String val_Char1) {
		Val_Char1 = val_Char1;
	}
	public String getVal_Char2() {
		return Val_Char2;
	}
	public void setVal_Char2(String val_Char2) {
		Val_Char2 = val_Char2;
	}
	public ReglasBean(String idRules, String detalle, String val_Numer,
			String val_Logic) {
		super();
		this.idRules = idRules;
		Detalle = detalle;
		Val_Numer = val_Numer;
		Val_Logic = val_Logic;
	}
	
	
}
