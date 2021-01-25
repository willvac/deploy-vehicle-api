package com.udacity.vehicles.client.prices;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Implements a class to interface with the Pricing Client for price data.
 */
@Component
public class PriceClient {



    private final String getQuoteEndpoint = "/services/price?vehicleId={vehicleId}";
    private final String pricesEndpoint = "/prices";
    private final String pricesTargetEndpoint = "/prices/{vehicleId}";

    private static final Logger log = LoggerFactory.getLogger(PriceClient.class);

    private final WebClient priceClient;


    public PriceClient(WebClient pricing) {
        this.priceClient = pricing;
    }
    // In a real-world application we'll want to add some resilience
    // to this method with retries/CB/failover capabilities
    // We may also want to cache the results so we don't need to
    // do a request every time

    /**
     * Sets a vehicle price from the pricing client, given vehicle ID, if a price has not already been set.
     * @param vehicleId ID number of the vehicle for which to get the price
     * @return Currency and price of the requested vehicle,
     *   error message that the vehicle ID is invalid, or note that the
     *   service is down.
     */

    public String setPrice(Long vehicleId) {
        try {

            Price price = priceClient
                    .get()
                    .uri( getQuoteEndpoint, vehicleId)
                    .retrieve().bodyToMono(Price.class).block();


            return String.format("%s %s", price.getCurrency(), price.getPrice());

        } catch (Exception e) {
            log.error("Unexpected error retrieving price for vehicle {}", vehicleId, e);
        }
        return "(consult price)";
    }

    /**
     * Gets a vehicle price from the pricing client, given vehicle ID.
     * @param vehicleId ID number of the vehicle for which to get the price
     * @return Currency and price of the requested vehicle,
     *   error message that the vehicle ID is invalid, or note that the
     *   service is down.
     */
    public String getPrice(Long vehicleId) {
            Price price = priceClient
                    .get()
                    .uri(pricesTargetEndpoint, vehicleId)
                    .retrieve().bodyToMono(Price.class).block();

            return String.format("%s %s", price.getCurrency(), price.getPrice());
    }

    /**
     * Post a Price with the pricing client, given a Price Object.
     * @param price containing the vehicleId whose this price is associated with, the currency, and the price
     *
     */
    public String postPrice(Price price) {
        priceClient.post()
                .uri(pricesEndpoint).body(BodyInserters.fromObject(price)).retrieve().bodyToMono(Price.class).block();
        return String.format("%s %s", price.getCurrency(), price.getPrice());
    }


    public void deletePrice(Long vehicleId) {
        priceClient.delete()
                .uri(pricesTargetEndpoint, vehicleId).retrieve().bodyToMono(Void.class).block();
    }
}
