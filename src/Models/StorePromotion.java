package Models;

import java.util.Objects;
import java.util.UUID;

public class StorePromotion extends PromotionCard {
	public Store store;

	public StorePromotion(double offPercentage, double offMax, Store store) {
		super(offPercentage, offMax);
		this.store = store;
	}

	public boolean usePromo(String SerialNumber, Store store) {
		if(store != this.store)
			return false;
		for (SerialNumber Serial : SerialNumbers ) {
			if(Objects.equals(Serial.serial, SerialNumber) && !Serial.used ) {
				Serial.used = true;
				return true;
			}
		}
		return false;
	}
}

