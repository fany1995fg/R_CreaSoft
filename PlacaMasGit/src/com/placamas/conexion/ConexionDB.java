package com.placamas.conexion;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/*
 * ESTA CLASE PERMITE EL ACCESO A LA BASE DE DATOS PLACAMAS
 */
public class ConexionDB {

	//PERMITE EL ACCESO AL ARCHIVO DE PROPERTIES DETALLADO AFUERA DEL SRC
	private static ResourceBundle rb = 
			ResourceBundle.getBundle("database_conexion");
	
	//ACCEDE A  mysqlconnectorXXXX.jar
	static{
		try {
			Class.forName(rb.getString("driver"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	//METODO PARA CREAR CONEXIONES
	public Connection  getConexion(){
		Connection salida = null;
		try {
			salida = DriverManager.getConnection(
									rb.getString("url"),
									rb.getString("username"),
									rb.getString("password"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return salida;	
	}
	
	public static void main(String[] args) {
			ConexionDB con = new ConexionDB();
			Connection obj =   con.getConexion();
			System.out.println(obj);

	}

}
