package com.placamas.controlador;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.placamas.beans.RutasBean;
import com.placamas.conexion.ConexionDB;

public class RutasControlador {
	
	public int registrarRutas(RutasBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {

			cn=new ConexionDB().getConexion();

			String sql="insert into rutas values(?,?)";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdRutas());
			pstm.setString(2, x.getRutas());
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
	public int actualizarRutas(RutasBean x){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			cn=new ConexionDB().getConexion();
			String sql="update rutas set idRutas=?,Rutas=?";
			pstm=cn.prepareStatement(sql);
			pstm.setString(1, x.getIdRutas());
			pstm.setString(2, x.getRutas());
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
	public int eliminarRutas(String cod){
		int valor=-1;
		Connection cn=null;
		PreparedStatement pstm=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="delete from rutas where idRutas=?";
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
	
	public ArrayList<RutasBean> listarRutas(){
		ArrayList<RutasBean> data=new ArrayList<RutasBean>();
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			//1
			cn=new ConexionDB().getConexion();
			//2
			String sql="select *from rutas";
			//3
			pstm=cn.prepareStatement(sql);
			//4 para.
			//5 ejecutar
			rs=pstm.executeQuery();
			//6bucle
			while (rs.next()) {
				RutasBean mar=new RutasBean(rs.getString(1),
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
