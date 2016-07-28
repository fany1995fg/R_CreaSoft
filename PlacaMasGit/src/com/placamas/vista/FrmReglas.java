package com.placamas.vista;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
import javax.swing.table.DefaultTableModel;

import com.placamas.beans.ReglasBean;
import com.placamas.componentes.JComboBoxBD;
import com.placamas.controlador.ReglasControlador;

import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.JComboBox;

public class FrmReglas extends JInternalFrame implements ActionListener{

	
	ReglasControlador obj=new ReglasControlador();
	boolean estado=false;

	DefaultTableModel modelo=new DefaultTableModel();
	int tab=0,tap=0;
	String math_tab,math_can;
	private JButton btnGrabar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	private JToolBar toolBar;
	private JLabel label_1;
	JPanel reglas;
	private JPanel panel_OperAuto;
	private JPanel Corte;
	private JPanel panel_Enchape;
	private JPanel panel_Ranura;
	private JPanel panel_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JLabel lblMermaPas_1;
	private JLabel lblMermaPas;
	private JLabel lblMerma;
	private JLabel lblLargoMinimoDe;
	private JLabel lblAnchoMinimoDe;
	private JLabel lblEspesorMinimoDe;
	private JTextField txtEspSierra;
	private JTextField textField_13;
	private JLabel lblRefilarServicio;
	private JLabel lblEspSierr;
	private JTextField textField_14;
	private JTextField textField_15;
	private JLabel lblCodigoranuraaLibre;
	private JLabel lblEspesorMinimoDe_1;
	private JTextField textField_16;
	private JLabel lblCogidonoCanto;
	private JPanel panel_Sistema;
	private JPanel panel_FTP;
	private JLabel lblServidorFtp;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblCarpetaFtp;
	private JLabel lblUsuarioFtp;
	private JTextField textField_2;
	private JTextField textField_3;
	private JLabel lblPass;
	private JLabel lblConfirmarPassword;
	private JTextField textField_4;
	private JTextField textField_5;
	private JLabel lblServidorProxy;
	private JLabel lblPuertoProxy;
	private JTextField textField_17;
	private JLabel lblFormatoPedido;
	private JLabel lblCodigoDeTienda;
	private JTextField textField_19;
	private JTextField textField_20;
	private JLabel lblArchivoBach;
	private JLabel lblArchivoDeTrans;
	private JTextField textField_21;
	private JLabel lblUsuarioDigitador;
	private JLabel lblUsuarioEmisorLp;
	private JCheckBox chckbxNewCheckBox;
	private JCheckBox chckbxNewCheckBox_1;
	private JCheckBox chckbxImprimirFullEtiquetas;
	private JCheckBox chckbxAgruparAlGrabar;
	private JCheckBox chckbxCopiarUltimo;
	private JCheckBox chckbxAadirItemNuevo;
	private JComboBox comboBox_2;
	ResourceBundle rb = ResourceBundle.getBundle("database_sql");

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmReglas frame = new FrmReglas();
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
	public FrmReglas() {
				
		/*
		setToolTipText("Colores");
		setBounds(100, 100, 634, 493);
		getContentPane().setLayout(null);*/
		
		reglas = new JPanel();


		modelo.addColumn("Codigo");
		modelo.addColumn("Descripcion");
		modelo.addColumn("Tablero");
		modelo.addColumn("TapaCanto");
		Listar();
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 1194, 35);
		reglas.add(toolBar);
		
