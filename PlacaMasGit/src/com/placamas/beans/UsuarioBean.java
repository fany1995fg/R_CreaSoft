package com.placamas.beans;

public class UsuarioBean {

	private String idUser;
	private String User_Nomb;
	private String User_Pasw;
	private String idLocal;
	

	public UsuarioBean(String idUser, String user_Nomb, String user_Pasw) {
		super();
		this.idUser = idUser;
		User_Nomb = user_Nomb;
		User_Pasw = user_Pasw;
	}
	public String getIdUser() {
		return idUser;
	}
	public void setIdUser(String idUser) {
		this.idUser = idUser;
	}
	public String getUser_Nomb() {
		return User_Nomb;
	}
	public void setUser_Nomb(String user_Nomb) {
		User_Nomb = user_Nomb;
	}
	public String getUser_Pasw() {
		return User_Pasw;
	}
	public void setUser_Pasw(String user_Pasw) {
		User_Pasw = user_Pasw;
	}
	public String getIdLocal() {
		return idLocal;
	}
	public void setIdLocal(String idLocal) {
		this.idLocal = idLocal;
	}

	

	
	
}
