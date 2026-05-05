# TravelAgent Architecture

## Target Architecture

TravelAgent is designed as a modular travel-search platform with clear separation between UI, API, persistence, cache, and provider integration.

```text
React Shell
   |
   | Module Federation
   v
Search Criteria Microfrontend
   |
   | REST
   v
TravelAgent API Service
   |
   |---- PostgreSQL / Oracle
   |---- Redis Cache
   |---- Flight Provider Adapter
   |---- Scheduled Search Runner
```

## Core Domain Objects

| Object | Purpose |
|---|---|
| SearchCriteria | User-saved flight search preference |
| TripSegment | Multi-city itinerary leg support |
| FlightOffer | Cached and persisted flight result |
| SearchRun | Execution record for scheduled/manual searches |

## Search Logic

For each saved itinerary:

1. Build date windows using `flexDays`, defaulting to +/- 3 days.
2. Generate departure/return combinations.
3. Call provider adapter.
4. Filter offers using carry-on baggage requirement.
5. Cache search result in Redis.
6. Persist top offers for user review and future alerting.

## Caching Strategy

| Cache | Key | TTL |
|---|---|---:|
| Search offers | `offers:{criteriaId}:{criteriaHash}` | 6 hours |
| Airport reference data | `airport:{iata}` | 24 hours |
| Provider response | `provider:{provider}:{hash}` | 30 minutes |

## Database Strategy

Default local database is PostgreSQL. Oracle profile is included to support ORAAS/Oracle Autonomous DB style deployment.

## Provider Integration Strategy

The backend includes a `FlightProviderClient` interface and `StubFlightProviderClient` implementation. Replace the stub with provider-specific adapters such as:

- Amadeus
- Sabre
- Duffel
- Travelport
- Skyscanner partner API

Avoid screen scraping; use licensed/commercial APIs only.

## Scheduled Search

`DailySearchScheduler` runs all active saved searches daily. For production, consider replacing in-process scheduling with:

- Quartz
- Kubernetes CronJob
- AWS EventBridge
- Cloud Scheduler
- Temporal workflow

## Future Microservices

The starter begins with one backend service for simplicity. As the product grows, split into:

| Service | Responsibility |
|---|---|
| criteria-service | User saved search criteria |
| search-orchestrator | Daily/manual search execution |
| provider-adapter-service | External travel API integrations |
| offer-service | Fare result persistence and cache |
| notification-service | Email/SMS/push price alerts |
| identity-service | User profile and authentication |
