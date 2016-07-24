package com.placamas.vista;

import java.awt.EventQueue;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.placamas.beans.LocalBean;
import com.placamas.beans.Lugar;

public class FrmLocales extends JFrame {

	private JComboBox<String> cboRegion;
	private JComboBox<String> cboProvincia;
	private JComboBox<String> cboDistrito;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmLocales frame = new FrmLocales();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public FrmLocales() {
		addWindowListener(new WindowAdapter() {

			private LocalBean x;

			public void windowOpened(WindowEvent arg0) {
				cboRegion.addItem("Seleccionar");
				for (Lugar x : com.placamas.controlador.Ubigeo
						.getAllDepartamento()) {
					String name = x.getNombre();
					cboRegion.addItem(name);
				}
				x = null;
				cboRegion.setSelectedItem(x.getRegion());
				cboProvincia.setSelectedItem(x.getProvincia());
				cboDistrito.setSelectedItem(x.getDistrito());

			}

		});
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 548);
		getContentPane().setLayout(null);

		cboRegion = new JComboBox();
		cboRegion.setBounds(127, 87, 194, 22);
		getContentPane().add(cboRegion);

		cboProvincia = new JComboBox<String>();
		cboProvincia.setBounds(417, 88, 109, 20);
		getContentPane().add(cboProvincia);

		cboDistrito = new JComboBox();
		cboDistrito.setBounds(634, 88, 141, 20);
		getContentPane().add(cboDistrito);

		cboDistrito.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

			}
		});
		cboProvincia.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();

				if (!(c != KeyEvent.VK_ENTER)) {
					cboDistrito.requestFocus();
				}
			}
		});
		cboProvincia.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cboDistrito.removeAllItems();
				int valor = 0;
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String text = cboProvincia.getSelectedItem().toString();

					valor = com.placamas.controlador.Ubigeo.getCodProv(text);
					for (Lugar dist : com.placamas.controlador.Ubigeo
							.getAllDistritoByProv(valor)) {
						String name = dist.getNombre();
						cboDistrito.addItem(name);
					}
				}
			}
		});
		cboRegion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();

				if (!(c != KeyEvent.VK_ENTER)) {
					cboProvincia.requestFocus();
				}
			}
		});
		cboRegion.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				cboProvincia.removeAllItems();
				int valor = 0;
				if (e.getStateChange() == ItemEvent.SELECTED) {
					valor = cboRegion.getSelectedIndex();
					for (Lugar prov : com.placamas.controlador.Ubigeo
							.getAllProvinciaByDepa(valor)) {
						String name = prov.getNombre();
						cboProvincia.addItem(name);
					}
				}

			}
		});
	}

}
