package com.placamas.beans;

public class Ubigeo {

	private String region;
	private String provincia;
	private String distrito;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}


	public Ubigeo(String region, String provincia, String distrito) {
		super();
		this.region = region;
		this.provincia = provincia;
		this.distrito = distrito;
	}

	public Ubigeo() {
		super();
		// TODO Auto-generated constructor stub
	}
}
