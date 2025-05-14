package com.jk.apps.trades.reactive_non_reactive.common.service;

import com.jk.apps.trades.reactive_non_reactive.common.entity.TradeEvent;

public interface TradeService {
    void processTrade(TradeEvent event);
}
