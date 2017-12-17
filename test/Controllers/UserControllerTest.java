package Controllers;

import Models.Session;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class UserControllerTest {

	@Test
	public void testRegisterUser() throws Exception {
		HashMap<String, String> userData = new HashMap<>();
		userData.put("type", "Admin");
		userData.put("name", "khaled");
		userData.put("username", "wewarkUser");
		userData.put("passwordHash", "khaled");
		assertEquals(UserController.register(userData), true);
		assertEquals(UserController.login(userData.get("username"), userData.get("passwordHash")), true);
		assertEquals(Session.IsLoggedIn(), true);
		UserController.logout();
		assertEquals(Session.IsLoggedIn(), false);
	}

	@Test
	public void testRegisterStoreOwner() throws Exception {
		HashMap<String, String> userData = new HashMap<>();
		userData.put("type", "Admin");
		userData.put("name", "khaled");
		userData.put("username", "wewarkStoreOwner");
		userData.put("passwordHash", "khaled");
		assertEquals(UserController.register(userData), true);
		assertEquals(UserController.login(userData.get("username"), userData.get("passwordHash")), true);
		assertEquals(Session.IsLoggedIn(), true);
		UserController.logout();
		assertEquals(Session.IsLoggedIn(), false);
	}

	@Test
	public void testRegisterAdmin() throws Exception {
		HashMap<String, String> userData = new HashMap<>();
		userData.put("type", "Admin");
		userData.put("name", "khaled");
		userData.put("username", "wewarkAdmin");
		userData.put("passwordHash", "khaled");
		assertEquals(UserController.register(userData), true);
		assertEquals(UserController.login(userData.get("username"), userData.get("passwordHash")), true);
		assertEquals(Session.IsLoggedIn(), true);
		UserController.logout();
		assertEquals(Session.IsLoggedIn(), false);
	}
}