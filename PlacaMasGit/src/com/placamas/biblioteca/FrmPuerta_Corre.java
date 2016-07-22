package com.placamas.biblioteca;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

public class FrmPuerta_Corre extends JInternalFrame implements ActionListener{

	DefaultTableModel modelo=new DefaultTableModel();
	Boolean estado=false;
	JTable tbMarcas;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JSeparator separator;
	public JPanel puerta;
	private JLabel label;
	private JSeparator separator_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton button_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblDistanciaBordeSuperiordbs;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JLabel lblDistanciaBordeLateral;
	private JLabel label_8;
	private JTable table;
	private JTable table_1;
	private JButton button;
	private JButton button_1;
	private JButton button_4;
	private JButton button_5;
	private JButton button_6;
	private JButton button_7;
	private JButton button_8;
	private JButton button_9;
	private JButton button_10;
	private JButton button_11;
	private JButton button_12;
	private JButton button_13;
	private JButton button_14;
	private JButton button_15;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmPuerta_Corre frame = new FrmPuerta_Corre();
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
	public FrmPuerta_Corre() {
		
		puerta = new JPanel();
		puerta.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		puerta.add(toolBar);
		
		
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
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(FrmTableros.class.getResource("/iconosmodernos/1466476622_common-new-edit-compose-glyph.png")));
		button_2.setToolTipText("Eliminar");
		toolBar.add(button_2);
		
