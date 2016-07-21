package com.placamas.vista;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
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
import javax.swing.table.DefaultTableModel;

import com.placamas.beans.ColoresBean;
import com.placamas.beans.MarcasBean;
import com.placamas.beans.MedidasBean;
import com.placamas.controlador.ColoresControlador;

import java.awt.SystemColor;

import javax.swing.JToolBar;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.JCheckBox;

public class FrmColores extends JInternalFrame implements ActionListener {

	
	ColoresControlador obj=new ColoresControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	JCheckBox cb1, cb2;
	int tab=0,tap=0;
	String math_tab,math_can;
	private JTextField txtIdColores;
	private JTextField txtDescripcion;
	JTable tbColores;
	private JButton btnGrabar;
	//private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel label_1;
	JPanel colores;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmColores frame = new FrmColores();
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
	public FrmColores() {
		
		colores = new JPanel();
		colores.setLayout(null);
		
		JLabel lblIdMarca = new JLabel("C\u00F3digo de Color :");
		lblIdMarca.setBounds(57, 231, 115, 20);
		lblIdMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setBounds(57, 263, 87, 20);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtIdColores = new JTextField();
		txtIdColores.addKeyListener(new KeyAdapter() {
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
		txtIdColores.setBounds(190, 232, 115, 20);
		txtIdColores.setToolTipText("Escribe un id para el Color");
		txtIdColores.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(190, 264, 178, 20);
		txtDescripcion.setToolTipText("Escribe una descripción para el Color");
		txtDescripcion.setColumns(10);


		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Tablero");
		modelo.addColumn("TapaCanto");
		Listar();
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		colores.add(toolBar);
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466476618_File.png")));
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475388_save.png")));

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
		
        ///QUITANDOLE LOS BORDES A LOS BOTONES
		/*
		btnNuevo.setBorder(null);
		btnEliminar.setBorder(null);
		btnGrabar.setBorder(null);*/
		
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEliminar.setToolTipText("Eliminar");
		btnGrabar.setToolTipText("Grabar");
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmColores.class.getResource("/gui/img/banners/BanColor.png")));
		label_1.setBounds(10, 24, 598, 108);
		getContentPane().add(label_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 342, 414, 217);
		
		tbColores = new JTable();
		tbColores.addKeyListener(new KeyAdapter() {
			@Override
			//DISEÑO CLIC DERECHO EN EL SCROL / EVENT /KEY/ KEYRELEASED
			public void keyReleased(KeyEvent arg0) {
				Mostrar();
			}
		});
		tbColores.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				Mostrar();
			}
		});
		scrollPane.setViewportView(tbColores);
		tbColores.setModel(modelo);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 30, 1194, 121);
		label.setIcon(new ImageIcon(FrmColores.class.getResource("/gui/img/banners/BanColor.png")));
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 162, 1194, 11);
		
		JLabel lblListaDeColores = new JLabel("Lista de Colores:");
		lblListaDeColores.setBounds(57, 316, 153, 20);
		lblListaDeColores.setFont(new Font("Tahoma", Font.BOLD, 12));
		colores.setLayout(null);
		colores.add(toolBar);
		colores.add(separator);
		colores.add(label);
		colores.add(lblListaDeColores);
		colores.add(scrollPane);
		colores.add(lblDescripcion);
		colores.add(txtDescripcion);
		colores.add(lblIdMarca);
		colores.add(txtIdColores);
		
		JLabel lblEligeUnaOpcin = new JLabel("Pertenece a :");
		lblEligeUnaOpcin.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEligeUnaOpcin.setBounds(519, 203, 153, 20);
		colores.add(lblEligeUnaOpcin);
		
		cb1= new JCheckBox("Tablero");
		cb1.setBounds(529, 231, 97, 23);
		cb1.setMnemonic(KeyEvent.VK_1);
		cb1.setSelected(false);
		colores.add(cb1);
		
		//String numCadena= Integer.toString(numEntero);
				
		cb2 = new JCheckBox("Tapacanto",false);
		cb2.setBounds(529, 263, 97, 23);
		cb1.setMnemonic(KeyEvent.VK_1);
		cb1.setSelected(false);
		colores.add(cb2);
			
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
		txtIdColores.setText(""+tbColores.getValueAt(fila, 0));
		txtDescripcion.setText(""+tbColores.getValueAt(fila, 1));
		
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
		int [] anchos = {40, 200, 20, 20};
		
		for (int i = 0; i < tbColores.getColumnCount(); i++) {
			tbColores.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
				
	}
		
	
void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}	
	
	 public void itemStateChanged(ItemEvent e) {
		 if(cb1.isSelected()){
			 
			 tab=1;
			 mensaje(""+tab);
		 }else{
			 tab=0;
			 mensaje(""+tab);
		 }
		 
		 if(cb2.isSelected()){
			 
			 tap=1;
			 mensaje(""+tap);
		 }else{
			 tap=0;
			 mensaje(""+tap);
		 }
		 
		 
	 }
	 

	
protected void btnGrabarActionPerformed(ActionEvent arg0) { 

	
	
	
	String texto=txtIdColores.getText();
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
	ColoresBean l=new ColoresBean(txtIdColores.getText(), txtDescripcion.getText(), math_tab.toString(), math_can.toString());
	int valor=obj.registrarColores(l);
	if(valor==1){
		mensaje("Registro Exitoso de Colores");
		Listar();
		txtIdColores.setText("");
		txtDescripcion.setText("");
		math_tab.toString();
		math_can.toString();
		
		}
   }
}
	
}


protected void btnEliminarActionPerformed(ActionEvent arg0) {


 int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?");

	if(descicion==JOptionPane.YES_OPTION){
		
		int valor=obj.eliminarColores(txtIdColores.getText());
		
		 if(valor==1){
			 if(tbColores.getSelectedRow() >=0 ){					 
				 ((DefaultTableModel)tbColores.getModel()).removeRow(tbColores.getSelectedRow());
			 }
				mensaje("Registro Eliminado");
				txtIdColores.setText("");
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
		txtIdColores.setText("");
		txtDescripcion.setText("");
		txtDescripcion.requestFocus();
		estado=true;
	}
	
	
	void Listar(){
		modelo.setRowCount(0);
		ArrayList<ColoresBean> info=obj.listarColores();
		for(ColoresBean x:info){
			Object fila[]={x.getIdColor(),x.getDescripcion(),x.getMatch_tab(),x.getMatch_can()};
			modelo.addRow(fila);
			
		}
			

	}
	void Mostrar(){
	
		int fila=tbColores.getSelectedRow();
		txtIdColores.setText(""+tbColores.getValueAt(fila, 0));
		txtDescripcion.setText(""+tbColores.getValueAt(fila, 1));
		
	}
}





