package Models;


import java.io.*;
import java.util.ArrayList;

public class Platform {
	public static ArrayList<User> Users = new ArrayList<>();
	public static ArrayList<Product> Products = new ArrayList<>();
	public static ArrayList<Product> SuggestedProducts = new ArrayList<>();
	public static ArrayList<Store> AppliedStores = new ArrayList<>();
	public static ArrayList<PromotionCard> PromoCards = new ArrayList<>();
	public static ArrayList<Store> Stores = new ArrayList<>();

	public static void Initialize() {
		//Output File Names
		String outputPath = "Database.db";

		try {
			InputStream file = new FileInputStream(outputPath);
			InputStream buffer = new BufferedInputStream(file);
			ObjectInput input = new ObjectInputStream(buffer);
			Users = (ArrayList<User>) input.readObject();
			Products = (ArrayList<Product>) input.readObject();
			SuggestedProducts = (ArrayList<Product>) input.readObject();
			AppliedStores = (ArrayList<Store>) input.readObject();
			PromoCards = (ArrayList<PromotionCard>) input.readObject();
			Stores = (ArrayList<Store>) input.readObject();
			input.close();

		}
		catch (ClassNotFoundException  | IOException e){
			//Reset Values incase any corrupt read
			System.out.println("DB not found or Corrupted, Starting fresh...");
			Users = new ArrayList<>();
			Products = new ArrayList<>();
			SuggestedProducts = new ArrayList<>();
			AppliedStores = new ArrayList<>();
			PromoCards = new ArrayList<>();
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
		objectOutputStream.writeObject(SuggestedProducts);
		objectOutputStream.writeObject(AppliedStores);
		objectOutputStream.writeObject(PromoCards);
		objectOutputStream.writeObject(Stores);
		objectOutputStream.close();
    }




}
