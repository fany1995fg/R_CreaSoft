package com.placamas.listado;

import java.awt.BorderLayout;
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

import com.placamas.biblioteca.FrmBisagrado;
import com.placamas.biblioteca.FrmRanuras;
import com.placamas.biblioteca.FrmTableros;
import com.placamas.listado.Filtro;
import com.placamas.vista.FrmTextura;

import javax.swing.JTabbedPane;

public class FrmListado_Pieza extends JInternalFrame implements ActionListener{

	DefaultTableModel modelo=new DefaultTableModel();
	Boolean estado=false;
	JTabbedPane tab;
	JTable tbMarcas;
	private JButton btnGrabar;
	private JButton btnCerrar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	public JPanel listado;
	private JLabel label;
	private JSeparator separator_1;
	private JButton button_3;

	private Filtro Filtro= new Filtro();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListado_Pieza frame = new FrmListado_Pieza();
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
	public FrmListado_Pieza() {
		
		listado = new JPanel();
		listado.setLayout(null);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		listado.add(toolBar);
		
		label = new JLabel("");
		label.setBounds(0, 33, 1194, 65);
		label.setIcon(new ImageIcon(FrmBisagrado.class.getResource("/gui/img/banners/Bisagrado.JPG")));
		listado.add(label);
		
		separator_1 = new JSeparator();
		separator_1.setBounds(10, 106, 1354, 8);
		listado.add(separator_1);
		
		
		JPanel wim = new JPanel();
		wim.setToolTipText("");
		wim.setBounds(10, 125, 1184, 570);
		listado.add(wim);
		wim.setLayout(new BorderLayout(0, 0));
		
		tab = new JTabbedPane();
		tab.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
		wim.add(tab);
		
		JPanel Listado = new JPanel();
		Listado.setBounds(10, 319, 1200, 135);
		tab.add(Listado, "Listado de Piezas ");
		Listado.setLayout(null);
		
		JPanel Resumen = new JPanel();
		tab.add(Resumen, "Resumen Material y Servicios ");
		Resumen.setLayout(null);
		
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmListado_Pieza.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNuevoActionPerformed(arg0);
			}
		});
		
		
		btnNuevo.setToolTipText("Nuevo Registro");
		
		JButton button_2 = new JButton("");
		button_2.setIcon(new ImageIcon(FrmListado_Pieza.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		button_2.setToolTipText("Eliminar");
		toolBar.add(button_2);
		
				btnEliminar = new JButton("");
				toolBar.add(btnEliminar);
				btnEliminar.setIcon(new ImageIcon(FrmListado_Pieza.class.getResource("/Iconos_PlacaMas/_Erase.png")));
				btnEliminar.setToolTipText("Eliminar");
		
		button_3 = new JButton("");
		button_3.setIcon(new ImageIcon(FrmListado_Pieza.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		button_3.setToolTipText("Eliminar");
		toolBar.add(button_3);
		
		
		
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmListado_Pieza.class.getResource("/Iconos_PlacaMas/_Save.png")));
		btnGrabar.setToolTipText("Grabar");
		
		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		
		
		
		tbMarcas = new JTable();
		
		
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

	


	public void btnNuevoActionPerformed(ActionEvent arg0){
		Filtro.setVisible(true);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}