package com.jk.apps.trades.reactive_non_reactive.common.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Data
@Getter
@Setter
public class TradeEventDto {

    private String customerId;
    private String fromCurrency;
    private String toCurrency;
    private BigDecimal fromUnitPrice;
    private BigDecimal toUnitPrice;
    private BigDecimal volume;

    public TradeEventDto() {
    }

    public TradeEventDto(String customerId, String fromCurrency, String toCurrency, BigDecimal fromUnitPrice, BigDecimal toUnitPrice, BigDecimal volume) {
        this.customerId = customerId;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.fromUnitPrice = fromUnitPrice;
        this.toUnitPrice = toUnitPrice;
        this.volume = volume;
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
}
