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

import com.placamas.beans.MarcasBean;
import com.placamas.beans.TexturaBean;
import com.placamas.controlador.TexturaControlador;

public class FrmTextura extends JInternalFrame implements ActionListener{

	TexturaControlador obj=new TexturaControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	
	private JTextField txtIdTextura;
	private JTextField txtDescripcion;
	JTable tbTextura;
	private JButton btnGrabar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel lblNewLabel;
	private JSeparator separator;
	JPanel textura;
	private JLabel label;
	private JLabel lblListaDeTexturas;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTextura frame = new FrmTextura();
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
	public FrmTextura() {
		
		textura = new JPanel();
		textura.setLayout(null);
		
		JLabel lblIdTextura = new JLabel("C\u00F3digo de Textura");
		lblIdTextura.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblIdTextura.setBounds(92, 195, 146, 19);
		textura.add(lblIdTextura);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescripcion.setBounds(92, 226, 137, 15);
		textura.add(lblDescripcion);
		
		txtIdTextura = new JTextField();
		txtIdTextura.setDocument(new LimiteJTextField(2));
		txtIdTextura.addKeyListener(new KeyAdapter() {
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
		txtIdTextura.setBounds(270, 194, 100, 19);
		txtIdTextura.setToolTipText("Escribe el Codigo de la Marca (2 Car)");
		textura.add(txtIdTextura);
		txtIdTextura.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(270, 225, 146, 19);
		txtDescripcion.setToolTipText("Escribe una Descripción para el textura");
		textura.add(txtDescripcion);
		
	
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 347, 359, 224);
		textura.add(scrollPane);
		
		tbTextura = new JTable();
		tbTextura = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};
		tbTextura.addKeyListener(new KeyAdapter() {
			@Override
			//DISEÑO CLIC DERECHO EN EL SCROL / EVENT /KEY/ KEYRELEASED
			public void keyReleased(KeyEvent arg0) {
				Mostrar();
			}
		});
		tbTextura.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Mostrar();
			}
		});
		scrollPane.setViewportView(tbTextura);


		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		tbTextura.setModel(modelo);
		Listar();
		setDefaultCloseOperation(HIDE_ON_CLOSE); //Se oculte al cerrara
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		textura.add(toolBar);
		
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
		lblNewLabel.setIcon(new ImageIcon(FrmTextura.class.getResource("/gui/img/banners/Textura.jpg")));
		lblNewLabel.setBounds(0, 41, 1024, 120);
		textura.add(lblNewLabel);
		
		separator = new JSeparator();
		separator.setBounds(0, 173, 1194, 14);
		textura.add(separator);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmTextura.class.getResource("/gui/img/banners/Textura.jpg")));
		label.setBounds(170, 32, 1024, 120);
		textura.add(label);
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
		
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEliminar.setToolTipText("Eliminar");
		btnGrabar.setToolTipText("Grabar");
		
		tbTextura.requestFocus();
		tbTextura.changeSelection(0,0,true, false);
		
		int fila=0;
		txtIdTextura.setText(""+tbTextura.getValueAt(fila, 0));
		txtDescripcion.setText(""+tbTextura.getValueAt(fila, 1));
		
		lblListaDeTexturas = new JLabel("Lista de Texturas:");
		lblListaDeTexturas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListaDeTexturas.setBounds(57, 316, 153, 20);
		textura.add(lblListaDeTexturas);
		
		tamañoTablas();
	}
	
private void tamañoTablas() {
		
		int [] anchos = {40, 200, 50};
		
		for (int i = 0; i < tbTextura.getColumnCount(); i++) {
			tbTextura.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
				
	}
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}
	
	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) {
		
		String texto=txtIdTextura.getText();
		String descripcion=txtDescripcion.getText();
		descripcion=descripcion.replaceAll(" ", "");
        texto=texto.replaceAll(" ", "");
        
        if(texto.length()==0){
        	
        	mensaje("ERROR: No se acepta 'CODIGO' en blanco");
            txtIdTextura.requestFocus();
        }
        else
        if(descripcion.length()==0){
        	
        	mensaje("ERROR: No se acepta 'DESCRIPCION' en blanco");
            txtDescripcion.requestFocus();
        }
        else
        if(texto.length()>2 || texto.length()<2){
        	
            mensaje("ERROR: Solo se aceptan 2 caracteres");
            
        }
        else
        if(texto.length()==2){
        	estado=true;
        if(estado==true){ 	
		TexturaBean l=new TexturaBean(txtIdTextura.getText(), txtDescripcion.getText());
		int valor=obj.registrarTextura(l);
		if(valor==1){
			
			mensaje("Registro Exitoso de Marca");
			estado=false;
			Listar();
			tbTextura.requestFocus();
			tbTextura.changeSelection(0,0,true, false);
			
			txtIdTextura.setText(""+tbTextura.getValueAt(0, 0));
			txtDescripcion.setText(""+tbTextura.getValueAt(0, 1));
			}
		
       }
	}
		
}
	

protected void btnEliminarActionPerformed(ActionEvent arg0) {
	
	
		int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?",null, JOptionPane.OK_CANCEL_OPTION );
	
		if(descicion==JOptionPane.OK_OPTION){
			
			int valor=obj.eliminarTextura(txtIdTextura.getText());
			
			 if(valor==1){
				 if(tbTextura.getSelectedRow() >=0 ){					 
					 ((DefaultTableModel)tbTextura.getModel()).removeRow(tbTextura.getSelectedRow());
				 }
					mensaje("Registro Eliminado");
					
					tbTextura.requestFocus();
					tbTextura.changeSelection(0,0,true, false);
					
					txtIdTextura.setText(""+tbTextura.getValueAt(0, 0));
					txtDescripcion.setText(""+tbTextura.getValueAt(0, 1));
					
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
		txtIdTextura.setText("");
		txtDescripcion.setText("");
		txtIdTextura.requestFocus();
		estado=true;
	}
	
	void Listar(){
		modelo.setRowCount(0);
		ArrayList<TexturaBean> info=obj.listarTextura();
		for(TexturaBean x:info){
			Object fila[]={x.getIdTextura(),x.getDescripcion()};
			modelo.addRow(fila);
			
		}
			

	}
	void Mostrar(){
	
		int fila=tbTextura.getSelectedRow();
		txtIdTextura.setText(""+tbTextura.getValueAt(fila, 0));
		txtDescripcion.setText(""+tbTextura.getValueAt(fila, 1));
		
	}
	
}
