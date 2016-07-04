package com.placamas.vista;

import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.placamas.beans.UsuarioBean;
import com.placamas.controlador.UsuarioControlador;


@SuppressWarnings("serial")
public class FrmLogin extends JDialog implements ActionListener{
	
	public JLabel lblLogin, lblClave;
	public JTextField txtLogin;
	public JPasswordField txtClave;
	public static JTextField txtCamCont;
	public static JTextField txtLog;
	public JButton btnEnviar, btnLimpiar;
	
	public static String idUsuario;
	
	private UsuarioControlador model = new UsuarioControlador();
	public Iniciar frm;
	
	public FrmLogin(Iniciar frm) {
		getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
			this.frm = frm;
			
			getContentPane().setLayout(null);
			this.setSize(539, 358);
			this.setLocationRelativeTo(null);
		    this.setTitle("PlacaMas Version 1.0");
		    
			lblLogin = new JLabel("Usuario:");
			lblLogin.setForeground(SystemColor.activeCaption);
			lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblLogin.setBounds(39,107,100,25);
			getContentPane().add(lblLogin);
			
			txtLogin = new JTextField();
			txtLogin.setBounds(170,107,160,25);
			txtLogin.addActionListener(this);
			getContentPane().add(txtLogin);
			
			lblClave = new JLabel("Password:");
			lblClave.setForeground(SystemColor.activeCaption);
			lblClave.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblClave.setBounds(39,161,100,25);
			getContentPane().add(lblClave);
			
			txtClave = new JPasswordField();
			txtClave.addActionListener(this);
			txtClave.setBounds(170,164,160,25);
			getContentPane().add(txtClave);
			
			btnEnviar = new JButton("Entrar");
			btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnEnviar.setIcon(new ImageIcon(FrmLogin.class.getResource("/iconos/Lock.gif")));
			btnEnviar.addActionListener(this);
			btnEnviar.setBounds(115,245,107,38);
			getContentPane().add(btnEnviar);
			
			btnLimpiar = new JButton("Limpiar");
			btnLimpiar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnLimpiar.setIcon(new ImageIcon(FrmLogin.class.getResource("/iconos/Trash.gif")));
			btnLimpiar.addActionListener(this);
			btnLimpiar.setBounds(293,245,100,38);
			getContentPane().add(btnLimpiar);
			
			JLabel lblBienvenidoAPlacamas = new JLabel("Bienvenido a Placamas Version 1.0");
			lblBienvenidoAPlacamas.setForeground(SystemColor.activeCaption);
			lblBienvenidoAPlacamas.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblBienvenidoAPlacamas.setBounds(39, 26, 411, 38);
			getContentPane().add(lblBienvenidoAPlacamas);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(FrmLogin.class.getResource("/iconos/1405731856_gnome-keyring-manager.png")));
			label.setBounds(354, 75, 145, 135);
			getContentPane().add(label);
			
			
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			if(e.getSource() == btnEnviar || e.getSource()== txtLogin || e.getSource() == txtClave){
				
				String login = txtLogin.getText().trim();
				String clave = new String(txtClave.getPassword());
				
				UsuarioBean bean =  model.valida(login, clave);
				txtCamCont = new JTextField(""+txtClave);
				txtLog = new JTextField(""+txtLogin);
				
				if(bean!= null){
					idUsuario = bean.getIdUser();
					frm.setVisible(true);
					this.setVisible(false);
					frm.menu.muestraOpciones();
				}else{
					JOptionPane.showMessageDialog(this, "Usuario no valido");
				}
	
			}
			if(e.getSource() == btnLimpiar){
				txtLogin.setText("");
				txtClave.setText("");
				txtLogin.requestFocus();
			}
		
	}
	

	public void windowDeactivated(WindowEvent e) {}
}





