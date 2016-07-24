package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.placamas.beans.Lugar;
import com.placamas.conexion.ConexionDB;



public class Ubigeo {
	public static ArrayList<Lugar> getAllDepartamento() {
		ArrayList<Lugar> departamento = new ArrayList<Lugar>();

		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// realizamos la conexion sql
			cn = new ConexionDB().getConexion();
			sql = "SELECT d.codDepa, d.departamento from ubdepartamento d;";

			// ejecutamos el query sql
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery(sql);

			// Almacenamos al obj data para almacenar la informacion del usuario
			while (rs.next()) {
				Lugar depa = new Lugar();
				depa.setCodigo(rs.getInt(1));
				depa.setNombre(rs.getString(2));

				// agregamos al usuario al arraylist
				departamento.add(depa);
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

		return departamento;
	}

	public static ArrayList<Lugar> getAllProvinciaByDepa(int codDepa) {
		ArrayList<Lugar> provincia = new ArrayList<Lugar>();

		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// realizamos la conexion sql
			cn = new ConexionDB().getConexion();
			sql = "SELECT p.codProv, p.provincia FROM ubprovincia p where codDepa = '"
					+ codDepa + "';";

			// ejecutamos el query sql
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery(sql);

			// Almacenamos al obj data para almacenar la informacion del usuario
			while (rs.next()) {
				Lugar prov = new Lugar();
				prov.setCodigo(rs.getInt(1));
				prov.setNombre(rs.getString(2));

				// agregamos al usuario al arraylist
				provincia.add(prov);
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

		return provincia;
	}

	public static int getCodProv(String prov) {
		int n = 0;

		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// realizamos la conexion sql
			cn = new ConexionDB().getConexion();
			sql = "SELECT p.codProv FROM ubprovincia p where p.provincia = '"
					+ prov + "';";

			// ejecutamos el query sql
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery(sql);

			// Almacenamos al obj data para almacenar la informacion del usuario
			while (rs.next()) {
				n = rs.getInt(1);
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

		return n;
	}

	public static ArrayList<Lugar> getAllDistritoByProv(int codProv) {
		ArrayList<Lugar> distrito = new ArrayList<Lugar>();

		Connection cn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		String sql = null;

		try {
			// realizamos la conexion sql
			cn = new ConexionDB().getConexion();
			sql = "SELECT d.codDist, d.distrito from ubdistrito d where codProv = '"
					+ codProv + "';";

			// ejecutamos el query sql
			pstm = cn.prepareStatement(sql);
			rs = pstm.executeQuery(sql);

			// Almacenamos al obj data para almacenar la informacion del usuario
			while (rs.next()) {
				Lugar dist = new Lugar();
				dist.setCodigo(rs.getInt(1));
				dist.setNombre(rs.getString(2));

				// agregamos al usuario al arraylist
				distrito.add(dist);
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

		return distrito;
	}
}
