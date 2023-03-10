package fr.ldnr.entities;

public class Product {
	private int id;
	private String description;
	private String brand;
	private double price;
	private String category;
	private int quantity;
	
	public Product(int id, String description, String brand, double price, String category, int quantity) {
		super();
		this.id = id;
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	public Product(String description, String brand, double price, String category, int quantity) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}
	
	public Product(String description, String brand, double price) {
		super();
		this.description = description;
		this.brand = brand;
		this.price = price;
	}
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return  id + "\t" + description + "\t" + brand + "\t" + price + "\t" + category + "\t" + quantity;
	}
	
}
