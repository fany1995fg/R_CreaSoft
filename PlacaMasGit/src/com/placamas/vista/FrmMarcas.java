package com.placamas.vista;

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
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.placamas.beans.MarcasBean;
import com.placamas.controlador.MarcasControlador;

public class FrmMarcas extends JInternalFrame implements ActionListener {

	
	MarcasControlador obj=new MarcasControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	
	JTextField txtIdMarca;
	private JTextField txtDescripcion;
	JTable tbMarcas;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JSeparator separator;
	JPanel marcas;
	private JLabel label;
	private JSeparator separator_1;
	private JLabel lblListaDeMarcas;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMarcas frame = new FrmMarcas();
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
	public FrmMarcas() {
		
		marcas = new JPanel();
		marcas.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		marcas.add(toolBar);
		
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466476618_File.png")));
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475388_save.png")));

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
		
		
		
		
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
		
		JLabel lblIdMarca = new JLabel("C\u00F3digo de Marca:");
		lblIdMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdMarca.setBounds(63, 204, 118, 20);
		marcas.add(lblIdMarca);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(63, 245, 81, 20);
		
		marcas.add(lblDescripcion);
		
		

		txtIdMarca = new JTextField();
		txtIdMarca.setDocument(new LimiteJTextField(3));
		txtIdMarca.addKeyListener(new KeyAdapter() {
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
		txtIdMarca.setBounds(221, 206, 81, 20);
		txtIdMarca.setToolTipText("Escribe el Codigo de la Marca (3 Car)");
		marcas.add(txtIdMarca);
		
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(221, 247, 198, 20);
		txtDescripcion.setColumns(10);
		txtDescripcion.setToolTipText("Escribe una Descripción para la marca");
		marcas.add(txtDescripcion);
		
		
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEliminar.setToolTipText("Eliminar");
		btnGrabar.setToolTipText("Grabar");
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		Listar();
		
		//setDefaultCloseOperation(DISPOSE_ON_CLOSE ); //Se oculte al cerrara
		
		separator = new JSeparator();
		separator.setBounds(726, 132, 0, 2);
		marcas.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 342, 362, 222);
		marcas.add(scrollPane);		
		
		
		
		tbMarcas = new JTable();
		tbMarcas = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};
		tbMarcas.addKeyListener(new KeyAdapter() {
			@Override
			//DISEÑO CLIC DERECHO EN EL SCROL / EVENT /KEY/ KEYRELEASED
			public void keyReleased(KeyEvent arg0) {
				Mostrar();
			
			}
		});
		tbMarcas.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Mostrar();
			}
		});
		scrollPane.setViewportView(tbMarcas);
		tbMarcas.setModel(modelo);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmMarcas.class.getResource("/gui/img/banners/Marquitas.png")));
		label.setBounds(0, 33, 1364, 116);
		marcas.add(label);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 173, 1354, 20);
		marcas.add(separator_1);
		
		lblListaDeMarcas = new JLabel("Lista de Marcas:");
		lblListaDeMarcas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListaDeMarcas.setBounds(57, 316, 153, 20);
		marcas.add(lblListaDeMarcas);
		Listar();
		
		
		int fila=0;
		txtIdMarca.setText(""+tbMarcas.getValueAt(fila, 0));
		txtDescripcion.setText(""+tbMarcas.getValueAt(fila, 1));
		
		tbMarcas.requestFocus();
		tbMarcas.changeSelection(0,0,true, false);
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
		int [] anchos = {30, 200, 50};
		
		for (int i = 0; i < tbMarcas.getColumnCount(); i++) {
			tbMarcas.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
				
	}

	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}	

	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) {
        	
		String texto=txtIdMarca.getText();
		String descripcion=txtDescripcion.getText();
        texto=texto.replaceAll(" ", "");
        descripcion=descripcion.replaceAll(" ", "");
        
        if(descripcion.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco "+" 'Descripcion'");
            txtDescripcion.requestFocus();
        }
        else
        if(texto.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco"+" 'Codigo'");
            txtIdMarca.requestFocus();
        }
        else
        if(texto.length()>3 || texto.length()<3){
        	
            mensaje("ERROR: El Codigo debe de tener 3 caracteres");
            txtIdMarca.requestFocus();
        }
        else
        if(texto.length()==3){
        	estado=true;
        if(estado==true){ 	
		MarcasBean l=new MarcasBean(txtIdMarca.getText(), txtDescripcion.getText());
		int valor=obj.registrarMarcas(l);
		if(valor==1){
			
			mensaje("Registro Exitoso de Marca");

			Listar();
		 }
		tbMarcas.requestFocus();
		tbMarcas.changeSelection(0,0,true, false);
		
		txtIdMarca.setText(""+tbMarcas.getValueAt(0, 0));
		txtDescripcion.setText(""+tbMarcas.getValueAt(0, 1));
       }
	}		
        
        
}
	

protected void btnEliminarActionPerformed(ActionEvent arg0) {
		
	 int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?",null, JOptionPane.OK_CANCEL_OPTION );

		if(descicion==JOptionPane.OK_OPTION){
			
			int valor=obj.eliminarMarcas(txtIdMarca.getText());
			
			 if(valor==1){
				 if(tbMarcas.getSelectedRow() >=0 ){					 
					 ((DefaultTableModel)tbMarcas.getModel()).removeRow(tbMarcas.getSelectedRow());
				 }
					mensaje("Registro Eliminado");
					tbMarcas.requestFocus();
					tbMarcas.changeSelection(0,0,true, false);
					
					
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
		txtIdMarca.setText("");
		txtDescripcion.setText("");
		txtIdMarca.requestFocus();
		estado=true;
	}
	
	void Listar(){
		modelo.setRowCount(0);
		
		ArrayList<MarcasBean> info=obj.listarMarcas();
		
		for(MarcasBean x:info){
			Object fila[]={x.getIdMarcas(),x.getDescripcion()};
			modelo.addRow(fila);
			
		}

	}
	void Mostrar(){
		
		int fila=tbMarcas.getSelectedRow();
		txtIdMarca.setText(""+tbMarcas.getValueAt(fila, 0));
		txtDescripcion.setText(""+tbMarcas.getValueAt(fila, 1));
		
	}
}





