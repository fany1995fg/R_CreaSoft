package com.placamas.menu;

import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Pestañas extends JFrame{

	
    private static final long serialVersionUID = 1L;
    private JTabbedPane tabbedPane;
	
    
    public Pestañas() {
    	
    	tabbedPane = new JTabbedPane();
        tabbedPane.setPreferredSize(new Dimension(800, 700));//tamaño de la ventana
        getContentPane().add(tabbedPane);
        
    	
        JButton herramientas = new JButton("herramentas");
    	
    }
	
}
