package fr.fms.mvc;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fr.fms.bdd.Dao;
import fr.fms.bdd.ProductDao;
import fr.fms.entities.Product;

public class Controller implements ActionListener {
	public View view;
	private AbstractTableModel model;

	public Controller(AbstractTableModel model) {
		System.out.println("controller");
		this.model = model;
	}

	Dao<Product> dao = new ProductDao();
	ArrayList<Product> list = dao.readAll();

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("coucou");
		// dao on injecte les articles dans le model
		Dao<Product> dao = new ProductDao();
		ArrayList<Product> products = dao.readAll();
		// Collection<Product> products2 = products.addAll(Arrays.asList(products));
//		Product product1 = new Product(" Description", "Brand", 10, "Category", 15);
//		products.add(product1);
		// model = new Model(products);
		((Model) model).setProducts(products);

	}
}
