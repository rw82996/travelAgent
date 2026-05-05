package com.travelagent.api.provider;

import com.travelagent.api.domain.TripType;
import java.time.LocalDate;

public record FlightSearchRequest(
        String fromAirport,
        String toAirport,
        TripType tripType,
        LocalDate departureDate,
        LocalDate returnDate,
        Integer passengers,
        Boolean carryOnRequired,
        String currency
) { }
