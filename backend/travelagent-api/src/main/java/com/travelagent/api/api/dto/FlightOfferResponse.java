package com.travelagent.api.api.dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public record FlightOfferResponse(
        Long id,
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
