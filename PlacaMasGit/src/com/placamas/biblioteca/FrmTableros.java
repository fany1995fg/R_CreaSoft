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
	Boolean estado=false;
	JTable tbMarcas;
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
	private JTextField vrbPila;
	private JTable tbFormato;
	private JTextField vrbCodigo;
	private JTextField vrbDescripcion;


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
		toolBar.setBounds(0, 0, 310, 35);
		tablero.add(toolBar);
		
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		btnEditar = new JButton("");
		toolBar.add(btnEditar);
		btnEditar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		
		JButton btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		btnEliminar.setToolTipText("Eliminar Registro");
		toolBar.add(btnEliminar);
		
		JButton btnExportar = new JButton("");
		btnExportar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Upload.png")));
		btnExportar.setToolTipText("Exportar Tableros");
		toolBar.add(btnExportar);
		
		JSeparator separator_3 = new JSeparator();
		separator_3.setBounds(290, 109, 11, 33);
		separator_3.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_3);
		
		JButton btnEditarNo = new JButton("");
		btnEditarNo.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		toolBar.add(btnEditarNo);
		btnEditarNo.setToolTipText("Quitar Edicion Registro");
		
				btnGrabar = new JButton("");
				toolBar.add(btnGrabar);
				btnGrabar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Save.png")));
				btnGrabar.setToolTipText("Grabar Cambios");
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_2);
		
		JButton btnCopiar = new JButton("");
		btnCopiar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Copy.png")));
		btnCopiar.setToolTipText("Copiar Registro");
		toolBar.add(btnCopiar);
		
		JButton btnPegar = new JButton("");
		btnPegar.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Paste.png")));
		btnPegar.setToolTipText("Pegar Registro");
		toolBar.add(btnPegar);
		
		JSeparator separator_4 = new JSeparator();
		separator_4.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator_4);
		
		JButton btnInicio = new JButton("");
		btnInicio.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_First.png")));
		btnInicio.setToolTipText("Ir a Inicio de Registros");
		toolBar.add(btnInicio);
		
		JButton btnAtras = new JButton("");
		btnAtras.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Back.png")));
		btnAtras.setToolTipText("Ir a Pantalla anterior");
		toolBar.add(btnAtras);
		
		JButton btnAdelante = new JButton("");
		btnAdelante.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Forward.png")));
		btnAdelante.setToolTipText("Ir a Pantalla Siguientes");
		toolBar.add(btnAdelante);
		
		JButton btnFinal = new JButton("");
		btnFinal.setIcon(new ImageIcon(FrmTableros.class.getResource("/Iconos_PlacaMas/_Last.png")));
		btnFinal.setToolTipText("Ir a Ultimo Registro");
		toolBar.add(btnFinal);
		
		
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEditar.setToolTipText("Editar Registro");
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		
		label = new JLabel("");
		label.setBounds(0, 36, 1194, 65);
		label.setIcon(new ImageIcon(FrmTableros.class.getResource("/gui/img/banners/tablero.jpg")));
		tablero.add(label);
		
		
		
		tbMarcas = new JTable();
		
		JPanel panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Tableros", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_5.setBounds(20, 112, 1113, 495);
		tablero.add(panel_5);
		panel_5.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 33, 496, 417);
		panel_5.add(scrollPane);
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
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblCodigo.setBounds(599, 31, 70, 20);
		panel_5.add(lblCodigo);
		
		vrbCodigo = new JTextField();
		vrbCodigo.setColumns(10);
		vrbCodigo.setBounds(678, 31, 122, 20);
		panel_5.add(vrbCodigo);
		
		JLabel lblDescripcion = new JLabel("Descripcion : ");
		lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblDescripcion.setBounds(599, 57, 70, 20);
		panel_5.add(lblDescripcion);
		
		vrbDescripcion = new JTextField();
		vrbDescripcion.setColumns(10);
		vrbDescripcion.setBounds(678, 57, 350, 20);
		panel_5.add(vrbDescripcion);
		
		chbxActivo = new JCheckBox("Activo");
		chbxActivo.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chbxActivo.setBounds(964, 31, 64, 20);
		panel_5.add(chbxActivo);
		
		chbxVeta = new JCheckBox("Con Veta");
		chbxVeta.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chbxVeta.setBounds(599, 85, 77, 20);
		panel_5.add(chbxVeta);
		
		chbxRotacion = new JCheckBox("Permite Rotacion");
		chbxRotacion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chbxRotacion.setBounds(741, 85, 107, 20);
		panel_5.add(chbxRotacion);
		
		JCheckBox chbxSiCanto = new JCheckBox("Permite Colocar Canto");
		chbxSiCanto.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chbxSiCanto.setBounds(901, 84, 127, 23);
		panel_5.add(chbxSiCanto);
		
		JLabel lblMaterial = new JLabel("Material:");
		lblMaterial.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMaterial.setBounds(599, 114, 70, 20);
		panel_5.add(lblMaterial);
		
		JComboBox cmBxMaterial = new JComboBox();
		cmBxMaterial.setBounds(678, 114, 350, 20);
		panel_5.add(cmBxMaterial);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblMarca.setBounds(599, 145, 70, 20);
		panel_5.add(lblMarca);
		
		JComboBox cmBxMarca = new JComboBox();
		cmBxMarca.setBounds(678, 145, 350, 20);
		panel_5.add(cmBxMarca);
		
		JLabel lblEspesor = new JLabel("Espesor:");
		lblEspesor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblEspesor.setBounds(599, 176, 70, 20);
		panel_5.add(lblEspesor);
		
		JComboBox cmBxEspesor = new JComboBox();
		cmBxEspesor.setBounds(678, 176, 70, 20);
		panel_5.add(cmBxEspesor);
		
		JLabel lblPila = new JLabel("Cantidad de Pieza x Pila:");
		lblPila.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblPila.setBounds(852, 176, 122, 20);
		panel_5.add(lblPila);
		
		vrbPila = new JTextField();
		vrbPila.setBounds(984, 176, 44, 20);
		panel_5.add(vrbPila);
		vrbPila.setColumns(10);
		
		JLabel lblColor = new JLabel("Color:");
		lblColor.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblColor.setBounds(599, 228, 70, 20);
		panel_5.add(lblColor);
		
		JLabel lblTextura = new JLabel("Textura:");
		lblTextura.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblTextura.setBounds(599, 249, 70, 20);
		panel_5.add(lblTextura);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(678, 207, 170, 73);
		panel_5.add(panel_2);
		panel_2.setBorder(new TitledBorder(null, "Cara1", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setLayout(null);
		
		JComboBox cmBxColorC1 = new JComboBox();
		cmBxColorC1.setBounds(10, 21, 148, 20);
		panel_2.add(cmBxColorC1);
		
		JComboBox cmBxTexturaC1 = new JComboBox();
		cmBxTexturaC1.setBounds(10, 44, 148, 20);
		panel_2.add(cmBxTexturaC1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(858, 207, 170, 73);
		panel_5.add(panel_3);
		panel_3.setBorder(new TitledBorder(null, "Cara2", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setLayout(null);
		
		JComboBox cmBxColorC2 = new JComboBox();
		cmBxColorC2.setBounds(10, 21, 148, 20);
		panel_3.add(cmBxColorC2);
		
		JComboBox cmBxTexturaC2 = new JComboBox();
		cmBxTexturaC2.setBounds(10, 44, 148, 20);
		panel_3.add(cmBxTexturaC2);
		
		JCheckBox chbxVerTodos = new JCheckBox("Ver Todos (Act./Inact.)");
		chbxVerTodos.setFont(new Font("Tahoma", Font.PLAIN, 10));
		chbxVerTodos.setBounds(21, 453, 177, 23);
		panel_5.add(chbxVerTodos);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(599, 285, 429, 164);
		panel_5.add(panel_4);
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Formato", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_4.setLayout(null);
		
		tbFormato = new JTable();
		tbFormato.setBounds(10, 40, 401, 113);
		panel_4.add(tbFormato);
		
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
		btnElimForm.setBounds(37, 14, 23, 23);
		panel_4.add(btnElimForm);
		
		
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




