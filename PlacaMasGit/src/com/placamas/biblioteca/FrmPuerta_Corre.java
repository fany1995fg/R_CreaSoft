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
import java.awt.SystemColor;

public class FrmPuerta_Corre extends JInternalFrame implements ActionListener{

	DefaultTableModel modelo=new DefaultTableModel();
	DefaultTableModel model=new DefaultTableModel();
	Boolean estado=false;
	JTable tbMarcas;
	private JButton btnAtras;

	private JButton btnAdelante;
	private JButton btnInicio;
	private JToolBar toolBar;
	public JPanel puerta;
	private JLabel lblBanner;
	private JTextField txtCodigo;
	private JTextField txtESP;
	private JTextField txtDBL1;
	private JTextField txtPRF;
	private JTextField txtDBL2;
	private JLabel lblDBL1;
	private JTextField txtPerCodigoRap;
	private JTextField txtCodigoLarg;
	private JTextField txtDiametro;
	private JLabel lblDBL2;
	private JLabel lblPRF;
	private JTable tbRanura;
	private JTable tbPerforaciones;
	private JButton btnRanNuevo;
	private JButton btnRanEdita;
	private JButton btnRanElimina;
	private JButton btnRanEditaNo;
	private JButton btnGrabar;
	private JButton btnCopiar;
	private JButton btnPegar;
	private JButton btnPerNuevo;
	private JButton btnPerEdita;
	private JButton btnPerGrabar;
	private JButton btnPerEditaNo;
	private JButton btnPerElimina;
	private JButton btnPerCopiar;
	private JButton btnPerPegar;
	private JSeparator separator;
	private JSeparator separator_1;
	private JSeparator separator_3;


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
		toolBar.setBounds(0, 0, 286, 30);
		puerta.add(toolBar);
		
		
		btnInicio = new JButton("");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnInicio);
		btnInicio.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_First.png")));
		
		btnAtras = new JButton("");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnAtras);
		btnAtras.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Back.png")));

		btnAdelante = new JButton("");
		toolBar.add(btnAdelante);
		btnAdelante.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Forward.png")));
		
		
		btnInicio.setToolTipText("Ir a 1er. registro");
		btnAdelante.setToolTipText("Ir a siguiente pantalla");
		btnAtras.setToolTipText("Ir a pantalla anterior");
		
		JButton btnFinal = new JButton("");
		btnFinal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFinal.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Last.png")));
		btnFinal.setToolTipText("Ir a ultimo registro");
		toolBar.add(btnFinal);
		
		modelo.addColumn("Codigo");
		modelo.addColumn(" ESP ");
		modelo.addColumn("DBL1");
		modelo.addColumn("DBL2");
		modelo.addColumn(" PRF ");
		
		model.addColumn("Codigo");
		model.addColumn("  Q  ");
		model.addColumn(" DBL ");
		
		tbMarcas = new JTable();
		
		lblBanner = new JLabel("");
		lblBanner.setBounds(0, 33, 1194, 65);
		lblBanner.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/gui/img/banners/corre.jpg")));
		puerta.add(lblBanner);
		
		JPanel panel_Ranuras = new JPanel();
		panel_Ranuras.setBounds(20, 120, 1113, 250);
		panel_Ranuras.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ranuras", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		puerta.add(panel_Ranuras);
		panel_Ranuras.setLayout(null);
		
		btnRanNuevo = new JButton("");
		btnRanNuevo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRanNuevo.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		btnRanNuevo.setToolTipText("Nuevo");
		btnRanNuevo.setBorder(null);
		btnRanNuevo.setBounds(10, 18, 23, 23);
		panel_Ranuras.add(btnRanNuevo);
		
		btnRanEdita = new JButton("");
		btnRanEdita.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRanEdita.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		btnRanEdita.setToolTipText("Editar");
		btnRanEdita.setBorder(null);
		btnRanEdita.setBounds(33, 18, 23, 23);
		panel_Ranuras.add(btnRanEdita);
		
		btnRanElimina = new JButton("");
		btnRanElimina.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRanElimina.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		btnRanElimina.setToolTipText("Eliminar");
		btnRanElimina.setBorder(null);
		btnRanElimina.setBounds(56, 18, 23, 23);
		panel_Ranuras.add(btnRanElimina);
		
		separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(82, 18, 2, 23);
		panel_Ranuras.add(separator);
		
		btnRanEditaNo = new JButton("");
		btnRanEditaNo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnRanEditaNo.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		btnRanEditaNo.setToolTipText("Salir de editar sin grabar");
		btnRanEditaNo.setBorder(null);
		btnRanEditaNo.setBounds(86, 18, 23, 23);
		panel_Ranuras.add(btnRanEditaNo);
		
		btnGrabar = new JButton("");
		btnGrabar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGrabar.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Save.png")));
		btnGrabar.setToolTipText("Grabar cambios");
		btnGrabar.setBorder(null);
		btnGrabar.setBounds(109, 18, 23, 23);
		panel_Ranuras.add(btnGrabar);
		
		separator_1 = new JSeparator();
		separator_1.setOrientation(SwingConstants.VERTICAL);
		separator_1.setBounds(134, 18, 2, 23);
		panel_Ranuras.add(separator_1);
		
		btnCopiar = new JButton("");
		btnCopiar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCopiar.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_List.png")));
		btnCopiar.setToolTipText("Copiar");
		btnCopiar.setBorder(null);
		btnCopiar.setBounds(138, 18, 23, 23);
		panel_Ranuras.add(btnCopiar);
		
		btnPegar = new JButton("");
		btnPegar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPegar.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Paste.png")));
		btnPegar.setToolTipText("Pegar");
		btnPegar.setBorder(null);
		btnPegar.setBounds(161, 18, 23, 23);
		panel_Ranuras.add(btnPegar);
		
		JLabel lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblCodigo.setBounds(530, 31, 160, 20);
		panel_Ranuras.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(696, 31, 122, 20);
		panel_Ranuras.add(txtCodigo);
		
		JLabel lblESP = new JLabel("Espesor (ESP) : ");
		lblESP.setHorizontalAlignment(SwingConstants.TRAILING);
		lblESP.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblESP.setBounds(520, 57, 170, 20);
		panel_Ranuras.add(lblESP);
		
		txtESP = new JTextField();
		txtESP.setText("");
		txtESP.setColumns(10);
		txtESP.setBounds(696, 57, 40, 20);
		panel_Ranuras.add(txtESP);
		
		lblDBL1 = new JLabel("Distancia Borde Lateral 1 (DBL1) : ");
		lblDBL1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDBL1.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDBL1.setBounds(490, 82, 200, 20);
		panel_Ranuras.add(lblDBL1);
		
		txtDBL1 = new JTextField();
		txtDBL1.setText("");
		txtDBL1.setColumns(10);
		txtDBL1.setBounds(696, 83, 40, 20);
		panel_Ranuras.add(txtDBL1);
		
		lblDBL2 = new JLabel("Distancia Borde Lateral 2 (DBL2) : ");
		lblDBL2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDBL2.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDBL2.setBounds(490, 108, 200, 20);
		panel_Ranuras.add(lblDBL2);
		
		txtDBL2 = new JTextField();
		txtDBL2.setText("");
		txtDBL2.setColumns(10);
		txtDBL2.setBounds(696, 109, 40, 20);
		panel_Ranuras.add(txtDBL2);
		
		lblPRF = new JLabel("Profundidad (PRF) : ");
		lblPRF.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPRF.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblPRF.setBounds(520, 136, 170, 20);
		panel_Ranuras.add(lblPRF);
		
		txtPRF = new JTextField();
		txtPRF.setText("");
		txtPRF.setColumns(10);
		txtPRF.setBounds(696, 136, 40, 20);
		panel_Ranuras.add(txtPRF);
		
		JCheckBox chckbxActivo = new JCheckBox("Activo");
		chckbxActivo.setFont(new Font("Dialog", Font.PLAIN, 11));
		chckbxActivo.setBounds(900, 31, 90, 20);
		panel_Ranuras.add(chckbxActivo);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 52, 456, 170);
		panel_Ranuras.add(scrollPane);

		tbRanura = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};
		
				scrollPane.setViewportView(tbRanura);
				
				tbRanura.setModel(modelo);
				
				tbRanura.requestFocus();
				tbRanura.changeSelection(0,0,true, false);
		
		JCheckBox chckbxVerTodos = new JCheckBox("Ver Todos (Act./Inact.)");
		chckbxVerTodos.setFont(new Font("Dialog", Font.PLAIN, 11));
		chckbxVerTodos.setBounds(10, 222, 177, 23);
		panel_Ranuras.add(chckbxVerTodos);
		
		JPanel panel_Perforaciones = new JPanel();
		panel_Perforaciones.setLayout(null);
		panel_Perforaciones.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Perforaciones", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_Perforaciones.setBounds(20, 375, 1113, 250);
		puerta.add(panel_Perforaciones);
		
		btnPerNuevo = new JButton("");
		btnPerNuevo.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		btnPerNuevo.setToolTipText("Nuevo Registro");
		btnPerNuevo.setBorder(null);
		btnPerNuevo.setBounds(10, 18, 23, 23);
		panel_Perforaciones.add(btnPerNuevo);
		
		btnPerEdita = new JButton("");
		btnPerEdita.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		btnPerEdita.setToolTipText("Editar Registro");
		btnPerEdita.setBorder(null);
		btnPerEdita.setBounds(33, 18, 23, 23);
		panel_Perforaciones.add(btnPerEdita);
		
		btnPerElimina = new JButton("");
		btnPerElimina.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		btnPerElimina.setToolTipText("Eliminar Registro");
		btnPerElimina.setBounds(56, 18, 23, 23);
		btnPerElimina.setBorder(null);
		panel_Perforaciones.add(btnPerElimina);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(82, 18, 2, 23);
		panel_Perforaciones.add(separator_2);
		
		btnPerEditaNo = new JButton("");
		btnPerEditaNo.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		btnPerEditaNo.setToolTipText("Salir de Editar sin Grabar");
		btnPerEditaNo.setBorder(null);
		btnPerEditaNo.setBounds(86, 18, 23, 23);
		panel_Perforaciones.add(btnPerEditaNo);
		
		btnPerGrabar = new JButton("");
		btnPerGrabar.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Save.png")));
		btnPerGrabar.setToolTipText("Grabar cambios");
		btnPerGrabar.setBorder(null);
		btnPerGrabar.setBounds(109, 18, 23, 23);
		panel_Perforaciones.add(btnPerGrabar);
		
		separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		separator_3.setBounds(134, 18, 2, 23);
		panel_Perforaciones.add(separator_3);
		
		btnPerCopiar = new JButton("");
		btnPerCopiar.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_List.png")));
		btnPerCopiar.setToolTipText("Copiar");
		btnPerCopiar.setBorder(null);
		btnPerCopiar.setBounds(138, 18, 23, 23);
		panel_Perforaciones.add(btnPerCopiar);
		
		btnPerPegar = new JButton("");
		btnPerPegar.setIcon(new ImageIcon(FrmPuerta_Corre.class.getResource("/Iconos_PlacaMas/_Paste.png")));
		btnPerPegar.setToolTipText("Pegar");
		btnPerPegar.setBorder(null);
		btnPerPegar.setBounds(161, 18, 23, 23);
		panel_Perforaciones.add(btnPerPegar);
		
		JLabel lblPerCodigoRapido = new JLabel("Codigo Rapido:");
		lblPerCodigoRapido.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPerCodigoRapido.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblPerCodigoRapido.setBounds(530, 31, 160, 20);
		panel_Perforaciones.add(lblPerCodigoRapido);
		
		txtPerCodigoRap = new JTextField();
		txtPerCodigoRap.setText("");
		txtPerCodigoRap.setColumns(10);
		txtPerCodigoRap.setBounds(696, 31, 40, 20);
		panel_Perforaciones.add(txtPerCodigoRap);
		
		JLabel lblPerCodigoLarg = new JLabel("Codigo Largo:");
		lblPerCodigoLarg.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPerCodigoLarg.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblPerCodigoLarg.setBounds(520, 57, 170, 20);
		panel_Perforaciones.add(lblPerCodigoLarg);
		
		txtCodigoLarg = new JTextField();
		txtCodigoLarg.setText("");
		txtCodigoLarg.setColumns(10);
		txtCodigoLarg.setBounds(696, 57, 122, 20);
		panel_Perforaciones.add(txtCodigoLarg);
		
		JLabel lblDMT = new JLabel("Diametro(DMT):");
		lblDMT.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDMT.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDMT.setBounds(520, 83, 170, 20);
		panel_Perforaciones.add(lblDMT);
		
		txtDiametro = new JTextField();
		txtDiametro.setText("");
		txtDiametro.setColumns(10);
		txtDiametro.setBounds(696, 83, 40, 20);
		panel_Perforaciones.add(txtDiametro);
		
		JCheckBox chckbxPerActivo = new JCheckBox("Activo");
		chckbxPerActivo.setFont(new Font("Dialog", Font.PLAIN, 11));
		chckbxPerActivo.setBounds(900, 31, 90, 20);
		panel_Perforaciones.add(chckbxPerActivo);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 52, 456, 170);
		panel_Perforaciones.add(scrollPane_1);
		
		
		tbPerforaciones = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};
		
				scrollPane_1.setViewportView(tbPerforaciones);
				
				tbPerforaciones.setModel(model);
				
				tbPerforaciones.requestFocus();
				tbPerforaciones.changeSelection(0,0,true, false);
		
		JCheckBox chckbxPerVerTodos = new JCheckBox("Ver Todos (Act./Inact.)");
		chckbxPerVerTodos.setFont(new Font("Dialog", Font.PLAIN, 11));
		chckbxPerVerTodos.setBounds(10, 222, 177, 23);
		panel_Perforaciones.add(chckbxPerVerTodos);
		
		int fila=0;
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
		int [] anchos = {200, 60, 60, 60,60};
		int [] per = {200, 60, 60, 60,60};
		
		for (int i = 0; i < tbRanura.getColumnCount(); i++) {
			tbRanura.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		
		for (int i = 0; i < tbPerforaciones.getColumnCount(); i++) {
			tbPerforaciones.getColumnModel().getColumn(i).setPreferredWidth(per[i]);
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
