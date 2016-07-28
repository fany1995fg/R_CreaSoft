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
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	public JPanel bisagrado;
	private JLabel label;
	private JTextField txtCodigo;
	private JTextField txtDMT;
	private JTextField txtDBL;
	private JTextField txtPRF;
	private JButton btnFinal;
	private JTextField txtDBS;
	private JTextField txtDBI;
	private JLabel lblDBS;
	private JLabel lblDBI;
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
		panel_1.setBounds(20, 121, 1113, 495);
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
		lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblCodigo.setBounds(530, 31, 160, 20);
		panel_1.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setText("");
		txtCodigo.setBounds(696, 31, 122, 20);
		panel_1.add(txtCodigo);
		txtCodigo.setColumns(10);
		
		JCheckBox chbxActivo = new JCheckBox("Activo");
		chbxActivo.setFont(new Font("Dialog", Font.PLAIN, 11));
		chbxActivo.setBounds(900, 31, 110, 20);
		panel_1.add(chbxActivo);
		
		JLabel lblDMT = new JLabel("Diametro (DMT) : ");
		lblDMT.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDMT.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDMT.setBounds(530, 57, 160, 20);
		panel_1.add(lblDMT);
		
		txtDMT = new JTextField();
		txtDMT.setText("");
		txtDMT.setColumns(10);
		txtDMT.setBounds(696, 57, 40, 20);
		panel_1.add(txtDMT);
		
		JCheckBox chbxEditarLp = new JCheckBox("Editar en LP");
		chbxEditarLp.setFont(new Font("Dialog", Font.PLAIN, 11));
		chbxEditarLp.setBounds(900, 57, 110, 20);
		panel_1.add(chbxEditarLp);
		
		JLabel lblDBL = new JLabel("Distancia Borde Lateral (DBL) : ");
		lblDBL.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDBL.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDBL.setBounds(510, 82, 180, 20);
		panel_1.add(lblDBL);
		
		txtDBL = new JTextField();
		txtDBL.setText("");
		txtDBL.setColumns(10);
		txtDBL.setBounds(696, 83, 40, 20);
		panel_1.add(txtDBL);
		
		JCheckBox chbxDBL = new JCheckBox("Mas Usado");
		chbxDBL.setFont(new Font("Dialog", Font.PLAIN, 11));
		chbxDBL.setBounds(900, 83, 110, 20);
		panel_1.add(chbxDBL);
		
		JLabel lblPRF = new JLabel("Profundidad (PRF) : ");
		lblPRF.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPRF.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblPRF.setBounds(530, 109, 160, 20);
		panel_1.add(lblPRF);
		
		txtPRF = new JTextField();
		txtPRF.setText("");
		txtPRF.setColumns(10);
		txtPRF.setBounds(696, 109, 40, 20);
		panel_1.add(txtPRF);
		
		lblDBS = new JLabel("Distancia Borde Superior (DBS) : ");
		lblDBS.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDBS.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDBS.setBounds(510, 134, 180, 20);
		panel_1.add(lblDBS);
		
		txtDBS = new JTextField();
		txtDBS.setText("");
		txtDBS.setColumns(10);
		txtDBS.setBounds(696, 135, 40, 20);
		panel_1.add(txtDBS);
		
		lblDBI = new JLabel("Distancia Borde Inferior (DBI) : ");
		lblDBI.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDBI.setFont(new Font("Dialog", Font.PLAIN, 11));
		lblDBI.setBounds(510, 160, 180, 20);
		panel_1.add(lblDBI);
		
		txtDBI = new JTextField();
		txtDBI.setText("");
		txtDBI.setColumns(10);
		txtDBI.setBounds(696, 161, 38, 20);
		panel_1.add(txtDBI);
		
		JCheckBox chbxVerTodos = new JCheckBox("Ver Todos (Act./Inact.)");
		chbxVerTodos.setFont(new Font("Dialog", Font.PLAIN, 11));
		chbxVerTodos.setBounds(10, 457, 177, 23);
		panel_1.add(chbxVerTodos);
		
		
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