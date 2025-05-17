package com.jk.apps.trades.reactive_non_reactive.blocking.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import org.springframework.context.annotation.Profile;


@Configuration
@Profile("blocking")
@EnableJpaRepositories(basePackages = "com.jk.apps.trades.reactive_non_reactive.blocking.repository")
@EntityScan(basePackages = "com.jk.apps.trades.reactive_non_reactive.common.entity")
@EnableAutoConfiguration(exclude = {
        // Prevent R2DBC auto-config
        org.springframework.boot.autoconfigure.data.r2dbc.R2dbcDataAutoConfiguration.class,
        org.springframework.boot.autoconfigure.r2dbc.R2dbcAutoConfiguration.class
})public class JpaRepositoryConfig {
}