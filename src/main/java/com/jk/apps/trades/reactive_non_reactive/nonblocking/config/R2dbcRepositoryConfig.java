package com.jk.apps.trades.reactive_non_reactive.nonblocking.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories;

@Configuration
@Profile("nonblocking")
@EnableR2dbcRepositories(basePackages = "com.jk.apps.trades.reactive_non_reactive.nonblocking.repository")
@EntityScan(basePackages = "com.jk.apps.trades.reactive_non_reactive.common.entity")
public class R2dbcRepositoryConfig {
}