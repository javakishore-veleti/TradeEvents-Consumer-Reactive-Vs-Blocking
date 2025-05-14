package com.jk.apps.trades.reactive_non_reactive.common.util;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

public class ApiClientUtil {

    private ApiClientUtil() {
        // Utility class
    }

    public static Mono<Boolean> validateCustomer(WebClient webClient, String customerId) {
        return webClient.get()
                .uri("http://customer-profile-service/api/customers/validate/{customerId}", customerId)
                .retrieve()
                .bodyToMono(Boolean.class)
                .onErrorReturn(false);  // Fallback if unreachable or exception occurs
    }
}
