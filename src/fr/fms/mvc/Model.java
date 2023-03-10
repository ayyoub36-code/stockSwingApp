package fr.fms.mvc;

import java.util.ArrayList;

import javax.swing.table.AbstractTableModel;

import fr.fms.bdd.ProductDao;
import fr.fms.entities.Product;

public class Model extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private static final int COL_ID = 0;
	private static final int COL_DESCRIPTION = 1;
	private static final int COL_BRAND = 2;
	private static final int COL_PRICE = 3;
	private static final int COL_CATEGORY = 4;
	private static final int COL_QUANTITY = 5;
	private ArrayList<Product> products = new ProductDao().readAll();

	public Model(Product... products) {
		this.setValueAt(products, getRowCount(), getColumnCount());
		// this.products.addAll(Arrays.asList(products));
		System.out.println("model");
	}

	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case COL_ID:
			return "ID";
		case COL_DESCRIPTION:
			return "Description";
		case COL_BRAND:
			return "Brand";
		case COL_PRICE:
			return "Price";
		case COL_CATEGORY:
			return "Category";
		case COL_QUANTITY:
			return "Quantity";
		default:
			return "";
		}
	}

	@Override
	public void setValueAt(Object product, int rowIndex, int columnIndex) {

		switch (columnIndex) {
		case COL_ID:
			products.get(rowIndex).setId(((Product) product).getId());
			System.out.println("id");
			break;
		case COL_DESCRIPTION:
			products.get(rowIndex).setDescription(((Product) product).getDescription());
			System.out.println("description");
			break;
		case COL_BRAND:
			products.get(rowIndex).setBrand((((Product) product).getBrand()));
			break;
		case COL_PRICE:
			products.get(rowIndex).setPrice((((Product) product).getPrice()));
			break;
		case COL_CATEGORY:
			products.get(rowIndex).setCategory((((Product) product).getCategory()));
			break;
		case COL_QUANTITY:
			products.get(rowIndex).setQuantity((((Product) product).getQuantity()));
			break;
		}

	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public int getColumnCount() {
		return 6;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case COL_ID:
			return products.get(rowIndex).getId();
		case COL_DESCRIPTION:
			return products.get(rowIndex).getDescription();
		case COL_BRAND:
			return products.get(rowIndex).getBrand();
		case COL_PRICE:
			return products.get(rowIndex).getPrice();
		case COL_CATEGORY:
			return products.get(rowIndex).getCategory();
		case COL_QUANTITY:
			return products.get(rowIndex).getQuantity();
		default:
			return "";
		}
	}

}
