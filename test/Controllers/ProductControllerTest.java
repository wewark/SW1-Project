package Controllers;

import Models.PhysicalProduct;
import Models.Platform;
import Models.Product;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ProductControllerTest {
	private PhysicalProduct exampleProduct = new PhysicalProduct(
			"productName",
			"productBrand",
			"productCompany",
			15.6,
			3.1415
	);

	@BeforeClass
	public void beforeClass() {
		System.out.println("Testing Product Controller:");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		Platform.Products.clear();
		Platform.SuggestedProducts.clear();
	}

	@Test
	public void testAddProduct() throws Exception {
		System.out.println("Testing add product...");
		ProductController.addProduct(exampleProduct);
		assertNotEquals(Platform.Products.indexOf(exampleProduct), -1);
	}

	@Test
	public void testGetProduct() throws Exception {
		System.out.println("Testing get product...");
		ProductController.addProduct(exampleProduct);
		Product result = Product.getProduct(exampleProduct.name);
		assertEquals(result, exampleProduct);
	}

	@Test
	public void testAddSuggestedProduct() throws Exception {
		System.out.println("Testing add suggested product...");
		ProductController.addSuggestedProduct(exampleProduct);
		assertNotEquals(Platform.SuggestedProducts.indexOf(exampleProduct), -1);
	}

	@Test
	public void testDeleteSuggestedProduct() throws Exception {
		System.out.println("Testing delete suggested product...");
		ProductController.addSuggestedProduct(exampleProduct);
		ProductController.deleteSuggestedProduct(exampleProduct);
		assertEquals(Platform.SuggestedProducts.indexOf(exampleProduct), -1);
	}
}