package com.travelagent.api.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;

public record TripSegmentRequest(
        @NotBlank @Size(min = 3, max = 3) String fromAirport,
        @NotBlank @Size(min = 3, max = 3) String toAirport,
        @NotNull LocalDate departureDate
) { }
