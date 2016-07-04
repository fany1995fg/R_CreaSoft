package com.placamas.menu;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.FlowLayout;


public class PanelConPestañas extends JFrame {

    private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;
    private JButton agregar;
    private JPanel panellistado;
    private JPanel ingresar;
    
    
    private JMenu  mnArchivo	  	 = new JMenu("Archivo");
    
    private JMenuItem mnArcList    = new JMenuItem("Listado de Piezas");
    
    
 
    
    public PanelConPestañas() {
       	
    	
    	
        tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(800, 700));//tamaño de la ventana
        getContentPane().add(tabbedPane);
        
        //primera Pestaña
        panellistado = new JPanel();
        tabbedPane.add(panellistado, "Listado");//crea la pestaña()JMenu
        panellistado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));//
        	agregar= new JButton("Agregar");
        	
        	
        	
		    panellistado.add(agregar);
	       /* ///////
	        JPanel panel_1 = new JPanel();//cuerpo pestaña ()J
	        
		        
		        
		        JLabel lblControlDeUsuarios = new JLabel("Ingresar el Listado");//campo dentro de la primera pestaña
		        panellistado.add(panel_1);
		        panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));//
		        panel_1.add(lblControlDeUsuarios);
		        
	        ////////////////////////////
        */
        
        
        JTextField one = new JTextField("");//pestaña mostrada
        tabbedPane.add(one, "Administracion");
        tabbedPane.setTabPlacement(JTabbedPane.NORTH);
       
        JPanel Usuarios = new JPanel();
        tabbedPane.addTab("Control de Usuarios", null, Usuarios, null);
        
        JLabel lblUsuarios = new JLabel("USUARIOS");
        Usuarios.add(lblUsuarios);
    }

    
    
    
    public static void main(String args[]) {
      
    	
    	PanelConPestañas frame = new PanelConPestañas();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        
        
    }
}