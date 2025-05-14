package com.jk.apps.trades.reactive_non_reactive.blocking.service.impl;

import com.jk.apps.trades.reactive_non_reactive.blocking.repository.TradeRepository;
import com.jk.apps.trades.reactive_non_reactive.common.entity.TradeEvent;
import com.jk.apps.trades.reactive_non_reactive.common.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TradeServiceImpl implements TradeService {

    private final TradeRepository tradeRepository;
    private final RestTemplate restTemplate;

    @Autowired
    public TradeServiceImpl(TradeRepository tradeRepository, RestTemplate restTemplate) {
        this.tradeRepository = tradeRepository;
        this.restTemplate = restTemplate;
    }

    @Override
    public void processTrade(TradeEvent event) {
        Boolean isValid = restTemplate.getForObject(
                "http://customer-profile-service/api/customers/validate/" + event.getCustomerId(),
                Boolean.class
        );

        if (Boolean.TRUE.equals(isValid)) {
            tradeRepository.save(event);
        }
    }
}
