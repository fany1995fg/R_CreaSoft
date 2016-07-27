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
import javax.swing.border.TitledBorder;
import javax.swing.UIManager;

public class FrmColores extends JInternalFrame implements ActionListener {

	
	ColoresControlador obj=new ColoresControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	JCheckBox chckboxtab, chckboxtap;
	int tab=0,tap=0;
	String math_tab,math_can;
	private JTextField txtIdColor;
	private JTextField txtDescripcion;
	JTable tbColores;
	private JButton btnGrabar;
	//private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel label_1;
	JPanel colores;
	private JButton btnEditar;
	private JButton btnEditarNo;
	private JSeparator separator;

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


		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Tablero");
		modelo.addColumn("TapaCanto");
		Listar();
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 135, 30);
		colores.add(toolBar);
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmColores.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(FrmColores.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		btnEditar.setToolTipText("Eliminar");
		toolBar.add(btnEditar);

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmColores.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		
        ///QUITANDOLE LOS BORDES A LOS BOTONES
		/*
		btnNuevo.setBorder(null);
		btnEliminar.setBorder(null);
		btnGrabar.setBorder(null);*/
		
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEliminar.setToolTipText("Eliminar");
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmColores.class.getResource("/gui/img/banners/BanColor.png")));
		label_1.setBounds(10, 24, 598, 108);
		getContentPane().add(label_1);
		
		JLabel lblBanner = new JLabel("");
		lblBanner.setBounds(0, 33, 1194, 65);
		lblBanner.setIcon(new ImageIcon(FrmColores.class.getResource("/gui/img/banners/BanColor.png")));
		colores.setLayout(null);
		colores.add(toolBar);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		
		btnEditarNo = new JButton("");
		btnEditarNo.setIcon(new ImageIcon(FrmColores.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		btnEditarNo.setToolTipText("Eliminar");
		toolBar.add(btnEditarNo);
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmColores.class.getResource("/Iconos_PlacaMas/_Save.png")));
		btnGrabar.setToolTipText("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGrabarActionPerformed(arg0);
			}
		});
		colores.add(lblBanner);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Listado de Colores", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(20, 121, 1113, 495);
		colores.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblICodColor = new JLabel("C\u00F3digo de Color :");
		lblICodColor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblICodColor.setBounds(47, 40, 115, 20);
		panel_1.add(lblICodColor);
		lblICodColor.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtIdColor = new JTextField();
		txtIdColor.setBounds(172, 41, 115, 20);
		panel_1.add(txtIdColor);
		txtIdColor.addKeyListener(new KeyAdapter() {
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
		txtIdColor.setToolTipText("Escribe un id para el Color");
		txtIdColor.setColumns(10);
		
		JLabel lblDescripcion = new JLabel("Descripci\u00F3n:");
		lblDescripcion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescripcion.setBounds(47, 72, 115, 20);
		panel_1.add(lblDescripcion);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtDescripcion = new JTextField();
		txtDescripcion.setBounds(172, 73, 178, 20);
		panel_1.add(txtDescripcion);
		txtDescripcion.setToolTipText("Escribe una descripción para el Color");
		txtDescripcion.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(413, 23, 166, 78);
		panel_1.add(panel);
		panel.setBorder(new TitledBorder(null, "Pertenece a:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setLayout(null);
		
		chckboxtab= new JCheckBox("Tablero");
		chckboxtab.setBounds(18, 22, 97, 20);
		panel.add(chckboxtab);
		chckboxtab.setMnemonic(KeyEvent.VK_1);
		chckboxtab.setSelected(false);
		chckboxtab.setMnemonic(KeyEvent.VK_1);
		chckboxtab.setSelected(false);
		
		//String numCadena= Integer.toString(numEntero);
				
		chckboxtap = new JCheckBox("Tapacanto",false);
		chckboxtap.setBounds(18, 48, 97, 20);
		panel.add(chckboxtap);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 136, 414, 300);
		panel_1.add(scrollPane);
		
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
			
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEliminarActionPerformed(arg0);
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
		
		int [] anchos = {40, 200, 20, 20};
		
		for (int i = 0; i < tbColores.getColumnCount(); i++) {
			tbColores.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
				
	}
		
	
void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}	
	
	 public void itemStateChanged(ItemEvent e) {
		 if(chckboxtab.isSelected()){
			 
			 tab=1;
			 mensaje(""+tab);
		 }else{
			 tab=0;
			 mensaje(""+tab);
		 }
		 
		 if(chckboxtap.isSelected()){
			 
			 tap=1;
			 mensaje(""+tap);
		 }else{
			 tap=0;
			 mensaje(""+tap);
		 }
		 
		 
	 }
	 

	
protected void btnGrabarActionPerformed(ActionEvent arg0) { 

	
	
	
	String texto=txtIdColor.getText();
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
	ColoresBean l=new ColoresBean(txtIdColor.getText(), txtDescripcion.getText(), math_tab.toString(), math_can.toString());
	int valor=obj.registrarColores(l);
	if(valor==1){
		mensaje("Registro Exitoso de Colores");
		Listar();
		txtIdColor.setText("");
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
		
		int valor=obj.eliminarColores(txtIdColor.getText());
		
		 if(valor==1){
			 if(tbColores.getSelectedRow() >=0 ){					 
				 ((DefaultTableModel)tbColores.getModel()).removeRow(tbColores.getSelectedRow());
			 }
				mensaje("Registro Eliminado");
				txtIdColor.setText("");
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
		txtIdColor.setText("");
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
		txtIdColor.setText(""+tbColores.getValueAt(fila, 0));
		txtDescripcion.setText(""+tbColores.getValueAt(fila, 1));
		
	}
}





