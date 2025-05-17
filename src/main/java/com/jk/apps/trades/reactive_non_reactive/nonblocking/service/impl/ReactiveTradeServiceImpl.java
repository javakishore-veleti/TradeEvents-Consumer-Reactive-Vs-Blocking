package com.jk.apps.trades.reactive_non_reactive.nonblocking.service.impl;

import com.jk.apps.trades.reactive_non_reactive.common.entity.TradeEvent;
import com.jk.apps.trades.reactive_non_reactive.common.service.TradeService;
import com.jk.apps.trades.reactive_non_reactive.nonblocking.repository.ReactiveTradeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Profile("nonblocking")
@Service("reactiveTradeService")
public class ReactiveTradeServiceImpl implements TradeService {

    private final ReactiveTradeRepository tradeRepository;
    private final WebClient webClient;

    @Autowired
    public ReactiveTradeServiceImpl(ReactiveTradeRepository tradeRepository, WebClient webClient) {
        this.tradeRepository = tradeRepository;
        this.webClient = webClient;
    }

    @Override
    public void processTrade(TradeEvent event) {
        webClient.get()
                .uri("http://customer-profile-service/api/customers/validate/{customerId}", event.getCustomerId())
                .retrieve()
                .bodyToMono(Boolean.class)
                .filter(Boolean::booleanValue)
                .flatMap(valid -> tradeRepository.save(event))
                .subscribe();
    }
}
