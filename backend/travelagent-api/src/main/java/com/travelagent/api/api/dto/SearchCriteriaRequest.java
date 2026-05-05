package com.travelagent.api.api.dto;

import com.travelagent.api.domain.TripType;
import jakarta.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public record SearchCriteriaRequest(
        @NotBlank String name,
        @NotBlank @Size(min = 3, max = 3) String fromAirport,
        @NotBlank @Size(min = 3, max = 3) String toAirport,
        @NotNull TripType tripType,
        @NotNull LocalDate departureDate,
        LocalDate returnDate,
        @Min(0) @Max(7) Integer flexDays,
        @Min(1) @Max(9) Integer passengers,
        Boolean carryOnRequired,
        BigDecimal maxPrice,
        @Size(min = 3, max = 3) String currency,
        List<TripSegmentRequest> segments
) { }
