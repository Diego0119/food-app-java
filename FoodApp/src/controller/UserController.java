package controller;
import model.User;
import controller.StoreController;

public class UserController {
	 
	private User user;
	private StoreController storeController;
				
	public UserController(User user, StoreController storeController) {
		this.user = user;
		this.storeController = storeController;
		
	}
	
	public void buyProduct(double price) {
	
		double total_money = user.getTotalMoney();
		
		if(total_money < price) {
			System.out.println("El usuario no tiene el dinero suficiente");
		}
		else {
			double new_money = total_money - price;
			user.setTotalMoney(new_money);
		}
		storeController.plusPurchasedProduct();
		storeController.setProfits(price);
		
	}
	
	public int getPurchasedProducts() {
		return user.getPurchasedProducts();
	}
	
	
}
