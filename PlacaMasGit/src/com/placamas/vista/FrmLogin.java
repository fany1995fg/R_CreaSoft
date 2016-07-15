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
import com.placamas.vista.FrmPregunta;

import java.awt.Color;

import javax.swing.UIManager;


@SuppressWarnings("serial")
public class FrmLogin extends JDialog implements ActionListener{
	
	public JLabel lblLogin, lblClave;
	public static JTextField txtLogin;
	public static JPasswordField txtClave;
	public static JTextField txtCamCont;
	public static JTextField txtLog;
	public JButton btnEnviar, btnCancelar;
	JButton btnOlvContra;
	public static String idUsuario;
	private UsuarioControlador model = new UsuarioControlador();
	private FrmPregunta FrmPregunta = new FrmPregunta();
	public Iniciar frm;
	private JLabel lblBienvenido;
	private JLabel lblPorFavorIngrese;
	
	public FrmLogin(Iniciar frm) {
		getContentPane().setForeground(new Color(255, 228, 196));
		getContentPane().setBackground(UIManager.getColor("ToolBar.floatingBackground"));
			this.frm = frm;
			
			getContentPane().setLayout(null);
			this.setSize(548, 381);
			this.setLocationRelativeTo(null);
		    this.setTitle("PlacaMas Version 1.0");
		    
			lblLogin = new JLabel("Usuario:");
			lblLogin.setForeground(new Color(0, 0, 0));
			lblLogin.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblLogin.setBounds(207,160,100,25);
			getContentPane().add(lblLogin);
			
			txtLogin = new JTextField();
			txtLogin.setBounds(338,162,160,25);
			txtLogin.addActionListener(this);
			getContentPane().add(txtLogin);
			
			lblClave = new JLabel("Contrase\u00F1a:");
			lblClave.setForeground(new Color(0, 0, 0));
			lblClave.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblClave.setBounds(207,198,121,25);
			getContentPane().add(lblClave);
			
			txtClave = new JPasswordField();
			txtClave.addActionListener(this);
			txtClave.setBounds(338,198,160,25);
			getContentPane().add(txtClave);
			
			btnEnviar = new JButton("Aceptar");
			btnEnviar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnEnviar.setIcon(new ImageIcon(FrmLogin.class.getResource("/recursos/aceptar.png")));
			btnEnviar.addActionListener(this);
			btnEnviar.setBounds(217,280,129,38);
			getContentPane().add(btnEnviar);
			
			btnCancelar = new JButton("Cancelar");
			btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
			btnCancelar.setIcon(new ImageIcon(FrmLogin.class.getResource("/recursos/cancelar.png")));
			btnCancelar.addActionListener(this);
			btnCancelar.setBounds(356,280,129,38);
			getContentPane().add(btnCancelar);
			
			JLabel lblBienvenidoAPlacamas = new JLabel("LOGIN PLACAMAS");
			lblBienvenidoAPlacamas.setForeground(new Color(0, 0, 0));
			lblBienvenidoAPlacamas.setFont(new Font("Tahoma", Font.BOLD, 23));
			lblBienvenidoAPlacamas.setBounds(27, 25, 411, 38);
			getContentPane().add(lblBienvenidoAPlacamas);
			
			JLabel label = new JLabel("");
			label.setIcon(new ImageIcon(FrmLogin.class.getResource("/iconos/1405731856_gnome-keyring-manager.png")));
			label.setBounds(37, 160, 145, 135);
			getContentPane().add(label);
			
			lblBienvenido = new JLabel("Bienvenido");
			lblBienvenido.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblBienvenido.setBounds(27, 70, 223, 25);
			getContentPane().add(lblBienvenido);
			
			lblPorFavorIngrese = new JLabel("Por Favor ingrese sus credenciales de acceso");
			lblPorFavorIngrese.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPorFavorIngrese.setBounds(27, 96, 344, 25);
			getContentPane().add(lblPorFavorIngrese);
			
			btnOlvContra = new JButton("¿Olvidaste tu contraseña?");
			btnOlvContra.setBackground(UIManager.getColor("Panel.background"));
			btnOlvContra.setForeground(Color.BLUE);
			btnOlvContra.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnOlvContraActionPerformed(arg0);
				}
			});
			btnOlvContra.setBorder(null);
			btnOlvContra.setBounds(338, 232, 160, 23);
			getContentPane().add(btnOlvContra);
			
			
			setVisible(true);
			setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			
			limpiar();
	}

	private void limpiar() {
		txtLogin.setText("");
		txtClave.setText("");
		
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
				}else {
						JOptionPane.showMessageDialog(this, "Usuario o Contraseña no valida!!!");
						txtLogin.requestFocus();
						limpiar();

					}
					
			}
			if(e.getSource() == btnCancelar){
				System.exit(0);
			}
		
	}
	
	protected void btnOlvContraActionPerformed(ActionEvent e) {
		
		FrmPregunta.setVisible(true);
		//this.setVisible(false);
      }
	
	
	public void windowDeactivated(WindowEvent e) {}
}





