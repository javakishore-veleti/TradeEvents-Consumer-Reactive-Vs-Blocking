package com.jk.apps.trades.reactive_non_reactive.common.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeEventDto {

    private String customerId;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal fromUnitPrice;
    private BigDecimal toUnitPrice;
    private BigDecimal volume;
}
