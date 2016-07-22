package com.placamas.listado;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;

import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;


import javax.swing.JRadioButton;
import javax.swing.JComboBox;

import com.toedter.calendar.JDateChooser;

public class Filtro extends JInternalFrame implements ActionListener{

	DefaultTableModel modelo=new DefaultTableModel();
	Boolean estado=false;
	JTable tbMarcas;
	private JButton btnCerrar;
	private JSeparator separator;
	//public JPanel getContentPane();
	private JPanel panel;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Filtro frame = new Filtro();
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
	public Filtro() {
		


		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		
		

		this.setSize(940, 540);
		
		//getContentPane() = new JPanel();
		getContentPane().setLayout(null);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		
		
		separator = new JSeparator();
		separator.setBounds(726, 132, 0, 2);
		getContentPane().add(separator);
		
		
		
		tbMarcas = new JTable();
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(70, 44, 409, 78);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Origen", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("Todos");
		rdbtnNewRadioButton.setBounds(52, 19, 109, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnMostrador = new JRadioButton("Mostrador");
		rdbtnMostrador.setBounds(52, 45, 109, 23);
		panel_1.add(rdbtnMostrador);
		
		JRadioButton rdbtnExterno = new JRadioButton("Externo");
		rdbtnExterno.setBounds(212, 45, 109, 23);
		panel_1.add(rdbtnExterno);
		
		JRadioButton rdbtnSala = new JRadioButton("Sala");
		rdbtnSala.setBounds(212, 19, 109, 23);
		panel_1.add(rdbtnSala);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Estado de la LP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(70, 132, 409, 258);
		getContentPane().add(panel);
		
		JRadioButton rdbtnEmitido = new JRadioButton("Emitido");
		rdbtnEmitido.setBounds(18, 26, 109, 16);
		panel.add(rdbtnEmitido);
		
		JRadioButton rdbtnActualizado = new JRadioButton("Actualizado");
		rdbtnActualizado.setBounds(18, 44, 109, 16);
		panel.add(rdbtnActualizado);
		
		JRadioButton rdbtnFacturado = new JRadioButton("Facturado");
		rdbtnFacturado.setBounds(18, 81, 109, 16);
		panel.add(rdbtnFacturado);
		
		JRadioButton rdbtnOptimizar = new JRadioButton("Optimizado");
		rdbtnOptimizar.setBounds(18, 62, 109, 16);
		panel.add(rdbtnOptimizar);
		
		JRadioButton rdbtnProduccion = new JRadioButton("Producci\u00F3n");
		rdbtnProduccion.setBounds(18, 118, 109, 16);
		panel.add(rdbtnProduccion);
		
		JRadioButton rdbtnAprobado = new JRadioButton("Aprobado");
		rdbtnAprobado.setBounds(18, 100, 109, 16);
		panel.add(rdbtnAprobado);
		
		JRadioButton rdbtnEntregado = new JRadioButton("Entregado");
		rdbtnEntregado.setBounds(18, 155, 109, 16);
		panel.add(rdbtnEntregado);
		
		JRadioButton rdbtnListoParaEntregar = new JRadioButton("Listo para Entregar");
		rdbtnListoParaEntregar.setBounds(18, 137, 133, 16);
		panel.add(rdbtnListoParaEntregar);
		
		JLabel lblFechaInicial = new JLabel("Fecha Inicial:");
		lblFechaInicial.setBounds(212, 27, 68, 14);
		panel.add(lblFechaInicial);
		
		JLabel label_1 = new JLabel("Optimizador:");
		label_1.setBounds(212, 45, 62, 14);
		panel.add(label_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(286, 22, 98, 20);
		panel.add(dateChooser);
		
		JDateChooser dateChooser_1 = new JDateChooser();
		dateChooser_1.setBounds(286, 44, 98, 20);
		panel.add(dateChooser_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(Filtro.class.getResource("/Iconos_PlacaMas/_First.png")));
		button.setToolTipText("Ir a Inicio de Registros");
		button.setBounds(252, 81, 23, 23);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(Filtro.class.getResource("/Iconos_PlacaMas/_Back.png")));
		button_1.setToolTipText("Ir a Pantalla anterior");
		button_1.setBounds(275, 81, 23, 23);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(Filtro.class.getResource("/Iconos_PlacaMas/_Forward.png")));
		button_2.setToolTipText("Ir a Pantalla Siguientes");
		button_2.setBounds(298, 81, 23, 23);
		panel.add(button_2);
		
		JButton button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(Filtro.class.getResource("/Iconos_PlacaMas/_Last.png")));
		button_3.setToolTipText("Ir a Ultimo Registro");
		button_3.setBounds(321, 81, 23, 23);
		panel.add(button_3);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ver lista con un ESTADO ACTUAL");
		chckbxNewCheckBox_1.setBounds(173, 202, 216, 23);
		panel.add(chckbxNewCheckBox_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Actualizaci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(504, 44, 379, 78);
		getContentPane().add(panel_2);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Actualizar Lista Automaticamente");
		chckbxNewCheckBox.setBounds(23, 20, 208, 23);
		panel_2.add(chckbxNewCheckBox);
		
		JLabel lblNewLabel = new JLabel("(de preferencia usar este check cuando el origen es Externo)");
		lblNewLabel.setBounds(46, 40, 320, 14);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_3.setBounds(504, 132, 379, 110);
		getContentPane().add(panel_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 27, 257, 20);
		panel_3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(100, 52, 257, 20);
		panel_3.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(100, 79, 257, 20);
		panel_3.add(comboBox_2);
		
		JLabel lblDigitador = new JLabel("Digitador:");
		lblDigitador.setBounds(28, 30, 62, 14);
		panel_3.add(lblDigitador);
		
		JLabel lblOptimizador = new JLabel("Optimizador:");
		lblOptimizador.setBounds(28, 55, 62, 14);
		panel_3.add(lblOptimizador);
		
		JLabel lblVendedor = new JLabel("Vendedor:");
		lblVendedor.setBounds(28, 82, 62, 14);
		panel_3.add(lblVendedor);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Datos Generales", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(504, 241, 379, 149);
		getContentPane().add(panel_4);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(28, 30, 62, 14);
		panel_4.add(lblNombre);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setBounds(28, 55, 62, 14);
		panel_4.add(lblCliente);
		
		JLabel lblObra = new JLabel("Obra:");
		lblObra.setBounds(28, 82, 62, 14);
		panel_4.add(lblObra);
		
		JLabel lblReferencia = new JLabel("Referencia:");
		lblReferencia.setBounds(28, 110, 62, 14);
		panel_4.add(lblReferencia);
		
		textField = new JTextField();
		textField.setBounds(100, 27, 256, 20);
		panel_4.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(100, 52, 256, 20);
		panel_4.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(100, 79, 256, 20);
		panel_4.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(100, 107, 256, 20);
		panel_4.add(textField_3);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Numero de LP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(289, 401, 379, 78);
		getContentPane().add(panel_5);
		
		JLabel lblNewLabel_1 = new JLabel("Inicio:");
		lblNewLabel_1.setBounds(26, 29, 46, 14);
		panel_5.add(lblNewLabel_1);
		
		textField_4 = new JTextField();
		textField_4.setBounds(82, 26, 92, 20);
		panel_5.add(textField_4);
		textField_4.setColumns(10);
		
		JLabel lblFinal = new JLabel("Final:");
		lblFinal.setBounds(200, 26, 46, 14);
		panel_5.add(lblFinal);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(256, 23, 92, 20);
		panel_5.add(textField_5);
		
		JButton btnNewButton = new JButton("Aceptar");
		btnNewButton.setBounds(342, 507, 89, 23);
		getContentPane().add(btnNewButton);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(485, 507, 89, 23);
		getContentPane().add(btnCancelar);
		
		
		int fila=0;
		
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

	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}