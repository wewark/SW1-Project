//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : ShoppingCart.java
//  @ Date : 14/12/2017
//  @ Author : 
//
//



package Models;


import java.io.Serializable;
import java.util.ArrayList;

public class ShoppingCart implements Serializable {
	public String userID;
	public ArrayList<Order> orders = new ArrayList<>();
	public boolean addOrder(StoreProduct product, int Quantity) {
		orders.add(new Order(product, Quantity));
		return true;
	}

	//Console Function
	public void printOrders()
	{
		int i = 0;
		System.out.println("-------Orders-------");
		for (Order order : orders ) {
			System.out.println(	++i
								+ ".\t Name: \t" + order.product.product.name
								+ ".\t Store:\t" + order.product.product.name
								+ ".\t Price:\t" + order.product.price
								+ ".\t Quantity:\t" + order.quantity + " Unit."
			);
		}
	}

	public int calculateSum()
	{
		int sum = 0;
		for (Order order : orders ) {
			sum += order.product.price * order.quantity;
		}
		return sum;
	}

	public int calculateSumPromotion(PromotionCard promotion) {
		if (promotion instanceof StorePromotion) {
			int sum = 0;
			for (Order order : orders) {
				if (((StorePromotion)promotion).store == order.product.store) {
					double total = order.product.price * order.quantity;
					double offValue = total * (promotion.offPercentage / (double) 100);
					offValue = Math.min(offValue, promotion.offMax);
					sum += total - offValue;
				} else
					sum += order.product.price * order.quantity;
			}
			return sum;
		} else {
			int sum = 0;
			for (Order order : orders) {
					double total = order.product.price * order.quantity;
					double offValue = total * (promotion.offPercentage / (double) 100);
					offValue = Math.min(offValue, promotion.offMax);
					sum += total - offValue;
			}
			return sum;
		}
	}
}
