package com.placamas.beans;

public class LocalBean extends Ubigeo {
	
	public String idLocal ;
	public String Loc_Nomb;
	
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


	public LocalBean() {

	}
	public LocalBean(String region, String provincia, String distrito,
			String idLocal, String loc_Nomb) {
		super(region, provincia, distrito);
		this.idLocal = idLocal;
		Loc_Nomb = loc_Nomb;
	}
	
	
	

}