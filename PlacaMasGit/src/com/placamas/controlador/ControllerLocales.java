package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.placamas.beans.LocalBean;
import com.placamas.conexion.ConexionDB;



public class ControllerLocales {

	public static ArrayList<LocalBean> getAllLocaless() {
		ArrayList<LocalBean> locales = new ArrayList<LocalBean>();

		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// realizamos la conexion sql
			cn = new ConexionDB().getConexion();
			sql = "select * from locales";

			// ejecutamos el query sql
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery(sql);

			// Almacenamos al obj data para almacenar la informacion del usuario
			while (rs.next()) {
				LocalBean local = new LocalBean();
				local.setIdLocal(rs.getString(1));
				local.setLoc_Nomb(rs.getString(2));
				local.setRegion(rs.getString(3));
				local.setProvincia(rs.getString(4));
				local.setDistrito(rs.getString(5));
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// cerramos la conexion
				if (rs != null)
					rs.close();
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return locales;
	}

	

	/*
	 * Metodo para registrar un paciente nuevo en el sistema
	 */
	public static int addUser(LocalBean x) {
		int estado = -1;

		Connection cn = null;
		PreparedStatement pstm = null;
		String sql = null;

		try {
			// realizamos la conexion sql
			cn = new ConexionDB().getConexion();
			 sql =
			 "insert into usuario (idLocal, Loc_Nomb, region, provincia, distrito) "
			 +"values (?,?,?,?,?)";

			pstm = cn.prepareStatement(sql);
			estado = pstm.executeUpdate();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			try {
				// cerramos la conexion
				if (pstm != null)
					pstm.close();
				if (cn != null)
					cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		return estado;
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
