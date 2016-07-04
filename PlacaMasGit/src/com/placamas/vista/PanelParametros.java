package com.placamas.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.placamas.beans.DepartamentoBean;
import com.placamas.beans.LocalBean;
import com.placamas.controlador.DepartamentoControlador;
import com.placamas.controlador.LocalesControlador;
import javax.swing.JLayeredPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class PanelParametros extends JPanel implements MouseListener,ActionListener{
	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;
	
	
	private JLabel lblMantenimientoDeLocales;
	private JLabel lblNombreDeLocal;
	private JLabel lblProvincia;
	private JLabel lblDepartamento;
	private JLabel lbl_6;
	private JLabel lbl_9;
	
	private JTextField txtCodigo;
	private JTextField txtNombre;
	private JComboBox cboEspecialidad;
	private JComboBox cboDistrito;
	private JComboBox cboTipoUsuario;
	private JButton btnGrabar;
	private JButton btnNuevo;
	private JButton btnModificar;
	private JButton btnEliminar;
	private JButton btnListar;
	private JButton btnCerrar;
	private JTable table;

	
	private JPanel PanelLocales;
	
	
	DefaultListModel<LocalBean> xemp;
	private JScrollBar scrollBar;
	
	/**
	 * Launch the application.
	*/
	private Integer idLocal = -1;
	private LocalesControlador ca = new LocalesControlador();
	private JPanel PanelColores;
	private JLabel label;
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PanelParametros frame = new PanelParametros();
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
	public PanelParametros() {
		  
		tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(800, 700));
        
        PanelColores = new JPanel();
        tabbedPane.addTab("New tab", null, PanelColores, null);
      //  get().add(tabbedPane);
		
        PanelLocales = new JPanel();
        tabbedPane.add(PanelLocales, "Listado");
		    //panellistado.add(agregar);
		PanelLocales.setBackground(SystemColor.menu);
		//setTitle("Gesti\u00F3n de Locales");
		//setClosable(true);
		//setDefaultCloseOperation(HIDE_ON_CLOSE);
		setBounds(100, 100, 678, 529);
		PanelLocales.setLayout(null);
				
		
		
		lblMantenimientoDeLocales = new JLabel("Mantenimiento de Locales");
		lblMantenimientoDeLocales.setToolTipText("Locales");
		lblMantenimientoDeLocales.setForeground(SystemColor.desktop);
		lblMantenimientoDeLocales.setFont(new Font("Arial", Font.BOLD, 17));
		lblMantenimientoDeLocales.setBounds(204, 159, 294, 25);
		
		lbl_9 = new JLabel("Codigo:");
		lbl_9.setBounds(10, 201, 46, 14);
		
		lblNombreDeLocal = new JLabel("Nombre de Local:");
		lblNombreDeLocal.setBounds(10, 223, 67, 14);
		
		lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(319, 237, 67, 14);
		
		lblDepartamento = new JLabel("Departamento:");
		lblDepartamento.setBounds(316, 195, 89, 14);
		
		lbl_6 = new JLabel("Distrito:");
		lbl_6.setBounds(319, 273, 67, 14);
		
		txtCodigo = new JTextField();
		txtCodigo.setBounds(86, 198, 60, 20);
		txtCodigo.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(87, 220, 186, 20);
		txtNombre.setColumns(10);
		
		cboEspecialidad = new JComboBox();
		cboEspecialidad.setBounds(415, 192, 160, 20);
		
		cboDistrito = new JComboBox();
		cboDistrito.setBounds(418, 270, 160, 20);
		
		cboTipoUsuario = new JComboBox();
		cboTipoUsuario.setBounds(418, 237, 160, 20);
		
		
		
		//botones//
		btnCerrar= new JButton("Salir");
		btnCerrar.addActionListener(this);
		btnCerrar.setBounds(786, 560, 89, 39);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 298, 638, 199);
		
		table = new JTable();
		table.setBackground(new Color(102, 205, 170));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre", "Departamento", "Provincia", "Distrito"
			}
		));
		scrollPane.setViewportView(table);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 674, 39);
		
		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(PanelParametros.class.getResource("/iconos/Add.gif")));
		toolBar.add(btnNuevo);
		//	btnNuevo.setIcon(new ImageIcon("D:\\ProyectoFINALlp\\PROYECTITOlp1\\licencia enfermedad\\src\\iconos\\Create.gif"));
			btnNuevo.setBackground(SystemColor.menu);
			btnNuevo.setForeground(Color.WHITE);
			btnNuevo.addActionListener(this);
		
		btnGrabar = new JButton("");
		btnGrabar.setBackground(SystemColor.menu);
		btnGrabar.setIcon(new ImageIcon(PanelParametros.class.getResource("/iconos/Save.gif")));
		toolBar.add(btnGrabar);
		
		btnModificar = new JButton("");
		btnModificar.setIcon(new ImageIcon(PanelParametros.class.getResource("/iconos/Edit.gif")));
		toolBar.add(btnModificar);
		
		btnListar = new JButton("");
		btnListar.setIcon(new ImageIcon(PanelParametros.class.getResource("/iconos/List.gif")));
		toolBar.add(btnListar);
		
		
		
		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(PanelParametros.class.getResource("/iconos/Delete.gif")));
		PanelLocales.setLayout(null);
		PanelLocales.add(lblDepartamento);
		PanelLocales.add(cboEspecialidad);
		PanelLocales.add(lblProvincia);
		PanelLocales.add(cboTipoUsuario);
		PanelLocales.add(lbl_6);
		PanelLocales.add(cboDistrito);
		PanelLocales.add(btnCerrar);
		PanelLocales.add(scrollPane);
		PanelLocales.add(toolBar);
		PanelLocales.add(lbl_9);
		PanelLocales.add(txtCodigo);
		PanelLocales.add(lblNombreDeLocal);
		PanelLocales.add(txtNombre);
		PanelLocales.add(lblMantenimientoDeLocales);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(PanelParametros.class.getResource("/gui/img/banners/loca4.png")));
		label.setToolTipText("Locales");
		label.setForeground(Color.BLACK);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		label.setBounds(0, 39, 674, 123);
		PanelLocales.add(label);
		btnEliminar.addActionListener(this);
	    btnListar.addActionListener(this);
		btnModificar.addActionListener(this);
        btnGrabar.addActionListener(this);
		
	//	listaDistrito();
		listaDepartamento();
	//	listaTipoUsuario();
		
		
	}
	//Eventos//
		public void actionPerformed (ActionEvent arg0 ){
			if (arg0.getSource()==btnGrabar){
				do_btnGrabar_actionPerformed(arg0);
			}
			if (arg0.getSource()==btnEliminar){
				do_btnEliminar_actionPerformed(arg0);
			}
			if (arg0.getSource()==btnModificar){
				do_btnModificar_actionPerformed(arg0);
			}
			if (arg0.getSource()==btnListar){
				do_btnListar_actionPerformed(arg0);
			}
			if (arg0.getSource()==btnNuevo){
				do_btnNuevo_actionPerformed(arg0);
			}
			if (arg0.getSource()==btnCerrar){
				
			}
			
	}
		
		void listaDepartamento(){
			ArrayList<DepartamentoBean> data = new DepartamentoControlador().lista();
			for (DepartamentoBean x:data)
				cboEspecialidad.addItem(x.getDepartamento());
		}
	
	/*	void listaDistrito(){
			ArrayList<DistritoBean> data = new LocalesControlador().getLista();
			for (DistritoBean x:data)
				cboDistrito.addItem(x.getDescripcion());
		}
		void listaDepartamento(){
			ArrayList<DepartamentoBean> data = new DepartamentoControlador().getLista();
			for (DepartamentoBean x:data)
				cboEspecialidad.addItem(x.getDescripcion());
		}
		void listaTipoUsuario(){
			ArrayList<ProvinciaBean> data = new ProvinciaControlador().getLista();
			for (ProvinciaBean x:data)
				cboTipoUsuario.addItem(x.getDescripcion());
		}*/
	
	public void mouseClicked(MouseEvent arg0) {
		if (arg0.getSource() == table) {
			do_table_mouseClicked(arg0);
		}
	}
	public void mouseEntered(MouseEvent arg0) {
	}
	public void mouseExited(MouseEvent arg0) {
	}
	public void mousePressed(MouseEvent arg0) {
	}
	public void mouseReleased(MouseEvent arg0) {	
	}
	
	protected void do_btnGrabar_actionPerformed(ActionEvent arg0) {
		LocalesControlador  ca=new LocalesControlador();
		LocalBean bean = new LocalBean();
		
		String idLocal,Loc_Nomb,idDepa;
		idLocal=txtCodigo.getText().trim();
		Loc_Nomb=txtNombre.getText().trim();
		idDepa=""+(cboEspecialidad.getSelectedIndex()+1);
		
		bean.setIdLocal(idLocal);
		bean.setLoc_Nomb(Loc_Nomb);
		 bean.setIdDepa(Integer.parseInt(idDepa));
		
		 int salida = ca.registrarLocal(bean);
		 if (salida>0){
			 JOptionPane.showMessageDialog(null, "Se Registro Informacion");
		 }
		 else{
			 JOptionPane.showMessageDialog(null, "Error en el Registro");
		 }
		 listaData();
		
	}
	
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {

	}
	
	protected void do_btnModificar_actionPerformed(ActionEvent arg0) {
		LocalesControlador  ca=new LocalesControlador();
		LocalBean bean = new LocalBean();
		String idLocal,Loc_Nomb,idDepa;
		idLocal=txtCodigo.getText().trim();
		Loc_Nomb=txtNombre.getText().trim();
		idDepa=""+(cboEspecialidad.getSelectedIndex()+1);

        
	//	distrito=""+(cboDistrito.getSelectedIndex()+1);
	//	TipoUsuario=""+(cboTipoUsuario.getSelectedIndex()+1);
        
		}
	
	protected void do_btnListar_actionPerformed(ActionEvent arg0) {
		listaData();
	}
	protected void do_btnBuscar_actionPerformed(ActionEvent arg0) {
	
	}
	protected void do_btnNuevo_actionPerformed(ActionEvent arg0) {
		
		txtCodigo.setText("");
		txtNombre.setText("");
	//	cboSexo.setSelectedIndex(0);
		cboEspecialidad.setSelectedIndex(0);
		cboDistrito.setSelectedIndex(0);
		cboTipoUsuario.setSelectedIndex(0);
		
		
	}
	protected void do_btnCerrar_actionPerformed(ActionEvent arg0) {
	}
	
	protected void do_table_mouseClicked(MouseEvent arg0) {
			 int fila = table.getSelectedRow();
			 
			 DefaultTableModel model = (DefaultTableModel) table.getModel();
			 String descripcion = (String)model.getValueAt(fila, 1);   
			 idLocal = (Integer)model.getValueAt(fila, 0);   
			 txtCodigo.setText(descripcion);
		}	
public void listaData(){
	
		ArrayList<LocalBean> data = ca.listarLocal();
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		model.setRowCount(0);
		for (LocalBean bean : data) {
			model.addRow(new Object[]{bean.getIdLocal(),bean.getLoc_Nomb(),bean.getIdDepa()});			
		}
		
	}
}



