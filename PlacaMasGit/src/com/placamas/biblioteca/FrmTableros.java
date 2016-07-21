package com.placamas.biblioteca;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.placamas.beans.MarcasBean;
import com.placamas.controlador.MarcasControlador;
import com.placamas.vista.FrmMarcas;
import com.placamas.vista.FrmTextura;
import com.placamas.vista.LimiteJTextField;
import javax.swing.border.TitledBorder;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.UIManager;
import java.awt.Color;

public class FrmTableros extends JInternalFrame implements ActionListener{

	DefaultTableModel modelo=new DefaultTableModel();
	Boolean estado=false;
	JTable tbMarcas;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JSeparator separator;
	JPanel tablero;
	private JLabel label;
	private JSeparator separator_1;
	private JLabel lblListaDeMarcas;
	private JCheckBox checkBox;
	private JCheckBox checkBox_1;
	private JCheckBox checkBox_2;
	private JCheckBox checkBox_3;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmTableros frame = new FrmTableros();
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
	public FrmTableros() {
		
		tablero = new JPanel();
		tablero.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		tablero.add(toolBar);
		
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466476618_File.png")));
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475388_save.png")));

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
		
		
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEliminar.setToolTipText("Eliminar");
		btnGrabar.setToolTipText("Grabar");
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		
		
		separator = new JSeparator();
		separator.setBounds(726, 132, 0, 2);
		tablero.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 215, 496, 417);
		tablero.add(scrollPane);		
		
		
		
		tbMarcas = new JTable();
		tbMarcas = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};

		scrollPane.setViewportView(tbMarcas);
		tbMarcas.setModel(modelo);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(FrmMarcas.class.getResource("/gui/img/banners/Marquitas.png")));
		label.setBounds(0, 33, 1079, 116);
		tablero.add(label);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(0, 173, 1354, 20);
		tablero.add(separator_1);
		
		lblListaDeMarcas = new JLabel("Lista de Tableros:");
		lblListaDeMarcas.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblListaDeMarcas.setBounds(57, 183, 153, 20);
		tablero.add(lblListaDeMarcas);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Codigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(626, 208, 153, 55);
		tablero.add(panel);
		panel.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setColumns(10);
		textField_2.setBounds(10, 24, 133, 20);
		panel.add(textField_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(625, 274, 389, 84);
		tablero.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(137, 22, 228, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(137, 48, 228, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(63, 25, 46, 14);
		panel_1.add(lblNewLabel);
		
		JLabel label_1 = new JLabel("New label");
		label_1.setBounds(63, 51, 46, 14);
		panel_1.add(label_1);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(808, 240, 97, 23);
		tablero.add(chckbxNewCheckBox);
		
		checkBox = new JCheckBox("New check box");
		checkBox.setBounds(917, 240, 97, 23);
		tablero.add(checkBox);
		
		checkBox_1 = new JCheckBox("New check box");
		checkBox_1.setBounds(808, 222, 97, 23);
		tablero.add(checkBox_1);
		
		checkBox_2 = new JCheckBox("New check box");
		checkBox_2.setBounds(917, 222, 97, 23);
		tablero.add(checkBox_2);
		
		checkBox_3 = new JCheckBox("New check box");
		checkBox_3.setBounds(917, 204, 97, 23);
		tablero.add(checkBox_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(796, 362, 203, 20);
		tablero.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(796, 386, 203, 20);
		tablero.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(796, 410, 55, 20);
		tablero.add(comboBox_2);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setBounds(756, 389, 38, 14);
		tablero.add(lblMarca);
		
		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setBounds(748, 365, 46, 14);
		tablero.add(lblMaterial);
		
		JLabel lblEspesor = new JLabel("Espesor:");
		lblEspesor.setBounds(748, 413, 46, 14);
		tablero.add(lblEspesor);
		
		JLabel lblPiezaPor = new JLabel("Pieza x Pila:");
		lblPiezaPor.setBounds(891, 413, 65, 14);
		tablero.add(lblPiezaPor);
		
		textField_3 = new JTextField();
		textField_3.setBounds(955, 410, 44, 20);
		tablero.add(textField_3);
		textField_3.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Cara1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(737, 441, 131, 73);
		tablero.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(10, 21, 111, 20);
		panel_2.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(10, 44, 111, 20);
		panel_2.add(comboBox_4);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Cara2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(880, 441, 134, 73);
		tablero.add(panel_3);
		panel_3.setLayout(null);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(10, 21, 111, 20);
		panel_3.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(10, 44, 111, 20);
		panel_3.add(comboBox_6);
		
		JLabel lblTextura = new JLabel("Textura:");
		lblTextura.setBounds(692, 489, 46, 14);
		tablero.add(lblTextura);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setBounds(704, 464, 34, 14);
		tablero.add(lblColor);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setBounds(655, 516, 359, 134);
		tablero.add(panel_4);
		panel_4.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 23, 339, 82);
		panel_4.add(table);
		
		JLabel lblins = new JLabel("[INS]Nuevo [DEL]Borrar");
		lblins.setBounds(228, 116, 121, 14);
		panel_4.add(lblins);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ver Todos (Act./Inact.)");
		chckbxNewCheckBox_1.setBounds(498, 650, 144, 23);
		tablero.add(chckbxNewCheckBox_1);
		
		
		int fila=0;
		
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

	


	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


