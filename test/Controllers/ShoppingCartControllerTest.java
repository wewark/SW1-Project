package Controllers;

import Models.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.*;

public class ShoppingCartControllerTest {
	private PhysicalStoreProduct testProduct = new PhysicalStoreProduct(
			new PhysicalProduct(),
			15,
			new PhysicalStore(
					"storeName",
					"storeAddress",
					new StoreOwner(new HashMap<>())
			)
	);

	@BeforeClass
	public void beforeClass() {
		System.out.println("Testing ShoppingCart Controller:");
	}

	@Test
	public void testAddToCart() throws Exception {
		System.out.println("Testing add to cart...");
		ShoppingCartController testShoppingCartController = new ShoppingCartController(
				new ShoppingCart()
		);
		testShoppingCartController.addToCart(testProduct, 5);
		boolean found = false;
		for (Order order : testShoppingCartController.shoppingCart.orders)
			if (order.product == testProduct && order.quantity == 5)
				found = true;
		assertEquals(found, true);
	}

	@Test
	public void testClearCart() throws Exception {
		System.out.println("Testing clear cart...");
		ShoppingCartController testShoppingCartController = new ShoppingCartController(
				new ShoppingCart()
		);
		testShoppingCartController.addToCart(testProduct, 5);
		testShoppingCartController.clearCart();
		assertEquals(testShoppingCartController.shoppingCart.orders.isEmpty(), true);
	}
}