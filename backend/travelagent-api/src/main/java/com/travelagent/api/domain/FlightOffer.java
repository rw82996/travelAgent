package com.travelagent.api.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class FlightOffer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id;
    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "criteria_id", nullable = false) private SearchCriteria criteria;
    @Column(nullable = false, length = 80) private String provider;
    @Column(nullable = false, length = 80) private String airline;
    @Column(nullable = false, length = 50) private String flightNumber;
    @Column(nullable = false, length = 3) private String fromAirport;
    @Column(nullable = false, length = 3) private String toAirport;
    @Column(nullable = false) private LocalDate departureDate;
    private LocalDate returnDate;
    @Column(nullable = false) private BigDecimal price;
    @Column(nullable = false, length = 3) private String currency;
    @Column(nullable = false) private Boolean carryOnIncluded;
    @Column(nullable = false) private Boolean checkedBagIncluded;
    @Column(length = 1000) private String deepLink;
    @Column(nullable = false) private Instant createdAt = Instant.now();
    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public SearchCriteria getCriteria(){return criteria;} public void setCriteria(SearchCriteria criteria){this.criteria=criteria;}
    public String getProvider(){return provider;} public void setProvider(String provider){this.provider=provider;}
    public String getAirline(){return airline;} public void setAirline(String airline){this.airline=airline;}
    public String getFlightNumber(){return flightNumber;} public void setFlightNumber(String flightNumber){this.flightNumber=flightNumber;}
    public String getFromAirport(){return fromAirport;} public void setFromAirport(String fromAirport){this.fromAirport=fromAirport;}
    public String getToAirport(){return toAirport;} public void setToAirport(String toAirport){this.toAirport=toAirport;}
    public LocalDate getDepartureDate(){return departureDate;} public void setDepartureDate(LocalDate departureDate){this.departureDate=departureDate;}
    public LocalDate getReturnDate(){return returnDate;} public void setReturnDate(LocalDate returnDate){this.returnDate=returnDate;}
    public BigDecimal getPrice(){return price;} public void setPrice(BigDecimal price){this.price=price;}
    public String getCurrency(){return currency;} public void setCurrency(String currency){this.currency=currency;}
    public Boolean getCarryOnIncluded(){return carryOnIncluded;} public void setCarryOnIncluded(Boolean carryOnIncluded){this.carryOnIncluded=carryOnIncluded;}
    public Boolean getCheckedBagIncluded(){return checkedBagIncluded;} public void setCheckedBagIncluded(Boolean checkedBagIncluded){this.checkedBagIncluded=checkedBagIncluded;}
    public String getDeepLink(){return deepLink;} public void setDeepLink(String deepLink){this.deepLink=deepLink;}
}
