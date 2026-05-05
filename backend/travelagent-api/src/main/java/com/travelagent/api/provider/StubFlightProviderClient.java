package com.travelagent.api.provider;

import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class StubFlightProviderClient implements FlightProviderClient {
    private final Random random = new Random(42);

    public List<ProviderFlightOffer> search(FlightSearchRequest request) {
        List<ProviderFlightOffer> offers = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            boolean carryOn = i % 2 == 0;
            BigDecimal base = BigDecimal.valueOf(250 + random.nextInt(900));
            offers.add(new ProviderFlightOffer(
                    "stub-provider",
                    i % 2 == 0 ? "United" : "Delta",
                    (i % 2 == 0 ? "UA" : "DL") + (1000 + i),
                    request.fromAirport(),
                    request.toAirport(),
                    request.departureDate(),
                    request.returnDate(),
                    base,
                    request.currency(),
                    carryOn,
                    i % 3 == 0,
                    "https://example.com/book"
            ));
        }
        return offers;
    }
}
