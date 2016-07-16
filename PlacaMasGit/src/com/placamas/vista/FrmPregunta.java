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
import javax.swing.ImageIcon;

public class FrmPregunta extends JFrame implements ActionListener{
	
	private static final Iniciar Iniciar = null;
	private JTextField txtResp;
	Boolean estado=false;
	JButton btnVerificar;
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
		this.setSize(439, 248);
		this.setLocationRelativeTo(null);
	    this.setTitle("PlacaMas Version 1.0");
		
		lblIngresarIdDe = new JLabel("Ingresar ID de usuario:");
		lblIngresarIdDe.setBounds(54, 43, 122, 14);
		getContentPane().add(lblIngresarIdDe);
		
		txtIdUser = new JTextField();
		txtIdUser.setColumns(10);
		txtIdUser.setBounds(236, 40, 128, 20);
		getContentPane().add(txtIdUser);
		
		JLabel lblIngre = new JLabel("Ingresar su respuesta:");
		lblIngre.setBounds(54, 117, 122, 14);
		getContentPane().add(lblIngre);

		
		txtResp = new JTextField();
		txtResp.setBounds(236, 114, 128, 20);
		getContentPane().add(txtResp);
		txtResp.setColumns(10);
		
		btnVerificar = new JButton("Verificar");
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVerificarActionPerformed(arg0);
			}
		});
		btnVerificar.setBounds(165, 159, 89, 23);
		getContentPane().add(btnVerificar);
		
		JLabel label = new JLabel("");
		label.setBounds(65, 80, 284, 20);
		getContentPane().add(label);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(FrmPregunta.class.getResource("/recursos/aceptar.png")));
		button.setBounds(374, 39, 30, 23);
		getContentPane().add(button);
		
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


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}
