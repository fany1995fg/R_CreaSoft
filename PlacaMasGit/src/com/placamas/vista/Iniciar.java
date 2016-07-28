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
public class Iniciar extends JFrame implements WindowListener{
 
	public MenuPrincipal menu = new MenuPrincipal();
	
	public Iniciar(String cad, int x, int y) {
		super(cad);
		setLocation(0, 0);
		setIconImage(new ImageIcon(getClass().getClassLoader().getResource("Iconos_PlacaMas/Money.gif")).getImage());
		setSize(x, y);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		
		menu.setBackground(SystemColor.activeCaption);
		
		getContentPane().add(menu.menuBar, BorderLayout.NORTH);
		getContentPane().add(menu.contenedor, BorderLayout.CENTER);

		addWindowListener(this);		
		
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
		
		if (n == JOptionPane.NO_OPTION){
			JOptionPane.showMessageDialog(null, "Operacion cancelada");
		}
			
	}

	public void windowClosed(WindowEvent e) {}

	public void windowIconified(WindowEvent e) {}

	public void windowDeiconified(WindowEvent e) {}

	public void windowActivated(WindowEvent e) {}

	public void windowDeactivated(WindowEvent e) {}

	

}