package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.placamas.beans.MarcasBean;
import com.placamas.conexion.ConexionDB;



public class MarcasControlador {

	public int registrarMarcas(MarcasBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {

			cn=new ConexionDB().getConexion();

			String sql="insert into marcas values(?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdMarcas());
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
	public int actualizarMarcas(MarcasBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=new ConexionDB().getConexion();
			String sql="update marcas set idMarcas=?,Descripcion=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdMarcas());
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
	public int eliminarMarcas(String cod){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="delete from marcas where idMarcas=?";
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
	
	public ArrayList<MarcasBean> listarMarcas(){
		ArrayList<MarcasBean> data=new ArrayList<MarcasBean>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="select *from marcas";//"select ?  from user_data where IdUser = ?";
			//3
			pstm=cn.prepareStatement(sql);
			//4 para.
			//5 ejecutar
			rs=pstm.executeQuery();
			//6bucle
			while (rs.next()) {
				MarcasBean mar=new MarcasBean(rs.getString(1),
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
