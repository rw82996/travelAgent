package com.travelagent.api.provider;

import java.math.BigDecimal;
import java.time.LocalDate;

public record ProviderFlightOffer(
        String provider,
        String airline,
        String flightNumber,
        String fromAirport,
        String toAirport,
        LocalDate departureDate,
        LocalDate returnDate,
        BigDecimal price,
        String currency,
        Boolean carryOnIncluded,
        Boolean checkedBagIncluded,
        String deepLink
) { }
