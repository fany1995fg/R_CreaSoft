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
import java.awt.Rectangle;
import java.awt.Component;

public class FrmTapacantos extends JInternalFrame implements ActionListener{
	DefaultTableModel modelo=new DefaultTableModel();
	DefaultTableModel model=new DefaultTableModel();
	Boolean estado=false;
	JTable tbMarcas;
	private JTable tbCantos;
	private JButton btnEditar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	public JPanel tapacanto;
	private JLabel label;
	private JCheckBox chbxActivo;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;
	private JTable tbMatch;


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
		toolBar.setBounds(0, 0, 286, 30);
		tapacanto.add(toolBar);
		
		
		btnNuevo = new JButton("");
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		btnEditar = new JButton("");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnEditar);
		btnEditar.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Modify.png")));

		btnEliminar = new JButton("");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		
		
		btnNuevo.setToolTipText("Nuevo");
		btnEliminar.setToolTipText("Eliminar");
		btnEditar.setToolTipText("Editar");
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		
		JButton btnEditaNo = new JButton("");
		btnEditaNo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEditaNo.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Modify_No.png")));
		btnEditaNo.setToolTipText("Salir de editar sin grabar");
		toolBar.add(btnEditaNo);
		
		JButton btnGrabar = new JButton("");
		btnGrabar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnGrabar.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Save.png")));
		btnGrabar.setToolTipText("Grabar cambios");
		toolBar.add(btnGrabar);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		JButton btnCopiar = new JButton("");
		btnCopiar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCopiar.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Copy.png")));
		btnCopiar.setToolTipText("Copiar");
		toolBar.add(btnCopiar);
		
		JButton btnPegar = new JButton("");
		btnPegar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPegar.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Paste.png")));
		btnPegar.setToolTipText("Pegar");
		toolBar.add(btnPegar);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_3);
		
		JButton btnInicio = new JButton("");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnInicio.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_First.png")));
		btnInicio.setToolTipText("Ir a 1er registro");
		toolBar.add(btnInicio);
		
		JButton btnAnterior = new JButton("");
		btnAnterior.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAnterior.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Back.png")));
		btnAnterior.setToolTipText("Ir a pantalla anterior");
		toolBar.add(btnAnterior);
		
		JButton btnAdelante = new JButton("");
		btnAdelante.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdelante.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Forward.png")));
		btnAdelante.setToolTipText("Ir a siguiente pantalla");
		toolBar.add(btnAdelante);
		
		JButton btnFinal = new JButton("");
		btnFinal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFinal.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Last.png")));
		btnFinal.setToolTipText("Ir a ultimo registro");
		toolBar.add(btnFinal);
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		
		model.addColumn("Codigo");
		model.addColumn("Marca");
		
		
		
		
		
		label = new JLabel("");
		label.setBounds(0, 33, 1194, 65);
		label.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/gui/img/banners/Tapacantos.jpg")));
		tapacanto.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Tapa Cantos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(20, 121, 1113, 495);
		tapacanto.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setSize(496, 417);
		scrollPane.setLocation(10, 33);
		panel_1.add(scrollPane);
		tbCantos = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};
		
				scrollPane.setViewportView(tbCantos);
				tbCantos.setModel(modelo);
				
				tbCantos.requestFocus();
				tbCantos.changeSelection(0,0,true, false);
		
		JLabel lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigo.setBounds(599, 31, 85, 20);
		panel_1.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(690, 31, 122, 20);
		panel_1.add(txtCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripcion : ");
		lblDescripcion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcion.setBounds(599, 57, 85, 20);
		panel_1.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(690, 57, 319, 20);
		panel_1.add(txtDescripcion);
		
		chbxActivo = new JCheckBox("Activo");
		chbxActivo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxActivo.setBounds(950, 31, 64, 20);
		panel_1.add(chbxActivo);
		
		JLabel lblMaterial = new JLabel("Material : ");
		lblMaterial.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaterial.setBounds(599, 114, 85, 20);
		panel_1.add(lblMaterial);
		
		JComboBox cmBxMaterial = new JComboBox();
		cmBxMaterial.setBounds(690, 114, 319, 20);
		panel_1.add(cmBxMaterial);
		
		JLabel lblColor1 = new JLabel("Color Especifico : ");
		lblColor1.setHorizontalAlignment(SwingConstants.TRAILING);
		lblColor1.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblColor1.setBounds(599, 140, 85, 20);
		panel_1.add(lblColor1);
		
		JComboBox cmBxColor1 = new JComboBox();
		cmBxColor1.setBounds(690, 140, 319, 20);
		panel_1.add(cmBxColor1);
		
		JLabel lblColor2 = new JLabel("Color Adicional : ");
		lblColor2.setHorizontalAlignment(SwingConstants.TRAILING);
		lblColor2.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblColor2.setBounds(599, 166, 85, 20);
		panel_1.add(lblColor2);
		
		JComboBox cmBxColor2 = new JComboBox();
		cmBxColor2.setBounds(690, 166, 319, 20);
		panel_1.add(cmBxColor2);
		
		JLabel lblEspCanto = new JLabel("Espesor Canto : ");
		lblEspCanto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEspCanto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEspCanto.setBounds(599, 192, 85, 20);
		panel_1.add(lblEspCanto);
		
		JComboBox cmBxEspCanto = new JComboBox();
		cmBxEspCanto.setBounds(690, 192, 64, 20);
		panel_1.add(cmBxEspCanto);
		
		JLabel lblEspTabl = new JLabel("Espesor Min. Tablero : ");
		lblEspTabl.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEspTabl.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEspTabl.setBounds(815, 192, 120, 20);
		panel_1.add(lblEspTabl);
		
		JCheckBox chbxVerTodos = new JCheckBox("Ver Todos (Act./Inact.)");
		chbxVerTodos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxVerTodos.setBounds(10, 457, 177, 23);
		panel_1.add(chbxVerTodos);
		
		JComboBox cmBxEspTabl = new JComboBox();
		cmBxEspTabl.setBounds(945, 192, 64, 20);
		panel_1.add(cmBxEspTabl);
		
		JLabel lblAncCanto = new JLabel("Ancho Canto : ");
		lblAncCanto.setHorizontalAlignment(SwingConstants.TRAILING);
		lblAncCanto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAncCanto.setBounds(599, 218, 85, 20);
		panel_1.add(lblAncCanto);
		
		JComboBox cmBxAncCanto = new JComboBox();
		cmBxAncCanto.setBounds(690, 218, 64, 20);
		panel_1.add(cmBxAncCanto);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Match Con Tablero", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_2.setBounds(599, 277, 429, 174);
		panel_1.add(panel_2);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 40, 390, 113);
		panel_2.add(scrollPane_1);
		
		
		tbMatch = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
			return false;
			}
		};
	
			scrollPane_1.setViewportView(tbMatch);
			
			tbMatch.setModel(model);
			
			tbMatch.requestFocus();
			tbMatch.changeSelection(0,0,true, false);
		
		JButton btnNewMatch = new JButton("");
		btnNewMatch.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		btnNewMatch.setToolTipText("Nuevo Match");
		btnNewMatch.setBorder(null);
		btnNewMatch.setBounds(8, 14, 23, 23);
		panel_2.add(btnNewMatch);
		
		JButton btnElimMatch = new JButton("");
		btnElimMatch.setIcon(new ImageIcon(FrmTapacantos.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		btnElimMatch.setToolTipText("Elimina Match");
		btnElimMatch.setBorder(null);
		btnElimMatch.setBounds(32, 14, 23, 23);
		panel_2.add(btnElimMatch);
		
		
		int fila=0;
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
		int [] anchos = {30, 200, 50};
		
		for (int i = 0; i < tbCantos.getColumnCount(); i++) {
			tbCantos.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		
		for (int i = 0; i < tbMatch.getColumnCount(); i++) {
			tbMatch.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
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