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
import javax.swing.SwingConstants;

public class FrmRanuras extends JInternalFrame implements ActionListener{

	DefaultTableModel modelo=new DefaultTableModel();
	Boolean estado=false;
	JTable tbMarcas;
	private JTable tbRanura;
	private JButton btnEditar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	public JPanel ranura;
	private JLabel label;
	private JTextField txtCodigo;
	private JTextField txtEsp;
	private JTextField txtDBL;
	private JTextField txtPRF;
	private JButton btnFinal;
	private JSeparator separator_1;
	private JButton btnGrabar;
	private JSeparator separator_2;
	private JButton btnCopiar;
	private JButton btnPegar;
	private JSeparator separator_3;
	private JButton btnInicio;
	private JButton btnAtras;
	private JButton btnAdelante;


	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmRanuras frame = new FrmRanuras();
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
	public FrmRanuras() {
		
		ranura = new JPanel();
		ranura.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 286, 30);
		ranura.add(toolBar);
		
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		btnEditar = new JButton("");
		toolBar.add(btnEditar);
		btnEditar.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_Modify.png")));

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		
		
		btnNuevo.setToolTipText("Nuevo");
		btnEliminar.setToolTipText("Eliminar");
		btnEditar.setToolTipText("Editar");
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_1);
		
		JButton btnEditaNo = new JButton("");
		btnEditaNo.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		btnEditaNo.setToolTipText("Salir de editar sin grabar");
		toolBar.add(btnEditaNo);
		
		btnGrabar = new JButton("");
		btnGrabar.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_Save.png")));
		btnGrabar.setToolTipText("Grabar cambios");
		toolBar.add(btnGrabar);
		
		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		btnCopiar = new JButton("");
		btnCopiar.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_Copy.png")));
		btnCopiar.setToolTipText("Copiar Registro");
		toolBar.add(btnCopiar);
		
		btnPegar = new JButton("");
		btnPegar.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_Paste.png")));
		btnPegar.setToolTipText("Eliminar");
		toolBar.add(btnPegar);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_3);
		
		btnInicio = new JButton("");
		btnInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnInicio.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_First.png")));
		btnInicio.setToolTipText("Ir a 1er. registro");
		toolBar.add(btnInicio);
		
		btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_Back.png")));
		btnAtras.setToolTipText("Ir a pantalla anterior");
		toolBar.add(btnAtras);
		
		btnAdelante = new JButton("");
		btnAdelante.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_Forward.png")));
		btnAdelante.setToolTipText("Ir a siguiente pantalla");
		toolBar.add(btnAdelante);
		
		btnFinal = new JButton("");
		btnFinal.setIcon(new ImageIcon(FrmRanuras.class.getResource("/Iconos_PlacaMas/_Last.png")));
		btnFinal.setToolTipText("Ir a ultimo registro");
		toolBar.add(btnFinal);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		
		
		
		tbMarcas = new JTable();
		
		label = new JLabel("");
		label.setBounds(0, 33, 1194, 65);
		label.setIcon(new ImageIcon(FrmRanuras.class.getResource("/gui/img/banners/Ranuras.jpg")));
		ranura.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(20, 121, 1113, 495);
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ranura", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		ranura.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 418, 417);
		panel_1.add(scrollPane);
		tbRanura = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};
		
				scrollPane.setViewportView(tbRanura);
				tbRanura.setModel(modelo);
				
				tbRanura.requestFocus();
				tbRanura.changeSelection(0,0,true, false);
		
		JLabel lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigo.setBounds(510, 31, 180, 20);
		panel_1.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setBounds(696, 31, 122, 20);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JCheckBox chbxActivo = new JCheckBox("Activo");
		chbxActivo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxActivo.setBounds(900, 31, 100, 20);
		panel_1.add(chbxActivo);
		
		JLabel lblESP = new JLabel("Espesor (ESP) : ");
		lblESP.setHorizontalAlignment(SwingConstants.TRAILING);
		lblESP.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblESP.setBounds(510, 57, 180, 20);
		panel_1.add(lblESP);
		
		txtEsp = new JTextField();
		txtEsp.setText("");
		txtEsp.setColumns(10);
		txtEsp.setBounds(696, 57, 40, 20);
		panel_1.add(txtEsp);
		
		JCheckBox chbxEditar = new JCheckBox("Editar en LP");
		chbxEditar.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxEditar.setBounds(900, 57, 100, 20);
		panel_1.add(chbxEditar);
		
		JLabel lblDBL = new JLabel("Distancia Borde Lateral (DBL) : ");
		lblDBL.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDBL.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDBL.setBounds(510, 83, 180, 20);
		panel_1.add(lblDBL);
		
		txtDBL = new JTextField();
		txtDBL.setText("");
		txtDBL.setColumns(10);
		txtDBL.setBounds(695, 83, 40, 20);
		panel_1.add(txtDBL);
		
		JCheckBox chbxComun = new JCheckBox("Mas Usado");
		chbxComun.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxComun.setBounds(900, 83, 100, 20);
		panel_1.add(chbxComun);
		
		JLabel lblPRF = new JLabel("Profundidad (PRF) : ");
		lblPRF.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPRF.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPRF.setBounds(510, 109, 180, 20);
		panel_1.add(lblPRF);
		
		txtPRF = new JTextField();
		txtPRF.setText("");
		txtPRF.setColumns(10);
		txtPRF.setBounds(695, 109, 40, 20);
		panel_1.add(txtPRF);
		
		JCheckBox chBxVerTodos = new JCheckBox("Ver Todos (Act./Inact.)");
		chBxVerTodos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chBxVerTodos.setBounds(10, 457, 177, 23);
		panel_1.add(chBxVerTodos);
		
		
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
