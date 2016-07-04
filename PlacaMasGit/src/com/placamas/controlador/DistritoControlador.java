package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.placamas.beans.DistritoBean;
import com.placamas.conexion.ConexionDB;


public class DistritoControlador {

	public int inserta(DistritoBean bean){
		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="insert into ubdistrito values(null,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getDistrito());
			contador = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return contador;
	}
	public int actualiza(DistritoBean bean){
		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="update ubdistrito set distrito=? where idDist=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getDistrito());
			pstm.setInt(2, bean.getIdDist());
			contador = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return contador;
	}
	public int elimina(int codigo) {
		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="delete from ubdistrito where idDist=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			contador = pstm.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return contador;
	}
	public DistritoBean busca(int codigo){
		DistritoBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="select * from ubdistrito where idDist=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				bean = new DistritoBean();
				bean.setIdDist(rs.getInt("idDist"));
				bean.setDistrito(rs.getString("distrito"));
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return bean;
	}
	public ArrayList<DistritoBean> lista(){
		
		ArrayList<DistritoBean> data = new ArrayList<DistritoBean>();
		DistritoBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="select * from ubdistrito";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				bean = new DistritoBean();
				bean.setIdDist(rs.getInt("idDist"));
				bean.setDistrito(rs.getString("distrito"));
				data.add(bean);
			}
		} catch (Exception e) {
			System.out.println(e);
		} finally{
			try {
				conn.close();
				pstm.close();
			} catch (SQLException e) {
			}
		}
		return data;
	}
}
