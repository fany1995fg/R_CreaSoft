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
import javax.swing.border.TitledBorder;
import javax.swing.SwingConstants;

public class FrmMedidas extends JInternalFrame implements ActionListener {

	MedidasControlador obj=new MedidasControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	
	private JTextField txtIdMedidas;
	private JTextField txtMedidas;
	JTable tbMedidas;
	private JButton btnGrabar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel lblNewLabel;
	JPanel medidas;
	private JPanel panel;
	private JPanel panel_1;
	private JButton btnEditar;
	private JButton btnEditarNo;


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
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 135, 30);
		medidas.add(toolBar);
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmMedidas.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		btnEditar = new JButton("");
		btnEditar.setIcon(new ImageIcon(FrmMedidas.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		btnEditar.setToolTipText("Eliminar");
		toolBar.add(btnEditar);
		
				btnEliminar = new JButton("");
				toolBar.add(btnEliminar);
				btnEliminar.setIcon(new ImageIcon(FrmMedidas.class.getResource("/Iconos_PlacaMas/_Erase.png")));
				
				btnNuevo.setToolTipText("Nuevo Registro");
				btnEliminar.setToolTipText("Eliminar");
				
				JSeparator separator = new JSeparator();
				separator.setOrientation(SwingConstants.VERTICAL);
				toolBar.add(separator);
				
				btnEditarNo = new JButton("");
				btnEditarNo.setIcon(new ImageIcon(FrmMedidas.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
				btnEditarNo.setToolTipText("Eliminar");
				toolBar.add(btnEditarNo);
				
				btnGrabar = new JButton("");
				toolBar.add(btnGrabar);
				btnGrabar.setIcon(new ImageIcon(FrmMedidas.class.getResource("/Iconos_PlacaMas/_Save.png")));
				btnGrabar.setToolTipText("Grabar");
				btnGrabar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnGrabarActionPerformed(arg0);
					}
				});
				
				btnEliminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						btnEliminarActionPerformed(arg0);
					}
				});
				btnNuevo.addActionListener(this);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(FrmMedidas.class.getResource("/gui/img/banners/medidas.jpg")));
		lblNewLabel.setBounds(0, 33, 1194, 65);
		medidas.add(lblNewLabel);
		
		modelo.addColumn("Tipo");
		modelo.addColumn("Medida");
		modelo.addColumn("Tablero");
		modelo.addColumn("Tapa Cantos");
		Listar();
		
		setDefaultCloseOperation(HIDE_ON_CLOSE); //Se oculte al cerrara
		Listar();
		
		Listar();
		
		int fila=0;
		
		panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Listado de Medidas", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(20, 121, 1113, 495);
		medidas.add(panel);
		panel.setLayout(null);
		
		JLabel lblIdMedidas = new JLabel("C\u00F3digo de Medidas:");
		lblIdMedidas.setHorizontalAlignment(SwingConstants.TRAILING);
		lblIdMedidas.setBounds(47, 40, 115, 20);
		panel.add(lblIdMedidas);
		lblIdMedidas.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		txtIdMedidas= new JTextField();
		txtIdMedidas.setBounds(172, 41, 115, 20);
		panel.add(txtIdMedidas);
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
		txtIdMedidas.setColumns(10);
		txtIdMedidas.setToolTipText("Escribe el Codigo de la Medida");
		
		JLabel lblMedidas = new JLabel("Medida:");
		lblMedidas.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMedidas.setBounds(47, 72, 115, 20);
		panel.add(lblMedidas);
		lblMedidas.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		txtMedidas = new JTextField();
		txtMedidas.setBounds(172, 73, 178, 20);
		panel.add(txtMedidas);
		txtMedidas.setColumns(10);
		txtMedidas.setToolTipText("Escribe una Descripción para la medida");
		
		panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Pertenece a:", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(413, 23, 166, 78);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JCheckBox checkBox = new JCheckBox("Tapacanto", false);
		checkBox.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBox.setBounds(18, 22, 97, 20);
		panel_1.add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("Tablero");
		checkBox_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		checkBox_1.setBounds(18, 48, 97, 20);
		panel_1.add(checkBox_1);
		checkBox_1.setSelected(false);
		checkBox_1.setMnemonic(KeyEvent.VK_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(35, 136, 323, 300);
		panel.add(scrollPane);
		
	
		
		
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
		txtIdMedidas.setText(""+tbMedidas.getValueAt(fila, 0));
		txtMedidas.setText(""+tbMedidas.getValueAt(fila, 1));
		
		tbMedidas.requestFocus();
		tbMedidas.changeSelection(0,0,true, false);
					
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
		int [] anchos = {40, 30, 20, 30};
		
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
