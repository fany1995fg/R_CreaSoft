package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.placamas.beans.ProvinciaBean;
import com.placamas.conexion.ConexionDB;


public class ProvinciaControlador {

	public int inserta(ProvinciaBean bean){
		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="insert into ubprovincia values(null,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getProvincia());
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
	public int actualiza(ProvinciaBean bean){
		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="update ubprovincia set provincia=? where idProv=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getProvincia());
			pstm.setInt(2, bean.getIdProv());
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
			String sql ="delete from ubprovincia where idProv=?";
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
	public ProvinciaBean busca(int codigo){
		ProvinciaBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="select * from ubprovincia where idProv=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				bean = new ProvinciaBean();
				bean.setIdProv(rs.getInt("idProv"));
				bean.setProvincia(rs.getString("provincia"));
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
	public ArrayList<ProvinciaBean> lista(){
		
		ArrayList<ProvinciaBean> data = new ArrayList<ProvinciaBean>();
		ProvinciaBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="select * from ubprovincia";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				bean = new ProvinciaBean();
				bean.setIdProv(rs.getInt("idProv"));
				bean.setProvincia(rs.getString("provincia"));
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
