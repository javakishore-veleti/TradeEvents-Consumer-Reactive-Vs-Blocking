package com.jk.apps.trades.reactive_non_reactive.nonblocking.kafka;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jk.apps.trades.reactive_non_reactive.common.entity.TradeEvent;
import com.jk.apps.trades.reactive_non_reactive.common.service.TradeService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

@Component
public class ReactiveTradeEventConsumer {

    private final TradeService tradeService;
    private final ObjectMapper objectMapper;

    @Autowired
    public ReactiveTradeEventConsumer(TradeService tradeService, ObjectMapper objectMapper) {
        this.tradeService = tradeService;
        this.objectMapper = objectMapper;
    }

    @KafkaListener(topics = "trade-events", groupId = "reactive-trade-consumer")
    public void consume(ConsumerRecord<String, String> record) {
        try {
            TradeEvent tradeEvent = objectMapper.readValue(record.value(), TradeEvent.class);
            Mono.fromRunnable(() -> tradeService.processTrade(tradeEvent)).subscribe();
        } catch (Exception e) {
            // log and handle error
            e.printStackTrace();
        }
    }
}
