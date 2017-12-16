//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : StoreProduct.java
//  @ Date : 14/12/2017
//  @ Author : 
//
//



package Models;


public abstract class StoreProduct {
	public double price;
	public Product product;
	public StoreProduct(float price) {
		this.price = price;
	}
	public  String detailsString(){
		return "Name: \t" + product.name +  "Price: \t " + price;
	}
	public  String viewDetails(){
		product.view++;
		return "Name: \t" + product.name + " Brand: \t " + product.brand +  " Company: \t " + product.company +  "Price: \t " + price;
	}

	//Console Function
	public void viewAndPrintDetails(){
		System.out.println(viewDetails());
	}
}
