package Controllers;

import Models.Platform;
import Models.Session;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.HashMap;

import static org.testng.Assert.assertEquals;

public class UserControllerTest {
	private HashMap<String, String> userData = new HashMap<>();

	@BeforeMethod
	public void setUp() throws Exception {
		Platform.Users.clear();
		userData.put("type", "User");
		userData.put("name", "khaled");
		userData.put("username", "wewarkUser");
		userData.put("passwordHash", "khaled");
	}

	@Test
	public void testRegister() throws Exception {
		assertEquals(UserController.register(userData), true);
		assertEquals(UserController.login(userData.get("username"), userData.get("passwordHash")), true);
	}

	@Test
	public void testLogin() throws Exception {
		assertEquals(UserController.register(userData), true);
		assertEquals(UserController.login(userData.get("username"), userData.get("passwordHash")), true);
		assertEquals(Session.IsLoggedIn(), true);
	}

	@Test
	public void testLogout() throws Exception {
		assertEquals(UserController.register(userData), true);
		assertEquals(UserController.login(userData.get("username"), userData.get("passwordHash")), true);
		assertEquals(Session.IsLoggedIn(), true);
		UserController.logout();
		assertEquals(Session.IsLoggedIn(), false);
	}
}