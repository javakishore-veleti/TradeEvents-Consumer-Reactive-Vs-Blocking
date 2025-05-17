package com.jk.apps.trades.reactive_non_reactive.common.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table(name = "TRADE_EVENT")
@Data
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

    public TradeEvent() {
    }

    public TradeEvent(Long id, String customerId, String fromCurrency, String toCurrency, BigDecimal fromUnitPrice, BigDecimal toUnitPrice, BigDecimal volume, BigDecimal fromAmount, BigDecimal toAmount) {
        this.id = id;
        this.customerId = customerId;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.fromUnitPrice = fromUnitPrice;
        this.toUnitPrice = toUnitPrice;
        this.volume = volume;
        this.fromAmount = fromAmount;
        this.toAmount = toAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public BigDecimal getFromUnitPrice() {
        return fromUnitPrice;
    }

    public void setFromUnitPrice(BigDecimal fromUnitPrice) {
        this.fromUnitPrice = fromUnitPrice;
    }

    public BigDecimal getToUnitPrice() {
        return toUnitPrice;
    }

    public void setToUnitPrice(BigDecimal toUnitPrice) {
        this.toUnitPrice = toUnitPrice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public BigDecimal getFromAmount() {
        return fromAmount;
    }

    public void setFromAmount(BigDecimal fromAmount) {
        this.fromAmount = fromAmount;
    }

    public BigDecimal getToAmount() {
        return toAmount;
    }

    public void setToAmount(BigDecimal toAmount) {
        this.toAmount = toAmount;
    }
}
