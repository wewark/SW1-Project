import Controllers.UserController;
import Models.ShoppingCart;
import Models.User;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int userChoice;
        while (true) {
            print("1. Login\n" +
                    "2. Signup\n" +
                    "3. Exit"
            );
            userChoice = sc.nextInt();
            if (userChoice == 1) {
                login();
                loggedInMain();
            } else if (userChoice == 2)
                signUp();
            else if (userChoice == 3)
                break;
            else
                print("Invalid Option");
        }
    }

    private static void login() {
        while (true) {
            System.out.print("Username: ");
            String username = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            if (UserController.login(username, password)) break;
            System.out.println("Wrong username or password");
        }
        System.out.println("Logged in");
    }

    private static void signUp() {
        while (true) {
            HashMap<String, String> userData = new HashMap<>();
            System.out.print("Name: ");
            userData.put("name", sc.nextLine());
            System.out.print("Username: ");
            userData.put("username", sc.nextLine());
            System.out.print("Password: ");
            userData.put("passwordHash", sc.nextLine());
            if (UserController.register(userData)) break;
            System.out.println("user exists");
        }
        System.out.println("User added");
    }

    private static void loggedInMain() {
        //CODE FOR PROGRAM
    }

    public static void print(String string) {
        System.out.println(string);
    }
}
