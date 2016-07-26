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
import javax.swing.SwingConstants;

public class FrmBisagrado extends JInternalFrame implements ActionListener{

	DefaultTableModel modelo=new DefaultTableModel();
	Boolean estado=false;
	JTable tbMarcas;
	private JTable tbBisagra;
	private JButton btnEditar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	public JPanel bisagrado;
	private JLabel label;
	private JTextField vrdCodigo;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JButton btnFinal;
	private JTextField textField_5;
	private JTextField textField_6;
	private JLabel lblDistanciaBordeSuperiordbs;
	private JLabel lblDistanciaBordeInferiordbi;
	private JSeparator separator_1;
	private JButton btnEditarNo;
	private JButton btnCopiar;
	private JButton btnPegar;
	private JButton btnInicio;
	private JButton btnAtras;
	private JButton btnAdelante;
	private JSeparator separator_2;
	private JSeparator separator_3;


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
		toolBar.setBounds(0, 0, 286, 30);
		bisagrado.add(toolBar);
		
		
		btnNuevo = new JButton("");
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		btnEditar = new JButton("");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnEditar);
		btnEditar.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_Modify.png")));

		btnEliminar = new JButton("");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		
		
		btnNuevo.setToolTipText("Nuevo");
		btnEliminar.setToolTipText("Eliminar");
		btnEditar.setToolTipText("Editar");
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_1);
		
		btnEditarNo = new JButton("");
		btnEditarNo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEditarNo.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		btnEditarNo.setToolTipText("Salir de editar sin grabar");
		toolBar.add(btnEditarNo);
		
		JButton btnGrabar = new JButton("");
		btnGrabar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGrabar.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_Save.png")));
		btnGrabar.setToolTipText("Grabar cambios");
		toolBar.add(btnGrabar);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		btnCopiar = new JButton("");
		btnCopiar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCopiar.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_Copy.png")));
		btnCopiar.setToolTipText("Copiar");
		toolBar.add(btnCopiar);
		
		btnPegar = new JButton("");
		btnPegar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPegar.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_Paste.png")));
		btnPegar.setToolTipText("Pegar");
		toolBar.add(btnPegar);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_3);
		
		btnInicio = new JButton("");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnInicio.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_First.png")));
		btnInicio.setToolTipText("Ir a 1er registro");
		toolBar.add(btnInicio);
		
		btnAtras = new JButton("");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAtras.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_Back.png")));
		btnAtras.setToolTipText("Ir a pantalla anterior");
		toolBar.add(btnAtras);
		
		btnAdelante = new JButton("");
		btnAdelante.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdelante.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_Forward.png")));
		btnAdelante.setToolTipText("Ir a siguiente pantalla");
		toolBar.add(btnAdelante);
		
		btnFinal = new JButton("");
		btnFinal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFinal.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/Iconos_PlacaMas/_Last.png")));
		btnFinal.setToolTipText("Ir al utlimo registro");
		toolBar.add(btnFinal);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		
		
		
		tbMarcas = new JTable();
		
		label = new JLabel("");
		label.setBounds(0, 33, 1194, 65);
		label.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/gui/img/banners/Bisagrado.JPG")));
		bisagrado.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(29, 113, 1113, 495);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Bisagrado", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		bisagrado.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 353, 417);
		panel_1.add(scrollPane);
		tbBisagra = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};
		
				scrollPane.setViewportView(tbBisagra);
				tbBisagra.setModel(modelo);
				
				tbBisagra.requestFocus();
				tbBisagra.changeSelection(0,0,true, false);
		
		JLabel lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCodigo.setBounds(599, 31, 140, 20);
		panel_1.add(lblCodigo);
		
		vrdCodigo = new JTextField();
		vrdCodigo.setText("");
		vrdCodigo.setBounds(750, 31, 122, 20);
		panel_1.add(vrdCodigo);
		vrdCodigo.setColumns(10);
		
		JCheckBox chbxActivo = new JCheckBox("Activo");
		chbxActivo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chbxActivo.setBounds(950, 31, 64, 20);
		panel_1.add(chbxActivo);
		
		JLabel lblDistancia = new JLabel("Distancia Borde Lateral(DBL):");
		lblDistancia.setBounds(552, 170, 169, 14);
		panel_1.add(lblDistancia);
		
		JLabel lblEspesoresp = new JLabel("Diametro(DMT):");
		lblEspesoresp.setBounds(542, 147, 83, 14);
		panel_1.add(lblEspesoresp);
		
		textField_2 = new JTextField();
		textField_2.setText("");
		textField_2.setColumns(10);
		textField_2.setBounds(637, 144, 38, 20);
		panel_1.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("");
		textField_3.setColumns(10);
		textField_3.setBounds(727, 167, 38, 20);
		panel_1.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("");
		textField_4.setColumns(10);
		textField_4.setBounds(727, 189, 38, 20);
		panel_1.add(textField_4);
		
		JLabel lblProfundidad = new JLabel("Profundidad(PRF):");
		lblProfundidad.setBounds(614, 192, 103, 14);
		panel_1.add(lblProfundidad);
		
		JCheckBox chckbxDistanciaBordeLateral = new JCheckBox("Comun");
		chckbxDistanciaBordeLateral.setBounds(731, 145, 190, 20);
		panel_1.add(chckbxDistanciaBordeLateral);
		
		JCheckBox chckbxEditarEnLp = new JCheckBox("Editar en LP");
		chckbxEditarEnLp.setBounds(731, 122, 133, 20);
		panel_1.add(chckbxEditarEnLp);
		
		textField_5 = new JTextField();
		textField_5.setText("");
		textField_5.setColumns(10);
		textField_5.setBounds(727, 233, 38, 20);
		panel_1.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setText("");
		textField_6.setColumns(10);
		textField_6.setBounds(727, 211, 38, 20);
		panel_1.add(textField_6);
		
		lblDistanciaBordeSuperiordbs = new JLabel("Distancia Borde Superior(DBS):");
		lblDistanciaBordeSuperiordbs.setBounds(552, 214, 169, 14);
		panel_1.add(lblDistanciaBordeSuperiordbs);
		
		lblDistanciaBordeInferiordbi = new JLabel("Distancia Borde Inferior(DBI):");
		lblDistanciaBordeInferiordbi.setBounds(552, 236, 169, 14);
		panel_1.add(lblDistanciaBordeInferiordbi);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Ver Todos (Act./Inact.)");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chckbxNewCheckBox_1.setBounds(10, 457, 177, 23);
		panel_1.add(chckbxNewCheckBox_1);
		
		
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