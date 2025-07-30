package main.Strategies.Pricing;

import main.Entities.RideMetaData;
import main.Interfaces.IPricingStrategy;

public class DistanceBasedPricingStrategy implements IPricingStrategy {

    @Override
    public float calculatePrice(RideMetaData meta) {
        float PRICE_PER_KM = 4.0f;
        return meta.getEndLocation().getDistance(meta.getStartLocation()) * PRICE_PER_KM;
    }
}
