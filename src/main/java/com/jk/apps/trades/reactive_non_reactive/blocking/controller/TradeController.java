package com.jk.apps.trades.reactive_non_reactive.blocking.controller;

import com.jk.apps.trades.reactive_non_reactive.common.entity.TradeEvent;
import com.jk.apps.trades.reactive_non_reactive.common.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/blocking/trades")
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(@Qualifier("blockingTradeService") TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public void handleTrade(@RequestBody TradeEvent event) {
        tradeService.processTrade(event);
    }
}