		button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(FrmRanuras.class.getResource("/iconosmodernos/1466475396_Save-as.png")));
		button_3.setToolTipText("Eliminar");
		toolBar.add(button_3);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		
		
		separator = new JSeparator();
		separator.setBounds(726, 132, 0, 2);
		puerta.add(separator);
		
		
		
		tbMarcas = new JTable();
		
		label = new JLabel("");
		label.setBounds(0, 33, 1194, 65);
		label.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/gui/img/banners/corre.jpg")));
		puerta.add(label);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 106, 1354, 8);
		puerta.add(separator_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(64, 132, 818, 259);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ranuras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		puerta.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblDistancia = new JLabel("Espesor(ESP):");
		lblDistancia.setBounds(607, 44, 77, 14);
		panel_1.add(lblDistancia);
		
		JLabel lblEspesoresp = new JLabel("Codigo:");
		lblEspesoresp.setBounds(636, 21, 48, 14);
		panel_1.add(lblEspesoresp);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setColumns(10);
		textField_2.setBounds(690, 18, 38, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setColumns(10);
		textField_3.setBounds(690, 41, 38, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setColumns(10);
		textField_4.setBounds(690, 63, 38, 20);
		panel_1.add(textField_4);
		
		JCheckBox chckbxActivo = new JCheckBox("Activo");
		chckbxActivo.setBounds(734, 18, 64, 23);
		panel_1.add(chckbxActivo);
		
		textField_5 = new JTextField();
		textField_5.setText("");
		textField_5.setColumns(10);
		textField_5.setBounds(690, 107, 38, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("");
		textField_6.setColumns(10);
		textField_6.setBounds(690, 85, 38, 20);
		panel_1.add(textField_6);
		
		lblDistanciaBordeSuperiordbs = new JLabel("Distancia Borde Lateral 1 (DBL1):");
		lblDistanciaBordeSuperiordbs.setBounds(515, 66, 169, 14);
		panel_1.add(lblDistanciaBordeSuperiordbs);
		
		JCheckBox checkBox_3 = new JCheckBox("Ver Todos (Act./Inact.)");
		checkBox_3.setBounds(25, 229, 177, 23);
		panel_1.add(checkBox_3);
		
		lblDistanciaBordeLateral = new JLabel("Distancia Borde Lateral 2 (DBL2):");
		lblDistanciaBordeLateral.setBounds(515, 88, 169, 14);
		panel_1.add(lblDistanciaBordeLateral);
		
		label_8 = new JLabel("Profundidad(PRF):");
		label_8.setBounds(586, 110, 98, 14);
		panel_1.add(label_8);
		
		table = new JTable();
		table.setBounds(25, 49, 456, 173);
		panel_1.add(table);
		
		button = new JButton("");
		button.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		button.setToolTipText("Nuevo Registro");
		button.setBounds(25, 21, 23, 23);
		panel_1.add(button);
		
		button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		button_1.setToolTipText("Editar Registro");
		button_1.setBounds(48, 21, 23, 23);
		panel_1.add(button_1);
		
		button_4 = new JButton("");
		button_4.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/iconosmodernos/1466475388_save.png")));
		button_4.setToolTipText("Eliminar Registro");
		button_4.setBounds(71, 21, 23, 23);
		panel_1.add(button_4);
		
		button_5 = new JButton("");
		button_5.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		button_5.setToolTipText("Exportar Tableros");
		button_5.setBounds(94, 21, 23, 23);
		panel_1.add(button_5);
		
		button_6 = new JButton("");
		button_6.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		button_6.setToolTipText("Quitar Edicion Registro");
		button_6.setBounds(124, 21, 23, 23);
		panel_1.add(button_6);
		
		button_7 = new JButton("");
		button_7.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_List.png")));
		button_7.setToolTipText("Grabar Cambios");
		button_7.setBounds(154, 21, 23, 23);
		panel_1.add(button_7);
		
		button_8 = new JButton("");
		button_8.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Text_preview.png")));
		button_8.setToolTipText("Copiar Registro");
		button_8.setBounds(177, 21, 23, 23);
		panel_1.add(button_8);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Perforaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel.setBounds(64, 395, 818, 259);
		puerta.add(panel);
		
		textField_7 = new JTextField();
		textField_7.setText("");
		textField_7.setColumns(10);
		textField_7.setBounds(653, 62, 76, 20);
		panel.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setText("");
		textField_8.setColumns(10);
		textField_8.setBounds(653, 84, 49, 20);
		panel.add(textField_8);
		
		JLabel label_1 = new JLabel("Codigo Rapido:");
		label_1.setBounds(560, 65, 83, 14);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Codigo Largo:");
		label_2.setBounds(567, 87, 76, 14);
		panel.add(label_2);
		
		JLabel label_4 = new JLabel("Diametro(DMT):");
		label_4.setBounds(558, 110, 83, 14);
		panel.add(label_4);
		
		textField_9 = new JTextField();
		textField_9.setText("");
		textField_9.setColumns(10);
		textField_9.setBounds(653, 107, 49, 20);
		panel.add(textField_9);
		
		JCheckBox checkBox_2 = new JCheckBox("Activo");
		checkBox_2.setBounds(735, 61, 61, 23);
		panel.add(checkBox_2);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ver Todos (Act./Inact.)");
		chckbxNewCheckBox_1.setBounds(29, 229, 177, 23);
		panel.add(chckbxNewCheckBox_1);
		
		table_1 = new JTable();
		table_1.setBounds(29, 48, 452, 178);
		panel.add(table_1);
		
		button_9 = new JButton("");
		button_9.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		button_9.setToolTipText("Nuevo Registro");
		button_9.setBounds(31, 21, 23, 23);
		panel.add(button_9);
		
		button_10 = new JButton("");
		button_10.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		button_10.setToolTipText("Editar Registro");
		button_10.setBounds(54, 21, 23, 23);
		panel.add(button_10);
		
		button_11 = new JButton("");
		button_11.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/iconosmodernos/1466475388_save.png")));
		button_11.setToolTipText("Eliminar Registro");
		button_11.setBounds(77, 21, 23, 23);
		panel.add(button_11);
		
		button_12 = new JButton("");
		button_12.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		button_12.setToolTipText("Exportar Tableros");
		button_12.setBounds(100, 21, 23, 23);
		panel.add(button_12);
		
		button_13 = new JButton("");
		button_13.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		button_13.setToolTipText("Quitar Edicion Registro");
		button_13.setBounds(130, 21, 23, 23);
		panel.add(button_13);
		
		button_14 = new JButton("");
		button_14.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_List.png")));
		button_14.setToolTipText("Grabar Cambios");
		button_14.setBounds(160, 21, 23, 23);
		panel.add(button_14);
		
		button_15 = new JButton("");
		button_15.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Text_preview.png")));
		button_15.setToolTipText("Copiar Registro");
		button_15.setBounds(183, 21, 23, 23);
		panel.add(button_15);
		
		
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
