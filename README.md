# TravelAgent

TravelAgent is a flight-search starter platform inspired by Kayak and Priceline patterns. It lets users save itinerary search criteria and run scheduled daily searches across flexible dates, trip types, and baggage preferences.

## Capabilities

- Save itinerary criteria by user
- Support one-way, round-trip, and multi-city searches
- Search across +/- 3 days around departure and return dates
- Carry-on baggage required filter
- Daily scheduled search for saved criteria
- Redis caching for performance
- PostgreSQL default database with Oracle profile support
- React microfrontend starter UI
- Java Spring Boot backend API

## Structure

```text
travelAgent/
├── backend/travelagent-api
├── frontend/shell
├── frontend/search-mfe
├── infra/docker-compose.yml
├── docs/architecture.md
└── .github/workflows/ci.yml
```

## Local Startup

```bash
cd infra
docker compose up -d postgres redis

cd ../backend/travelagent-api
mvn spring-boot:run
```

## Production Notes

This starter uses a stub flight provider. Real production use requires contracted supplier APIs, OAuth2/OIDC, rate-limit handling, alerting, notifications, monitoring, and secure secrets management.
