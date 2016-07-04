package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.placamas.beans.TexturaBean;
import com.placamas.conexion.ConexionDB;

public class TexturaControlador {

	public int registrarTextura(TexturaBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {

			cn=new ConexionDB().getConexion();

			String sql="insert into textura values(?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdTextura());
			pstm.setString(2, x.getDescripcion());
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
	public int actualizarTextura(TexturaBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=new ConexionDB().getConexion();
			String sql="update marcas set idTextura=?,Descripcion=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdTextura());
			pstm.setString(2, x.getDescripcion());
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
	
	
	public int eliminarTextura(String cod){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="delete from textura where idTextura=?";
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
	
	public ArrayList<TexturaBean> listarTextura(){
		ArrayList<TexturaBean> data=new ArrayList<TexturaBean>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="select *from textura";
			//3
			pstm=cn.prepareStatement(sql);
			//4 para.
			//5 ejecutar
			rs=pstm.executeQuery();
			//6bucle
			while (rs.next()) {
				TexturaBean mar=new TexturaBean(rs.getString(1),
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
