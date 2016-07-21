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
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import com.placamas.beans.LocalBean;
import com.placamas.beans.MarcasBean;
import com.placamas.beans.MedidasBean;
import com.placamas.controlador.MedidasControlador;

import javax.swing.JCheckBox;

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
		medidas.setLayout(null);
		
		JLabel lblIdMedidas = new JLabel("C\u00F3digo de Medidas:");
		lblIdMedidas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdMedidas.setBounds(57, 207, 146, 18);
		medidas.add(lblIdMedidas);
		
		JLabel lblMedidas = new JLabel("Medida:");
		lblMedidas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMedidas.setBounds(57, 254, 137, 15);
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
		txtIdMedidas.setBounds(213, 207, 80, 19);
		txtIdMedidas.setColumns(10);
		txtIdMedidas.setToolTipText("Escribe el Codigo de la Medida");
		medidas.add(txtIdMedidas);
		
		txtMedidas = new JTextField();
		txtMedidas.setBounds(213, 252, 80, 19);
		txtMedidas.setColumns(10);
		txtMedidas.setToolTipText("Escribe una Descripción para la medida");
		medidas.add(txtMedidas);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(77, 342, 323, 224);
		medidas.add(scrollPane);		
		
		modelo.addColumn("Tipo");
		modelo.addColumn("Medida");
		modelo.addColumn("Tablero");
		modelo.addColumn("Tapa Cantos");
		Listar();
		
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
		tbMedidas.setModel(modelo);
		
		setDefaultCloseOperation(HIDE_ON_CLOSE); //Se oculte al cerrara
		
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
		
		
		JLabel lblListaDeMedidas = new JLabel("Lista de Medidas:");
		lblListaDeMedidas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListaDeMedidas.setBounds(77, 316, 153, 20);
		medidas.add(lblListaDeMedidas);
		
		JCheckBox checkBox = new JCheckBox("Tapacanto", false);
		checkBox.setBounds(362, 246, 97, 23);
		medidas.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Tablero");
		checkBox_1.setSelected(false);
		checkBox_1.setMnemonic(KeyEvent.VK_1);
		checkBox_1.setBounds(362, 214, 97, 23);
		medidas.add(checkBox_1);
		
		JLabel label = new JLabel("Pertenece a :");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setBounds(352, 186, 153, 20);
		medidas.add(label);
		
		Listar();
		
		int fila=0;
		txtIdMedidas.setText(""+tbMedidas.getValueAt(fila, 0));
		txtMedidas.setText(""+tbMedidas.getValueAt(fila, 1));
			
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
		int [] anchos = {40, 30, 20, 20};
		
		for (int i = 0; i < tbMedidas.getColumnCount(); i++) {
			tbMedidas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
				
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
