CREATE TABLE search_criteria (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(200) NOT NULL,
    user_id VARCHAR(100) NOT NULL DEFAULT 'demo-user',
    from_airport VARCHAR(3) NOT NULL,
    to_airport VARCHAR(3) NOT NULL,
    trip_type VARCHAR(30) NOT NULL,
    departure_date DATE NOT NULL,
    return_date DATE,
    flex_days INT NOT NULL DEFAULT 3,
    passengers INT NOT NULL DEFAULT 1,
    carry_on_required BOOLEAN NOT NULL DEFAULT false,
    max_price NUMERIC(12,2),
    currency VARCHAR(3) NOT NULL DEFAULT 'USD',
    active BOOLEAN NOT NULL DEFAULT true,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE flight_offer (
    id BIGSERIAL PRIMARY KEY,
    criteria_id BIGINT NOT NULL REFERENCES search_criteria(id) ON DELETE CASCADE,
    provider VARCHAR(80) NOT NULL,
    airline VARCHAR(80) NOT NULL,
    flight_number VARCHAR(50) NOT NULL,
    from_airport VARCHAR(3) NOT NULL,
    to_airport VARCHAR(3) NOT NULL,
    departure_date DATE NOT NULL,
    return_date DATE,
    price NUMERIC(12,2) NOT NULL,
    currency VARCHAR(3) NOT NULL,
    carry_on_included BOOLEAN NOT NULL,
    checked_bag_included BOOLEAN NOT NULL,
    deep_link VARCHAR(1000),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_search_criteria_user_active ON search_criteria(user_id, active);
CREATE INDEX idx_flight_offer_criteria_date ON flight_offer(criteria_id, created_at DESC);
