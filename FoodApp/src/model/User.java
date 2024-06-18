package model;

public class User {
	
	private static String name;
	private String password;
	private static double total_money;
	private int purchased_products = 0;

	public User(String name, String password, double total_money)
	{
		this.name = name;
		this.password = password;
		this.total_money= total_money;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getTotalMoney() {
		return total_money;
	}

	public void setTotalMoney(double total_money) {
		this.total_money = total_money;
	}
	
	public int getPurchasedProducts() {
		return purchased_products;
	}
	
	public void setPurchasedProducts(int purchased_products) {
		this.purchased_products = purchased_products;
	}
	

}