		btnNuevo = new JButton("");
		toolBar.add(btnNuevo);
		btnNuevo.setIcon(new ImageIcon(FrmReglas.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(FrmReglas.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		button.setToolTipText("Eliminar");
		toolBar.add(button);

		btnEliminar = new JButton("");
		toolBar.add(btnEliminar);
		btnEliminar.setIcon(new ImageIcon(FrmReglas.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		
        ///QUITANDOLE LOS BORDES A LOS BOTONES
		/*
		btnNuevo.setBorder(null);
		btnEliminar.setBorder(null);
		btnGrabar.setBorder(null);*/
		
		btnNuevo.setToolTipText("Nuevo Registro");
		btnEliminar.setToolTipText("Eliminar");
		
		label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon(FrmColores.class.getResource("/gui/img/banners/BanColor.png")));
		label_1.setBounds(10, 24, 598, 108);
		getContentPane().add(label_1);
		reglas.setLayout(null);
		reglas.add(toolBar);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(FrmReglas.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		button_1.setToolTipText("Eliminar");
		toolBar.add(button_1);
		
		btnGrabar = new JButton("");
		toolBar.add(btnGrabar);
		btnGrabar.setIcon(new ImageIcon(FrmReglas.class.getResource("/Iconos_PlacaMas/_Save.png")));
		btnGrabar.setToolTipText("Grabar");
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGrabarActionPerformed(arg0);
			}
		});
			
		btnEliminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnEliminarActionPerformed(arg0);
			}
		});
		btnNuevo.addActionListener(this);
		setClosable(true); //->Se pueda cerrara
		setDefaultCloseOperation(HIDE_ON_CLOSE); //Se oculte al cerrara
		Listar();
		
		
		int fila=0;
		
		JPanel panel_MantenimientoLP = new JPanel();
		panel_MantenimientoLP.setBorder(new TitledBorder(null, "Mantenimiento de LP", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_MantenimientoLP.setBounds(78, 35, 879, 308);
		reglas.add(panel_MantenimientoLP);
		panel_MantenimientoLP.setLayout(null);
		
		chckbxNewCheckBox = new JCheckBox("RMS-Obligatorio Importar Tablero");
		chckbxNewCheckBox.setBounds(27, 32, 194, 16);
		panel_MantenimientoLP.add(chckbxNewCheckBox);
		
		chckbxNewCheckBox_1 = new JCheckBox("CC-Obligatorio Contacto y Movil");
		chckbxNewCheckBox_1.setBounds(27, 51, 179, 16);
		panel_MantenimientoLP.add(chckbxNewCheckBox_1);
		
		panel_OperAuto = new JPanel();
		panel_OperAuto.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Operaciones Automaticas", TitledBorder.LEADING, TitledBorder.TOP, null, Color.BLUE));
		panel_OperAuto.setBounds(10, 91, 234, 114);
		panel_MantenimientoLP.add(panel_OperAuto);
		panel_OperAuto.setLayout(null);
		
		chckbxImprimirFullEtiquetas = new JCheckBox("Imprimir full Etiquetas");
		chckbxImprimirFullEtiquetas.setBounds(17, 46, 173, 16);
		panel_OperAuto.add(chckbxImprimirFullEtiquetas);
		
		chckbxAgruparAlGrabar = new JCheckBox("Agrupar Piezas al Grabar");
		chckbxAgruparAlGrabar.setBounds(17, 27, 173, 16);
		panel_OperAuto.add(chckbxAgruparAlGrabar);
		
		chckbxCopiarUltimo = new JCheckBox("Copiar Ultimo Item");
		chckbxCopiarUltimo.setBounds(17, 84, 157, 16);
		panel_OperAuto.add(chckbxCopiarUltimo);
		
		chckbxAadirItemNuevo = new JCheckBox("A\u00F1adir Item Nuevo");
		chckbxAadirItemNuevo.setBounds(17, 65, 173, 16);
		panel_OperAuto.add(chckbxAadirItemNuevo);
		
		Corte = new JPanel();
		Corte.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Corte", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		Corte.setBounds(254, 24, 273, 68);
		panel_MantenimientoLP.add(Corte);
		Corte.setLayout(null);
		
		lblEspSierr = new JLabel("Espesor de Sierra (mm)");
		lblEspSierr.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspSierr.setBounds(70, 15, 138, 20);
		Corte.add(lblEspSierr);
		
		txtEspSierra = new JTextField();
		txtEspSierra.setToolTipText("Escribe una descripci\u00F3n para el Color");
		txtEspSierra.setColumns(10);
		txtEspSierra.setBounds(213, 14, 25, 20);
		Corte.add(txtEspSierra);
		
		lblRefilarServicio = new JLabel("Refilar Servicio Premiun(mm)");
		lblRefilarServicio.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRefilarServicio.setBounds(39, 37, 169, 20);
		Corte.add(lblRefilarServicio);
		
		textField_13 = new JTextField();
		textField_13.setToolTipText("Escribe un id para el Color");
		textField_13.setColumns(10);
		textField_13.setBounds(213, 36, 25, 20);
		Corte.add(textField_13);
		
		panel_Enchape = new JPanel();
		panel_Enchape.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Enchape", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_Enchape.setBounds(254, 91, 273, 203);
		panel_MantenimientoLP.add(panel_Enchape);
		panel_Enchape.setLayout(null);
		
		textField_6 = new JTextField();
		textField_6.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_6.setColumns(10);
		textField_6.setBounds(214, 24, 25, 20);
		panel_Enchape.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setToolTipText("Escribe un id para el Color");
		textField_7.setColumns(10);
		textField_7.setBounds(214, 45, 25, 20);
		panel_Enchape.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_8.setColumns(10);
		textField_8.setBounds(214, 67, 25, 20);
		panel_Enchape.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_9.setColumns(10);
		textField_9.setBounds(214, 89, 25, 20);
		panel_Enchape.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setToolTipText("Escribe un id para el Color");
		textField_10.setColumns(10);
		textField_10.setBounds(214, 111, 25, 20);
		panel_Enchape.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_11.setColumns(10);
		textField_11.setBounds(214, 133, 25, 20);
		panel_Enchape.add(textField_11);
		
		lblMermaPas_1 = new JLabel(" Merma Pas. > 150 mm");
		lblMermaPas_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMermaPas_1.setBounds(66, 132, 143, 20);
		panel_Enchape.add(lblMermaPas_1);
		
		lblMermaPas = new JLabel(" Merma Pas. < 150 mm");
		lblMermaPas.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMermaPas.setBounds(66, 112, 143, 20);
		panel_Enchape.add(lblMermaPas);
		
		lblMerma = new JLabel(" Merma Pas. < 100 mm");
		lblMerma.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblMerma.setBounds(66, 90, 143, 20);
		panel_Enchape.add(lblMerma);
		
		lblLargoMinimoDe = new JLabel("Largo minimo de pieza(mm)");
		lblLargoMinimoDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblLargoMinimoDe.setBounds(47, 66, 162, 20);
		panel_Enchape.add(lblLargoMinimoDe);
		
		lblAnchoMinimoDe = new JLabel("Ancho minimo de pieza(mm)");
		lblAnchoMinimoDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAnchoMinimoDe.setBounds(44, 45, 165, 20);
		panel_Enchape.add(lblAnchoMinimoDe);
		
		lblEspesorMinimoDe = new JLabel("Espesor minimo de pieza (mm)");
		lblEspesorMinimoDe.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspesorMinimoDe.setBounds(30, 23, 179, 20);
		panel_Enchape.add(lblEspesorMinimoDe);
		
		textField_16 = new JTextField();
		textField_16.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_16.setColumns(10);
		textField_16.setBounds(214, 155, 36, 20);
		panel_Enchape.add(textField_16);
		
		lblCogidonoCanto = new JLabel("Cogido \"No Canto\"");
		lblCogidonoCanto.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCogidonoCanto.setBounds(104, 154, 105, 20);
		panel_Enchape.add(lblCogidonoCanto);
		
		panel_Ranura = new JPanel();
		panel_Ranura.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Ranura", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_Ranura.setBounds(556, 24, 263, 68);
		panel_MantenimientoLP.add(panel_Ranura);
		panel_Ranura.setLayout(null);
		
		textField_14 = new JTextField();
		textField_14.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_14.setColumns(10);
		textField_14.setBounds(197, 14, 25, 20);
		panel_Ranura.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setToolTipText("Escribe un id para el Color");
		textField_15.setColumns(10);
		textField_15.setBounds(197, 36, 37, 20);
		panel_Ranura.add(textField_15);
		
		lblCodigoranuraaLibre = new JLabel("Codigo \"Ranura Libre\"");
		lblCodigoranuraaLibre.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoranuraaLibre.setBounds(59, 37, 133, 20);
		panel_Ranura.add(lblCodigoranuraaLibre);
		
		lblEspesorMinimoDe_1 = new JLabel("Espesor minimo de pieza(mm)");
		lblEspesorMinimoDe_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblEspesorMinimoDe_1.setBounds(17, 15, 175, 20);
		panel_Ranura.add(lblEspesorMinimoDe_1);
		
		panel_5 = new JPanel();
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Perforacion", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_5.setBounds(556, 91, 263, 74);
		panel_MantenimientoLP.add(panel_5);
		
		panel_Sistema = new JPanel();
		panel_Sistema.setBorder(new TitledBorder(null, "Sistemas", TitledBorder.LEADING, TitledBorder.TOP, null, Color.RED));
		panel_Sistema.setBounds(78, 364, 879, 236);
		reglas.add(panel_Sistema);
		panel_Sistema.setLayout(null);
		
		lblCodigoDeTienda = new JLabel("Codigo de Tienda");
		lblCodigoDeTienda.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCodigoDeTienda.setBounds(20, 41, 100, 20);
		panel_Sistema.add(lblCodigoDeTienda);
		
		comboBox_2 = new JComboBoxBD(rb.getString("SQL_COMBO_IDLOCAL"));
		comboBox_2.setBounds(122, 42, 110, 20);
		panel_Sistema.add(comboBox_2);
		
		lblFormatoPedido = new JLabel("Formato Pedido");
		lblFormatoPedido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblFormatoPedido.setBounds(20, 63, 90, 20);
		panel_Sistema.add(lblFormatoPedido);
		
		textField_19 = new JTextField();
		textField_19.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_19.setColumns(10);
		textField_19.setBounds(132, 64, 100, 20);
		panel_Sistema.add(textField_19);
		
		panel_FTP = new JPanel();
		panel_FTP.setBorder(new TitledBorder(new CompoundBorder(null, UIManager.getBorder("TitledBorder.border")), "FTP", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 255)));
		panel_FTP.setBounds(242, 23, 627, 194);
		panel_Sistema.add(panel_FTP);
		panel_FTP.setLayout(null);
		
		lblServidorFtp = new JLabel("Servidor FTP");
		lblServidorFtp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblServidorFtp.setBounds(62, 27, 74, 20);
		panel_FTP.add(lblServidorFtp);
		
		textField = new JTextField();
		textField.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField.setColumns(10);
		textField.setBounds(141, 28, 195, 20);
		panel_FTP.add(textField);
		
		lblCarpetaFtp = new JLabel("Carpeta FTP");
		lblCarpetaFtp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCarpetaFtp.setBounds(65, 49, 71, 20);
		panel_FTP.add(lblCarpetaFtp);
		
		textField_1 = new JTextField();
		textField_1.setToolTipText("Escribe un id para el Color");
		textField_1.setColumns(10);
		textField_1.setBounds(141, 49, 195, 20);
		panel_FTP.add(textField_1);
		
		lblUsuarioFtp = new JLabel("Usuario FTP");
		lblUsuarioFtp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuarioFtp.setBounds(66, 70, 70, 20);
		panel_FTP.add(lblUsuarioFtp);
		
		textField_2 = new JTextField();
		textField_2.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_2.setColumns(10);
		textField_2.setBounds(141, 71, 195, 20);
		panel_FTP.add(textField_2);
		
		lblPass = new JLabel("Password");
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPass.setBounds(81, 92, 55, 20);
		panel_FTP.add(lblPass);
		
		textField_3 = new JTextField();
		textField_3.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_3.setColumns(10);
		textField_3.setBounds(141, 93, 116, 20);
		panel_FTP.add(textField_3);
		
		lblConfirmarPassword = new JLabel("Confirmar Password");
		lblConfirmarPassword.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblConfirmarPassword.setBounds(20, 116, 116, 20);
		panel_FTP.add(lblConfirmarPassword);
		
		textField_4 = new JTextField();
		textField_4.setToolTipText("Escribe un id para el Color");
		textField_4.setColumns(10);
		textField_4.setBounds(141, 115, 116, 20);
		panel_FTP.add(textField_4);
		
		lblServidorProxy = new JLabel("Servidor Proxy");
		lblServidorProxy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblServidorProxy.setBounds(53, 136, 83, 20);
		panel_FTP.add(lblServidorProxy);
		
		textField_5 = new JTextField();
		textField_5.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_5.setColumns(10);
		textField_5.setBounds(141, 137, 116, 20);
		panel_FTP.add(textField_5);
		
		lblPuertoProxy = new JLabel("Puerto Proxy");
		lblPuertoProxy.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPuertoProxy.setBounds(63, 158, 73, 20);
		panel_FTP.add(lblPuertoProxy);
		
		textField_17 = new JTextField();
		textField_17.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_17.setColumns(10);
		textField_17.setBounds(141, 159, 74, 20);
		panel_FTP.add(textField_17);
		
		lblArchivoBach = new JLabel("Archivo Batch");
		lblArchivoBach.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblArchivoBach.setBounds(377, 92, 78, 20);
		panel_FTP.add(lblArchivoBach);
		
		textField_20 = new JTextField();
		textField_20.setToolTipText("Escribe una descripci\u00F3n para el Color");
		textField_20.setColumns(10);
		textField_20.setBounds(460, 92, 135, 20);
		panel_FTP.add(textField_20);
		
		lblArchivoDeTrans = new JLabel("Archivo de Transf.");
		lblArchivoDeTrans.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblArchivoDeTrans.setBounds(350, 115, 105, 20);
		panel_FTP.add(lblArchivoDeTrans);
		
		textField_21 = new JTextField();
		textField_21.setToolTipText("Escribe un id para el Color");
		textField_21.setColumns(10);
		textField_21.setBounds(460, 114, 135, 20);
		panel_FTP.add(textField_21);
		
		lblUsuarioDigitador = new JLabel("Usuario Digitador LP");
		lblUsuarioDigitador.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuarioDigitador.setBounds(339, 135, 116, 20);
		panel_FTP.add(lblUsuarioDigitador);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(460, 136, 135, 20);
		panel_FTP.add(comboBox_1);
		
		lblUsuarioEmisorLp = new JLabel("Usuario Emisor LP");
		lblUsuarioEmisorLp.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblUsuarioEmisorLp.setBounds(350, 157, 105, 20);
		panel_FTP.add(lblUsuarioEmisorLp);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(460, 158, 135, 20);
		panel_FTP.add(comboBox);
		
		
		tamañoTablas();
	
	}
	
private void tamañoTablas() {
		
				
	}
		
	
void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}	
	
	
	 

	
protected void btnGrabarActionPerformed(ActionEvent arg0) { 
	
}


protected void btnEliminarActionPerformed(ActionEvent arg0) {


}


	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnNuevo) {
			btnNuevoActionPerformed(arg0);
		}
	}
	

	protected void btnNuevoActionPerformed(ActionEvent arg0) {
		
	}
	
	
	void Listar(){
		modelo.setRowCount(0);
		ArrayList<ReglasBean> info=obj.listarReglas();
		for(ReglasBean x:info){
			Object fila[]={x.getIdRules(),x.getDetalle(),x.getVal_Numer(),x.getVal_Logic()};
			modelo.addRow(fila);
			
		}
			

	}
}
