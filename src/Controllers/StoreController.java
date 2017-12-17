//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : StoreController.java
//  @ Date : 14/12/2017
//  @ Author : 
//
//

package Controllers;

import Models.Store;
import Models.StoreOwner;
import Models.StoreProduct;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StoreController {
	public Models.Store store;

	public StoreController(Store store) {
		this.store = store;
	}

	public StoreController() {

	}

	public static boolean addStore(Store store, StoreOwner storeOwner) {
		if (Store.exists(store)) {
			System.out.println("Store already exists");
			return false;
		}

		Store.addtoDB(store);
		storeOwner.addStore(store);
		return true;
	}

	//Console Version Functions
	public StoreProduct chooseStoreProducts() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		if (store.products.size() > 0) {
			for (StoreProduct product : store.products) {
				System.out.println(++i + ".\t " + product.detailsString());
			}
			System.out.print("Choose Product: ");
			while ((i = sc.nextInt()) < 1 || i > store.products.size())
				System.out.print("Invalid Input");

			return store.products.get(i - 1);
		} else return null;
	}

	//Print Views for Store Owners
	public StoreProduct chooseStoreProductsViews() {
		Scanner sc = new Scanner(System.in);
		int i = 0;
		List<StoreProduct> sortedProducts = new ArrayList<>(store.products);
		sortedProducts.sort(Comparator.comparingDouble(StoreProduct::getView).reversed());    //TODO Test Sorting
		if (sortedProducts.size() > 0) {
			for (StoreProduct product : store.products) {
				System.out.println(++i + ".\t" + product.view + " Views | " + product.detailsString());
			}
			System.out.print("Choose Product: ");
			while ((i = sc.nextInt()) < 1 || i > store.products.size())
				System.out.print("Invalid Input");
			return store.products.get(i - 1);
		} else return null;
	}

}
