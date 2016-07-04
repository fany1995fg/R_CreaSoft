package com.placamas.vista;

import java.awt.Color;
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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.JToolBar;
import javax.swing.JSeparator;

import com.placamas.beans.MarcasBean;
import com.placamas.beans.MaterialBean;
import com.placamas.controlador.MaterialControlador;

public class FrmMaterial extends JInternalFrame implements ActionListener {


	
	MaterialControlador obj=new MaterialControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	
	private JTextField txtIdMaterial;
	private JTextField txtDescripcion;
	JTable tbMaterial;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel lblNewLabel;
	private JSeparator separator;
	JPanel material;
	private JLabel lblListaDeMateriales;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMaterial frame = new FrmMaterial();
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
	public FrmMaterial() {
		
		material = new JPanel();
		//material.addMouseListener((MouseListener) this);
		material.setLayout(null);
		
		/*
		setTitle("Material");
		setClosable(true);
		setBounds(100, 100, 577, 511);
		getContentPane().setLayout(null);*/
		
		JLabel lblIdMaterial = new JLabel("C\u00F3digo de Material:");
		lblIdMaterial.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdMaterial.setBounds(86, 209, 146, 18);
		material.add(lblIdMaterial);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(86, 239, 137, 15);
		material.add(lblDescripcion);
		
		txtIdMaterial = new JTextField();
		txtIdMaterial.setBounds(264, 208, 128, 19);
		txtIdMaterial.setToolTipText("Escribe el Codigo de la Marca (3 Car)");
		material.add(txtIdMaterial);
		txtIdMaterial.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(264, 238, 253, 19);
		material.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 342, 675, 220);
		material.add(scrollPane);
		
		tbMaterial = new JTable();
		tbMaterial.addKeyListener(new KeyAdapter() {
			@Override
			//DISEÑO CLIC DERECHO EN EL SCROL / EVENT /KEY/ KEYRELEASED
			public void keyReleased(KeyEvent arg0) {
				Mostrar();
			}
		});
		tbMaterial.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Mostrar();
			}
		});
		scrollPane.setViewportView(tbMaterial);


		modelo.addColumn("codigo");
		modelo.addColumn("descripcion");
		tbMaterial.setModel(modelo);
		Listar();
		setDefaultCloseOperation(HIDE_ON_CLOSE); //Se oculte al cerrara
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		material.add(toolBar);
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466476618_File.png")));
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475388_save.png")));

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
		
		
		/*
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEliminar.setToolTipText("Eliminar");
		btnGrabar.setToolTipText("Grabar");
		*/
		///QUITANDOLE LOS BORDES A LOS BOTONES
		
		//		btnNuevo.setBorder(null);
			//	btnEliminar.setBorder(null);
				//btnGrabar.setBorder(null);

		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmMaterial.class.getResource("/gui/img/banners/BannerMateriales.png")));

		lblNewLabel.setBounds(0, 36, 1194, 115);
		material.add(lblNewLabel);
		
		
		
		separator = new JSeparator();
		separator.setBounds(0, 173, 1184, 14);
		material.add(separator);
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
		txtIdMaterial.setText(""+tbMaterial.getValueAt(fila, 0));
		txtDescripcion.setText(""+tbMaterial.getValueAt(fila, 1));
		
		lblListaDeMateriales = new JLabel("Lista de Materiales:");
		lblListaDeMateriales.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListaDeMateriales.setBounds(57, 316, 153, 20);
		material.add(lblListaDeMateriales);
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}
	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) {
		/*String texto=txtIdMarca.getText();
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
            System.out.println("no ai texto");
            
        }
        else
        {
            System.out.println("si lo ai ");
        }*/
        
		
		String texto=txtIdMaterial.getText();
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
		MaterialBean l=new MaterialBean(txtIdMaterial.getText(), txtDescripcion.getText());
		int valor=obj.registrarMaterial(l);
		if(valor==1){
			
			mensaje("Registro Exitoso de Marca");
			estado=false;
			Listar();
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
        
		
}
	

protected void btnEliminarActionPerformed(ActionEvent arg0) {
	
	
	 int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?");

		if(descicion==JOptionPane.YES_OPTION){
			
			int valor=obj.eliminarMaterial(txtIdMaterial.getText());
			
			 if(valor==1){
				 if(tbMaterial.getSelectedRow() >=0 ){					 
					 ((DefaultTableModel)tbMaterial.getModel()).removeRow(tbMaterial.getSelectedRow());
				 }
					mensaje("Registro Eliminado");
					txtIdMaterial.setText("");
					txtDescripcion.setText("");
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
		txtIdMaterial.setText("");
		txtDescripcion.setText("");
		txtDescripcion.requestFocus();
		estado=true;
	}
	
	void Listar(){
		modelo.setRowCount(0);
		ArrayList<MaterialBean> info=obj.listarMaterial();
		for(MaterialBean x:info){
			Object fila[]={x.getIdMaterial(),x.getDescripcion()};
			modelo.addRow(fila);
			
		}
			

	}
	void Mostrar(){
	
		int fila=tbMaterial.getSelectedRow();
		txtIdMaterial.setText(""+tbMaterial.getValueAt(fila, 0));
		txtDescripcion.setText(""+tbMaterial.getValueAt(fila, 1));
		
	}
}
