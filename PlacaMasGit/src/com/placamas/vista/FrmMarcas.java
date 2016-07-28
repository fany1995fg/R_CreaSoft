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
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

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
	JPanel marcas;
	private JLabel label;
	private JButton btnEditar;
	private JButton btnEditarNo;
	private JSeparator separator;


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
		toolBar.setBounds(0, 0, 135, 30);
		marcas.add(toolBar);
		
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmMarcas.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(FrmMarcas.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		btnEditar.setToolTipText("Eliminar");
		toolBar.add(btnEditar);

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmMarcas.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		
		
		
		
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
		btnEditarNo.setIcon(new ImageIcon(FrmMarcas.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		btnEditarNo.setToolTipText("Eliminar");
		toolBar.add(btnEditarNo);
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmMarcas.class.getResource("/Iconos_PlacaMas/_Save.png")));
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGrabarActionPerformed(arg0);
			}
		});
		btnGrabar.setToolTipText("Grabar");
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		Listar();
		
		
		
		tbMarcas = new JTable();
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmMarcas.class.getResource("/gui/img/banners/Marquitas.png")));
		label.setBounds(0, 33, 1194, 65);
		marcas.add(label);
		Listar();
		
		
		int fila=0;
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de Marcas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 121, 1113, 495);
		marcas.add(panel);
		panel.setLayout(null);
		
		JLabel lblIdMarca = new JLabel("C\u00F3digo de Marca:");
		lblIdMarca.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdMarca.setBounds(47, 40, 115, 20);
		panel.add(lblIdMarca);
		lblIdMarca.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		

		txtIdMarca = new JTextField();
		txtIdMarca.setBounds(172, 41, 115, 20);
		panel.add(txtIdMarca);
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
		txtIdMarca.setToolTipText("Escribe el Codigo de la Marca (3 Car)");
		
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescripcion.setBounds(47, 72, 115, 20);
		panel.add(lblDescripcion);
		lblDescripcion.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(172, 73, 178, 20);
		panel.add(txtDescripcion);
		txtDescripcion.setColumns(10);
		txtDescripcion.setToolTipText("Escribe una Descripción para la marca");
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 136, 362, 300);
		panel.add(scrollPane);
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
        
        
        if(texto.length()==0){
        	
            mensaje("ERROR: No se acepta 'CODIGO' en blanco");
            txtIdMarca.requestFocus();
        }
        else
        if(descripcion.length()==0){
        	
        	mensaje("ERROR: No se acepta 'DESCRIPCION' en blanco");
            txtDescripcion.requestFocus();
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
			tbMarcas.requestFocus();
			tbMarcas.changeSelection(0,0,true, false);
			
			txtIdMarca.setText(""+tbMarcas.getValueAt(0, 0));
			txtDescripcion.setText(""+tbMarcas.getValueAt(0, 1));
		 }
		
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





