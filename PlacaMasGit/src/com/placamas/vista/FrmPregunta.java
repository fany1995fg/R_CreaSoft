package com.placamas.vista;


import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;

import com.placamas.beans.UsuarioBean;
import com.placamas.controlador.UsuarioControlador;
//import com.placamas.vista.FrmLogin;
import com.placamas.vista.Iniciar;



import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;

public class FrmPregunta extends JFrame implements ActionListener{
	
	private static final Iniciar Iniciar = null;
	private JTextField txtResp;
	Boolean estado=false;
	private JTextField txtPass;
	JButton btnVerificar;
	JButton btnAceptar;
	private JLabel lblIngresarIdDe;
	private JTextField txtIdUser;
	
	//private FrmLogin FrmLogin= new FrmLogin(Iniciar);
	
	private UsuarioControlador model = new UsuarioControlador();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPregunta frame = new FrmPregunta();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	public FrmPregunta(){
		
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		this.setSize(439, 285);
		this.setLocationRelativeTo(null);
	    this.setTitle("PlacaMas Version 1.0");

		
		txtResp = new JTextField();
		txtResp.setBounds(236, 71, 128, 20);
		getContentPane().add(txtResp);
		txtResp.setColumns(10);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVerificarActionPerformed(arg0);
			}
		});
		btnVerificar.setBounds(162, 112, 89, 23);
		getContentPane().add(btnVerificar);
		
		txtPass = new JTextField();
		txtPass.setColumns(10);
		txtPass.setBounds(236, 151, 128, 20);
		getContentPane().add(txtPass);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAceptarActionPerformed(arg0);
			}
		});
		btnAceptar.setBounds(162, 185, 89, 23);
		getContentPane().add(btnAceptar);
		
		JLabel lblIngre = new JLabel("Ingresar su respuesta:");
		lblIngre.setBounds(54, 74, 122, 14);
		getContentPane().add(lblIngre);
		
		JLabel lblIngresarlaNuevaContrasea = new JLabel("Ingresarla nueva contrase\u00F1a:");
		lblIngresarlaNuevaContrasea.setBounds(54, 154, 162, 14);
		getContentPane().add(lblIngresarlaNuevaContrasea);
		
		lblIngresarIdDe = new JLabel("Ingresar ID de usuario:");
		lblIngresarIdDe.setBounds(54, 43, 122, 14);
		getContentPane().add(lblIngresarIdDe);
		
		txtIdUser = new JTextField();
		txtIdUser.setColumns(10);
		txtIdUser.setBounds(236, 40, 128, 20);
		getContentPane().add(txtIdUser);
		
		limpiar();
		
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}
	private void limpiar() {
		txtIdUser.setText("");
		txtResp.setText("");
		
	}
	
	protected void btnVerificarActionPerformed(ActionEvent e) {
		
		if(e.getSource() == btnVerificar || e.getSource()== txtIdUser || e.getSource() == txtResp){
			
			String login = txtIdUser.getText().trim();
			String pregunta = txtResp.getText().trim();
			
			UsuarioBean bean =  model.Pregunta(login, pregunta);
			
			if(bean!= null){
				mensaje("Verificacion correcta");
				txtIdUser.setEnabled(false);
				txtResp.setEnabled(false);
			}else {
					JOptionPane.showMessageDialog(this, "Los datos ingresardos son incorrectos");
					txtIdUser.requestFocus();
					limpiar();

				}
				
		}
		
		
    }

	
	protected void btnAceptarActionPerformed(ActionEvent e) {
	
		String clave=txtPass.getText();
		
		String log=txtIdUser.getText();
		String pass=txtPass.getText();
		
		
		
		clave=clave.replaceAll(" ", "");
       
        
        if(clave.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");
            
        }
        else
        	if(e.getSource() == btnAceptar){
        	estado=true;
	        if(estado==true){ 	
	        	
	        	UsuarioBean bean =  model.cambiarContraseña(pass, log );
	        	if(bean!= null){
				mensaje("Se cambió de contraseña");
				
				}
        	  }
	        }
		
        //Iniciar.setVisible(true);
		this.setVisible(false);
		
		
	  }


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	
	
	
	
	
}
