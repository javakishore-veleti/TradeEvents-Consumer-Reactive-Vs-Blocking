# TradeEvents-Consumer-Reactive-Vs-Blocking

A comparative Spring Boot project that consumes trade events from Kafka and persists them to PostgreSQL using two architectural modes:

- **Blocking Mode**: Spring MVC + JPA (JDBC)
- **Non-Blocking Mode**: Spring WebFlux + R2DBC

This project is useful for benchmarking, educational comparison, or incremental migration from synchronous to reactive architecture.

---

## Project Structure

```
com.jk.apps.trades.reactive_non_reactive
├── common/              # Shared models, interfaces, utilities
├── blocking/            # Spring MVC + JPA + Kafka + RestTemplate
├── nonblocking/         # WebFlux + R2DBC + Kafka + WebClient
```

---

## Tech Stack

| Component     | Blocking                      | Non-Blocking               |
|--------------|-------------------------------|----------------------------|
| Web Layer     | Spring MVC                    | Spring WebFlux             |
| Kafka         | Spring for Apache Kafka       | Spring for Apache Kafka    |
| DB Access     | Spring Data JPA (JDBC)        | Spring Data R2DBC          |
| REST Client   | RestTemplate                  | WebClient                  |
| DB Driver     | PostgreSQL JDBC Driver        | R2DBC PostgreSQL Driver    |

---

## Getting Started

### Prerequisites

- Java 17+
- Maven 3.8+
- Docker & Docker Compose

---

## Docker Setup (PostgreSQL + Kafka)

```bash
docker-compose up -d
```

Ensure the following services are accessible:

- PostgreSQL: `localhost:5432`
- Kafka Broker: `localhost:9092`

---

## Running the Application

### Choose the mode by setting Spring profile:

```bash
# For blocking mode
-Dspring.profiles.active=blocking

# For non-blocking mode
-Dspring.profiles.active=nonblocking
```

### Build & Run:

```bash
mvn clean package
java -jar target/trade-events-consumer.jar
```

---

## Swagger UI

- Blocking Docs: `http://localhost:8080/swagger-ui-blocking.html`
- Reactive Docs: `http://localhost:8080/swagger-ui-reactive.html`

---

## Load Testing with Gatling

Gatling setup available under `/gatling-loadtest` folder:

```bash
cd gatling-loadtest
mvn gatling:test
```

Customize simulation in `TradeSimulation.scala`.

---

## Integration Testing with Testcontainers

- Kafka and PostgreSQL containers auto-managed via JUnit 5
- Located under `src/test/java/com/.../integration/KafkaIntegrationTest.java`

---

## GitHub Actions (CI)

- Lint, build, and run tests on push/pull requests
- See `.github/workflows/ci.yml`

---
