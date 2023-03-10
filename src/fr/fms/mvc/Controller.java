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
		this.model = model;
	}

	Dao<Product> dao = new ProductDao();
	ArrayList<Product> list = dao.readAll();

//	public static char[][] listToArray(list) {
//	     
//	    int size = list.size();
//	    char[][] tab2d = new char[size][size];
//	     
//	    for(int i = 0; i < size; i++){
//	        for(int j = 0; j < size; j++){
//	            tab2d[i][j] = list.get(i).charAt(j);
//	        }
//	    }
//	     
//	    return tab2d;
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("coucou");
		// dao on injecte les articles dans le model
		Dao<Product> dao = new ProductDao();
		ArrayList<Product> products = dao.readAll();
		// Collection<Product> products2 = products.addAll(Arrays.asList(products));
		Product product1 = new Product(" Description", "Brand", 10, "Category", 15);
		products.add(product1);
		// model = new Model(products);
		((Model) model).setProducts(products);
		// model = new Model();
		view = new View();
//		for (Product product : products) {
//			products.get(rowIndex).setId(((Product) product).getId());
//			model.setValueAt(product, model.getRowCount(), model.getColumnCount());
//
//		}
	}
}

//	public void setValueAt(Product product, int rowIndex, int columnIndex) {
//		switch (columnIndex) {
//		case COL_ID:
//			products.get(rowIndex).setId(product.getId());
//			break;
//		case COL_DESCRIPTION:
//			products.get(rowIndex).setDescription(product.getDescription());
//			break;
//		case COL_BRAND:
//			products.get(rowIndex).setBrand(product.getBrand());
//			break;
//		case COL_PRICE:
//			products.get(rowIndex).setPrice(product.getPrice());
//			break;
//		case COL_CATEGORY:
//			products.get(rowIndex).setCategory(product.getCategory());
//			break;
//		case COL_QUANTITY:
//			products.get(rowIndex).setQuantity(product.getQuantity());
//			break;
//		}
//	}
