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
		private JSeparator separator;
		JPanel rutas;
		private JLabel label;
		private JSeparator separator_1;
		private JLabel lblListaDeRutas;
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
			//marcas.addMouseListener((MouseListener) this);
			rutas.setLayout(null);
			
			toolBar = new JToolBar();
			toolBar.setBounds(0, 0, 1194, 35);
			rutas.add(toolBar);
			
			
			btnNuevo = new JButton("");
			toolBar.add(btnNuevo);
			btnNuevo.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466476618_File.png")));
			
			btnGrabar = new JButton("");
			toolBar.add(btnGrabar);
			btnGrabar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475388_save.png")));

			btnEliminar = new JButton("");
			toolBar.add(btnEliminar);
			btnEliminar.setIcon(new ImageIcon(FrmTextura.class.getResource("/iconosmodernos/1466475182_TrashBin.png")));
			
			
			
			
			btnEliminar.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					btnEliminarActionPerformed(arg0);
				}
			});
			btnGrabar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnGrabarActionPerformed(arg0);
				}
			});
			btnNuevo.addActionListener(this);
			
			JLabel lblIdMarca = new JLabel("C\u00F3digo de Ruta:");
			lblIdMarca.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblIdMarca.setBounds(63, 204, 118, 20);
			rutas.add(lblIdMarca);
			
			JLabel lblDescripcion = new JLabel("Ruta:");
			lblDescripcion.setFont(new Font("Tahoma", Font.PLAIN, 13));
			lblDescripcion.setBounds(63, 245, 81, 20);
			
			rutas.add(lblDescripcion);
			
			

			txtIdRuta = new JTextField(3);
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
			txtIdRuta.setBounds(221, 206, 143, 20);
			txtIdRuta.setColumns(10);
			txtIdRuta.setToolTipText("Escribe el Codigo de la Marca (3 Car)");
			rutas.add(txtIdRuta);
			
			
			txtRuta = new JTextField();
			txtRuta.setBounds(221, 247, 317, 20);
			txtRuta.setColumns(10);
			txtRuta.setToolTipText("Escribe una Descripción para la marca");
			rutas.add(txtRuta);
			
			
			
			
			
			btnNuevo.setToolTipText("Nuevo Registro");
			btnEliminar.setToolTipText("Eliminar");
			btnGrabar.setToolTipText("Grabar");
			
			modelo.addColumn("codigo");
			modelo.addColumn("Ruta dada");
			Listar();
			
			//setDefaultCloseOperation(DISPOSE_ON_CLOSE ); //Se oculte al cerrara
			
			separator = new JSeparator();
			separator.setBounds(726, 132, 0, 2);
			rutas.add(separator);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(57, 342, 675, 220);
			rutas.add(scrollPane);		
			
			
			
			tbRutas = new JTable();
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
			
			label = new JLabel("");
			label.setIcon(new ImageIcon(FrmMarcas.class.getResource("/gui/img/banners/Marquitas.png")));
			label.setBounds(0, 33, 1364, 116);
			rutas.add(label);
			
			separator_1 = new JSeparator();
			separator_1.setBounds(0, 173, 1354, 20);
			rutas.add(separator_1);
			
			lblListaDeRutas = new JLabel("Lista de Marcas:");
			lblListaDeRutas.setFont(new Font("Tahoma", Font.BOLD, 12));
			lblListaDeRutas.setBounds(57, 316, 153, 20);
			rutas.add(lblListaDeRutas);
			Listar();
			
			
			//tbMarcas.setFocusable(true);
			//tbMarcas.getValueAt(0,0);
			
			
			int fila=0;
			txtIdRuta.setText(""+tbRutas.getValueAt(fila, 0));
			txtRuta.setText(""+tbRutas.getValueAt(fila, 1));
			
			btnAbrir = new JButton("...");
			btnAbrir.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					btnEscogerActionPerformed(arg0);
				}
			});
			btnAbrir.setBounds(579, 245, 89, 23);
			rutas.add(btnAbrir);
			
			
			//tbMarcas.requestFocus();
			//tbMarcas.changeSelection(0,0,true, true);
			
			//tbMarcas.getValueAt(0, 0).setFocus();
			//tbMarcas.setFocusable(true);
			//tbMarcas.requestFocusInWindow();
			//tbMarcas.requestFocus(true);
			//tbMarcas.requestFocus();
			
		
		}
		
		
		void mensaje(String m){
			JOptionPane.showMessageDialog(null, m);
	}	

		
		
		protected void btnGrabarActionPerformed(ActionEvent arg0) {
			/*String texto=txtIdMarca.getText();
	        texto=texto.replaceAll(" ", "");
	        if(texto.length()==0){
	            System.out.println("no ai texto");
	            
	        }
	        else
	        {
	            System.out.println("si lo ai ");
	        }*/
	        
			
			String texto=txtIdRuta.getText();
	        texto=texto.replaceAll(" ", "");
	        if(texto.length()==0){
	        	
	            mensaje("ERROR: No se aceptan campos en blanco");
	            
	        }
	        else
	        if(texto.length()>3 || texto.length()<3){
	        	
	            mensaje("ERROR: Solo se aceptan 3 caracteres");
	            
	        }
	        else
	        if(texto.length()==3){
	        	estado=true;
	        if(estado==true){ 	
			RutasBean l=new RutasBean(txtIdRuta.getText(), txtRuta.getText());
			int valor=obj.registrarRutas(l);
			if(valor==1){
				
				mensaje("Registro Exitoso de Ruta");
				estado=false;
				Listar();
				}
	       }
		}
		/*else{
			MarcasBean l=new MarcasBean(txtIdMarca.getText(), txtDescripcion.getText());
			int valor=obj.actualizarMarcas(l);
			if(valor==1){
				mensaje("Actualizado Correctamente");
			Listar();
			}
			else
				mensaje("Error");
		}*/
	        
			
	}
		

	protected void btnEliminarActionPerformed(ActionEvent arg0) {
		
		
		 int descicion = JOptionPane.showConfirmDialog(null,"Esta seguro de eliminar en registro?");

			if(descicion==JOptionPane.YES_OPTION){
				
				int valor=obj.eliminarRutas(txtIdRuta.getText());
				
				 if(valor==1){
					 if(tbRutas.getSelectedRow() >=0 ){					 
						 ((DefaultTableModel)tbRutas.getModel()).removeRow(tbRutas.getSelectedRow());
					 }
						mensaje("Registro Eliminado");
						txtIdRuta.setText("");
						txtRuta.setText("");
				 }
				 else
						mensaje("Error al Eliminar");
				 
				}

			if(descicion==JOptionPane.NO_OPTION){

				mensaje("El Registro no se Elimino");
			}
			
		
		}

	String archivo ="";
	@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getSource() == btnNuevo) {
				btnNuevoActionPerformed(arg0);
			}
		}
	
	
	public void btnEscogerActionPerformed(ActionEvent arg0){
		
			JFileChooser fc = new JFileChooser();
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

