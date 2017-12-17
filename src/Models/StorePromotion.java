package Models;

public class StorePromotion extends PromotionCard {
	public Store store;

	public StorePromotion(double offPercentage, double offMax, Store store) {
		super(offPercentage, offMax);
		this.store = store;
	}

}

