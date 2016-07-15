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
	private JComboBox cboUsuario_1;
	private JTextField txtIdUser;
	private JTextField txtNomb_User;
	private JTextField txtEmail;

	//private ControladorCategoria c = new ControladorCategoria();
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
		/*
		setBounds(100, 100, 1008, 673);
		control.setLayout(null);
		setClosable(true);
		setDefaultCloseOperation(HIDE_ON_CLOSE);
		setIconifiable(true);
		setTitle("Control de Usuarios");*/
		control.setLayout(null);
		
		//cboUsuario_1 = new JComboBox();
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/gui/img/banners/pruebaBanner2.jpg")));
		label.setBounds(20, 35, 1078, 108);
		control.add(label);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Usuarios", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel.setBounds(40, 177, 297, 344);
		control.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 25, 277, 297);
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
		
		toolBar = new JToolBar();
		toolBar.setBounds(0, 0, 358, 23);
		control.add(toolBar);
		
		btnNuevo = new JButton("");
		btnNuevo.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/iconosmodernos/1466476618_File.png")));
		toolBar.add(btnNuevo);
		
		btnGrabar = new JButton("");
		btnGrabar.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/iconosmodernos/1466475388_save.png")));
		toolBar.add(btnGrabar);
		
		btnEliminar = new JButton("");
		btnEliminar.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
		toolBar.add(btnEliminar);
		
		JLabel lblSeleccioneUnUsuario = new JLabel("Seleccione un Usuario:");
		lblSeleccioneUnUsuario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSeleccioneUnUsuario.setBounds(13, 945, 137, 17);
		control.add(lblSeleccioneUnUsuario);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(155, 952, 0, 2);
		control.add(separator);
		
		
		modelo.addColumn("Cod-Usuario");
		modelo.addColumn("Local");
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsuario.setBounds(68, 306, 48, 19);
		control.add(lblUsuario);
		cboUsuario_1 = new JComboBoxBD(rb.getString("SQL_COMBO_USUARIO"));
		cboUsuario_1.setBounds(131, 307, 171, 20);
		control.add(cboUsuario_1);
		
		JButton btnAadirPrivilegios = new JButton("Accesos al Sistema");
		btnAadirPrivilegios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FrmOpciones frm = new FrmOpciones();
				frm.setVisible(true);
			
			}
		});
		btnAadirPrivilegios.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/iconos/Notes.gif")));
		btnAadirPrivilegios.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAadirPrivilegios.setBounds(88, 545, 209, 50);
		control.add(btnAadirPrivilegios);
		
		JPanel panel_1 = new JPanel();
		panel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		panel_1.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Detalle Usuario", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(51, 153, 255)));
		panel_1.setBounds(392, 177, 696, 418);
		control.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblLocales = new JLabel("Locales");
		lblLocales.setBounds(403, 246, 51, 20);
		panel_1.add(lblLocales);
		lblLocales.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(21, 276, 274, 125);
		panel_1.add(scrollPane_1);
		
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
				"Codigo", "Local"
			}
		));
		
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(403, 276, 274, 125);
		panel_1.add(scrollPane_2);
		
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
		
		JLabel lblLocalXUsuarios = new JLabel("Usuarios x Local");
		lblLocalXUsuarios.setBounds(21, 246, 115, 20);
		panel_1.add(lblLocalXUsuarios);
		lblLocalXUsuarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JLabel label_1 = new JLabel("Lista de Privilegios");
		label_1.setBounds(275, 11, 131, 20);
		panel_1.add(label_1);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		
		JCheckBox checkBox_1 = new JCheckBox("Anular LP");
		checkBox_1.setBounds(275, 38, 79, 25);
		panel_1.add(checkBox_1);
		checkBox_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_2 = new JCheckBox("Desbloquear LP");
		checkBox_2.setBounds(275, 66, 113, 25);
		panel_1.add(checkBox_2);
		checkBox_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_3 = new JCheckBox("Aprobar/Desaprobar Produccion");
		checkBox_3.setBounds(275, 94, 209, 25);
		panel_1.add(checkBox_3);
		checkBox_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_4 = new JCheckBox("Incluir Lista de Digitadores");
		checkBox_4.setBounds(275, 178, 177, 25);
		panel_1.add(checkBox_4);
		checkBox_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_5 = new JCheckBox("Incluir Lista de Optimizadores");
		checkBox_5.setBounds(275, 122, 195, 25);
		panel_1.add(checkBox_5);
		checkBox_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_6 = new JCheckBox("Editar Digitador");
		checkBox_6.setBounds(275, 150, 113, 25);
		panel_1.add(checkBox_6);
		checkBox_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_7 = new JCheckBox("Editar Optimizador");
		checkBox_7.setBounds(275, 206, 131, 25);
		panel_1.add(checkBox_7);
		checkBox_7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_8 = new JCheckBox("Editar Vendedor");
		checkBox_8.setBounds(486, 38, 117, 25);
		panel_1.add(checkBox_8);
		checkBox_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_9 = new JCheckBox("Editar Tiempo de Entrega");
		checkBox_9.setBounds(486, 66, 171, 25);
		panel_1.add(checkBox_9);
		checkBox_9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_10 = new JCheckBox("Editar Documentos de Venta");
		checkBox_10.setBounds(486, 94, 187, 25);
		panel_1.add(checkBox_10);
		checkBox_10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_11 = new JCheckBox("Exportar hacia Servidor FTP");
		checkBox_11.setBounds(486, 122, 185, 25);
		panel_1.add(checkBox_11);
		checkBox_11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_12 = new JCheckBox("Importar desde Servidor FTP");
		checkBox_12.setBounds(486, 150, 191, 25);
		panel_1.add(checkBox_12);
		checkBox_12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JCheckBox checkBox_13 = new JCheckBox("Administrar Usuarios");
		checkBox_13.setBounds(486, 178, 145, 25);
		panel_1.add(checkBox_13);
		checkBox_13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		
		JButton btnA = new JButton("");
		btnA.setBounds(323, 298, 57, 33);
		panel_1.add(btnA);
		btnA.setContentAreaFilled(false);
		btnA.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/iconos/Up.gif")));
		
		JButton btnB = new JButton("");
		btnB.setBounds(323, 353, 57, 33);
		panel_1.add(btnB);
		btnB.setContentAreaFilled(false);
		btnB.setIcon(new ImageIcon(FrmControlUsuarios.class.getResource("/iconos/Down.gif")));
		
		JLabel lblCodigo = new JLabel("Codigo:");
		lblCodigo.setBounds(20, 38, 48, 17);
		panel_1.add(lblCodigo);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(20, 95, 54, 17);
		panel_1.add(lblNombre);
		lblNombre.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(20, 151, 36, 17);
		panel_1.add(lblEmail);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
		
		txtIdUser = new JTextField();
		//txtIdUser.setEnabled(false);
		txtIdUser.setBounds(21, 72, 115, 20);
		panel_1.add(txtIdUser);
		txtIdUser.setColumns(10);
		
		txtNomb_User = new JTextField();
		//txtNombre.setEnabled(false);
		txtNomb_User.setBounds(21, 123, 229, 20);
		panel_1.add(txtNomb_User);
		txtNomb_User.setColumns(10);
		
		txtEmail = new JTextField();
		//txtEmail.setEnabled(false);
		txtEmail.setBounds(21, 182, 229, 20);
		panel_1.add(txtEmail);
		txtEmail.setColumns(10);
		btnEliminar.addActionListener(this);
		
		btnGrabar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnGrabarActionPerformed(arg0);
			}
		});
		
		
		
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
		
		int [] anchos = {30, 200, 50};
		
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
		//String des = textField.getText().trim();
		
	/*//	CategoriaBean bean = new CategoriaBean();
		bean.setDescripcion(des);
		
		c.inserta(bean);
		
		listaData();*/
	}
	protected void do_btnEliminar_actionPerformed(ActionEvent arg0) {
		/*if( idCategoria!= -1){
			c.elimina(idCategoria);
			textField.setText("");
			listaData();
		}*/
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
//			row[0] = modelo1.getValueAt(indexs[i], 0);
//			row[1] = modelo1.getValueAt(indexs[i], 1);
			
			if (modelo1.getValueAt(i,0).equals(modelo2.getValueAt(i, 0))){				
				JOptionPane.showMessageDialog(null, "El DATO ya esta Seleccionado");
			} else {
				row[0] = modelo1.getValueAt(indexs[i], 0);
				row[1] = modelo1.getValueAt(indexs[i], 1);
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
