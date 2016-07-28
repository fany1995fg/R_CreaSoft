package com.placamas.seguridad;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.ResourceBundle;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import com.lowagie.text.Table;
import com.placamas.beans.LocalBean;
import com.placamas.beans.MarcasBean;
import com.placamas.beans.UsuarioBean;
import com.placamas.beans.UsuarioRight;
import com.placamas.componentes.JComboBoxBD;
import com.placamas.controlador.LocalesControlador;
import com.placamas.controlador.MarcasControlador;
import com.placamas.controlador.UsuarioControlador;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import javax.swing.JTree;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.JCheckBox;

import org.apache.poi.hssf.record.formula.TblPtg;
import org.omg.CORBA.OBJ_ADAPTER;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class FrmControlUsuarios extends JInternalFrame implements ActionListener, MouseListener {
	
	UsuarioControlador obj=new UsuarioControlador();
	Boolean estado=false;
	public JTable table;
	public JTable tableul;
	public JTable tablelocal;
	private JButton btnGrabar;
	private JButton btnEliminar;
	private JButton btnNuevo;
	public JPanel control;
	DefaultTableModel modelo=new DefaultTableModel();
	private JToolBar toolBar;
	ResourceBundle rb = ResourceBundle.getBundle("database_sql");
	private JTextField txtIdUser;
	private JTextField txtNomb_User;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmControlUsuarios frame = new FrmControlUsuarios();
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
	public FrmControlUsuarios() {
		
		control = new JPanel();
		control.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/gui/img/banners/pruebaBanner2.jpg")));
		label.setBounds(0, 33, 1194, 65);
		control.add(label);
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 135, 30);
		control.add(toolBar);
		
		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/Iconos_PlacaMas/_New_document.png")));
		toolBar.add(btnNuevo);
		
		JButton button_1 = new JButton("");
		button_1.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/Iconos_PlacaMas/_Modify.png")));
		toolBar.add(button_1);
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/Iconos_PlacaMas/_Erase.png")));
		toolBar.add(btnEliminar);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		toolBar.add(separator);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
		toolBar.add(button);
		
		btnGrabar = new JButton("");
		btnGrabar.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/Iconos_PlacaMas/_Save.png")));
		toolBar.add(btnGrabar);
		
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGrabarActionPerformed(arg0);
			}
		});
		

		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Control de Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(20, 121, 1113, 495);
		control.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 40, 319, 372);
		panel_2.add(panel);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 299, 336);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setBounds(328, 292, 318, 138);
		table.addMouseListener(this);
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre de Usuario"
			}
		));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(349, 40, 754, 433);
		panel_2.add(panel_1);
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel_1.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblCodigo.setBounds(22, 42, 48, 20);
		panel_1.add(lblCodigo);
		lblCodigo.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		txtIdUser = new JTextField();
		//txtIdUser.setEnabled(false);
		txtIdUser.setBounds(80, 42, 115, 20);
		panel_1.add(txtIdUser);
		txtIdUser.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setHorizontalAlignment(SwingConstants.TRAILING);
		lblNombre.setBounds(212, 42, 54, 20);
		panel_1.add(lblNombre);
		lblNombre.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		txtNomb_User = new JTextField();
		//txtNombre.setEnabled(false);
		txtNomb_User.setBounds(272, 42, 180, 20);
		panel_1.add(txtNomb_User);
		txtNomb_User.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setHorizontalAlignment(SwingConstants.TRAILING);
		lblEmail.setBounds(475, 41, 36, 20);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		txtEmail = new JTextField();
		//txtEmail.setEnabled(false);
		txtEmail.setBounds(521, 42, 200, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		
		JPanel panel_Privilegios = new JPanel();
		panel_Privilegios.setBorder(new TitledBorder(null, "Privilegios de Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Privilegios.setBounds(10, 82, 735, 150);
		panel_1.add(panel_Privilegios);
		panel_Privilegios.setLayout(null);
		
		JCheckBox checkBox_3 = new JCheckBox("Aprobar/Desaprobar Produccion");
		checkBox_3.setBounds(25, 105, 209, 20);
		panel_Privilegios.add(checkBox_3);
		checkBox_3.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_2 = new JCheckBox("Desbloquear LP");
		checkBox_2.setBounds(25, 82, 113, 20);
		panel_Privilegios.add(checkBox_2);
		checkBox_2.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_1 = new JCheckBox("Anular LP");
		checkBox_1.setBounds(25, 59, 79, 20);
		panel_Privilegios.add(checkBox_1);
		checkBox_1.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_5 = new JCheckBox("Incluir Lista de Optimizadores");
		checkBox_5.setBounds(25, 36, 195, 20);
		panel_Privilegios.add(checkBox_5);
		checkBox_5.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_12 = new JCheckBox("Importar desde Servidor FTP");
		checkBox_12.setBounds(267, 36, 191, 20);
		panel_Privilegios.add(checkBox_12);
		checkBox_12.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_4 = new JCheckBox("Incluir Lista de Digitadores");
		checkBox_4.setBounds(267, 82, 177, 20);
		panel_Privilegios.add(checkBox_4);
		checkBox_4.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_7 = new JCheckBox("Editar Optimizador");
		checkBox_7.setBounds(267, 105, 131, 20);
		panel_Privilegios.add(checkBox_7);
		checkBox_7.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_13 = new JCheckBox("Administrar Usuarios");
		checkBox_13.setBounds(502, 105, 145, 20);
		panel_Privilegios.add(checkBox_13);
		checkBox_13.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_10 = new JCheckBox("Editar Documentos de Venta");
		checkBox_10.setBounds(502, 82, 187, 20);
		panel_Privilegios.add(checkBox_10);
		checkBox_10.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_9 = new JCheckBox("Editar Tiempo de Entrega");
		checkBox_9.setBounds(502, 59, 171, 20);
		panel_Privilegios.add(checkBox_9);
		checkBox_9.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_8 = new JCheckBox("Editar Vendedor");
		checkBox_8.setBounds(502, 36, 117, 20);
		panel_Privilegios.add(checkBox_8);
		checkBox_8.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JCheckBox checkBox_11 = new JCheckBox("Exportar hacia Servidor FTP");
		checkBox_11.setBounds(267, 59, 185, 20);
		panel_Privilegios.add(checkBox_11);
		checkBox_11.setFont(new Font("Dialog", Font.PLAIN, 11));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new TitledBorder(null, "Locales x Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 244, 735, 178);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 40, 274, 125);
		panel_3.add(scrollPane_1);
		
		tableul = new JTable();
		scrollPane_1.setViewportView(tableul);
		tableul.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tableul.addKeyListener(new KeyAdapter() {
			@Override
			//DISEÑO CLIC DERECHO EN EL SCROL / EVENT /KEY/ KEYRELEASED
			public void keyReleased(KeyEvent arg0) {
				//Mostrar();	
			}
		});
		tableul.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
				//Mostrar();
			}
		});
		tableul.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod_Usuario", "Local"
			}
		));
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(438, 40, 274, 125);
		panel_3.add(scrollPane_2);
		
		tablelocal = new JTable();
		scrollPane_2.setViewportView(tablelocal);
		tablelocal.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		tablelocal.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Codigo", "Nombre de Local"
			}
		));
		
		JButton btnQuitLocal = new JButton("");
		btnQuitLocal.setBounds(340, 62, 57, 33);
		panel_3.add(btnQuitLocal);
		btnQuitLocal.setContentAreaFilled(false);
		btnQuitLocal.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/Iconos_PlacaMas/_Forward.png")));
		
		JButton btnAgrLocal = new JButton("");
		btnAgrLocal.setBounds(340, 106, 57, 33);
		panel_3.add(btnAgrLocal);
		btnAgrLocal.setContentAreaFilled(false);
		btnAgrLocal.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/Iconos_PlacaMas/_Back.png")));
		
		JButton btnAadirPrivilegios = new JButton("Accesos al Sistema");
		btnAadirPrivilegios.setBounds(72, 423, 209, 50);
		panel_2.add(btnAadirPrivilegios);
		btnAadirPrivilegios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmOpciones frm = new FrmOpciones();
				frm.setVisible(true);
			
			}
		});
		btnAadirPrivilegios.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/Iconos_PlacaMas/_List.png")));
		btnAadirPrivilegios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnEliminar.addActionListener(this);
		
		
		
		btnNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNuevoActionPerformed(arg0);
			}
		});
		
		listaLocales();
		listarUsuarioLocales();
		listaData();
			
		tamañoTablas();
		
	}
	private void tamañoTablas() {
		
		int [] anchos = {50, 200, 50};
		
		for (int i = 0; i < table.getColumnCount(); i++) {
			table.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		for (int i = 0; i < tableul.getColumnCount(); i++) {
			tableul.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		for (int i = 0; i < tablelocal.getColumnCount(); i++) {
			tablelocal.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		
	}
	
	void mensaje(String m){
		JOptionPane.showMessageDialog(null, m);
}	

	
protected void btnGrabarActionPerformed(ActionEvent arg0) {
		
		String texto=txtIdUser.getText();
        texto=texto.replaceAll(" ", "");
        if(texto.length()==0){
        	
            mensaje("ERROR: No se aceptan campos en blanco");        
        }
        else
        if(texto.length()>11 || texto.length()<0){
        	
            mensaje("ERROR: Solo se aceptan de 3 a 11 caracteres");
            
        }
        else
        if(texto.length()>0 || texto.length()<11){
        	estado=true;
        if(estado==true){ 	
		UsuarioBean l=new UsuarioBean(txtIdUser.getText(), txtNomb_User.getText(),txtIdUser.getText(),txtNomb_User.getText(),txtEmail.getText());
		int valor=obj.insertaUsuario(l);
		if(valor==1){
			mensaje("Registro Exitoso de Usuario");
			estado=false;
			listaData();
			}
       	  }
       	}
      }
        
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource() == btnEliminar) {
			do_btnEliminar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnGrabar) {
			do_btnAgregar_actionPerformed(arg0);
		}
		if (arg0.getSource() == btnNuevo) {
			btnNuevoActionPerformed(arg0);
		}
	}
	
	protected void btnNuevoActionPerformed(ActionEvent arg0) {
		txtIdUser.setText("");
		txtNomb_User.setText("");
		txtIdUser.requestFocus();
		estado=true;
	}
	protected void do_btnAgregar_actionPerformed(ActionEvent arg0) {
	
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
	}
	
	private void listarUsuarioLocales() {
	
		UsuarioControlador uc = new UsuarioControlador();
		ArrayList<UsuarioRight> lista = uc.listarUsuarioLocal();
		DefaultTableModel model1 = (DefaultTableModel) tableul.getModel();
		
		//limpia la tabla
		model1.setRowCount(0);
		
		//paso la data de la lista al model
		for (UsuarioRight bean : lista) {
			model1.addRow(new Object[]{bean.getIdUser(),
										bean.getLocal()});			
		}

	}

	private void listaLocales() {
		
		//la data de la abse de datos
				LocalesControlador lc = new LocalesControlador();
				ArrayList<LocalBean> lista = lc.listarLocal();
				
				//el model de la tabla(GUI)
				DefaultTableModel model = (DefaultTableModel) tablelocal.getModel();
				
				//limpia la tabla
				model.setRowCount(0);
				
				//paso la data de la lista al model
				for (LocalBean bean : lista) {
					model.addRow(new Object[]{bean.getIdLocal(),
												bean.getLoc_Nomb()});			
				}

	}

	public void listaData(){
		
	//la data de la abse de datos
		//UsuarioControlador uc = new UsuarioControlador();
		ArrayList<UsuarioBean> lista = obj.listarUsuario();
		
		//el model de la tabla(GUI)
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		
		//limpia la tabla
		model.setRowCount(0);
		
		//paso la data de la lista al model
		for (UsuarioBean bean : lista) {
			model.addRow(new Object[]{bean.getIdUser(),
										bean.getUser_Nomb()});			
		}
	}
	
	public void mouseClicked(MouseEvent arg0) {	
		
		TableModel modelo2 = tableul.getModel();

		int[] indexs = table.getSelectedRows();
		Object[] row = new Object[2];
		DefaultTableModel modelo1 = (DefaultTableModel) tableul.getModel();
		
		for (int i = 0; i < indexs.length; i++) {
			
			if (modelo1.getValueAt(i,0).equals(modelo2.getValueAt(i, 0))){				
				JOptionPane.showMessageDialog(null, "El DATO ya esta Seleccionado");
			} else {
				//row[0] = modelo1.getValueAt(indexs[i], 0);
				//row[1] = modelo1.getValueAt(indexs[i], 1);
				modelo1.addRow(row);
			}	
		}
		
		//limpiar();

	}
	
	public void limpiar(){

		for (int i = 0; i < table.getRowCount(); i++) {
			modelo.removeRow(i);
			i =-1;
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
}
