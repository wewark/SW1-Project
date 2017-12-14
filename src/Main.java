import Controllers.UserController;
import Models.ShoppingCart;
import Models.User;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static UserController user = new UserController();
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		loginOrSignup();

	}

	private static void loginOrSignup() {
		System.out.println("1. Login\n" +
				"2. Signup");
		int x = Integer.parseInt(sc.nextLine());
		if (x == 1) {
			while (true) {
				System.out.print("name: ");
				String username = sc.nextLine();
				System.out.print("password: ");
				String password = sc.nextLine();
				if (user.login(username, password)) break;
				System.out.println("Wrong username or password");
			}
			System.out.println("Logged in");
		}
		else {
			while (true) {
				HashMap<String, String> userData = new HashMap<>();
				System.out.print("name: ");
				userData.put("name", sc.nextLine());
				System.out.print("username: ");
				userData.put("username", sc.nextLine());
				System.out.print("password: ");
				userData.put("passwordHash", sc.nextLine());

				if (user.register(userData)) break;
				System.out.println("user exists");
			}
			System.out.println("User added");
		}
	}
}
