#!/bin/bash

echo "Checking PostgreSQL..."
PG_READY=$(pg_isready -h localhost -p 5432 -U postgres)
echo "$PG_READY"

echo "Checking Kafka..."
KAFKA_READY=$(docker exec kafka \
  kafka-topics --bootstrap-server localhost:9092 --list 2>&1)

if [[ "$KAFKA_READY" == *"Exception"* ]]; then
  echo "Kafka might not be ready yet."
else
  echo "Kafka topics: $KAFKA_READY"
fi
