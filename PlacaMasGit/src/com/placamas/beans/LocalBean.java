package com.placamas.beans;

public class LocalBean {
	
	public String idLocal ;
	public String Loc_Nomb;
	public int idDepa;
	public int idProv;
	public int idDist;
	
	
	
	public String getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(String idLocal) {
		this.idLocal = idLocal;
	}
	public String getLoc_Nomb() {
		return Loc_Nomb;
	}
	public void setLoc_Nomb(String loc_Nom) {
		Loc_Nomb = loc_Nom;
	}
	public int getIdDepa() {
		return idDepa;
	}
	public void setIdDepa(int idDepa) {
		this.idDepa = idDepa;
	}
	public int getIdProv() {
		return idProv;
	}
	public void setIdProv(int idProv) {
		this.idProv = idProv;
	}
	public int getIdDist() {
		return idDist;
	}
	public void setIdDist(int idDist) {
		this.idDist = idDist;
	}

	public LocalBean() {

	}
	public LocalBean(String idlocal, String loc_Nomb) {
		super();
		this.idLocal = idlocal;
		this.Loc_Nomb = loc_Nomb;
	}
	
	

}