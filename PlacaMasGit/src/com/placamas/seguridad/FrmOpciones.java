package com.placamas.seguridad;

import java.awt.EventQueue;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTree;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

public class FrmOpciones extends JFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmOpciones frame = new FrmOpciones();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmOpciones() {
		setTitle("Ver Opciones");
		setBounds(100, 100, 321, 503);
		
		JPanel panel = new JPanel();
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 32, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
		JTree tree = new JTree();
		tree.setModel(new DefaultTreeModel(
			new DefaultMutableTreeNode("Opciones") {
				{
					DefaultMutableTreeNode node_1;
					node_1 = new DefaultMutableTreeNode("Lista de Piezas");
						node_1.add(new DefaultMutableTreeNode("Listado de Piezas"));
						node_1.add(new DefaultMutableTreeNode("Resumen de Productos y Servicios"));
						node_1.add(new DefaultMutableTreeNode("Seguimiento"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Administracion");
						node_1.add(new DefaultMutableTreeNode("Tableros"));
						node_1.add(new DefaultMutableTreeNode("Tapacantos"));
						node_1.add(new DefaultMutableTreeNode("Ranuras"));
						node_1.add(new DefaultMutableTreeNode("Bisagrados"));
						node_1.add(new DefaultMutableTreeNode("Puertas Corredizas"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Parametros");
						node_1.add(new DefaultMutableTreeNode("Marcas"));
						node_1.add(new DefaultMutableTreeNode("Materiales"));
						node_1.add(new DefaultMutableTreeNode("Texturas"));
						node_1.add(new DefaultMutableTreeNode("Colores"));
						node_1.add(new DefaultMutableTreeNode("Medidas"));
						node_1.add(new DefaultMutableTreeNode("Locales"));
						node_1.add(new DefaultMutableTreeNode("Rutas de Archivo"));
						node_1.add(new DefaultMutableTreeNode("Reglas de Sistema"));
					add(node_1);
					node_1 = new DefaultMutableTreeNode("Usuarios");
					node_1.add(new DefaultMutableTreeNode("Gestión de Usuarios"));
					node_1.add(new DefaultMutableTreeNode("Control de Usuarios"));
				add(node_1);
				}
			}
		));
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(233))
				.addComponent(tree, GroupLayout.DEFAULT_SIZE, 305, Short.MAX_VALUE)
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(tree, GroupLayout.PREFERRED_SIZE, 461, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		getContentPane().setLayout(groupLayout);

	}

}
