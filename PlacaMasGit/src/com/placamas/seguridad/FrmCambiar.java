package com.placamas.seguridad;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.placamas.vista.FrmLogin;
import com.placamas.beans.UsuarioBean;

import com.placamas.controlador.UsuarioControlador;
import javax.swing.JCheckBox;



public class FrmCambiar extends JInternalFrame implements ActionListener{


	UsuarioControlador obj=new UsuarioControlador();
	DefaultTableModel modelo=new DefaultTableModel();
	boolean estado=false;
	
	private JTextField txtPassAct;
	private JTextField txtPassNew;
	private JButton btnGuardar;
	private JButton btnCancelar;
	
	public JPanel usuario;
	JSeparator separator;
	private JTextField txtPassNew1;
	private JTextField txtPalabClave;
	private String newc;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCambiar frame = new FrmCambiar();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmCambiar() {
		
		usuario = new JPanel();
		//textura.addMouseListener((MouseListener) this);
		usuario.setLayout(null);
		/*
		setTitle("Textura");
		setClosable(true);
		setBounds(100, 100, 577, 511);
		getContentPane().setLayout(null);*/
		
		JLabel lblPassActual = new JLabel("Ingresar Contraseña Actual:");
		lblPassActual.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPassActual.setBounds(52, 48, 175, 19);
		usuario.add(lblPassActual);
		
		txtPassAct = new JTextField();
		txtPassAct.setBounds(276, 46, 128, 19);
		txtPassAct.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		usuario.add(txtPassAct);
		txtPassAct.setColumns(10);
		
		JLabel lblNuevaCont = new JLabel("Ingresar Nueva Contaseña:");
		lblNuevaCont.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNuevaCont.setBounds(52, 78, 175, 15);
		usuario.add(lblNuevaCont);
		
		txtPassNew = new JTextField();
		txtPassNew.setBounds(276, 76, 128, 19);
		usuario.add(txtPassNew);
		txtPassNew.setColumns(10);
		
		JLabel lblRepetaLaContrasea = new JLabel("Repeta la Contraseña:");
		lblRepetaLaContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRepetaLaContrasea.setBounds(52, 108, 137, 15);
		usuario.add(lblRepetaLaContrasea);
		
		txtPassNew1 = new JTextField();
		txtPassNew1.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		txtPassNew1.setColumns(10);
		txtPassNew1.setBounds(276, 106, 128, 19);
		usuario.add(txtPassNew1);
		
		separator = new JSeparator();
		separator.setBounds(10, 140, 480, 14);
		usuario.add(separator);
		
		JLabel lblCampoOpcional = new JLabel("Campo Opcional");
		lblCampoOpcional.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCampoOpcional.setBounds(52, 146, 137, 15);
		usuario.add(lblCampoOpcional);
		
		txtPalabClave = new JTextField();
		txtPalabClave.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		txtPalabClave.setColumns(10);
		txtPalabClave.setBounds(276, 171, 128, 19);
		usuario.add(txtPalabClave);
		
		JLabel lblDeseaCambiarLa = new JLabel("Desea cambiar la palabra clave:");
		lblDeseaCambiarLa.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDeseaCambiarLa.setBounds(52, 173, 194, 15);
		usuario.add(lblDeseaCambiarLa);
		
		btnGuardar = new JButton("Guardar");
		btnGuardar.setBounds(98, 233, 89, 23);
		btnGuardar.addActionListener(this);
		usuario.add(btnGuardar);
		
		btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnCancelar.setBounds(251, 233, 89, 23);
		usuario.add(btnCancelar);
		
		JLabel lblCambioDeContrasea = new JLabel("Cambio de Contrase\u00F1a");
		lblCambioDeContrasea.setBounds(206, 11, 123, 26);
		usuario.add(lblCambioDeContrasea);
		
		
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}

	/*public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == FrmLogin.txtCamCont){
						
			if(bean!= null){
				idusuario = bean.getIdUser();
				frm.setVisible(true);
				this.setVisible(false);
				frm.menu.muestraOpciones();
			}else{
				JOptionPane.showMessageDialog(this, "usuario no valido");
			}
			
		}
		if(e.getSource() == btnCancelar){
			txtLogin.setText("");
			txtClave.setText("");
			txtLogin.requestFocus();
		}
	
}*/
	
	
	protected void btnGrabarActionPerformed(ActionEvent e) {
		
		String texto=txtPassAct.getText();
		String newc=FrmLogin.txtCamCont.getText();
		String pass=txtPassNew.getText();
		String log=FrmLogin.txtLog.getText();
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");
            
        }
        else
        if(txtPassNew !=txtPassNew1){
        	
            mensaje("ERROR: Los campos no coinciden");
            
        }
        else
        	if(txtPassAct == FrmLogin.txtCamCont  || txtPassNew==txtPassNew1){
        	estado=true;
	        if(estado==true){ 	
			//UsuarioBean l=new UsuarioBean(txtPassNew.getText(), FrmLogin.txtLog.getText());
	        	
	        	UsuarioBean bean =  obj.cambiarContraseña(pass, log );
	        	if(bean!= null){
				mensaje("Cambio de contraseña");
				}else{
					JOptionPane.showMessageDialog(this, "Usuario no valido");
				}
	       
        	}
         }
      }
	/*else{
		MarcasBean l=new MarcasBean(txtIdMarca.getText(), txtDescripcion.getText());
		int valor=obj.actualizarMarcas(l);
		if(valor==1){
			mensaje("Actualizado Correctamente");
		Listar();
		}
		else
			mensaje("Error");
	}*/
        
		

	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		String texto=txtPassAct.getText();
		newc = FrmLogin.txtCamCont.getText();
		
		
		String pass=txtPassNew.getText();
		
		String log=FrmLogin.txtLog.getText();
		
		
        texto=texto.replaceAll(" ", "");
        
        if(texto.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");
            
        }
        else
        	if(txtPassAct.getText() == FrmLogin.txtLog.getText()  || txtPassNew.getText()==txtPassNew1.getText()){
        	estado=true;
	        if(estado==true){ 	
			//UsuarioBean l=new UsuarioBean(txtPassNew.getText(), FrmLogin.txtLog.getText());
	        	
	        	UsuarioBean bean =  obj.cambiarContraseña(pass, log );
	        	if(bean!= null){
				mensaje("Cambio de contraseña");
				}else{
					JOptionPane.showMessageDialog(this, "Usuario no valido");
				}
	       
        	  }
	        }
        
        else
        if(txtPassNew.getText() != txtPassNew1.getText()){
        	
            mensaje("ERROR: Los campos no coinciden");
            
        }
             
	}
}

	