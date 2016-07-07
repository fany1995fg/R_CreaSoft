package com.placamas.seguridad;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
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
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.placamas.beans.UsuarioBean;
import com.placamas.controlador.UsuarioControlador;


public class FrmCambioContraseña extends JInternalFrame implements ActionListener {

	
	UsuarioControlador obj=new UsuarioControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	
	private JTextField txtIdUser;
	private JTextField txtNomb_User;
	private JPasswordField txtPassword;
	public JTable tbUsuario;
	private JButton btnGrabar;
	//private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JSeparator separator;
	public JPanel GesUsu;
	private JSeparator separator_1;
	private JLabel lblListaDeUsuario;
	private JLabel lblNewLabel;
	private JButton btnCambiarContra;
	


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmCambioContraseña frame = new FrmCambioContraseña();
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
	public FrmCambioContraseña() {
		
		GesUsu = new JPanel();
		//GesUsu.addMouseListener((MouseListener) this);
		GesUsu.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 795, 35);
		GesUsu.add(toolBar);
		
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmCambioContraseña.class.getResource("/iconosmodernos/1466476618_File.png")));
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmCambioContraseña.class.getResource("/iconosmodernos/1466475388_save.png")));

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmCambioContraseña.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
		
		
		
		
		btnEliminar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				btnEliminarActionPerformed(arg0);
			}
		});
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGrabarActionPerformed(arg0);
			}
		});
		btnNuevo.addActionListener(this);
		
		JLabel lblIdMarca = new JLabel("C\u00F3digo de Usuario:");
		lblIdMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdMarca.setBounds(63, 204, 118, 20);
		GesUsu.add(lblIdMarca);
		
		JLabel lblDescripcion = new JLabel("Nombre de Usuario:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(63, 245, 118, 20);
		
		GesUsu.add(lblDescripcion);
		
		

		txtIdUser = new JTextField();
		txtIdUser.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent evt) {
				
				char c=evt.getKeyChar();
				if(Character.isLowerCase(c)){
					String cad=(""+c).toUpperCase();
					c=cad.charAt(0);
					evt.setKeyChar(c);
				}
			}
		});
		txtIdUser.setBounds(221, 206, 143, 20);
		txtIdUser.setColumns(10);
		txtIdUser.setToolTipText("Escribe el Codigo de la Marca (3 Car)");
		GesUsu.add(txtIdUser);
		
		
		txtNomb_User = new JTextField();
		txtNomb_User.setBounds(221, 247, 143, 20);
		txtNomb_User.setColumns(10);
		txtNomb_User.setToolTipText("Escribe una Descripción para la marca");
		GesUsu.add(txtNomb_User);
		
		
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEliminar.setToolTipText("Eliminar");
		btnGrabar.setToolTipText("Grabar");
		
		btnCambiarContra = new JButton("");
		btnCambiarContra.setIcon(new ImageIcon(FrmCambioContraseña.class.getResource("/iconosmodernos/1466476622_common-new-edit-compose-glyph.png")));
		btnCambiarContra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				FrmCambiar cambio = new FrmCambiar();
				cambio.setVisible(true);
			}
		});
		toolBar.add(btnCambiarContra);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		modelo.addColumn("Contraseña");
		Listar();
		
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE ); //Se oculte al cerrara
		
		separator = new JSeparator();
		separator.setBounds(726, 132, 0, 2);
		GesUsu.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 342, 380, 220);
		GesUsu.add(scrollPane);		
		
		
		
		tbUsuario = new JTable();
		tbUsuario.addKeyListener(new KeyAdapter() {
			@Override
			//DISEÑO CLIC DERECHO EN EL SCROL / EVENT /KEY/ KEYRELEASED
			public void keyReleased(KeyEvent arg0) {
				Mostrar();
			
			}
		});
		tbUsuario.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Mostrar();
			}
		});
		scrollPane.setViewportView(tbUsuario);
		tbUsuario.setModel(modelo);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 173, 1354, 20);
		GesUsu.add(separator_1);
		
		lblListaDeUsuario = new JLabel("Lista de Usuario:");
		lblListaDeUsuario.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListaDeUsuario.setBounds(57, 316, 153, 20);
		GesUsu.add(lblListaDeUsuario);
		Listar();
		
		
		//tbMarcas.setFocusable(true);
		//tbMarcas.getValueAt(0,0);
		
		
		int fila=0;
		txtIdUser.setText(""+tbUsuario.getValueAt(fila, 0));
		txtNomb_User.setText(""+tbUsuario.getValueAt(fila, 1));
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a:");
		lblContrasea.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblContrasea.setBounds(429, 208, 118, 20);
		GesUsu.add(lblContrasea);
		
		txtPassword =  new JPasswordField();
		txtPassword.setBounds(536, 209, 153, 20);
		GesUsu.add(txtPassword);
		txtPassword.setColumns(10);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmCambioContraseña.class.getResource("/gui/img/banners/Img_Banner_usuarios_.jpg")));
		lblNewLabel.setBounds(10, 32, 775, 130);
		GesUsu.add(lblNewLabel);
		
		
		//tbMarcas.requestFocus();
		//tbMarcas.changeSelection(0,0,true, true);
		
		//tbMarcas.getValueAt(0, 0).setFocus();
		//tbMarcas.setFocusable(true);
		//tbMarcas.requestFocusInWindow();
		//tbMarcas.requestFocus(true);
		//tbMarcas.requestFocus();
		
		tamañoTablas();
		
		}
		
	private void tamañoTablas() {
			
			int [] anchos = {15, 40, 40};
			
			for (int i = 0; i < tbUsuario.getColumnCount(); i++) {
				tbUsuario.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
			}
					
		}
	
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}	

	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) {
		
		String texto=txtIdUser.getText();
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");
            
        }
        else
        if(texto.length()>11 || texto.length()<3){
        	
            mensaje("ERROR: Solo se aceptan de 3 a 11 caracteres");
            
        }
        else
        if(texto.length()>0 || texto.length()<11){
        	estado=true;
        if(estado==true){ 	
		UsuarioBean l=new UsuarioBean(txtIdUser.getText(), txtNomb_User.getText(),txtPassword.getText());
		int valor=obj.insertaUsuario(l);
		if(valor==1){
			
			mensaje("Registro Exitoso de Usuario");
			estado=false;
			Listar();
			}
       }
	}
	/*else{
		MarcasBean l=new MarcasBean(txtIdUser.getText(), txtNomb_User.getText());
		int valor=obj.actualizarMarcas(l);
		if(valor==1){
			mensaje("Actualizado Correctamente");
		Listar();
		}
		else
			mensaje("Error");
	}*/
        
		
}
	

