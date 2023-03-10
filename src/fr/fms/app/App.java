package fr.fms.app;

import fr.fms.bdd.Dao;
import fr.fms.bdd.ProductDao;
import fr.fms.entities.Product;
import fr.fms.mvc.View;

public class App {

	public static void main(String[] args) {
		// TODO view JButton + JTable(model) ayyoub
		// TODO controller actionListner => event (view) françois + benoit
		// TODO model data bd => dao for remplir le tableau aurore + guillaume

		Dao<Product> dao = new ProductDao();
		dao.readAll().forEach(e -> System.out.println(e));
		new View();

		
	}
}