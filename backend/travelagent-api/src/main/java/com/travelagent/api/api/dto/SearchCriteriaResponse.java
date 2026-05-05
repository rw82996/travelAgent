package com.travelagent.api.api.dto;

import com.travelagent.api.domain.TripType;
import java.math.BigDecimal;
import java.time.LocalDate;

public record SearchCriteriaResponse(
        Long id,
        String name,
        String fromAirport,
        String toAirport,
        TripType tripType,
        LocalDate departureDate,
        LocalDate returnDate,
        Integer flexDays,
        Integer passengers,
        Boolean carryOnRequired,
        BigDecimal maxPrice,
        String currency,
        Boolean active
) { }
