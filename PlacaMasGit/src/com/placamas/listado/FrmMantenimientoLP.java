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
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;





import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.UIManager;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;

import com.toedter.calendar.JDateChooser;



import java.awt.Component;

import javax.swing.JTextPane;
import javax.swing.JEditorPane;

public class FrmMantenimientoLP extends JInternalFrame implements ActionListener  {

	//LocalesControlador obj=new LocalesControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	private JTextField txtLoc_Nomb;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel label_1;
	public JPanel mantenimiento;
	JTabbedPane tab;
	JPanel Items;
	JPanel Resumen;
	JPanel Seguimiento;
	JPanel Contacto;
	private JTextField textField;
	private JTextField textField_1;
	private JPanel panel;
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
	private JPanel panel_18;
	private JLabel lblDigitador;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTable table_1;
	private JScrollPane scrollPane_2;
	private JScrollPane scrollPane_3;
	private JScrollPane scrollPane_4;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_6;
	private JTextField textField_24;
	private JScrollPane scrollPane_5;
	private JScrollPane scrollPane_6;

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
		
		txtLoc_Nomb = new JTextField();
		txtLoc_Nomb.setBounds(361, 69, 214, 20);
		txtLoc_Nomb.setToolTipText("Escribe una descripción para el Local");
		txtLoc_Nomb.setColumns(10);


