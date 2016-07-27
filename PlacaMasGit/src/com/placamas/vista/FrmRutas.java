package com.placamas.vista;
	import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

	import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
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

	import com.placamas.beans.RutasBean;
import com.placamas.controlador.RutasControlador;
import javax.swing.SwingConstants;
public class FrmRutas extends JInternalFrame implements ActionListener {

		
	RutasControlador obj=new RutasControlador();
		boolean estado=false;

		DefaultTableModel modelo=new DefaultTableModel();
		
		
		JTextField txtIdRuta;
		private JTextField txtRuta;
		JTable tbRutas;
		private JButton btnGrabar;
		private static JButton btnEscoger;
		private JButton btnEliminar;
		private JButton btnNuevo;
		private JToolBar toolBar;
		JPanel rutas;
		private JLabel label;
		private JButton btnAbrir;


		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						FrmRutas frame = new FrmRutas();
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
		public FrmRutas() {
			
			
			rutas = new JPanel();
			rutas.setLayout(null);
			
			toolBar = new JToolBar();
			toolBar.setBounds(0, 0, 135, 30);
			rutas.add(toolBar);
			
			
			btnNuevo = new JButton("");
			toolBar.add(btnNuevo);
			btnNuevo.setIcon(new ImageIcon(FrmRutas.class.getResource("/Iconos_PlacaMas/_New_document.png")));
			
			btnEditar = new JButton("");
			btnEditar.setIcon(new ImageIcon(FrmRutas.class.getResource("/Iconos_PlacaMas/_Modify.png")));
			btnEditar.setToolTipText("Nuevo Registro");
			toolBar.add(btnEditar);

			btnEliminar = new JButton("");
			toolBar.add(btnEliminar);
			btnEliminar.setIcon(new ImageIcon(FrmRutas.class.getResource("/Iconos_PlacaMas/_Erase.png")));
			
			
			
			
			btnEliminar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					btnEliminarActionPerformed(arg0);
				}
			});
			btnNuevo.addActionListener(this);
			
			label = new JLabel("");
			label.setIcon(new ImageIcon(FrmMarcas.class.getResource("/gui/img/banners/Marquitas.png")));
			label.setBounds(0, 33, 1194, 65);
			rutas.add(label);
			
			
			
			
			
			btnNuevo.setToolTipText("Nuevo Registro");
			btnEliminar.setToolTipText("Eliminar");
			
			separator_1 = new JSeparator();
			separator_1.setOrientation(SwingConstants.VERTICAL);
			toolBar.add(separator_1);
			
			btnEditarNo = new JButton("");
			btnEditarNo.setIcon(new ImageIcon(FrmRutas.class.getResource("/Iconos_PlacaMas/_Editar_No.png")));
			btnEditarNo.setToolTipText("Nuevo Registro");
			toolBar.add(btnEditarNo);
			
			btnGrabar = new JButton("");
			toolBar.add(btnGrabar);
			btnGrabar.setIcon(new ImageIcon(FrmRutas.class.getResource("/Iconos_PlacaMas/_Save.png")));
			btnGrabar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnGrabarActionPerformed(arg0);
				}
			});
			btnGrabar.setToolTipText("Grabar");
			
			modelo.addColumn("codigo");
			modelo.addColumn("Ruta dada");
			Listar();
			
			
			
			tbRutas = new JTable();
			Listar();
			
			
			
			
			
			int fila=0;
			
			panel = new JPanel();
			panel.setBounds(20, 121, 1113, 495);
			rutas.add(panel);
			panel.setLayout(null);
			
			JLabel lblIdMarca = new JLabel("C\u00F3digo de Ruta:");
			lblIdMarca.setBounds(47, 40, 115, 20);
			panel.add(lblIdMarca);
			lblIdMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			

			txtIdRuta = new JTextField();
			txtIdRuta.setBounds(172, 41, 115, 20);
			panel.add(txtIdRuta);
			txtIdRuta.setDocument(new LimiteJTextField(8));
			txtIdRuta.addKeyListener(new KeyAdapter() {
				@Override
				public void keyTyped(KeyEvent evt) {
					
					char c=evt.getKeyChar();
					if(Character.isLowerCase(c)){
						String cad=(""+c).toUpperCase();
						c=cad.charAt(0);
						evt.setKeyChar(c);
					}
				}
			});
			txtIdRuta.setToolTipText("Escribe el Codigo de la Ruta( max. 8 car)");
			
			JLabel lblDescripcion = new JLabel("Ruta:");
			lblDescripcion.setBounds(47, 72, 115, 20);
			panel.add(lblDescripcion);
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			
			
			txtRuta = new JTextField();
			txtRuta.setBounds(172, 73, 178, 20);
			panel.add(txtRuta);
			txtRuta.setToolTipText("Escribe una Descripción para la ruta");
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(35, 136, 464, 300);
			panel.add(scrollPane);
			
			tbRutas = new JTable(){
				public boolean isCellEditable(int rowIndex, int colIndex){
					return false;
				}
			};
			tbRutas.addKeyListener(new KeyAdapter() {
				@Override
				//DISEÑO CLIC DERECHO EN EL SCROL / EVENT /KEY/ KEYRELEASED
				public void keyReleased(KeyEvent arg0) {
					Mostrar();
				
				}
			});
			tbRutas.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseReleased(MouseEvent arg0) {
					Mostrar();
				}
			});
			scrollPane.setViewportView(tbRutas);
			tbRutas.setModel(modelo);
			txtIdRuta.setText(""+tbRutas.getValueAt(fila, 0));
			txtRuta.setText(""+tbRutas.getValueAt(fila, 1));
			
			btnAbrir = new JButton("...");
			btnAbrir.setBounds(382, 73, 89, 20);
			panel.add(btnAbrir);
			btnAbrir.setToolTipText("selecionar una ubicacion");
			btnAbrir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnEscogerActionPerformed(arg0);
				}
			});
			
			tbRutas.requestFocus();
			tbRutas.changeSelection(0,0,true, false);
			
		
	}
		
		
		
		void mensaje(String m){
			JOptionPane.showMessageDialog(null, m);
	}	

		
		
		protected void btnGrabarActionPerformed(ActionEvent arg0) {
			
			String texto=txtIdRuta.getText();
			String descripcion=txtRuta.getText();
			descripcion=descripcion.replaceAll(" ", "");
	        texto=texto.replaceAll(" ", "");
	        
	        if(texto.length()==0){
	        	
	        	mensaje("ERROR: No se acepta 'CODIGO' en blanco");
	            txtIdRuta.requestFocus();
	        }
	        else
	        if(descripcion.length()==0){
	        	
	        	mensaje("ERROR: No se acepta 'DESCRIPCION' en blanco");
	            txtRuta.requestFocus();
	        }
	        else
	        if(texto.length()<3 || texto.length()>8){
	        	
	            mensaje("ERROR: Solo se aceptan como max. 9 car");
	            
	        }
	        else
	        if(texto.length()<=8 || texto.length()>3){
	        	estado=true;
	        if(estado==true){ 	
			RutasBean l=new RutasBean(txtIdRuta.getText(), txtRuta.getText());
			int valor=obj.registrarRutas(l);
			if(valor==1){
				
				mensaje("Registro Exitoso de Ruta");
				estado=false;
				Listar();
				
				tbRutas.requestFocus();
				tbRutas.changeSelection(0,0,true, false);
				
				txtIdRuta.setText(""+tbRutas.getValueAt(0, 0));
				txtRuta.setText(""+tbRutas.getValueAt(0, 1));
				}
			
	       }
		}
		
			
	}
		

	protected void btnEliminarActionPerformed(ActionEvent arg0) {
		
		
		int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?",null, JOptionPane.OK_CANCEL_OPTION );
		
		if(descicion==JOptionPane.OK_OPTION){
			
			int valor=obj.eliminarRutas(txtIdRuta.getText());
			
			 if(valor==1){
				 if(tbRutas.getSelectedRow() >=0 ){					 
					 ((DefaultTableModel)tbRutas.getModel()).removeRow(tbRutas.getSelectedRow());
				 }
					mensaje("Registro Eliminado");
					
					tbRutas.requestFocus();
					tbRutas.changeSelection(0,0,true, false);
					
					txtIdRuta.setText(""+tbRutas.getValueAt(0, 0));
					txtRuta.setText(""+tbRutas.getValueAt(0, 1));
					
			 }
		if(descicion==JOptionPane.CANCEL_OPTION){
	
			mensaje("El Registro no se Elimino");
			}
		}	
		
		}

	String archivo ="";
	private JSeparator separator_1;
	private JButton btnEditar;
	private JButton btnEditarNo;
	private JPanel panel;
	@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == btnNuevo) {
				btnNuevoActionPerformed(arg0);
			}
		}
	
	
	public void btnEscogerActionPerformed(ActionEvent arg0){
		
			JFileChooser fc = new JFileChooser();
			fc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			int returnVal = fc.showDialog(this, "Seleccione file");
			
			if(returnVal == JFileChooser.APPROVE_OPTION){
				  File file = fc.getSelectedFile();
				  txtRuta.setText(file.getAbsolutePath());
			}

		
	}
		protected void btnNuevoActionPerformed(ActionEvent arg0) {
			txtIdRuta.setText("");
			txtRuta.setText("");
			txtIdRuta.requestFocus();
			estado=true;
		}
		
		void Listar(){
			modelo.setRowCount(0);
			ArrayList<RutasBean> info=obj.listarRutas();
			for(RutasBean x:info){
				Object fila[]={x.getIdRutas(),x.getRutas()};
				modelo.addRow(fila);
				
			}

		}
		void Mostrar(){
			
			int fila=tbRutas.getSelectedRow();
			txtIdRuta.setText(""+tbRutas.getValueAt(fila, 0));
			txtRuta.setText(""+tbRutas.getValueAt(fila, 1));
			
		}
	}

