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

import java.awt.Font;
import java.awt.Color;

import javax.swing.SwingConstants;

import java.awt.Component;

public class FrmPregunta extends JFrame implements ActionListener{
	
	private static final Iniciar Iniciar = null;
	private JTextField txtResp;
	Boolean estado=false;
	JButton btnVerificar;
	private JLabel lblIngresarIdDe;
	JTextField txtIdUser;

	private UsuarioControlador model = new UsuarioControlador();
	private JLabel lblPregunta;
	
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
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		getContentPane().setLayout(null);
		this.setSize(504, 266);
		this.setLocationRelativeTo(null);
	    this.setTitle("Pregunta Secreta...");
		
		lblIngresarIdDe = new JLabel("Usuario : ");
		lblIngresarIdDe.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblIngresarIdDe.setBounds(26, 44, 115, 25);
		getContentPane().add(lblIngresarIdDe);
		
		txtIdUser = new JTextField();
		txtIdUser.setColumns(10);
		txtIdUser.setBounds(150, 42, 160, 25);
		getContentPane().add(txtIdUser);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(FrmPregunta.class.getResource("/recursos/consultar.png")));
		button.setBounds(328, 30, 35, 35);
		getContentPane().add(button);
	
		lblPregunta = new JLabel("Pregunta : ");
		lblPregunta.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblPregunta.setBounds(26, 80, 115, 25);
		getContentPane().add(lblPregunta);
		
		JLabel lblPruebaDeTexto = new JLabel("");
		lblPruebaDeTexto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPruebaDeTexto.setBounds(150, 80, 234, 25);
		getContentPane().add(lblPruebaDeTexto);
		
		JLabel lblIngre = new JLabel("Respuesta : ");
		lblIngre.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		lblIngre.setBounds(26, 116, 126, 25);
		getContentPane().add(lblIngre);

		
		txtResp = new JTextField();
		txtResp.setBounds(150, 120, 234, 25);
		getContentPane().add(txtResp);
		txtResp.setColumns(10);
		
		btnVerificar = new JButton("Aceptar");
		btnVerificar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnVerificar.setIcon(new ImageIcon(FrmPregunta.class.getResource("/recursos/aceptar.png")));
		btnVerificar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnVerificarActionPerformed(arg0);
			}
		});
		btnVerificar.setBounds(150, 167, 145, 38);
		getContentPane().add(btnVerificar);
		
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
					JOptionPane.showMessageDialog(this, "ERROR: Datos ingresardos incorrectos !!");
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
