package fr.ldnr.mvc;

import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import fr.ldnr.bdd.ProductDao;
import fr.ldnr.entities.Product;

public class Model extends AbstractTableModel { 		//Nous avons ici l'ensemble des caractéristiques d'exploitation de notre JTable
	private static final long serialVersionUID = 1L;
	private ProductDao productDao;
	private String[] columnName = new String[] {"ID","DESCRIPTION","BRAND", "PRICE", "CATEGORY", "QUANTITY"};
	private Vector<String[]> rows = new Vector<String[]>();		

	public Model() {		
		productDao = new ProductDao();		
	}

	@Override
	public int getRowCount() {
		return rows.size();
	}

	@Override
	public int getColumnCount() {
		return columnName.length;
	}
	
	@Override
	public String getColumnName(int column) {
		return columnName[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {		
		return rows.elementAt(rowIndex)[columnIndex];
	}
	
	public void loadData() {
		List<Product> list = productDao.readAll();
		if(rows != null) 	rows.clear();
		for(Product p : list) {	//pour chaque produit p de la liste de produits, on ajoute ses infos dans le vecteur
			rows.add(new String[] {
					  String.valueOf(p.getId()), p.getDescription(), p.getBrand(), String.valueOf(p.getPrice()), p.getCategory(), String.valueOf(p.getQuantity())
					  });
		}		
	}
	
	public boolean addProduct(Product p) {
		return productDao.create(p);
	}
	
	/*public List<Product> listProducts() {
		List<Product> list = job.getProducts();
		for(Product prod : list) {
			System.out.println(prod.getId() + " - " + prod.getName() + " - " + prod.getDescription() + " - " + prod.getPrice() + " - " + prod.getQuantity());
		}
		return list;
	}*/
}
