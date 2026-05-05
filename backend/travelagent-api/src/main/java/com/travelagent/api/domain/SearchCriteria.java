package com.travelagent.api.domain;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;

@Entity
public class SearchCriteria {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false, length = 200) private String name;
    @Column(nullable = false, length = 100) private String userId = "demo-user";
    @Column(nullable = false, length = 3) private String fromAirport;
    @Column(nullable = false, length = 3) private String toAirport;
    @Enumerated(EnumType.STRING) @Column(nullable = false, length = 30) private TripType tripType;
    @Column(nullable = false) private LocalDate departureDate;
    private LocalDate returnDate;
    @Column(nullable = false) private Integer flexDays = 3;
    @Column(nullable = false) private Integer passengers = 1;
    @Column(nullable = false) private Boolean carryOnRequired = false;
    private BigDecimal maxPrice;
    @Column(nullable = false, length = 3) private String currency = "USD";
    @Column(nullable = false) private Boolean active = true;
    @Column(nullable = false) private Instant createdAt = Instant.now();
    @Column(nullable = false) private Instant updatedAt = Instant.now();

    public Long getId(){return id;} public void setId(Long id){this.id=id;}
    public String getName(){return name;} public void setName(String name){this.name=name;}
    public String getUserId(){return userId;} public void setUserId(String userId){this.userId=userId;}
    public String getFromAirport(){return fromAirport;} public void setFromAirport(String fromAirport){this.fromAirport=fromAirport;}
    public String getToAirport(){return toAirport;} public void setToAirport(String toAirport){this.toAirport=toAirport;}
    public TripType getTripType(){return tripType;} public void setTripType(TripType tripType){this.tripType=tripType;}
    public LocalDate getDepartureDate(){return departureDate;} public void setDepartureDate(LocalDate departureDate){this.departureDate=departureDate;}
    public LocalDate getReturnDate(){return returnDate;} public void setReturnDate(LocalDate returnDate){this.returnDate=returnDate;}
    public Integer getFlexDays(){return flexDays;} public void setFlexDays(Integer flexDays){this.flexDays=flexDays;}
    public Integer getPassengers(){return passengers;} public void setPassengers(Integer passengers){this.passengers=passengers;}
    public Boolean getCarryOnRequired(){return carryOnRequired;} public void setCarryOnRequired(Boolean carryOnRequired){this.carryOnRequired=carryOnRequired;}
    public BigDecimal getMaxPrice(){return maxPrice;} public void setMaxPrice(BigDecimal maxPrice){this.maxPrice=maxPrice;}
    public String getCurrency(){return currency;} public void setCurrency(String currency){this.currency=currency;}
    public Boolean getActive(){return active;} public void setActive(Boolean active){this.active=active;}
    public Instant getCreatedAt(){return createdAt;} public void setCreatedAt(Instant createdAt){this.createdAt=createdAt;}
    public Instant getUpdatedAt(){return updatedAt;} public void setUpdatedAt(Instant updatedAt){this.updatedAt=updatedAt;}
}
