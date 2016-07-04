package com.placamas.vista;

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

import com.placamas.beans.LocalBean;
import com.placamas.beans.MarcasBean;
import com.placamas.beans.MedidasBean;
import com.placamas.controlador.MedidasControlador;

public class FrmMedidas extends JInternalFrame implements ActionListener {

	MedidasControlador obj=new MedidasControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	
	private JTextField txtIdMedidas;
	private JTextField txtMedidas;
	JTable tbMedidas;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel lblNewLabel;
	private JSeparator separator;
	JPanel medidas;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMedidas frame = new FrmMedidas();
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
	public FrmMedidas() {
		
		medidas = new JPanel();
		//medidas.addMouseListener((MouseListener) this);
		medidas.setLayout(null);
		
		/*
		setTitle("Medidas");
		setClosable(true);
		setBounds(100, 100, 577, 511);
		getContentPane().setLayout(null);*/
		
		JLabel lblIdMedidas = new JLabel("C\u00F3digo de Medidas:");
		lblIdMedidas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdMedidas.setBounds(49, 188, 146, 18);
		medidas.add(lblIdMedidas);
		
		JLabel lblMedidas = new JLabel("Medida:");
		lblMedidas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMedidas.setBounds(49, 235, 137, 15);
		medidas.add(lblMedidas);
		
		txtIdMedidas= new JTextField();
		txtIdMedidas.addKeyListener(new KeyAdapter() {
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
		txtIdMedidas.setBounds(205, 188, 128, 19);
		medidas.add(txtIdMedidas);
		txtIdMedidas.setColumns(10);
		txtIdMedidas.setToolTipText("Escribe el Codigo de la Medida");
		
		txtMedidas = new JTextField();
		txtMedidas.setBounds(205, 233, 253, 19);
		medidas.add(txtMedidas);
		txtMedidas.setColumns(10);
		txtMedidas.setToolTipText("Escribe una Descripción para la medida");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 342, 675, 220);
		medidas.add(scrollPane);		
		
		tbMedidas = new JTable();
		tbMedidas.addKeyListener(new KeyAdapter() {
			@Override
			//DISEÑO CLIC DERECHO EN EL SCROL / EVENT /KEY/ KEYRELEASED
			public void keyReleased(KeyEvent arg0) {
				Mostrar();
			
			}
		});
		tbMedidas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Mostrar();
			}
		});
		scrollPane.setViewportView(tbMedidas);


		modelo.addColumn("Tipo");
		modelo.addColumn("Medida");
		modelo.addColumn("Tablero");
		modelo.addColumn("Tapa Cantos");
		tbMedidas.setModel(modelo);
		Listar();
		setDefaultCloseOperation(HIDE_ON_CLOSE); //Se oculte al cerrara
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		medidas.add(toolBar);
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466476618_File.png")));
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475388_save.png")));

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
		
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmMedidas.class.getResource("/gui/img/banners/medidas.jpg")));

		lblNewLabel.setBounds(0, 36, 1205, 115);
		medidas.add(lblNewLabel);
		
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEliminar.setToolTipText("Eliminar");
		btnGrabar.setToolTipText("Grabar");
		
		separator = new JSeparator();
		separator.setBounds(10, 162, 1195, 14);
		medidas.add(separator);
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
		Listar();
		
		int fila=0;
		txtIdMedidas.setText(""+tbMedidas.getValueAt(fila, 0));
		txtMedidas.setText(""+tbMedidas.getValueAt(fila, 1));
		
		JLabel lblListaDeMedidas = new JLabel("Lista de Medidas:");
		lblListaDeMedidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListaDeMedidas.setBounds(57, 316, 153, 20);
		medidas.add(lblListaDeMedidas);
		
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
	}
	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) { 
		
		String texto=txtIdMedidas.getText();
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");
            
        }
        else
        if(texto.length()>3 || texto.length()<3){
        	
            mensaje("ERROR: Solo se aceptan 3 caracteres");
            
        }
        else
        if(texto.length()==3){
        	estado=true;
        if(estado==true){ 	
		MedidasBean l=new MedidasBean(txtIdMedidas.getText(), txtMedidas.getText());
		int valor=obj.registrarMedidas(l);
		if(valor==1){
			mensaje("Registro Exitoso de Marca");
			Listar();
			txtIdMedidas.setText("");
			txtMedidas.setText("");
			
			}
       }
	}
		
}
	

protected void btnEliminarActionPerformed(ActionEvent arg0) {
	
	
	 int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?");

		if(descicion==JOptionPane.YES_OPTION){
			
			int valor=obj.eliminarMedidas(txtIdMedidas.getText());
			
			 if(valor==1){
				 if(tbMedidas.getSelectedRow() >=0 ){					 
					 ((DefaultTableModel)tbMedidas.getModel()).removeRow(tbMedidas.getSelectedRow());
				 }
					mensaje("Registro Eliminado");
					txtIdMedidas.setText("");
					txtMedidas.setText("");
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
		txtIdMedidas.setText("");
		txtMedidas.setText("");
		txtMedidas.requestFocus();
		estado=true;
	}
	
	void Listar(){
		modelo.setRowCount(0);
		ArrayList<MedidasBean> info=obj.listarMedidas();
		for(MedidasBean x:info){
			Object fila[]={x.getIdMedidas(),x.getMedidas()};
			modelo.addRow(fila);
			
		}
			

	}
	void Mostrar(){
	
		int fila=tbMedidas.getSelectedRow();
		txtIdMedidas.setText(""+tbMedidas.getValueAt(fila, 0));
		txtMedidas.setText(""+tbMedidas.getValueAt(fila, 1));
		
	}
}
