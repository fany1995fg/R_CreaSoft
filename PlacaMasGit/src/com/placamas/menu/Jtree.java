package com.placamas.menu;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTree;
import javax.swing.WindowConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;


public class Jtree extends javax.swing.JFrame {
	
	private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;
    private JButton agregar;
    private JPanel panellistado;
    private JPanel ingresar;
	private JTree tree;
    
    private JButton hijo;
    public Jtree() {
       	
    	
    	
        tabbedPane = new JTabbedPane();
        tabbedPane.setBounds(219, 11, 297, 325);
        tabbedPane.setPreferredSize(new Dimension(800, 700));//tamaño de la ventana
        
        
        //primera Pestaña
        panellistado = new JPanel();
        tabbedPane.add(panellistado, "Listado");//crea la pestaña()JMenu
        //panellistado.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));//
        	agregar= new JButton("Agregar");
        	
        	
        	
		    panellistado.add(agregar);
		    
		    
		    
		    JPanel panel = new JPanel();
			panel.setBounds(10, 23, 199, 313);
			getContentPane().add(panel);    
		    
		   
		DefaultMutableTreeNode abuelo = new DefaultMutableTreeNode("abuelo");
		
		DefaultTreeModel modelo = new DefaultTreeModel(abuelo);
		JTree tree=new JTree(modelo); 
		panel.add(tree);
		//JTree.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 3));//
		//carpetas contenedoras
		DefaultMutableTreeNode padre= new DefaultMutableTreeNode("padre");
		DefaultMutableTreeNode tio = new DefaultMutableTreeNode("tio");
		modelo.insertNodeInto(padre, abuelo, 0);
		modelo.insertNodeInto(tio, abuelo, 1);
		
			//Sub de Padre
			DefaultMutableTreeNode hijo = new DefaultMutableTreeNode("hijo");
			DefaultMutableTreeNode hija = new DefaultMutableTreeNode("hija");
			modelo.insertNodeInto(hijo, padre, 0);
			modelo.insertNodeInto(hija, padre, 1);
			getContentPane().setLayout(null);
			
			
			getContentPane().add(tabbedPane);
			
			
			
			
		//creacion de la ventana
		/*
		JFrame v=new JFrame();
		
		
		
		
		
		v.pack();
		v.setVisible(true);
		v.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		*/		
		
}
		    
	public static void main (String[] args){	
		
		Jtree frame = new Jtree();
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
	}
}
