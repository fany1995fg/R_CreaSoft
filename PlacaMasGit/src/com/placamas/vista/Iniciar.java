package com.placamas.vista;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import com.placamas.vista.*;

import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;

import java.awt.SystemColor;



@SuppressWarnings("serial")
public class Iniciar extends JFrame implements WindowListener, MouseListener{
 
	public MenuPrincipal menu = new MenuPrincipal();
	
	public Iniciar(String cad, int x, int y) {
		super(cad);
		setLocation(0, 0);
		setIconImage(new ImageIcon(getClass().getClassLoader().getResource("iconos/Money.gif")).getImage());
		setSize(x, y);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		 
		//menu.setSize(600, 400);
		menu.setBackground(SystemColor.activeCaption);
		
		//se instancia a MenuPrincipal
		
		getContentPane().add(menu.menuBar, BorderLayout.NORTH);
		getContentPane().add(menu.contenedor, BorderLayout.CENTER);

		addWindowListener(this);		

		
		menu.mItem09.addMouseListener(this);
		menu.mItem10.addMouseListener(this);
		menu.mItem11.addMouseListener(this);
		menu.mItem12.addMouseListener(this);
		menu.mItem13.addMouseListener(this);
		menu.mItem14.addMouseListener(this);
		menu.mItem15.addMouseListener(this);
		menu.mItem16.addMouseListener(this);
		
	}
		

	public static void main(String[] args) {
		
		
		try {
			
			UIManager.setLookAndFeel("com.jtattoo.plaf.luna.LunaLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.fast.FastLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel");
			//UIManager.setLookAndFeel("com.jtattoo.plaf.aero.AeroLookAndFeel");
			
			Iniciar jf = new Iniciar(
					"PlacaMas Versión 1.0", 900, 600);
			jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			jf.setVisible(false);
			
			FrmLogin frm = new FrmLogin(jf);
			frm.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
			frm.setVisible(true);
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void windowOpened(WindowEvent e) {}

	public void windowClosing(WindowEvent e) {
		int n = JOptionPane.showConfirmDialog(e.getWindow(),
				"Desea Cerrar la Aplicación ?", "Confirmación",
				JOptionPane.YES_NO_OPTION);
		if (n == JOptionPane.YES_OPTION)
			System.exit(0);
	}

	public void windowClosed(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowActivated(WindowEvent e) {}

	public void windowDeactivated(WindowEvent e) {}

	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent evento) {
		// TODO Auto-generated method stub
		
		/*if (evento.getSource() == menu.mItem09){
			  FrmMarcas.marcas.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem10){
			  FrmMaterial.material.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem11){
			  FrmTextura.textura.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem12){
			  FrmColores.colores.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem13){
			  FrmMedidas.medidas.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem14){
			  FrmLocales.locales.requestFocus();			  
			  }*/
	}


	@Override
	public void mouseReleased(MouseEvent evento) {
		// TODO Auto-generated method stub
		/*if (evento.getSource() == menu.mItem09){
			  FrmMarcas.marcas.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem10){
			  FrmMaterial.material.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem11){
			  FrmTextura.textura.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem12){
			  FrmColores.colores.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem13){
			  FrmMedidas.medidas.requestFocus();			  
			  }
		if (evento.getSource() == menu.mItem14){
			  FrmLocales.locales.requestFocus();			  
			  }*/
	
	}

}