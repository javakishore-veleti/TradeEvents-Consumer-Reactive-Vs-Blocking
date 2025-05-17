package com.jk.apps.trades.reactive_non_reactive.nonblocking.controller;

import com.jk.apps.trades.reactive_non_reactive.common.entity.TradeEvent;
import com.jk.apps.trades.reactive_non_reactive.common.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@Profile("nonblocking")
@RestController
@RequestMapping("/api/reactive/trades")
public class ReactiveTradeController {

    private final TradeService tradeService;

    @Autowired
    public ReactiveTradeController(@Qualifier("reactiveTradeService") TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public Mono<Void> handleTrade(@RequestBody TradeEvent event) {
        return Mono.fromRunnable(() -> tradeService.processTrade(event));
    }
}
