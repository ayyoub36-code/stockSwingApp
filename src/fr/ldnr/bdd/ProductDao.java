/**
 * Explications ici
 * 
 * @author El babili - 2021
 * 
 */

package fr.ldnr.bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.ldnr.entities.Product;

public class ProductDao implements Dao<Product> {

	@Override
	public boolean create(Product obj) {
		String str = "INSERT INTO T_Products (Description, Brand, UnitaryPrice, Category, Quantity) VALUES (?,?,?,?,?);";	
		try (PreparedStatement ps = connection.prepareStatement(str)){
			ps.setString(1, obj.getDescription());
			ps.setString(2, obj.getBrand());
			ps.setDouble(3, obj.getPrice());	
			ps.setString(4, obj.getCategory());
			ps.setInt(5, obj.getQuantity());
			if( ps.executeUpdate() == 1)	return true;
		} catch (SQLException e) {
			e.printStackTrace();
		} 	
		return false;
		
	}

	@Override
	public Product read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean update(Product obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product obj) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Product> readAll() {
		ArrayList<Product> articles = new ArrayList<Product>();
		String strSql = "SELECT * FROM T_Products";		
		try(Statement statement = connection.createStatement()){
			try(ResultSet resultSet = statement.executeQuery(strSql)){ 			
				while(resultSet.next()) {
					int rsId = resultSet.getInt(1);	
					String rsDescription = resultSet.getString(2);
					String rsBrand = resultSet.getString(3);
					double rsPrice = resultSet.getDouble(4);	
					String rsCat = resultSet.getString(5);
					int rsQty = resultSet.getInt(6);
					articles.add((new Product(rsId,rsDescription,rsBrand,rsPrice,rsCat,rsQty)));						
				}	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}			
		return articles;
	}

}
