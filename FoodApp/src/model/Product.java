package model;

import java.time.LocalDate;

public class Product {
	
	private String code;
	private String name;
	private LocalDate due_date;
	private int quantity;
	private double price;
	
	public Product(String code, String name, LocalDate due_date, int quantity, double price)
	{
		this.code  = code;
		this.name = name;
		this.due_date  = due_date;
		this.quantity = quantity;
		this.price = price;
		
	}

	public String  getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getDueDate() {
		return due_date;
	}

	public void setDueDate(LocalDate due_date) {
		this.due_date = due_date;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	   @Override
	    public String toString() {
	        return "Product{" +
	                "name='" + name + '\'' +
	                ", code='" + code + '\'' +
	                ", dueDate=" + due_date +
	                ", quantity=" + quantity +
	                ", price=" + price +
	                '}';
	    }
}
