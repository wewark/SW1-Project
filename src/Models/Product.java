//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Product.java
//  @ Date : 14/12/2017
//  @ Author :
//
//

package Models;
import java.util.Scanner;


import java.io.Serializable;

public class Product implements Serializable{
	public static int nextID = 0;
	public String ID;
	public String name;
	public String brand;
	public String company;
	public double price;
public int views = 0;//	public DateTime date;
	public int view = 0;

	public Product() {

	}
	public static boolean addToDB(Product product) {
		product.ID = String.valueOf(nextID++);		//TODO get latest ID from DB if we're saving data.
		Platform.Products.add(product);
		return true;
	}

	public static boolean addToSuggestedDB(Product product) {
		product.ID = String.valueOf(nextID++);        //TODO get latest ID from DB if we're saving data.
		Platform.SuggestedProducts.add(product);
		return true;
	}

	public static boolean deleteSuggestedDB(Product product) {
		return Platform.SuggestedProducts.remove(product);
	}

	public static boolean exists(Product product) {
		return Platform.Products.indexOf(product) != -1;
	}

	public static boolean existsSuggested(Product product) {
		return Platform.SuggestedProducts.indexOf(product) != -1;
	}

	public Product(String name, String brand, String company, double price) {
		this.name = name;
		this.brand = brand;
		this.company = company;
		this.price = price;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null ||
				!Product.class.isAssignableFrom(obj.getClass()))
			return false;

		Product other = (Product) obj;
		return name.equals(other.name) &&
				brand.equals(other.brand) &&
				company.equals(other.company);
	}

	public String viewDetails(){
		view++;
		return "Name: " + name + "\t Brand: " + brand +  "\t Company: " + company +  "\t Avg. Price: " + price;
	}

	//Console Function
	public void takeInput(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter New Product Data: ");
		System.out.print("Name: ");		name = sc.next();
		System.out.print("Brand: ");	brand = sc.next();
		System.out.print("Company: ");	company = sc.next();
		System.out.print("Avg. Price: ");	price = sc.nextFloat();
	}

	public static Product getProduct(String name) {
		for (Product product : Platform.Products)
			if (product.name.equals(name))
				return product;
		return null;
	}
}
