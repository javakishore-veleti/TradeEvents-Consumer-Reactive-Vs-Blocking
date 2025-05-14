package com.jk.apps.trades.reactive_non_reactive.common.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
public class CommonValidationService {

    private static final String VALIDATION_URL = "http://customer-profile-service/api/customers/validate/{customerId}";

    public boolean validateCustomerBlocking(RestTemplate restTemplate, String customerId) {
        try {
            Boolean result = restTemplate.getForObject(VALIDATION_URL, Boolean.class, customerId);
            return Boolean.TRUE.equals(result);
        } catch (Exception e) {
            // Log and fallback if necessary
            return false;
        }
    }

    public Mono<Boolean> validateCustomerReactive(WebClient webClient, String customerId) {
        return webClient.get()
                .uri(VALIDATION_URL, customerId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .onErrorReturn(false);
    }
}
