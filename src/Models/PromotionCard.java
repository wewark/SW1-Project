//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : PromotionCard.java
//  @ Date : 14/12/2017
//  @ Author : 
//
//



package Models;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Objects;
import java.util.UUID;

public abstract class PromotionCard implements Serializable{
//	public Date expirationDate;
	public double offPercentage;
	public double offMax;
	public ArrayList<SerialNumber> SerialNumbers = new ArrayList<>();
	public PromotionCard(double offPercentage, double offMax) {
		this.offPercentage = offPercentage;
		this.offMax = offMax;
	}
	public void generateSerials(int N)
	{
		for (int i = 0; i < N; i++) {
			SerialNumbers.add(new SerialNumber(UUID.randomUUID().toString()));
		}
	}

	public static boolean addPromoCard(PromotionCard promotionCard)
	{
		Platform.PromoCards.add(promotionCard);
		return true;
	}

	public boolean usePromo(String SerialNumber) {
		for (SerialNumber Serial : SerialNumbers ) {
			if(Objects.equals(Serial.serial, SerialNumber) && !Serial.used ) {
				Serial.used = true;
				return true;
			}
		}
		return false;
	}

	public static PromotionCard getPromoBySerial(String GivenSerial){
		for (PromotionCard promo : Platform.PromoCards ) {
			for (SerialNumber serialNumber: promo.SerialNumbers ) {
				if(Objects.equals(serialNumber.serial, GivenSerial))
					return promo;
			}
		}
		return null;
	}

	//Console Function
	public void printSerials()
	{
		System.out.println("-------Serial-Numbers-------");
		for (SerialNumber serial : SerialNumbers ) {
			System.out.println("\t"+serial.serial+"\t Used: "+ (serial.used ? "Yes" : "No"));
		}
	}
}
