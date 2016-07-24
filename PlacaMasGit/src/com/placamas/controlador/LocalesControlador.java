package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.placamas.beans.LocalBean;
import com.placamas.conexion.ConexionDB;


public class LocalesControlador {
	
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


	public int registrarLocal(LocalBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {

			cn=new ConexionDB().getConexion();

			String sql="insert into locales values(?,?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdLocal());
			pstm.setString(2, x.getLoc_Nomb());
			pstm.setString(3, x.getRegion());
			pstm.setString(4, x.getProvincia());
			pstm.setString(5, x.getDistrito());
			valor=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(pstm!=null)pstm.close();	
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return valor;
	}
	public int actualizarLocal(LocalBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=new ConexionDB().getConexion();
			String sql="update locales set idLocal=?,Loc_Nomb=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdLocal());
			pstm.setString(2, x.getLoc_Nomb());
			valor=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return valor;
	}
	public int eliminarLocal(String cod){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="delete from locales where idLocal=?";
			//3
			pstm=cn.prepareStatement(sql);
			//4
			pstm.setString(1, cod);
			//5
			valor=pstm.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		finally{
			try {
				if(pstm!=null)pstm.close();
				if(cn!=null)cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		
		return valor;
	}
	
	public ArrayList<LocalBean> listarLocal(){
		ArrayList<LocalBean> data=new ArrayList<LocalBean>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="select * from locales";
			//3
			pstm=cn.prepareStatement(sql);
			//4 para.
			//5 ejecutar
			rs=pstm.executeQuery();
			//6bucle
			while (rs.next()) {
				LocalBean mar=new LocalBean(rs.getString(1),
											     rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5));
				//agregar el objeto al arreglo
				data.add(mar);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null) rs.close();
				if(pstm!=null) pstm.close();
				if(cn!=null) cn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return data;
	}
	
	
	
}
