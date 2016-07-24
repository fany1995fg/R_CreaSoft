package com.placamas.vista;

import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JPanel;

import java.awt.Color;

import javax.swing.border.TitledBorder;
import javax.swing.UIManager;
import javax.swing.SwingConstants;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.FocusAdapter;
import java.io.File;
import java.sql.Blob;

import javax.swing.JRadioButton;
import javax.swing.border.BevelBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.placamas.beans.LocalBean;
import com.placamas.beans.Lugar;
import com.placamas.beans.Ubigeo;

import java.awt.Font;

public class frmLoca extends JFrame {
	private JTextField txtEmail;
	private JTextField txtDireccion;
	private JComboBox<String> cboRegion;
	private JComboBox<String> cboProvincia;
	private JComboBox<String> cboDistrito;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frmLoca frame = new frmLoca();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public frmLoca() {
		addWindowListener(new WindowAdapter() {
			
			private LocalBean x;

			public void windowOpened(WindowEvent arg0) {
				cboRegion.addItem("Seleccionar");
				for (Lugar x : com.placamas.controlador.Ubigeo.getAllDepartamento()) {
					String name = x.getNombre();
					cboRegion.addItem(name);
				}
				x = null;
				cboRegion.setSelectedItem(x.getRegion());
				cboProvincia.setSelectedItem(x.getProvincia());
				cboDistrito.setSelectedItem(x.getDistrito());

				txtEmail.setText(x.getIdLocal());
				txtDireccion.setText(x.getLoc_Nomb());

			}

		});
		setResizable(false);
		setTitle("Mantenimiento Paciente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1008, 548);
		getContentPane().setLayout(null);

		JButton btnNuevo = new JButton("Nuevo");
		btnNuevo.setBounds(807, 60, 113, 36);
		getContentPane().add(btnNuevo);

		JPanel pInformacion = new JPanel();
		pInformacion.setBorder(new TitledBorder(null,
				"Informaci\u00F3n de contacto", TitledBorder.LEADING,
				TitledBorder.TOP, null, null));
		pInformacion.setBounds(23, 54, 748, 160);
		getContentPane().add(pInformacion);
		pInformacion.setLayout(null);

		JLabel lblEmail = new JLabel("Nombre de Local :");
		lblEmail.setBounds(285, 90, 147, 14);
		pInformacion.add(lblEmail);

		txtEmail = new JTextField();
		txtEmail.setBounds(390, 87, 194, 20);
		pInformacion.add(txtEmail);
		txtEmail.setColumns(10);

		JLabel lblIdlocal = new JLabel("idLocal:");
		lblIdlocal.setBounds(18, 90, 64, 14);
		pInformacion.add(lblIdlocal);
		lblIdlocal.setHorizontalAlignment(SwingConstants.RIGHT);

		txtDireccion = new JTextField();
		txtDireccion.setBounds(94, 87, 122, 20);
		pInformacion.add(txtDireccion);
		txtDireccion.setColumns(10);

		cboDistrito = new JComboBox();
		cboDistrito.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				char c = e.getKeyChar();

				if (!(c != KeyEvent.VK_ENTER)) {
					txtDireccion.requestFocus();
				}
			}
		});
		cboDistrito.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {

			}
		});
		cboDistrito.setBounds(593, 42, 141, 20);
		pInformacion.add(cboDistrito);

		JLabel lblDistrito = new JLabel("Distrito:");
		lblDistrito.setHorizontalAlignment(SwingConstants.RIGHT);
		lblDistrito.setBounds(527, 45, 54, 14);
		pInformacion.add(lblDistrito);

		JLabel lblProvincia = new JLabel("Provincia:");
		lblProvincia.setBounds(327, 45, 64, 14);
		pInformacion.add(lblProvincia);

		JLabel lblRegin = new JLabel("Regi\u00F3n:");
		lblRegin.setHorizontalAlignment(SwingConstants.RIGHT);
		lblRegin.setBounds(18, 44, 56, 16);
		pInformacion.add(lblRegin);

		cboRegion = new JComboBox();
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
					for (Lugar prov : com.placamas.controlador.Ubigeo.getAllProvinciaByDepa(valor)) {
						String name = prov.getNombre();
						cboProvincia.addItem(name);
					}
				}

			}
		});
		cboRegion.setBounds(94, 41, 194, 22);
		pInformacion.add(cboRegion);

		cboProvincia = new JComboBox<String>();
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
					for (Lugar dist : com.placamas.controlador.Ubigeo.getAllDistritoByProv(valor)) {
						String name = dist.getNombre();
						cboDistrito.addItem(name);
					}
				}
			}
		});
		cboProvincia.setBounds(401, 42, 109, 20);
		pInformacion.add(cboProvincia);

		JLabel lblNewLabel = new JLabel("LOCALES");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(23, 13, 194, 16);
		getContentPane().add(lblNewLabel);
	}

	void mensaje(String m) {
		JOptionPane.showMessageDialog(null, m);
	}
}
