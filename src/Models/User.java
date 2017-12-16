package Models;

import java.util.HashMap;

public class User {
	public static int nextID = 0;
	public int ID;
	public String name;
	public String username;
	public String birthDate;
	public String passwordHash;
	public Address address;
	public CCInfo CCInfo;
	public ShoppingCart shoppingCart;
	public User(HashMap<String, String> userData) {

	}

	public User() {

	}

	/**
	 * @param user user to be added to DB
	 */
	public static void addUser(User user) {
		user.ID = nextID++;		//TODO get latest ID from DB if we're saving data.
		Platform.users.add(user);
	}

	public User(String name, String username, String birthDate, String passwordHash, Address address, CCInfo CCInfo) {
		this.name = name;
		this.username = username;
		this.birthDate = birthDate;
		this.passwordHash = passwordHash;
		this.address = address;
		this.CCInfo = CCInfo;
		this.shoppingCart = new ShoppingCart();
	}

	/**
	 * @param username username to check
	 * @return true if exists
	 */
	public static boolean exists(String username) {
		for (User user : Platform.users)
			if (user.username.equals(username))
				return true;
		return false;
	}

	public static User getUser(String username) {
		for (User user : Platform.users)
			if (user.username.equals(username))
				return user;
		return new User();
	}
}
