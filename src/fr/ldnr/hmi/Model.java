package fr.ldnr.hmi;

import fr.ldnr.bdd.ProductDao;
import fr.ldnr.entities.Product;

public class Model { 		
	private ProductDao productDao;
	private String products = "";

	public Model() {		
		productDao = new ProductDao();		
	}

	public void loadData() {
		products = "";
		for(Product p : productDao.readAll()) {
			products += p + "\n";
		}
	}

	public String getProducts() {
		return products;
	}

	public void setProducts(String products) {
		this.products = products;
	}	
}
