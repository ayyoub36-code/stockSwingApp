package fr.fms.entities;

public class Product {

	// Attributs
	private int id;
	private String description;
	private String brand;
	private String category;
	private double price;
	private String quantity;
	

	// Construteur
	public Product(int id, String description, String brand, double price,String category, String quantity) {
		super();
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.category = category;
		this.price = price;
		this.quantity = quantity;
		
	}


	


	public Product(String description, String brand, double price,String category, String quantity) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}


	// Getters and Setters
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}


	public double getPrice() {
		return price;
	}


	public void setPrice(double price) {
		this.price = price;
	}


	public String getQuantity() {
		return quantity;
	}


	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	
	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}
	// Methode ToString()


	@Override
	public String toString() {
		return "Product [id=" + id + ", description=" + description + ", brand=" + brand + ", category=" + category
				+ ", price=" + price + ", quantity=" + quantity + "]";
	}
	
	
}