		modelo.addColumn("codigo");
		modelo.addColumn("nombre");
		Listar();
		
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		mantenimiento.add(toolBar);
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmMantenimientoLP.class.getResource("/iconosmodernos/1466476618_File.png")));
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmMantenimientoLP.class.getResource("/iconosmodernos/1466475388_save.png")));

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmMantenimientoLP.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmMantenimientoLP.class.getResource("/gui/img/banners/loca3.png")));
		label_1.setBounds(10, 24, 598, 108);
		
		mantenimiento.setLayout(null);
		mantenimiento.add(toolBar);
		
		JPanel PListaPieza = new JPanel();
		PListaPieza.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Lista de Piezas", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
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
		Items.setBounds(10, 319, 1200, 135);
		tab.add(Items, "Items ");
		Items.setLayout(null);
		
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
		panel_8.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 11, 649, 190);
		panel_8.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setColumnHeaderView(table_1);
		
		panel_9 = new JPanel();
		panel_9.setToolTipText("");
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "TapaCantos", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_9.setBounds(10, 223, 649, 188);
		Resumen.add(panel_9);
		panel_9.setLayout(null);
		
		scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(0, 22, 649, 166);
		panel_9.add(scrollPane_2);
		
		table_2 = new JTable();
		table_2.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane_2.setColumnHeaderView(table_2);
		
		panel_10 = new JPanel();
		panel_10.setToolTipText("");
		panel_10.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Perforaciones", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_10.setBounds(669, 11, 264, 201);
		Resumen.add(panel_10);
		panel_10.setLayout(null);
		
		scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(0, 11, 264, 190);
		panel_10.add(scrollPane_3);
		
		table_3 = new JTable();
		table_3.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane_3.setColumnHeaderView(table_3);
		
		panel_11 = new JPanel();
		panel_11.setToolTipText("");
		panel_11.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ranuras", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_11.setBounds(669, 223, 264, 188);
		Resumen.add(panel_11);
		panel_11.setLayout(null);
		
		scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(0, 22, 264, 166);
		panel_11.add(scrollPane_4);
		
		table_4 = new JTable();
		table_4.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
			},
			new String[] {
				"New column", "New column"
			}
		));
		scrollPane_4.setColumnHeaderView(table_4);
		
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
		panel_13.setBounds(212, 29, 315, 172);
		Seguimiento.add(panel_13);
		panel_13.setLayout(null);
		
		lblDigitador = new JLabel("Digitador:");
		lblDigitador.setBounds(19, 24, 54, 16);
		lblDigitador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		panel_13.add(lblDigitador);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(89, 22, 124, 20);
		panel_13.add(comboBox);
		
		JLabel lblEmitido = new JLabel("Emitido :");
		lblEmitido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmitido.setBounds(31, 78, 42, 16);
		panel_13.add(lblEmitido);
		
		JLabel lblActualizado = new JLabel("Actualizado :");
		lblActualizado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblActualizado.setBounds(11, 103, 62, 16);
		panel_13.add(lblActualizado);
		
		JLabel lblNombre = new JLabel("  Nombre :");
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre.setBounds(21, 126, 52, 16);
		panel_13.add(lblNombre);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(75, 101, 74, 20);
		panel_13.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(75, 126, 74, 20);
		panel_13.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(155, 101, 74, 20);
		panel_13.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(155, 126, 74, 20);
		panel_13.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(155, 76, 74, 20);
		panel_13.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(231, 101, 74, 20);
		panel_13.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(231, 126, 74, 20);
		panel_13.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(231, 76, 74, 20);
		panel_13.add(textField_14);
		
		JLabel lblHora = new JLabel("Fecha");
		lblHora.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHora.setBounds(93, 53, 36, 16);
		panel_13.add(lblHora);
		
		JLabel lblHora_1 = new JLabel("Hora");
		lblHora_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHora_1.setBounds(177, 53, 36, 16);
		panel_13.add(lblHora_1);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblUsuario.setBounds(248, 53, 41, 16);
		panel_13.add(lblUsuario);
		
		JDateChooser dateChooser_7 = new JDateChooser();
		dateChooser_7.setBounds(75, 76, 74, 20);
		panel_13.add(dateChooser_7);
		
		panel_14 = new JPanel();
		panel_14.setToolTipText("");
		panel_14.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_14.setBounds(566, 29, 348, 139);
		Seguimiento.add(panel_14);
		panel_14.setLayout(null);
		
		JLabel lblPrometido = new JLabel("Prometido:");
		lblPrometido.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPrometido.setBounds(21, 112, 54, 16);
		panel_14.add(lblPrometido);
		
		JLabel lblEmitido_1 = new JLabel("Emitido:");
		lblEmitido_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmitido_1.setBounds(21, 85, 54, 16);
		panel_14.add(lblEmitido_1);
		
		JDateChooser dateChooser = new JDateChooser(); 
		dateChooser.setBounds(81, 81, 87, 20);
		panel_14.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(81, 108, 87, 20);
		panel_14.add(dateChooser_1);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(81, 45, 87, 20);
		panel_14.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(178, 110, 74, 20);
		panel_14.add(textField_16);
		
		JLabel lblNumero = new JLabel("Numero :");
		lblNumero.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNumero.setBounds(21, 47, 54, 16);
		panel_14.add(lblNumero);
		
		JLabel lblTipo = new JLabel(" Tipo :");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTipo.setBounds(35, 18, 35, 16);
		panel_14.add(lblTipo);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Factura");
		rdbtnNewRadioButton_1.setBounds(81, 15, 68, 23);
		panel_14.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Boleta");
		rdbtnNewRadioButton_2.setBounds(167, 15, 109, 23);
		panel_14.add(rdbtnNewRadioButton_2);
		
		JLabel lblFecha = new JLabel("Fecha");
		lblFecha.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblFecha.setBounds(105, 65, 39, 16);
		panel_14.add(lblFecha);
		
		JLabel lblHora_2 = new JLabel("Hora");
		lblHora_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblHora_2.setBounds(196, 65, 32, 16);
		panel_14.add(lblHora_2);
		
		panel_15 = new JPanel();
		panel_15.setToolTipText("");
		panel_15.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_15.setBounds(566, 174, 348, 139);
		Seguimiento.add(panel_15);
		panel_15.setLayout(null);
		
		JLabel lblProgramado = new JLabel("Programado:");
		lblProgramado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblProgramado.setBounds(20, 55, 66, 16);
		panel_15.add(lblProgramado);
		
		JLabel lblAprobado = new JLabel("Aprobado:");
		lblAprobado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAprobado.setBounds(20, 28, 54, 16);
		panel_15.add(lblAprobado);
		
		JLabel lblListoServesp = new JLabel("Listo Serv/Esp:");
		lblListoServesp.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblListoServesp.setBounds(20, 109, 74, 16);
		panel_15.add(lblListoServesp);
		
		JLabel lblListo = new JLabel("Listo Serv/Std:");
		lblListo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblListo.setBounds(20, 82, 74, 16);
		panel_15.add(lblListo);
		
		JLabel label_2 = new JLabel("Fecha");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_2.setBounds(112, 11, 36, 16);
		panel_15.add(label_2);
		
		JLabel label_3 = new JLabel("Hora");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_3.setBounds(196, 11, 36, 16);
		panel_15.add(label_3);
		
		JLabel label_13 = new JLabel("Usuario");
		label_13.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_13.setBounds(267, 11, 41, 16);
		panel_15.add(label_13);
		
		JDateChooser dateChooser_2 = new JDateChooser();
		dateChooser_2.setBounds(96, 28, 74, 20);
		panel_15.add(dateChooser_2);
		
		JDateChooser dateChooser_3 = new JDateChooser();
		dateChooser_3.setBounds(96, 55, 74, 20);
		panel_15.add(dateChooser_3);
		
		JDateChooser dateChooser_4 = new JDateChooser();
		dateChooser_4.setBounds(96, 82, 74, 20);
		panel_15.add(dateChooser_4);
		
		JDateChooser dateChooser_5 = new JDateChooser();
		dateChooser_5.setBounds(96, 109, 74, 20);
		panel_15.add(dateChooser_5);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(180, 28, 59, 20);
		panel_15.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(180, 53, 59, 20);
		panel_15.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(180, 78, 59, 20);
		panel_15.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(180, 107, 59, 20);
		panel_15.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(249, 28, 74, 20);
		panel_15.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(249, 53, 74, 20);
		panel_15.add(textField_22);
		
		panel_16 = new JPanel();
		panel_16.setToolTipText("");
		panel_16.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_16.setBounds(212, 201, 315, 112);
		Seguimiento.add(panel_16);
		panel_16.setLayout(null);
		
		JLabel lblOptimizador = new JLabel("Optimizador:");
		lblOptimizador.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOptimizador.setBounds(10, 22, 69, 16);
		panel_16.add(lblOptimizador);
		
		JLabel lblOptimizado = new JLabel("Optimizado:");
		lblOptimizado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblOptimizado.setBounds(14, 76, 57, 16);
		panel_16.add(lblOptimizado);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(75, 20, 118, 20);
		panel_16.add(comboBox_1);
		
		JDateChooser dateChooser_8 = new JDateChooser();
		dateChooser_8.setBounds(75, 72, 74, 20);
		panel_16.add(dateChooser_8);
		
		JLabel label_9 = new JLabel("Fecha");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_9.setBounds(93, 49, 36, 16);
		panel_16.add(label_9);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(155, 72, 74, 20);
		panel_16.add(textField_6);
		
		JLabel label_10 = new JLabel("Hora");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_10.setBounds(177, 49, 36, 16);
		panel_16.add(label_10);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(231, 72, 74, 20);
		panel_16.add(textField_24);
		
		JLabel label_11 = new JLabel("Usuario");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_11.setBounds(248, 49, 41, 16);
		panel_16.add(label_11);
		
		panel_18 = new JPanel();
		panel_18.setToolTipText("");
		panel_18.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "LP Origen", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_18.setBounds(566, 324, 315, 67);
		Seguimiento.add(panel_18);
		panel_18.setLayout(null);
		
		JLabel lblEntregado = new JLabel("Entregado:");
		lblEntregado.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEntregado.setBounds(31, 32, 64, 16);
		panel_18.add(lblEntregado);
		
		JLabel label_14 = new JLabel("Fecha");
		label_14.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_14.setBounds(121, 11, 36, 16);
		panel_18.add(label_14);
		
		JDateChooser dateChooser_6 = new JDateChooser();
		dateChooser_6.setBounds(92, 28, 87, 20);
		panel_18.add(dateChooser_6);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(195, 28, 59, 20);
		panel_18.add(textField_23);
		
		JLabel label_16 = new JLabel("Hora");
		label_16.setFont(new Font("Tahoma", Font.PLAIN, 11));
		label_16.setBounds(211, 11, 36, 16);
		panel_18.add(label_16);
		
		Contacto=new JPanel();
		tab.add(Contacto, "Contacto y Comentario");
		Contacto.setLayout(null);
		
		panel_5 = new JPanel();
		panel_5.setBounds(20, 11, 327, 135);
		panel_5.setToolTipText("");
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calidad", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		Contacto.add(panel_5);
		panel_5.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Escribe un id para el Local");
		textField_2.setColumns(10);
		textField_2.setBounds(88, 27, 214, 20);
		panel_5.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Escribe una descripci\u00F3n para el Local");
		textField_3.setColumns(10);
		textField_3.setBounds(88, 50, 131, 20);
		panel_5.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Escribe un id para el Local");
		textField_4.setColumns(10);
		textField_4.setBounds(88, 73, 131, 20);
		panel_5.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("Escribe una descripci\u00F3n para el Local");
		textField_5.setColumns(10);
		textField_5.setBounds(88, 96, 214, 20);
		panel_5.add(textField_5);
		
		JLabel lblNombre_1 = new JLabel("Nombre:");
		lblNombre_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblNombre_1.setBounds(37, 31, 41, 16);
		panel_5.add(lblNombre_1);
		
		JLabel lblTelefono = new JLabel("Telefono:");
		lblTelefono.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTelefono.setBounds(32, 54, 46, 16);
		panel_5.add(lblTelefono);
		
		JLabel lblMovil = new JLabel("Movil:");
		lblMovil.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMovil.setBounds(50, 77, 28, 16);
		panel_5.add(lblMovil);
		
		JLabel lblEmail = new JLabel("E-mail:");
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEmail.setBounds(46, 100, 32, 16);
		panel_5.add(lblEmail);
		
		JPanel panel_19 = new JPanel();
		panel_19.setToolTipText("");
		panel_19.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calidad", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_19.setBounds(20, 149, 448, 262);
		Contacto.add(panel_19);
		panel_19.setLayout(null);
		JTextArea txtArea=null;
		JTextArea txtArea1=null;
		txtArea = new JTextArea();
		txtArea1 = new JTextArea();
		scrollPane_5 = new JScrollPane(txtArea);
		scrollPane_5.setBounds(10, 24, 428, 227);
		panel_19.add(scrollPane_5);
		
		
		
		
		
		
		JPanel panel_20 = new JPanel();
		panel_20.setToolTipText("");
		panel_20.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Calidad", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_20.setBounds(478, 149, 448, 262);
		Contacto.add(panel_20);
		panel_20.setLayout(null);
		
		scrollPane_6 = new JScrollPane(txtArea1);
		scrollPane_6.setBounds(10, 24, 428, 227);
		panel_20.add(scrollPane_6);
		mantenimiento.add(txtLoc_Nomb);
		
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
		
		panel_3 = new JPanel();
		panel_3.setToolTipText("");
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Material del Cliente", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_3.setBounds(466, 146, 214, 43);
		mantenimiento.add(panel_3);
		panel_3.setLayout(null);
		
		JCheckBox chckbxPlaca = new JCheckBox("Planchas");
		chckbxPlaca.setBounds(6, 13, 67, 23);
		panel_3.add(chckbxPlaca);
		
		panel_4 = new JPanel();
		panel_4.setToolTipText("");
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tipo de Entrega", TitledBorder.LEFT, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_4.setBounds(712, 146, 181, 43);
		mantenimiento.add(panel_4);
		
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}
	
	
	protected void btnGrabarActionPerformed(ActionEvent arg0) { /*
		
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
	}*/
		
}
	

protected void btnEliminarActionPerformed(ActionEvent arg0) {
	
	
	
	}


	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNuevo) {
			btnNuevoActionPerformed(arg0);
		}
		
		
	}
	

	protected void btnNuevoActionPerformed(ActionEvent arg0) {
		txtLoc_Nomb.setText("");
		txtLoc_Nomb.requestFocus();
		estado=true;
	}
	
	void Listar(){

	}
}
