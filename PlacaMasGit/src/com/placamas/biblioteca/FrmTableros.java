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
import javax.swing.JToggleButton;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

public class FrmTableros extends JInternalFrame implements ActionListener{

	DefaultTableModel modelo=new DefaultTableModel();
	DefaultTableModel model=new DefaultTableModel();
	Boolean estado=false;
	
	private JTable tbTablero;
	private JButton btnEditar;
	private JButton btnCerrar;
	private JButton btnGrabar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	public JPanel tablero;
	private JLabel label;
	private JCheckBox chbxActivo;
	private JCheckBox chbxRotacion;
	private JCheckBox chbxVeta;
	private JTextField txtPila;
	private JTable tbFormato;
	private JTextField txtCodigo;
	private JTextField txtDescripcion;


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
		toolBar.setBounds(0, 0, 310, 30);
		tablero.add(toolBar);
		
		
		btnNuevo = new JButton("");
		btnNuevo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		btnEditar = new JButton("");
		btnEditar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		toolBar.add(btnEditar);
		btnEditar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEliminar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		btnEliminar.setToolTipText("Eliminar");
		toolBar.add(btnEliminar);
		
		JButton btnExportar = new JButton("");
		btnExportar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnExportar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Upload.png")));
		btnExportar.setToolTipText("Exportar");
		toolBar.add(btnExportar);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(290, 109, 11, 33);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_3);
		
		JButton btnEditarNo = new JButton("");
		btnEditarNo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnEditarNo.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		toolBar.add(btnEditarNo);
		btnEditarNo.setToolTipText("Salir de editar sin grabar");
		
				btnGrabar = new JButton("");
				btnGrabar.setFont(new Font("Tahoma", Font.PLAIN, 10));
				toolBar.add(btnGrabar);
				btnGrabar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Save.png")));
				btnGrabar.setToolTipText("Grabar cambios");
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		JButton btnCopiar = new JButton("");
		btnCopiar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnCopiar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Copy.png")));
		btnCopiar.setToolTipText("Copiar");
		toolBar.add(btnCopiar);
		
		JButton btnPegar = new JButton("");
		btnPegar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPegar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Paste.png")));
		btnPegar.setToolTipText("Pegar");
		toolBar.add(btnPegar);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_4);
		
		JButton btnInicio = new JButton("");
		btnInicio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnInicio.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_First.png")));
		btnInicio.setToolTipText("Ir a 1er. Registro");
		toolBar.add(btnInicio);
		
		JButton btnAtras = new JButton("");
		btnAtras.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAtras.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Back.png")));
		btnAtras.setToolTipText("Ir a pantalla anterior");
		toolBar.add(btnAtras);
		
		JButton btnAdelante = new JButton("");
		btnAdelante.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAdelante.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Forward.png")));
		btnAdelante.setToolTipText("Ir a siguiente pantalla");
		toolBar.add(btnAdelante);
		
		JButton btnFinal = new JButton("");
		btnFinal.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnFinal.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Last.png")));
		btnFinal.setToolTipText("Ir a ultimo registro");
		toolBar.add(btnFinal);
		
		
		btnNuevo.setToolTipText("Nuevo");
		btnEditar.setToolTipText("Editar");
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		
		model.addColumn("Formato");
		model.addColumn("Ancho");
		model.addColumn("Largo");
		model.addColumn("Costo");
		model.addColumn("Factor");
		model.addColumn("Stock");
		model.addColumn("Medida");
		
		label = new JLabel("");
		label.setBounds(0, 33, 1194, 65);
		label.setIcon(new ImageIcon(FrmTableros.class.getResource("/gui/img/banners/tablero.jpg")));
		tablero.add(label);
		

		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tableros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_1.setBounds(20, 121, 1113, 495);
		tablero.add(panel_1);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 496, 417);
		panel_1.add(scrollPane);
		tbTablero = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};
		
				scrollPane.setViewportView(tbTablero);
				tbTablero.setModel(modelo);
				
				tbTablero.requestFocus();
				tbTablero.changeSelection(0,0,true, false);
		
		JLabel lblCodigo = new JLabel("Codigo : ");
		lblCodigo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblCodigo.setBounds(585, 31, 85, 20);
		panel_1.add(lblCodigo);
		
		txtCodigo = new JTextField();
		txtCodigo.setColumns(10);
		txtCodigo.setBounds(678, 31, 122, 20);
		panel_1.add(txtCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripcion : ");
		lblDescripcion.setHorizontalAlignment(SwingConstants.TRAILING);
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDescripcion.setBounds(585, 57, 85, 20);
		panel_1.add(lblDescripcion);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(678, 57, 350, 20);
		panel_1.add(txtDescripcion);
		
		chbxActivo = new JCheckBox("Activo");
		chbxActivo.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxActivo.setBounds(964, 31, 64, 20);
		panel_1.add(chbxActivo);
		
		chbxVeta = new JCheckBox("Con Veta");
		chbxVeta.setHorizontalAlignment(SwingConstants.LEFT);
		chbxVeta.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxVeta.setBounds(678, 84, 77, 20);
		panel_1.add(chbxVeta);
		
		chbxRotacion = new JCheckBox("Permite Rotacion");
		chbxRotacion.setHorizontalAlignment(SwingConstants.LEFT);
		chbxRotacion.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxRotacion.setBounds(757, 84, 121, 20);
		panel_1.add(chbxRotacion);
		
		JCheckBox chbxSiCanto = new JCheckBox("Permite Colocar Canto");
		chbxSiCanto.setHorizontalAlignment(SwingConstants.LEFT);
		chbxSiCanto.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxSiCanto.setBounds(888, 84, 140, 23);
		panel_1.add(chbxSiCanto);
		
		JLabel lblMaterial = new JLabel("Material : ");
		lblMaterial.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMaterial.setBounds(585, 114, 85, 20);
		panel_1.add(lblMaterial);
		
		JComboBox cmBxMaterial = new JComboBox();
		cmBxMaterial.setBounds(678, 114, 350, 20);
		panel_1.add(cmBxMaterial);
		
		JLabel lblMarca = new JLabel("Marca : ");
		lblMarca.setHorizontalAlignment(SwingConstants.TRAILING);
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblMarca.setBounds(585, 140, 85, 20);
		panel_1.add(lblMarca);
		
		JComboBox cmBxMarca = new JComboBox();
		cmBxMarca.setBounds(678, 140, 350, 20);
		panel_1.add(cmBxMarca);
		
		JLabel lblEspesor = new JLabel("Espesor : ");
		lblEspesor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEspesor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEspesor.setBounds(585, 166, 85, 20);
		panel_1.add(lblEspesor);
		
		JComboBox cmBxEspesor = new JComboBox();
		cmBxEspesor.setBounds(678, 166, 70, 20);
		panel_1.add(cmBxEspesor);
		
		JLabel lblPila = new JLabel("Cantidad de Pieza x Pila : ");
		lblPila.setHorizontalAlignment(SwingConstants.TRAILING);
		lblPila.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblPila.setBounds(814, 166, 144, 20);
		panel_1.add(lblPila);
		
		txtPila = new JTextField();
		txtPila.setBounds(964, 166, 64, 20);
		panel_1.add(txtPila);
		txtPila.setColumns(10);
		
		JLabel lblColor = new JLabel("Color : ");
		lblColor.setHorizontalAlignment(SwingConstants.TRAILING);
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblColor.setBounds(585, 216, 85, 20);
		panel_1.add(lblColor);
		
		JLabel lblTextura = new JLabel("Textura : ");
		lblTextura.setHorizontalAlignment(SwingConstants.TRAILING);
		lblTextura.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblTextura.setBounds(585, 237, 85, 20);
		panel_1.add(lblTextura);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(678, 195, 170, 73);
		panel_1.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "Cara1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		
		JComboBox cmBxColorC1 = new JComboBox();
		cmBxColorC1.setBounds(10, 21, 148, 20);
		panel_2.add(cmBxColorC1);
		
		JComboBox cmBxTexturaC1 = new JComboBox();
		cmBxTexturaC1.setBounds(10, 44, 148, 20);
		panel_2.add(cmBxTexturaC1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(858, 195, 170, 73);
		panel_1.add(panel_3);
		panel_3.setBorder(new TitledBorder(null, "Cara2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);
		
		JComboBox cmBxColorC2 = new JComboBox();
		cmBxColorC2.setBounds(10, 21, 148, 20);
		panel_3.add(cmBxColorC2);
		
		JComboBox cmBxTexturaC2 = new JComboBox();
		cmBxTexturaC2.setBounds(10, 44, 148, 20);
		panel_3.add(cmBxTexturaC2);
		
		JCheckBox chbxVerTodos = new JCheckBox("Ver Todos (Act./Inact.)");
		chbxVerTodos.setFont(new Font("Tahoma", Font.PLAIN, 11));
		chbxVerTodos.setBounds(10, 453, 177, 23);
		panel_1.add(chbxVerTodos);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(599, 277, 429, 174);
		panel_1.add(panel_4);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setLayout(null);
		
		JButton btnNewForm = new JButton("");
		btnNewForm.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		btnNewForm.setToolTipText("Nuevo Formato");
		btnNewForm.setBorder(null);
		btnNewForm.setBounds(8, 14, 23, 23);
		panel_4.add(btnNewForm);
		
		JButton btnElimForm = new JButton("");
		btnElimForm.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		btnElimForm.setToolTipText("Elimina Formato");
		btnElimForm.setBorder(null);
		btnElimForm.setBounds(32, 14, 23, 23);
		panel_4.add(btnElimForm);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 40, 408, 122);
		panel_4.add(scrollPane_1);
		
		tbFormato = new JTable(){
			public boolean isCellEditable(int rowIndex, int colIndex){
				return false;
			}
		};
		
				scrollPane_1.setViewportView(tbFormato);
				tbFormato.setModel(model);
				
				tbFormato.requestFocus();
				tbFormato.changeSelection(0,0,true, false);
		
		int fila=0;
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
		int [] anchos = {30, 200, 50};
		int [] form = {200, 60, 60,60,60,60,70};
		
		for (int i = 0; i < tbTablero.getColumnCount(); i++) {
			tbTablero.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		
		for (int i = 0; i < tbFormato.getColumnCount(); i++) {
			tbFormato.getColumnModel().getColumn(i).setPreferredWidth(form[i]);
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




