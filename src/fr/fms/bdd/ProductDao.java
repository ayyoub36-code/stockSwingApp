package fr.fms.bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import fr.fms.entities.Product;


public class ProductDao implements Dao<Product>{
	private ArrayList<Product> products = new ArrayList<>();
	public ArrayList<Product> readAll(){
		String strSql = "SELECT * FROM T_Articles ";
		try(PreparedStatement ps = connection.prepareStatement(strSql)){
			ResultSet resultSet = ps.executeQuery();
			while(resultSet.next()) {
				int rsId = resultSet.getInt(1);	
				String rsDescription = resultSet.getString(2);
				String rsBrand = resultSet.getString(3);
				double rsPrice = resultSet.getDouble(4);
				String rsCategory = resultSet.getString(5);
				String rsQuantity = resultSet.getString(6);
				products.add((new Product(rsId,rsDescription,rsBrand,rsPrice,rsCategory,rsQuantity)));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}
}
