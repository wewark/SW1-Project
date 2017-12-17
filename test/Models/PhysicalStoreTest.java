package Models;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.*;

public class PhysicalStoreTest {
	private PhysicalStore testPhysicalStore = new PhysicalStore(
			"storeName",
			"storeAddress",
			new StoreOwner(new HashMap<>())
	);
	private PhysicalProduct testPhysicalProduct = new PhysicalProduct(
			"productName",
			"productBrand",
			"productCompany",
			15.3,
			3.1415
	);
	private PhysicalStoreProduct testProduct = new PhysicalStoreProduct(
			testPhysicalProduct,
			(float) 15.3,
			testPhysicalStore
	);

	@BeforeClass
	public void beforeClass() {
		System.out.println("Testing Physical Store:");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		Platform.Stores.clear();
	}

	@Test
	public void testAddProduct() throws Exception {
		System.out.println("Testing add product...");
		testPhysicalStore.addProduct(testPhysicalProduct, (float) 15.3);
		boolean found = false;
		for (StoreProduct product : testPhysicalStore.products)
			if (product.product.name.equals(testProduct.product.name) &&
					product.product.price == testProduct.product.price)
				found = true;
		assertEquals(found, true);
	}

	@Test
	public void testAddtoDB() throws Exception {
		System.out.println("Testing add store to DB");
		PhysicalStore.addtoDB(testPhysicalStore);
		assertNotEquals(Platform.Stores.indexOf(testPhysicalStore), -1);
	}

	@Test
	public void testExists() throws Exception {
		System.out.println("Testing store exists...");
		assertEquals(PhysicalStore.exists(testPhysicalStore), false);
		PhysicalStore.addtoDB(testPhysicalStore);
		assertEquals(PhysicalStore.exists(testPhysicalStore), true);
	}
}