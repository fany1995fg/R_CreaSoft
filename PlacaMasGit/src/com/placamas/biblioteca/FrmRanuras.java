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
	private JTextField vrbCodigo;
	private JTextField vrbEsp;
	private JTextField vrbDBL;
	private JTextField vrbPRF;
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
		panel_1.setBounds(20, 112, 1113, 495);
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
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCodigo.setBounds(599, 31, 140, 20);
		panel_1.add(lblCodigo);
		
		vrbCodigo = new JTextField();
		vrbCodigo.setText("");
		vrbCodigo.setBounds(750, 31, 122, 20);
		panel_1.add(vrbCodigo);
		vrbCodigo.setColumns(10);
		
		JCheckBox chbxActivo = new JCheckBox("Activo");
		chbxActivo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chbxActivo.setBounds(950, 31, 64, 20);
		panel_1.add(chbxActivo);
		
		JLabel lblESP = new JLabel("Espesor (ESP) : ");
		lblESP.setHorizontalAlignment(SwingConstants.TRAILING);
		lblESP.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblESP.setBounds(599, 57, 140, 20);
		panel_1.add(lblESP);
		
		vrbEsp = new JTextField();
		vrbEsp.setText("");
		vrbEsp.setColumns(10);
		vrbEsp.setBounds(750, 57, 40, 20);
		panel_1.add(vrbEsp);
		
		JCheckBox chbxEditar = new JCheckBox("Editar en LP");
		chbxEditar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chbxEditar.setBounds(950, 57, 90, 20);
		panel_1.add(chbxEditar);
		
		JLabel lblDBL = new JLabel("Distancia Borde Lateral (DBL) : ");
		lblDBL.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDBL.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDBL.setBounds(599, 83, 140, 20);
		panel_1.add(lblDBL);
		
		vrbDBL = new JTextField();
		vrbDBL.setText("");
		vrbDBL.setColumns(10);
		vrbDBL.setBounds(750, 83, 40, 20);
		panel_1.add(vrbDBL);
		
		JCheckBox chbxComun = new JCheckBox("Mas Usado");
		chbxComun.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chbxComun.setBounds(950, 83, 120, 20);
		panel_1.add(chbxComun);
		
		JLabel lblPRF = new JLabel("Profundidad (PRF) : ");
		lblPRF.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPRF.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPRF.setBounds(599, 109, 140, 20);
		panel_1.add(lblPRF);
		
		vrbPRF = new JTextField();
		vrbPRF.setText("");
		vrbPRF.setColumns(10);
		vrbPRF.setBounds(750, 109, 40, 20);
		panel_1.add(vrbPRF);
		
		JCheckBox chBxVerTodos = new JCheckBox("Ver Todos (Act./Inact.)");
		chBxVerTodos.setFont(new Font("Tahoma", Font.PLAIN, 10));
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
