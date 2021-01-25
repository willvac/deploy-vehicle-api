package com.udacity.vehicles.client.maps;

import com.udacity.vehicles.domain.Location;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Objects;

/**
 * Implements a class to interface with the Maps Client for location data.
 */
@Component
public class MapsClient {

    private static final Logger log = LoggerFactory.getLogger(MapsClient.class);

    private final WebClient mapsClient;
    private final ModelMapper mapper;


    public MapsClient(WebClient maps, ModelMapper mapper) {
        this.mapsClient = maps;
        this.mapper = mapper;
    }

    /**
     * Gets an address from the Maps client, given latitude and longitude.
     * @param location An object containing "lat" and "lon" of location
     * @return An updated location including street, city, state and zip,
     *   or an exception message noting the Maps service is down
     */
    public Location getAddress(Location location) {
        try {
            Address address = mapsClient
                    .get()
                    .uri("/maps" + "?lat=" + location.getLat() + "&lon=" + location.getLon())
                    .retrieve().bodyToMono(Address.class).block();

            mapper.map(Objects.requireNonNull(address), location);

            return location;
        } catch (Exception e) {
            log.warn("Map service is down");
            return location;
        }
    }
}
