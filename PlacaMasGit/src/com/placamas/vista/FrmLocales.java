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
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

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
	private JPanel panel;
	private JButton btnEditar;
	private JButton btnEditarNo;
	private JSeparator separator;

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


		modelo.addColumn("Codigo");
		modelo.addColumn("Nombre");
		Listar();
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 135, 30);
		locales.add(toolBar);
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmLocales.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(FrmLocales.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		toolBar.add(btnEditar);
		
				btnEliminar = new JButton("");
				toolBar.add(btnEliminar);
				btnEliminar.setIcon(new ImageIcon(FrmLocales.class.getResource("/Iconos_PlacaMas/_Erase.png")));
				
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnEliminarActionPerformed(arg0);
					}
				});
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		
		btnEditarNo = new JButton("");
		btnEditarNo.setIcon(new ImageIcon(FrmLocales.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		toolBar.add(btnEditarNo);
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmLocales.class.getResource("/Iconos_PlacaMas/_Save.png")));
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmLocales.class.getResource("/gui/img/banners/loca3.png")));
		label_1.setBounds(10, 24, 598, 108);
		getContentPane().add(label_1);
		locales.setLayout(null);
		locales.add(toolBar);
		
		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(0, 33, 1194, 65);
		lblBanner.setIcon(new ImageIcon(FrmLocales.class.getResource("/gui/img/banners/BanColor.png")));
		locales.add(lblBanner);
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de Locales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 121, 1113, 495);
		locales.add(panel);
		panel.setLayout(null);
		
		JLabel lblIdLocal = new JLabel("C\u00F3digo de Local :");
		lblIdLocal.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdLocal.setBounds(47, 40, 115, 20);
		panel.add(lblIdLocal);
		lblIdLocal.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txtIdLocal = new JTextField();
		txtIdLocal.setBounds(172, 41, 115, 20);
		panel.add(txtIdLocal);
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
		txtIdLocal.setToolTipText("Escribe un id para el Local");
		txtIdLocal.setColumns(10);
		
		JLabel lblLoc_Nomb = new JLabel("Nombre del Local:");
		lblLoc_Nomb.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLoc_Nomb.setBounds(47, 72, 115, 20);
		panel.add(lblLoc_Nomb);
		lblLoc_Nomb.setFont(new Font("Tahoma", Font.PLAIN, 11));
		
		txtLoc_Nomb = new JTextField();
		txtLoc_Nomb.setBounds(172, 73, 178, 20);
		panel.add(txtLoc_Nomb);
		txtLoc_Nomb.setToolTipText("Escribe una descripción para el Local");
		txtLoc_Nomb.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 136, 327, 300);
		panel.add(scrollPane);
		
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
		txtIdLocal.setText(""+tbLocales.getValueAt(fila, 0));
		txtLoc_Nomb.setText(""+tbLocales.getValueAt(fila, 1));
		
		tbLocales.requestFocus();
		tbLocales.changeSelection(0,0,true, false);
		
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





