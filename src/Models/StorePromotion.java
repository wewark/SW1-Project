package Models;

import java.util.UUID;

public class StorePromotion extends PromotionCard {
	public Store store;
	public static boolean addPromo(double offPercentage, double offMax, Store store) {
		if(offPercentage > 1) offPercentage = 1;
		if(offPercentage < 0) offPercentage = 0;
		if(offMax < 0) offMax = 0;
		StorePromotion newPromo = new StorePromotion(offPercentage, offMax, store);

		//Add 10 Random Serial Numbers
		for (int i = 0; i < 10; i++) {
			newPromo.SerialNumbers.add(new SerialNumber(UUID.randomUUID().toString()));
		}

		//Add To Database
		Platform.PromoCards.add(newPromo);
		return true;
	}

	public StorePromotion(double offPercentage, double offMax, Store store) {
		super(offPercentage, offMax);
		this.store = store;
	}
}
