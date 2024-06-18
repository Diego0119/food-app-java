package controller;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Product;


public class StoreController {
	
	private List<Product> products;
	private static StoreController instance = null;
	private int count_of_purchased_products = 0;
	private double profits=0;
	
	private StoreController() {
		this.products = new ArrayList<>();
	}
	
	public static StoreController getInstance() {
		if(instance == null) {
			instance = new StoreController();
		}
		return instance;
	}
	
	public void addProduct(String name, String code, LocalDate due_date, int quantity, double price )
	{
		Product product = new Product(name,code,due_date,quantity,price);
		this.products.add(product);
		System.out.println("Producto guardado: " + product);
		System.out.println("Lista de productos: " + products);
		
	}
	
	public List<Product> getProducts(){
		return products;
	}
	
	public int getNumberOfProducts() {
		return products.size();
	}
	
	public void plusPurchasedProduct() {
		count_of_purchased_products++;
	}

	public int getCountOfPurchasedProducts() {
		return count_of_purchased_products;
	}

	public void setCountOfPurchasedProducts(int count_of_purchased_products) {
		this.count_of_purchased_products = count_of_purchased_products;
	}

	public double getProfits() {
		return profits;
	}

	public void setProfits(double profits) {
		this.profits += profits;
	}
	

}
