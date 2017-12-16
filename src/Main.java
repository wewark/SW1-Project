import Controllers.ProductController;
import Controllers.ShoppingCartController;
import Controllers.StoreController;
import Controllers.UserController;
import Models.*;

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
        println("-------User Dashboard-------");
        //User Functions go here
        print(  "\t1. Browse Store Products\n" +
                "\t2. Suggest Product\n" +
                "\t0. Back\n");

        int userChoice = sc.nextInt();
        sc.nextLine();
        if (userChoice == 1)
            browseStoresProducts();
        else if(userChoice == 2)
            suggestProduct();
        else return;
    }

    private static void StoreOwnerMain() {
    	while (true) {
		    println("-------Store-Owner Dashboard-------");
		    //StoreOwner Functions go here
		    print(  "\t1. Add store\n" +
                    "\t2. Browse Store's Products with Views\n" +
                    "\t3. Suggest Product\n" +
                    "\t0. Back\n");

		    int userChoice = sc.nextInt(); sc.nextLine();
		    if (userChoice == 1)
			    storeOwnerAddStore();
		    else if(userChoice == 2)
		        browseStoresProductsWithViews();
		    else if(userChoice == 3)
		        suggestProduct();
		    else return;
	    }
    }

    private static void AdminMain() {
    	while (true) {
		    println("-------Admin Dashboard-------");
		    //Admin Functions goes here
		    print(  "\t1. Add Product\n" +
                    "\t2. Add Suggested Product\n" +
                    "\t0. Back\n");

		    int userChoice = sc.nextInt(); sc.nextLine();
		    if (userChoice == 1)
		    	adminAddProduct();
		    else if(userChoice == 2)
                browseSuggestedProducts();
		    else return;
	    }
    }

    public static void println(String string) {
        System.out.println(string);
    }
    public static void print(String string) {
        System.out.print(string);
    }

    /*
     * User Functions
     */
    public static void browseStoresProducts()
    {
        StoreController storeController = new StoreController(StoreController.chooseStores());
        if(storeController.store == null)
            System.out.println("No Stores Available.");
        else
        {
            StoreProduct storeProduct = storeController.chooseStoreProducts();
            if(storeProduct == null) {
                System.out.println("Store is Empty.");
            }
            else {
                storeProduct.viewAndPrintDetails();
                System.out.println("1. Yes, 2. No \n Want to Buy ? ");
                int choice = sc.nextInt();
                if(choice == 1) {
                    System.out.print("Quantity : ");
                    new ShoppingCartController(Session.User.shoppingCart)
                            .addToCart(storeProduct, sc.nextInt());
                    println("Added to Shopping Cart!");
                }
            }
        }
    }

    /*
     * Store Owner Functions
     */
    public static void browseStoresProductsWithViews()
    {
        StoreController storeController = new StoreController(StoreController.chooseStores());
        if(storeController.store == null)
            System.out.println("No Stores Available.");
        else
        {
            StoreProduct storeProduct = storeController.chooseStoreProductsViews();
            if(storeProduct == null) {
                System.out.println("Store is Empty.");
            }
            else {
                storeProduct.viewAndPrintDetails();
                System.out.println("1. Yes, 2. No \n Want to Buy ? ");
                int choice = sc.nextInt();
                if(choice == 1) {
                    System.out.print("Quantity : ");
                    new ShoppingCartController(Session.User.shoppingCart)
                            .addToCart(storeProduct, sc.nextInt());
                    println("Added to Shopping Cart!");
                }
            }
        }
    }

    static void storeOwnerAddStore() {
    	StoreController storeController = new StoreController();
    	Store store;
	    println("\t1. Virtual Store\n" +
			    "\t2. Physical Store");
	    int userChoice = sc.nextInt(); sc.nextLine();

	    println("Store Name: ");
	    String storeName = sc.nextLine();
	    if (userChoice == 1)
		    store = new VirtualStore(storeName, (StoreOwner) Session.User);
	    else {
		    System.out.println("Address: ");
		    String address = sc.nextLine();
		    store = new PhysicalStore(storeName, address, (StoreOwner) Session.User);
	    }

	    StoreController.addStore(store, (StoreOwner) Session.User);
	    println("Store added successfully");
    }

	/*
	 * Admin Functions
	 */
	static void adminAddProduct() {
		Product product;
		println("\t1. Virtual Product\n" +
				"\t2. Physical Product");
		int userChoice = sc.nextInt(); sc.nextLine();
		if (userChoice == 1)
			product = new VirtualProduct();
		else
			product = new PhysicalProduct();


		// TODO: input product info
		ProductController.addProduct(product);
		// printing already done inside addProduct
	}


    public static void browseSuggestedProducts()
    {
        Product suggestedProduct = ProductController.ChooseSuggestedProduct();
        if(suggestedProduct == null) {
            System.out.println("No Suggested Products.");
        }
        else {
            System.out.println(suggestedProduct.viewDetails() + "\n" +
                    "\t1. Yes\n" +
                    "\t2. No \n" +
                    "\tWant to Add ? ");
            int choice = sc.nextInt();
            if(choice == 1) {
                ProductController.addProduct(suggestedProduct);
                ProductController.deleteSuggestedProduct(suggestedProduct);
                println("Added to Shopping Cart!");
            }
        }
    }

    //User & Store Owner Functions
    public static void suggestProduct()
    {
        Product product;
        println("\t1. Virtual Product\n" +
                "\t2. Physical Product");

        int userChoice = sc.nextInt();
        if (userChoice == 1)
            product = new VirtualProduct();
        else
            product = new PhysicalProduct();

        product.takeInput();    //Fill (Console Output Inside)

        if (ProductController.addSuggestedProduct(product))
            println("Added to Suggested, Admins will review suggestions soon!");

    }
}
