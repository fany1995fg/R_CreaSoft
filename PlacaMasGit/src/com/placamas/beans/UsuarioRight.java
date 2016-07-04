package com.placamas.beans;

public class UsuarioRight {

	private String idUser;
	  private String Local;
	  private String Usr_tree;
	  private String Usr_Right;
	  //, String usr_tree,
		//	String usr_Right
	public UsuarioRight(String idUser, String local) {
		this.idUser = idUser;
		Local = local;
		//Usr_tree = usr_tree;
		//Usr_Right = usr_Right;
	}
	
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getLocal() {
		return Local;
	}
	public void setLocal(String local) {
		Local = local;
	}
	public String getUsr_tree() {
		return Usr_tree;
	}
	public void setUsr_tree(String usr_tree) {
		Usr_tree = usr_tree;
	}
	public String getUsr_Right() {
		return Usr_Right;
	}
	public void setUsr_Right(String usr_Right) {
		Usr_Right = usr_Right;
	}

	  
	  
}