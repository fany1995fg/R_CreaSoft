package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.placamas.beans.ColoresBean;
import com.placamas.conexion.ConexionDB;

public class ColoresControlador {

	public int registrarColores(ColoresBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {

			cn=new ConexionDB().getConexion();

			String sql="insert into colores values(?,?,?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdColor());
			pstm.setString(2, x.getDescripcion());
			pstm.setString(3, x.getMatch_tab());
			pstm.setString(4, x.getMatch_can());
			
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
	public int actualizarColores(ColoresBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=new ConexionDB().getConexion();
			String sql="update colores set idColor=?,Descripcion=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdColor());
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
	public int eliminarColores(String cod){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="delete from colores where idColor=?";
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
	
	public ArrayList<ColoresBean> listarColores(){
		ArrayList<ColoresBean> data=new ArrayList<ColoresBean>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="select * from colores";
			//3
			pstm=cn.prepareStatement(sql);
			//4 para.
			//5 ejecutar
			rs=pstm.executeQuery();
			//6bucle
			while (rs.next()) {
				ColoresBean mar=new ColoresBean(rs.getString(1),rs.getString(2), rs.getString(3), rs.getString(4));
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
	
	
	/*public MarcasBean get(String cod) {
		MarcasBean marca = null;
        String sql="select * from cliente where idcliente=?";
        try {
            Connection cn= null;
            PreparedStatement pstm=null;
    		ResultSet rs=null;
            
    		pstm.setString(1, cod);
            
            marca= new marca();
            if(rs.next()){
            	marca.setIdMarcas(rs.getInt(1));
            	marca.setNombre(rs.getString(2));
            }
            cn.close();
            ps.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        return  marca;
    }*/
	
}