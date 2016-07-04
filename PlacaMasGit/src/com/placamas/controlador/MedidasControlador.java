package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.placamas.beans.MedidasBean;
import com.placamas.conexion.ConexionDB;

public class MedidasControlador {
	
	
	public int registrarMedidas(MedidasBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {

			cn=new ConexionDB().getConexion();

			String sql="insert into medidas values(?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdMedidas());
			pstm.setString(2, x.getMedidas());
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
	public int actualizarMedidas(MedidasBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=new ConexionDB().getConexion();
			String sql="update medidas set idMedidas=?,Medidas=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdMedidas());
			pstm.setString(2, x.getMedidas());
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
	public int eliminarMedidas(String cod){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="delete from medidas where idMedidas=?";
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
	//método que retorna un arreglo de objetos de la clase MarcasBean
	
	public ArrayList<MedidasBean> listarMedidas(){
		ArrayList<MedidasBean> data=new ArrayList<MedidasBean>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="select *from medidas";
			//3
			pstm=cn.prepareStatement(sql);
			//4 para.
			//5 ejecutar
			rs=pstm.executeQuery();
			//6bucle
			while (rs.next()) {
				MedidasBean mar=new MedidasBean(rs.getString(1),
											rs.getString(2));
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
