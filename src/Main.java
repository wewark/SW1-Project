import Controllers.UserController;
import Models.Admin;
import Models.Session;
import Models.StoreOwner;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int userChoice;
        while (true) {
            println("1. Login\n" +
                    "2. Signup\n" +
                    "3. Exit"
            );
            userChoice = sc.nextInt();
            if (userChoice == 1) {
                if(login())
                    loggedInMain();
            } else if (userChoice == 2)
                signUp();
            else if (userChoice == 3)
                break;
            else
                println("Invalid Option");
        }
    }

    private static boolean login() {
            print("Username: ");
            String username = sc.next();
            print("Password: ");
            String password = sc.next();
            if (UserController.login(username, password))
                return true;
            println("Wrong username or password");
            return false;
    }

    private static void signUp() {
        while (true) {
            HashMap<String, String> userData = new HashMap<>();
            print("Type: \"User\", \"StoreOwner\", \"Admin\" ? : ");
            userData.put("type", sc.next());        sc.nextLine(); //<-- Escape \n for the next nextLine();
            print("Name: ");
            userData.put("name", sc.nextLine());
            print("Username: ");
            userData.put("username", sc.next());     sc.nextLine(); //<-- Escape \n for the next nextLine();
            print("Password: ");
            userData.put("passwordHash", sc.nextLine());
            if (UserController.register(userData))
                break;
            println("User Exists, Or Type Doesn't Exist");  //Best error evahr
        }
        System.out.println("User added");
    }

    private static void loggedInMain() {
        //CODE FOR PROGRAM
        if(!Session.IsLoggedIn())
            return;
        ////////////////////

        int userChoice;
        println("Welcome, " + Session.User.name + "!.");
        while (true)
        {
                println("1. User Dashboard");
            if(Session.User instanceof Admin)
                println("2. Admin Dashboard");
            else if(Session.User instanceof StoreOwner)
                println("2. Store-Owner Dashboard");
            println("0. Logout");
            print("Enter Choice: ");
            userChoice = sc.nextInt();
            if(userChoice == 1)
                UserMain();
            else if(userChoice == 2 && Session.User instanceof Admin)
                AdminMain();
            else if(userChoice == 2 && Session.User instanceof StoreOwner)
                StoreOwnerMain();
            else if(userChoice == 0) {
                UserController.logout();
                break;
            }
            else println("Invalid Option");
        }
    }

    private static void UserMain() {

    }

    private static void StoreOwnerMain() {

    }

    private static void AdminMain() {

    }

    public static void println(String string) {
        System.out.println(string);
    }
    public static void print(String string) {
        System.out.print(string);
    }
}
