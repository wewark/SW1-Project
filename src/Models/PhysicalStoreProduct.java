//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : PhysicalStoreProduct.java
//  @ Date : 14/12/2017
//  @ Author : 
//
//



package Models;


public class PhysicalStoreProduct extends StoreProduct {
    public Product product;

    public PhysicalStoreProduct(float price, Product product) {
        super(price);
        this.product = product;
    }
}
