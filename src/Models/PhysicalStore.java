//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : PhysicalStore.java
//  @ Date : 14/12/2017
//  @ Author : 
//
//



package Models;


import java.util.ArrayList;

	public class PhysicalStore extends Store {
		public ArrayList<PhysicalStoreProduct> products;
		public String address;

		@Override
		public boolean addProduct(Product product, float Price) {
			products.add(new PhysicalStoreProduct(Price, product));
			return false;
		}
	}
