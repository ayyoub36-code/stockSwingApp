package fr.fms.mvc;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.border.TitledBorder;
import javax.swing.table.AbstractTableModel;

public class View {

	public View() {
		// JButton and JTable
		JButton showDataButton = new JButton("Charger la table des produits");
		JTable table = new JTable();
		System.out.println("view call");
		// ArrayList<Product> products;
		// table model
		AbstractTableModel model = new Model();
		table.setModel(model);

		// creer le controlleur
		Controller controller = new Controller(model);
		showDataButton.addActionListener(controller);

		// Set the view layout
		JPanel ctrlPane = new JPanel();
		ctrlPane.add(showDataButton);

		// barre de scrol(table)
		JScrollPane tableScrollPane = new JScrollPane(table);
		tableScrollPane.setPreferredSize(new Dimension(700, 182));
		tableScrollPane.setBorder(BorderFactory.createTitledBorder(BorderFactory.createEtchedBorder(),
				"Team TOULOUSE & François", TitledBorder.CENTER, TitledBorder.TOP));

		// split de jpanel entre button et table
		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, ctrlPane, tableScrollPane);
		splitPane.setDividerLocation(35);
		splitPane.setEnabled(false);

		// Display it all in a scrolling window and make the window appear
		JFrame frame = new JFrame("Mon appli de gestion de stock");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(splitPane);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);

	}

}
