package Controllers;

import Models.PhysicalStore;
import Models.Platform;
import Models.Store;
import Models.StoreOwner;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.*;

public class StoreControllerTest {
	private HashMap<String, String> userData = new HashMap<>();
	private StoreOwner testStoreOwner = new StoreOwner(userData);
	private PhysicalStore testStore = new PhysicalStore(
			"storeName",
			"storeAddress",
			testStoreOwner
	);

	@BeforeClass
	public void beforeClass() {
		System.out.println("Testing Store Controller:");
	}

	@BeforeMethod
	public void setUp() throws Exception {
		Platform.Stores.clear();
	}

	@Test
	public void testAddStore() throws Exception {
		System.out.println("Testing add store...");
		StoreController.addStore(testStore, testStoreOwner);
		assertNotEquals(Platform.Stores.indexOf(testStore), -1);
	}
}