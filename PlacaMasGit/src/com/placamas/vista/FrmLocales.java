package com.placamas.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
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
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.placamas.beans.LocalBean;
import com.placamas.beans.MarcasBean;
import com.placamas.controlador.LocalesControlador;

public class FrmLocales extends JInternalFrame implements ActionListener {

	LocalesControlador obj=new LocalesControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	
	private JTextField txtIdLocal;
	private JTextField txtLoc_Nomb;
	JTable tbLocales;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel label_1;
	JPanel locales;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLocales frame = new FrmLocales();
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
	public FrmLocales() {
		
		locales = new JPanel();
		locales.setLayout(null);


		modelo.addColumn("codigo");
		modelo.addColumn("nombre");
		Listar();
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		locales.add(toolBar);
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466476618_File.png")));
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475388_save.png")));

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmLocales.class.getResource("/gui/img/banners/loca3.png")));
		label_1.setBounds(10, 24, 598, 108);
		getContentPane().add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 342, 327, 220);
		
		tbLocales = new JTable();
		tbLocales.addKeyListener(new KeyAdapter() {
			@Override
			//DISEÑO CLIC DERECHO EN EL SCROL / EVENT /KEY/ KEYRELEASED
			public void keyReleased(KeyEvent arg0) {
				Mostrar();
			}
		});
		tbLocales.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Mostrar();
			}
		});
		scrollPane.setViewportView(tbLocales);
		tbLocales.setModel(modelo);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 162, 1194, 11);
		
		JLabel lblListaDeLocales = new JLabel("Lista de Locales:");
		lblListaDeLocales.setBounds(57, 316, 153, 20);
		lblListaDeLocales.setFont(new Font("Tahoma", Font.BOLD, 12));
		locales.setLayout(null);
		locales.add(toolBar);
		
		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(0, 30, 1194, 121);
		lblBanner.setIcon(new ImageIcon(FrmLocales.class.getResource("/gui/img/banners/BanColor.png")));
		locales.add(lblBanner);
		locales.add(separator);
		
		JLabel lblIdLocal = new JLabel("C\u00F3digo de Local :");
		lblIdLocal.setBounds(57, 231, 115, 20);
		lblIdLocal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		locales.add(lblIdLocal);
		
		txtIdLocal = new JTextField();
		txtIdLocal.addKeyListener(new KeyAdapter() {
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
		txtIdLocal.setBounds(190, 232, 127, 20);
		txtIdLocal.setToolTipText("Escribe un id para el Local");
		txtIdLocal.setColumns(10);
		locales.add(txtIdLocal);
		
		JLabel lblLoc_Nomb = new JLabel("Nombre del Local:");
		lblLoc_Nomb.setBounds(57, 263, 115, 20);
		lblLoc_Nomb.setFont(new Font("Tahoma", Font.PLAIN, 13));
		locales.add(lblLoc_Nomb);
		
		txtLoc_Nomb = new JTextField();
		txtLoc_Nomb.setBounds(190, 264, 194, 20);
		txtLoc_Nomb.setToolTipText("Escribe una descripción para el Local");
		txtLoc_Nomb.setColumns(10);
		locales.add(txtLoc_Nomb);
		locales.add(lblListaDeLocales);
		locales.add(scrollPane);
		
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
		setClosable(true); //->Se pueda cerrara
		setDefaultCloseOperation(HIDE_ON_CLOSE); //Se oculte al cerrara
		Listar();
		
		int fila=0;
		
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
		int [] anchos = {40, 200, 50};
		
		for (int i = 0; i < tbLocales.getColumnCount(); i++) {
			tbLocales.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
				
	}
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}
	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) { 
		
		String texto=txtIdLocal.getText();
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");
            
        }
        else
        if(texto.length()>5 || texto.length()<5){
        	
            mensaje("ERROR: Solo se aceptan 5 caracteres");
            
        }
        else
        if(texto.length()==5){
        	estado=true;
        if(estado==true){ 	
		LocalBean l=new LocalBean(txtIdLocal.getText(), txtLoc_Nomb.getText());
		int valor=obj.registrarLocal(l);
		if(valor==1){
			mensaje("Registro Exitoso de Marca");
			Listar();
			txtIdLocal.setText("");
			txtLoc_Nomb.setText("");
			
			}
       }
	}
		
}
	

protected void btnEliminarActionPerformed(ActionEvent arg0) {
	
	
	 int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?");

		if(descicion==JOptionPane.YES_OPTION){
			
			int valor=obj.eliminarLocal(txtIdLocal.getText());
			
			 if(valor==1){
				 if(tbLocales.getSelectedRow() >=0 ){					 
					 ((DefaultTableModel)tbLocales.getModel()).removeRow(tbLocales.getSelectedRow());
				 }
					mensaje("Registro Eliminado");
					txtIdLocal.setText("");
					txtLoc_Nomb.setText("");
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
		txtIdLocal.setText("");
		txtLoc_Nomb.setText("");
		txtLoc_Nomb.requestFocus();
		estado=true;
	}
	
	void Listar(){
		modelo.setRowCount(0);
		ArrayList<LocalBean> info=obj.listarLocal();
		for(LocalBean x:info){
			Object fila[]={x.getIdLocal(),x.getLoc_Nomb()};
			modelo.addRow(fila);
			
		}
			

	}
	void Mostrar(){
	
		int fila=tbLocales.getSelectedRow();
		txtIdLocal.setText(""+tbLocales.getValueAt(fila, 0));
		txtLoc_Nomb.setText(""+tbLocales.getValueAt(fila, 1));
		
	}
}