protected void btnEliminarActionPerformed(ActionEvent arg0) {
	
	
	 int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?");

		if(descicion==JOptionPane.YES_OPTION){
			
			int valor=obj.eliminarUsuario(txtIdUser.getText());
			
			 if(valor==1){
				 if(tbUsuario.getSelectedRow() >=0 ){					 
					 ((DefaultTableModel)tbUsuario.getModel()).removeRow(tbUsuario.getSelectedRow());
				 }
					mensaje("Registro Eliminado");
					txtIdUser.setText("");
					txtNomb_User.setText("");
			 }
			 else
					mensaje("Error al Eliminar");
			 
			}

		if(descicion==JOptionPane.NO_OPTION){

			mensaje("El Registro no se Elimino");
		}
		
	
	}


	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNuevo) {
			btnNuevoActionPerformed(arg0);
		}
	}
	protected void btnNuevoActionPerformed(ActionEvent arg0) {
		txtIdUser.setText("");
		txtNomb_User.setText("");
		txtPassword.setText("");
		txtIdUser.requestFocus();
		estado=true;
	}
	
	void Listar(){
		modelo.setRowCount(0);
		ArrayList<UsuarioBean> info=obj.listarUsuario();
		for(UsuarioBean x:info){
			Object fila[]={x.getIdUser(),x.getUser_Nomb(),x.getUser_Pasw()};
			modelo.addRow(fila);
			
		}

	}
	void Mostrar(){
		
		int fila=tbUsuario.getSelectedRow();
		txtIdUser.setText(""+tbUsuario.getValueAt(fila, 0));
		txtNomb_User.setText(""+tbUsuario.getValueAt(fila, 1));
		txtPassword.setText(""+tbUsuario.getValueAt(fila, 1));
		
	}
}



