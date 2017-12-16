package Models;


import javax.print.DocFlavor;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Platform {
	public static ArrayList<User> Users = new ArrayList<>();
	public static ArrayList<Product> Products = new ArrayList<>();
	public static ArrayList<Product> AppliedProducts = new ArrayList<>();
	public static ArrayList<Store> AppliedStores = new ArrayList<>();
	public static ArrayList<PromotionCard> PromoCards = new ArrayList<>();
    public static void Initialize() {
		//Output File Names
		String outputPath = "Database.db";

		try {
			InputStream file = new FileInputStream(outputPath);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			Users = (ArrayList<User>) input.readObject();
			Products = (ArrayList<Product>) input.readObject();
			AppliedProducts = (ArrayList<Product>) input.readObject();
			AppliedStores = (ArrayList<Store>) input.readObject();
			PromoCards = (ArrayList<PromotionCard>) input.readObject();
			input.close();

		}
		catch (IOException e){
			System.out.println("DB not found, Starting fresh...");
		}
		catch (ClassNotFoundException e){
			//Reset Values incase any corrupt read
			Users = new ArrayList<>();
			Products = new ArrayList<>();
			AppliedProducts = new ArrayList<>();
			AppliedStores = new ArrayList<>();
			PromoCards = new ArrayList<>();
			System.out.println("DB Corrupted, Starting fresh...");
		}
		return;
    }
    public static void SaveDB() throws IOException {
		//Output Files Names
		String outputPath = "Database.db";

		//Write using Java's Object Serialization
		FileOutputStream fileOutputStream = new FileOutputStream(outputPath);
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

		//Write
		objectOutputStream.writeObject(Users);
		objectOutputStream.writeObject(Products);
		objectOutputStream.writeObject(AppliedProducts);
		objectOutputStream.writeObject(AppliedStores);
		objectOutputStream.writeObject(PromoCards);
		objectOutputStream.close();
    }




}
