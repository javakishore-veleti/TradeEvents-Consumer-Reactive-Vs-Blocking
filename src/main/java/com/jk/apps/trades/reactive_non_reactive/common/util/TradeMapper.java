package com.jk.apps.trades.reactive_non_reactive.common.util;

import com.jk.apps.trades.reactive_non_reactive.common.dto.TradeEventDto;
import com.jk.apps.trades.reactive_non_reactive.common.entity.TradeEvent;

import java.math.BigDecimal;

public class TradeMapper {

    private TradeMapper() {
        // Utility class, no instances
    }

    public static TradeEvent toEntity(TradeEventDto dto) {
        BigDecimal fromAmount = dto.getFromUnitPrice().multiply(dto.getVolume());
        BigDecimal toAmount = dto.getToUnitPrice().multiply(dto.getVolume());

        return new TradeEvent(
                null,
                dto.getCustomerId(),
                dto.getFromCurrency(),
                dto.getToCurrency(),
                dto.getFromUnitPrice(),
                dto.getToUnitPrice(),
                dto.getVolume(),
                fromAmount,
                toAmount
        );
    }

    public static TradeEventDto toDto(TradeEvent entity) {
        return new TradeEventDto(
                entity.getCustomerId(),
                entity.getFromCurrency(),
                entity.getToCurrency(),
                entity.getFromUnitPrice(),
                entity.getToUnitPrice(),
                entity.getVolume()
        );
    }
}
