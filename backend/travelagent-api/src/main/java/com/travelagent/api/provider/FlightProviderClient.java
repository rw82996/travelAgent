package com.travelagent.api.provider;

import java.util.List;

public interface FlightProviderClient {
    List<ProviderFlightOffer> search(FlightSearchRequest request);
}
