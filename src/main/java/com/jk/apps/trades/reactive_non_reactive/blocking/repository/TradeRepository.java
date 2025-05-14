package com.jk.apps.trades.reactive_non_reactive.blocking.repository;

import com.jk.apps.trades.reactive_non_reactive.common.entity.TradeEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradeRepository extends JpaRepository<TradeEvent, Long> {
}
