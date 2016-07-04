package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.placamas.beans.DepartamentoBean;
import com.placamas.conexion.ConexionDB;


public class DepartamentoControlador {

	public int inserta(DepartamentoBean bean){
		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="insert into ubdepartamento values(null,?)";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getDepartamento());
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
	public int actualiza(DepartamentoBean bean){
		int contador = -1;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="update ubdepartamento set departamento=? where idDepa=?";
			pstm = conn.prepareStatement(sql);
			pstm.setString(1, bean.getDepartamento());
			pstm.setInt(2, bean.getIdDepa());
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
			String sql ="delete from ubdepartamento where idDepa=?";
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
	public DepartamentoBean busca(int codigo){
		DepartamentoBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="select * from ubdepartamento where idDepa=?";
			pstm = conn.prepareStatement(sql);
			pstm.setInt(1, codigo);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()){
				bean = new DepartamentoBean();
				bean.setIdDepa(rs.getInt("idDepa"));
				bean.setDepartamento(rs.getString("departamento"));
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
	public ArrayList<DepartamentoBean> lista(){
		
		ArrayList<DepartamentoBean> data = new ArrayList<DepartamentoBean>();
		DepartamentoBean bean = null;
		Connection conn = null;
		PreparedStatement pstm = null;
		try {
			conn = new ConexionDB().getConexion();
			String sql ="select * from ubdepartamento";
			pstm = conn.prepareStatement(sql);
			ResultSet rs = pstm.executeQuery();
			
			while(rs.next()){
				bean = new DepartamentoBean();
				bean.setIdDepa(rs.getInt("idDepa"));
				bean.setDepartamento(rs.getString("departamento"));
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
