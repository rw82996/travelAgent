package com.travelagent.api.repository;

import com.travelagent.api.domain.FlightOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface FlightOfferRepository extends JpaRepository<FlightOffer, Long> {
    List<FlightOffer> findTop50ByCriteriaIdOrderByPriceAsc(Long criteriaId);
}
