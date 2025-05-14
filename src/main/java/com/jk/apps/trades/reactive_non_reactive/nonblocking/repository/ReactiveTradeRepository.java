package com.jk.apps.trades.reactive_non_reactive.nonblocking.repository;

import com.jk.apps.trades.reactive_non_reactive.common.entity.TradeEvent;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
public interface ReactiveTradeRepository extends ReactiveCrudRepository<TradeEvent, Long> {
    Mono<TradeEvent> findByCustomerId(String customerId);
}
