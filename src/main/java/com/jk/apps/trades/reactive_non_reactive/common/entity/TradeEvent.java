package com.jk.apps.trades.reactive_non_reactive.common.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "TRADE_EVENT")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TradeEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String customerId;
    private String fromCurrency;
    private String toCurrency;

    private BigDecimal fromUnitPrice;
    private BigDecimal toUnitPrice;
    private BigDecimal volume;
    private BigDecimal fromAmount;
    private BigDecimal toAmount;

}
