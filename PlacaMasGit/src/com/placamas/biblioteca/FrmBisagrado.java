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

public class FrmBisagrado extends JInternalFrame implements ActionListener{

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
	public JPanel bisagrado;
	private JLabel label;
	private JSeparator separator_1;
	private JLabel lblListaDeMarcas;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton button_3;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblDistanciaBordeSuperiordbs;
	private JLabel lblDistanciaBordeInferiordbi;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmBisagrado frame = new FrmBisagrado();
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
	public FrmBisagrado() {
		
		bisagrado = new JPanel();
		bisagrado.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		bisagrado.add(toolBar);
		
		
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
		bisagrado.add(separator);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(57, 173, 353, 396);
		bisagrado.add(scrollPane);		
		
		
		
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
		label.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/gui/img/banners/Bisagrado.JPG")));
		bisagrado.add(label);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 106, 1354, 8);
		bisagrado.add(separator_1);
		
		lblListaDeMarcas = new JLabel("Lista de Perforaciones:");
		lblListaDeMarcas.setBounds(57, 149, 153, 20);
		lblListaDeMarcas.setFont(new Font("Tahoma", Font.BOLD, 12));
		bisagrado.add(lblListaDeMarcas);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(473, 174, 486, 208);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Descripci\u00F3n", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bisagrado.add(panel_1);
		panel_1.setLayout(null);
		
		textField = new JTextField();
		textField.setText("");
		textField.setBounds(196, 17, 83, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("");
		textField_1.setColumns(10);
		textField_1.setBounds(196, 39, 83, 20);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("Codigo Rapido:");
		lblNewLabel.setBounds(94, 23, 92, 14);
		panel_1.add(lblNewLabel);
		
		JLabel lblEtiqueta = new JLabel("Codigo Largo:");
		lblEtiqueta.setBounds(101, 42, 85, 14);
		panel_1.add(lblEtiqueta);
		
		JLabel lblDistancia = new JLabel("Distancia Borde Lateral(DBL):");
		lblDistancia.setBounds(21, 88, 169, 14);
		panel_1.add(lblDistancia);
		
		JLabel lblEspesoresp = new JLabel("Diametro(DMT):");
		lblEspesoresp.setBounds(101, 65, 83, 14);
		panel_1.add(lblEspesoresp);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setColumns(10);
		textField_2.setBounds(196, 62, 38, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setColumns(10);
		textField_3.setBounds(196, 85, 38, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setColumns(10);
		textField_4.setBounds(196, 107, 38, 20);
		panel_1.add(textField_4);
		
		JLabel lblProfundidad = new JLabel("Profundidad(PRF):");
		lblProfundidad.setBounds(83, 110, 103, 14);
		panel_1.add(lblProfundidad);
		
		JCheckBox chckbxDistanciaBordeLateral = new JCheckBox("Comun");
		chckbxDistanciaBordeLateral.setBounds(290, 63, 190, 20);
		panel_1.add(chckbxDistanciaBordeLateral);
		
		JCheckBox chckbxEditarEnLp = new JCheckBox("Editar en LP");
		chckbxEditarEnLp.setBounds(290, 40, 133, 20);
		panel_1.add(chckbxEditarEnLp);
		
		JCheckBox chckbxActivo = new JCheckBox("Activo");
		chckbxActivo.setBounds(290, 17, 83, 23);
		panel_1.add(chckbxActivo);
		
		textField_5 = new JTextField();
		textField_5.setText("");
		textField_5.setColumns(10);
		textField_5.setBounds(196, 151, 38, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("");
		textField_6.setColumns(10);
		textField_6.setBounds(196, 129, 38, 20);
		panel_1.add(textField_6);
		
		lblDistanciaBordeSuperiordbs = new JLabel("Distancia Borde Superior(DBS):");
		lblDistanciaBordeSuperiordbs.setBounds(21, 132, 169, 14);
		panel_1.add(lblDistanciaBordeSuperiordbs);
		
		lblDistanciaBordeInferiordbi = new JLabel("Distancia Borde Inferior(DBI):");
		lblDistanciaBordeInferiordbi.setBounds(21, 154, 169, 14);
		panel_1.add(lblDistanciaBordeInferiordbi);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ver Todos (Act./Inact.)");
		chckbxNewCheckBox_1.setBounds(506, 588, 177, 23);
		bisagrado.add(chckbxNewCheckBox_1);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(FrmTableros.class.getResource("/iconosmodernos/1466475388_save.png")));
		button.setToolTipText("Eliminar");
		button.setBounds(57, 115, 23, 23);
		bisagrado.add(button);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(FrmTableros.class.getResource("/iconosmodernos/1466476618_File.png")));
		button_1.setToolTipText("Eliminar");
		button_1.setBounds(83, 115, 23, 23);
		bisagrado.add(button_1);
		
		
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