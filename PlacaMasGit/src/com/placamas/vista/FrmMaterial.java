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
import javax.swing.border.TitledBorder;

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
	JPanel material;
	private JPanel panel;
	private JButton btnEditar;
	private JButton btnEditarNo;
	private JSeparator separator;


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
		material.setLayout(null);
				
				toolBar = new JToolBar();
				toolBar.setBounds(0, 0, 135, 30);
				material.add(toolBar);
				
				btnNuevo = new JButton("");
				toolBar.add(btnNuevo);
				btnNuevo.setIcon(new ImageIcon(FrmMaterial.class.getResource("/Iconos_PlacaMas/_New_document.png")));
				
				btnEditar = new JButton("");
				btnEditar.setIcon(new ImageIcon(FrmMaterial.class.getResource("/Iconos_PlacaMas/_Modify.png")));
				btnEditar.setToolTipText("Eliminar");
				toolBar.add(btnEditar);
				
						btnEliminar = new JButton("");
						toolBar.add(btnEliminar);
						btnEliminar.setIcon(new ImageIcon(FrmMaterial.class.getResource("/Iconos_PlacaMas/_Erase.png")));
						btnEliminar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								btnEliminarActionPerformed(arg0);
							}
						});
						btnNuevo.addActionListener(this);
						
						
						btnNuevo.setToolTipText("Nuevo Registro");
						btnEliminar.setToolTipText("Eliminar");
						
						separator = new JSeparator();
						separator.setOrientation(SwingConstants.VERTICAL);
						toolBar.add(separator);
						
						btnEditarNo = new JButton("");
						btnEditarNo.setIcon(new ImageIcon(FrmMaterial.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
						btnEditarNo.setToolTipText("Grabar");
						toolBar.add(btnEditarNo);
						
						btnGrabar = new JButton("");
						toolBar.add(btnGrabar);
						btnGrabar.setIcon(new ImageIcon(FrmMaterial.class.getResource("/Iconos_PlacaMas/_Save.png")));
						btnGrabar.addActionListener(new ActionListener() {
							public void actionPerformed(ActionEvent arg0) {
								btnGrabarActionPerformed(arg0);
							}
						});
						btnGrabar.setToolTipText("Grabar");
		
				lblNewLabel = new JLabel("");
				lblNewLabel.setIcon(new ImageIcon(FrmMaterial.class.getResource("/gui/img/banners/BannerMateriales.png")));
				lblNewLabel.setBounds(0, 33, 1194, 65);
				material.add(lblNewLabel);
		
		tbMaterial = new JTable();


		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		Listar();
		setDefaultCloseOperation(HIDE_ON_CLOSE); //Se oculte al cerrara
		Listar();
		
		
		int fila=0;
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de Material", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 121, 1113, 495);
		material.add(panel);
		panel.setLayout(null);
		
				
				JLabel lblIdMaterial = new JLabel("C\u00F3digo de Material:");
				lblIdMaterial.setBounds(47, 40, 115, 20);
				panel.add(lblIdMaterial);
				lblIdMaterial.setFont(new Font("Tahoma", Font.PLAIN, 13));
				
				JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
				lblDescripcion.setBounds(47, 72, 115, 20);
				panel.add(lblDescripcion);
				lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
				
				txtIdMaterial = new JTextField();
				txtIdMaterial.setBounds(172, 41, 115, 20);
				panel.add(txtIdMaterial);
				txtIdMaterial.setDocument(new LimiteJTextField(3));
				txtIdMaterial.addKeyListener(new KeyAdapter() {
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
				txtIdMaterial.setToolTipText("Escribe el Codigo de la Marca (3 Car)");
				txtIdMaterial.setColumns(10);
				
				txtDescripcion = new JTextField();
				txtDescripcion.setBounds(172, 73, 178, 20);
				panel.add(txtDescripcion);
				txtDescripcion.setToolTipText("Escribe una Descripción para el material");
				
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(35, 136, 411, 300);
				panel.add(scrollPane);
				tbMaterial = new JTable(){
					public boolean isCellEditable(int rowIndex, int colIndex){
						return false;
					}
				};
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
				tbMaterial.setModel(modelo);
				txtIdMaterial.setText(""+tbMaterial.getValueAt(fila, 0));
		
		tbMaterial.requestFocus();
		tbMaterial.changeSelection(0,0,true, false);
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
		int [] anchos = {40, 200, 50};
		
		for (int i = 0; i < tbMaterial.getColumnCount(); i++) {
			tbMaterial.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
				
	}
		
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}
	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) {
		
		String texto=txtIdMaterial.getText();
		String descripcion=txtDescripcion.getText();
		descripcion=descripcion.replaceAll(" ", "");
        texto=texto.replaceAll(" ", "");
        
        if(texto.length()==0){
        	
        	mensaje("ERROR: No se acepta 'CODIGO' en blanco");
            txtIdMaterial.requestFocus();
        }
        else
        if(descripcion.length()==0){
        	
        	mensaje("ERROR: No se acepta 'DESCRIPCION' en blanco");
            txtDescripcion.requestFocus();
        }
        else
        if(texto.length()>3 || texto.length()<3){
        	
            mensaje("ERROR: Solo se aceptan 3 caracteres");
            txtIdMaterial.requestFocus();
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
			tbMaterial.requestFocus();
	        tbMaterial.changeSelection(0,0,true, false);
			
	        txtIdMaterial.setText(""+tbMaterial.getValueAt(0, 0));
			txtDescripcion.setText(""+tbMaterial.getValueAt(0, 1));
			}
       }
        
	}	
}
	

protected void btnEliminarActionPerformed(ActionEvent arg0) {
	
	
	 int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?",null, JOptionPane.OK_CANCEL_OPTION );

		if(descicion==JOptionPane.OK_OPTION){
			
			int valor=obj.eliminarMaterial(txtIdMaterial.getText());
			
			 if(valor==1){
				 if(tbMaterial.getSelectedRow() >=0 ){					 
					 ((DefaultTableModel)tbMaterial.getModel()).removeRow(tbMaterial.getSelectedRow());
				 }
					mensaje("Registro Eliminado");
					
					tbMaterial.requestFocus();
					tbMaterial.changeSelection(0,0,true, false);
					
					txtIdMaterial.setText(""+tbMaterial.getValueAt(0, 0));
					txtDescripcion.setText(""+tbMaterial.getValueAt(0, 1));
					
			 }
		if(descicion==JOptionPane.CANCEL_OPTION){

			mensaje("El Registro no se Elimino");
			}
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
		txtIdMaterial.requestFocus();
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
