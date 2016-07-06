package com.placamas.listado;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.placamas.beans.LocalBean;
import com.placamas.controlador.LocalesControlador;
import com.placamas.vista.FrmLocales;
import com.placamas.vista.FrmTextura;

import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

public class FrmMantenimientoLP extends JInternalFrame implements ActionListener  {

	LocalesControlador obj=new LocalesControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	
	
	private JTextField txtIdLocal;
	private JTextField txtLoc_Nomb;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel label_1;
	JPanel mantenimiento;
	JTabbedPane tab;
	JPanel Items;
	JPanel Resumen;
	JPanel Seguimiento;
	JPanel Contacto;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel PModo;
	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel mante;
	private JPanel panel_5;
	private JTable table;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JLabel label;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmMantenimientoLP frame = new FrmMantenimientoLP();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	
	public FrmMantenimientoLP() {
		/*
		setToolTipText("Colores");
		setBounds(100, 100, 634, 493);
		getContentPane().setLayout(null);*/
		
		mantenimiento = new JPanel();
		//locales.addMouseListener((MouseListener) this);
		
		JLabel lblIdLocal = new JLabel("Nombre :");
		lblIdLocal.setBounds(282, 45, 78, 20);
		lblIdLocal.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		txtIdLocal = new JTextField();
		txtIdLocal.addKeyListener(new KeyAdapter() {
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
		
		txtIdLocal.setBounds(361, 46, 214, 20);
		txtIdLocal.setToolTipText("Escribe un id para el Local");
		txtIdLocal.setColumns(10);
		
		txtLoc_Nomb = new JTextField();
		txtLoc_Nomb.setBounds(361, 69, 214, 20);
		txtLoc_Nomb.setToolTipText("Escribe una descripción para el Local");
		txtLoc_Nomb.setColumns(10);


		modelo.addColumn("codigo");
		modelo.addColumn("nombre");
		Listar();
		Items.setBounds(10, 319, 1112, 135);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		mantenimiento.add(toolBar);
		
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
		
		/*btnNuevo.setBorder(null);
		btnEliminar.setBorder(null);
		btnGrabar.setBorder(null);*/
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmLocales.class.getResource("/gui/img/banners/loca3.png")));
		label_1.setBounds(10, 24, 598, 108);
		
		mantenimiento.setLayout(null);
		mantenimiento.add(toolBar);
		
		JPanel PListaPieza = new JPanel();
		PListaPieza.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista de Piezas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		//TitledBorder.setFont(new Font("Stencil", Font.PLAIN, 16));
		PListaPieza.setBounds(49, 46, 161, 62);
		mantenimiento.add(PListaPieza);
		
		mante = new JPanel();
		mante.setToolTipText("");
		mante.setBounds(10, 200, 995, 450);
		mantenimiento.add(mante);
		mante.setLayout(new BorderLayout(0, 0));
		
		tab = new JTabbedPane();
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		mante.add(tab);
		Items=new JPanel();
		tab.add(Items, "Items ");
		Items.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setToolTipText("");
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calidad", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_6.setBounds(173, 11, 291, 43);
		Items.add(panel_6);
		panel_6.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Lista de Piezas");
		rdbtnNewRadioButton.setBounds(6, 13, 95, 23);
		panel_6.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnListaDeCorte = new JRadioButton("Lista de Corte");
		rdbtnListaDeCorte.setBounds(101, 13, 93, 23);
		panel_6.add(rdbtnListaDeCorte);
		
		JRadioButton radioButton = new JRadioButton("Lista de Corte");
		radioButton.setBounds(196, 13, 93, 23);
		panel_6.add(radioButton);
		
		JPanel panel_7 = new JPanel();
		panel_7.setToolTipText("");
		panel_7.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operaciones Automaticas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_7.setBounds(501, 11, 479, 43);
		Items.add(panel_7);
		panel_7.setLayout(null);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Agrupar Piezas Iguales");
		chckbxNewCheckBox.setBounds(6, 13, 139, 23);
		panel_7.add(chckbxNewCheckBox);
		
		JCheckBox chckbxFullEtiquetas = new JCheckBox("Full Etiquetas");
		chckbxFullEtiquetas.setBounds(147, 13, 89, 23);
		panel_7.add(chckbxFullEtiquetas);
		
		JCheckBox chckbxAadirNuevoItem = new JCheckBox("A\u00F1adir Nuevo Item");
		chckbxAadirNuevoItem.setBounds(238, 13, 120, 23);
		panel_7.add(chckbxAadirNuevoItem);
		
		JCheckBox chckbxCopiar = new JCheckBox("Copiar Ultimo Item");
		chckbxCopiar.setBounds(360, 13, 113, 23);
		panel_7.add(chckbxCopiar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 55, 990, 367);
		Items.add(scrollPane);
		
		table = new JTable();
		scrollPane.setColumnHeaderView(table);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"as", "dff", "gg", "23", "32", "322", "4132", "424", "3233", "31313", "2121212", "111111111"},
			},
			new String[] {
				"asas", "asdadddddddddd", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.setBounds(26, 65, 936, 346);
		//Items.add(table);
		
		Resumen=new JPanel();
		tab.add(Resumen, "Resumen Material y Servicios ");
		Resumen.setLayout(null);
		
		panel_8 = new JPanel();
		panel_8.setToolTipText("");
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Corte", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_8.setBounds(10, 11, 649, 201);
		Resumen.add(panel_8);
		
		panel_9 = new JPanel();
		panel_9.setToolTipText("");
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tapacantos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_9.setBounds(10, 223, 649, 188);
		Resumen.add(panel_9);
		
		panel_10 = new JPanel();
		panel_10.setToolTipText("");
		panel_10.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Perforaciones", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_10.setBounds(669, 11, 264, 201);
		Resumen.add(panel_10);
		
		panel_11 = new JPanel();
		panel_11.setToolTipText("");
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ranuras", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_11.setBounds(669, 223, 264, 188);
		Resumen.add(panel_11);
		
		Seguimiento=new JPanel();
		tab.add(Seguimiento, "Seguimiento ");
		Seguimiento.setLayout(null);
		
		panel_12 = new JPanel();
		panel_12.setBounds(10, 11, 162, 48);
		panel_12.setToolTipText("");
		panel_12.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		Seguimiento.add(panel_12);
		
		panel_13 = new JPanel();
		panel_13.setToolTipText("");
		panel_13.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_13.setBounds(212, 29, 304, 172);
		Seguimiento.add(panel_13);
		panel_13.setLayout(null);
		
		label = new JLabel("Nombre :");
		label.setBounds(31, 24, 54, 16);
		label.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_13.add(label);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(95, 22, 118, 20);
		panel_13.add(comboBox);
		
		JLabel label_2 = new JLabel("Nombre :");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(31, 78, 54, 16);
		panel_13.add(label_2);
		
		JLabel label_3 = new JLabel("Nombre :");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(31, 105, 54, 16);
		panel_13.add(label_3);
		
		JLabel label_4 = new JLabel("Nombre :");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_4.setBounds(31, 132, 54, 16);
		panel_13.add(label_4);
		
		panel_14 = new JPanel();
		panel_14.setToolTipText("");
		panel_14.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_14.setBounds(552, 29, 315, 139);
		Seguimiento.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel label_13 = new JLabel("Nombre :");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_13.setBounds(21, 112, 54, 16);
		panel_14.add(label_13);
		
		JLabel label_14 = new JLabel("Nombre :");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_14.setBounds(21, 85, 54, 16);
		panel_14.add(label_14);
		
		panel_15 = new JPanel();
		panel_15.setToolTipText("");
		panel_15.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_15.setBounds(552, 174, 315, 139);
		Seguimiento.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel label_9 = new JLabel("Nombre :");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(20, 55, 54, 16);
		panel_15.add(label_9);
		
		JLabel label_10 = new JLabel("Nombre :");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(20, 28, 54, 16);
		panel_15.add(label_10);
		
		JLabel label_11 = new JLabel("Nombre :");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(20, 109, 54, 16);
		panel_15.add(label_11);
		
		JLabel label_12 = new JLabel("Nombre :");
		label_12.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_12.setBounds(20, 82, 54, 16);
		panel_15.add(label_12);
		
		panel_16 = new JPanel();
		panel_16.setToolTipText("");
		panel_16.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_16.setBounds(212, 201, 304, 112);
		Seguimiento.add(panel_16);
		panel_16.setLayout(null);
		
		JLabel label_5 = new JLabel("Nombre :");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_5.setBounds(25, 22, 54, 16);
		panel_16.add(label_5);
		
		JLabel label_6 = new JLabel("Nombre :");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_6.setBounds(25, 67, 54, 16);
		panel_16.add(label_6);
		
		panel_17 = new JPanel();
		panel_17.setToolTipText("");
		panel_17.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_17.setBounds(212, 312, 304, 79);
		Seguimiento.add(panel_17);
		panel_17.setLayout(null);
		
		JLabel label_7 = new JLabel("Nombre :");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_7.setBounds(24, 52, 54, 16);
		panel_17.add(label_7);
		
		JLabel label_8 = new JLabel("Nombre :");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_8.setBounds(24, 25, 54, 16);
		panel_17.add(label_8);
		
		panel_18 = new JPanel();
		panel_18.setToolTipText("");
		panel_18.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_18.setBounds(552, 324, 315, 67);
		Seguimiento.add(panel_18);
		panel_18.setLayout(null);
		
		JLabel label_15 = new JLabel("Nombre :");
		label_15.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_15.setBounds(21, 29, 54, 16);
		panel_18.add(label_15);
		
		Contacto=new JPanel();
		tab.add(Contacto, "Contacto y Comentario");
		Contacto.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBounds(20, 24, 327, 114);
		panel_5.setToolTipText("");
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calidad", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		Contacto.add(panel_5);
		panel_5.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Escribe un id para el Local");
		textField_2.setColumns(10);
		textField_2.setBounds(103, 11, 214, 20);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Escribe una descripci\u00F3n para el Local");
		textField_3.setColumns(10);
		textField_3.setBounds(103, 34, 131, 20);
		panel_5.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Escribe un id para el Local");
		textField_4.setColumns(10);
		textField_4.setBounds(103, 57, 131, 20);
		panel_5.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("Escribe una descripci\u00F3n para el Local");
		textField_5.setColumns(10);
		textField_5.setBounds(103, 80, 214, 20);
		panel_5.add(textField_5);
		
		JPanel panel_19 = new JPanel();
		panel_19.setToolTipText("");
		panel_19.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calidad", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_19.setBounds(20, 149, 448, 262);
		Contacto.add(panel_19);
		
		JPanel panel_20 = new JPanel();
		panel_20.setToolTipText("");
		panel_20.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calidad", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_20.setBounds(478, 149, 448, 262);
		Contacto.add(panel_20);
		
		PModo = new JPanel();
		PModo.setToolTipText("");
		PModo.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Modo", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		PModo.setBounds(623, 34, 125, 43);
		mantenimiento.add(PModo);
		mantenimiento.add(txtLoc_Nomb);
		mantenimiento.add(lblIdLocal);
		mantenimiento.add(txtIdLocal);
		
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
		
		textField = new JTextField();
		textField.setToolTipText("Escribe una descripci\u00F3n para el Local");
		textField.setColumns(10);
		textField.setBounds(361, 115, 214, 20);
		mantenimiento.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Escribe un id para el Local");
		textField_1.setColumns(10);
		textField_1.setBounds(361, 92, 214, 20);
		mantenimiento.add(textField_1);
		
		JLabel lblCliente = new JLabel("Cliente :");
		lblCliente.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCliente.setBounds(282, 69, 78, 20);
		mantenimiento.add(lblCliente);
		
		JLabel lblReferencia = new JLabel("Referencia :");
		lblReferencia.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblReferencia.setBounds(282, 115, 78, 20);
		mantenimiento.add(lblReferencia);
		
		JLabel lblObra = new JLabel("Obra :");
		lblObra.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblObra.setBounds(282, 91, 78, 20);
		mantenimiento.add(lblObra);
		
		panel = new JPanel();
		panel.setToolTipText("");
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estado", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel.setBounds(805, 34, 125, 43);
		mantenimiento.add(panel);
		
		panel_1 = new JPanel();
		panel_1.setToolTipText("");
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calidad", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_1.setBounds(49, 146, 181, 43);
		mantenimiento.add(panel_1);
		
		panel_2 = new JPanel();
		panel_2.setToolTipText("");
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Medidas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_2.setBounds(256, 146, 181, 43);
		mantenimiento.add(panel_2);
		
		panel_3 = new JPanel();
		panel_3.setToolTipText("");
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Material del Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_3.setBounds(466, 146, 214, 43);
		mantenimiento.add(panel_3);
		
		panel_4 = new JPanel();
		panel_4.setToolTipText("");
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Entrega", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_4.setBounds(712, 146, 181, 43);
		mantenimiento.add(panel_4);
		
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}
	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) { 
		
		String texto=txtIdLocal.getText();
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");
            
        }
        else
        if(texto.length()>5 || texto.length()<5){
        	
            mensaje("ERROR: Solo se aceptan 5 caracteres");
            
        }
        else
        if(texto.length()==5){
        	estado=true;
        if(estado==true){ 	
		LocalBean l=new LocalBean(txtIdLocal.getText(), txtLoc_Nomb.getText());
		int valor=obj.registrarLocal(l);
		if(valor==1){
			mensaje("Registro Exitoso de Marca");
			Listar();
			txtIdLocal.setText("");
			txtLoc_Nomb.setText("");
			
			}
       }
	}
		
}
	

protected void btnEliminarActionPerformed(ActionEvent arg0) {
	
	
	
	}


	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNuevo) {
			btnNuevoActionPerformed(arg0);
		}
		
		
	}
	

	protected void btnNuevoActionPerformed(ActionEvent arg0) {
		txtIdLocal.setText("");
		txtLoc_Nomb.setText("");
		txtLoc_Nomb.requestFocus();
		estado=true;
	}
	
	void Listar(){
		modelo.setRowCount(0);
		ArrayList<LocalBean> info=obj.listarLocal();
		for(LocalBean x:info){
			Object fila[]={x.getIdLocal(),x.getLoc_Nomb()};
			modelo.addRow(fila);
			
		}
			

	}
}
