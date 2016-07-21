package com.placamas.biblioteca;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import com.placamas.vista.FrmTextura;

public class FrmTapacantos extends JInternalFrame implements ActionListener{
	DefaultTableModel modelo=new DefaultTableModel();
	Boolean estado=false;
	JTable tbMarcas;
	private JTable tbTablero;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JSeparator separator;
	public JPanel tapacanto;
	private JLabel label;
	private JSeparator separator_1;
	private JLabel lblListaDeMarcas;
	private JCheckBox chckbxServPrimeun;
	private JCheckBox chckbxRotacion;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
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
	public FrmTapacantos() {
		
		tapacanto = new JPanel();
		tapacanto.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		tapacanto.add(toolBar);
		
		
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
		tapacanto.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 138, 496, 417);
		tapacanto.add(scrollPane);		
		
		
		
		tbMarcas = new JTable();
		tbTablero = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};

		scrollPane.setViewportView(tbTablero);
		tbTablero.setModel(modelo);
		
		label = new JLabel("");
		label.setBounds(0, 33, 1194, 65);
		label.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/gui/img/banners/Tapacantos.jpg")));
		tapacanto.add(label);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 106, 1354, 8);
		tapacanto.add(separator_1);
		
		lblListaDeMarcas = new JLabel("Lista de Tapacantos:");
		lblListaDeMarcas.setBounds(57, 106, 153, 20);
		lblListaDeMarcas.setFont(new Font("Tahoma", Font.BOLD, 12));
		tapacanto.add(lblListaDeMarcas);
		
		JPanel panel = new JPanel();
		panel.setBounds(627, 132, 109, 44);
		panel.setBorder(new TitledBorder(null, "Codigo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		tapacanto.add(panel);
		panel.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setColumns(10);
		textField_2.setBounds(10, 18, 86, 20);
		panel.add(textField_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(627, 175, 332, 73);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tapacanto.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(68, 19, 228, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(68, 42, 228, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("LP:");
		lblNewLabel.setBounds(38, 22, 26, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblEtiqueta = new JLabel("Etiqueta:");
		lblEtiqueta.setBounds(10, 45, 54, 14);
		panel_1.add(lblEtiqueta);
		
		chckbxServPrimeun = new JCheckBox("Modifica Descripcion en LP");
		chckbxServPrimeun.setBounds(762, 153, 193, 23);
		tapacanto.add(chckbxServPrimeun);
		
		chckbxRotacion = new JCheckBox("Activo");
		chckbxRotacion.setBounds(762, 135, 94, 20);
		tapacanto.add(chckbxRotacion);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(762, 262, 193, 20);
		tapacanto.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(762, 286, 193, 20);
		tapacanto.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(762, 310, 193, 20);
		tapacanto.add(comboBox_2);
		
		JLabel lblMarca = new JLabel(" Color Generico:");
		lblMarca.setBounds(660, 289, 94, 14);
		tapacanto.add(lblMarca);
		
		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setBounds(704, 265, 46, 14);
		tapacanto.add(lblMaterial);
		
		JLabel lblEspesor = new JLabel(" Color Especifico:");
		lblEspesor.setBounds(660, 313, 102, 14);
		tapacanto.add(lblEspesor);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(665, 338, 131, 44);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ancho", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tapacanto.add(panel_2);
		panel_2.setLayout(null);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(72, 13, 49, 20);
		panel_2.add(comboBox_3);
		
		JLabel label_1 = new JLabel("Canto:");
		label_1.setBounds(27, 16, 38, 14);
		panel_2.add(label_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(806, 338, 153, 73);
		panel_3.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Espesor", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tapacanto.add(panel_3);
		panel_3.setLayout(null);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(94, 19, 49, 20);
		panel_3.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(94, 42, 49, 20);
		panel_3.add(comboBox_6);
		
		JLabel lblCanto = new JLabel("Canto:");
		lblCanto.setBounds(46, 22, 38, 14);
		panel_3.add(lblCanto);
		
		JLabel lblMin = new JLabel("Min. Tablero:");
		lblMin.setBounds(10, 45, 85, 14);
		panel_3.add(lblMin);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(703, 409, 256, 172);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Match Tablero", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		tapacanto.add(panel_4);
		panel_4.setLayout(null);
		
		table = new JTable();
		table.setBounds(10, 23, 236, 120);
		panel_4.add(table);
		
		JLabel lblins = new JLabel("[INS]Nuevo [DEL]Borrar");
		lblins.setBounds(125, 147, 121, 14);
		panel_4.add(lblins);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ver Todos (Act./Inact.)");
		chckbxNewCheckBox_1.setBounds(506, 588, 177, 23);
		tapacanto.add(chckbxNewCheckBox_1);
		
		
		int fila=0;
		
		tbTablero.requestFocus();
		tbTablero.changeSelection(0,0,true, false);
		
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