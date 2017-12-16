package Models;

import java.util.Objects;
import java.util.UUID;

public class StorePromotion extends PromotionCard {
	public Store store;

	public StorePromotion(double offPercentage, double offMax, Store store) {
		super(offPercentage, offMax);
		this.store = store;
	}

}

