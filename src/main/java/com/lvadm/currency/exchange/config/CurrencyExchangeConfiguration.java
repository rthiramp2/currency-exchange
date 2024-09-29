package com.lvadm.currency.exchange.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Configuration
public class CurrencyExchangeConfiguration {

    private static final Integer TIMEOUT = 300000;

    @Bean
    public RestTemplate getRestTemplate(RestTemplateBuilder builder) {
        return builder.setConnectTimeout(Duration.ofMillis(TIMEOUT))
                .setReadTimeout(Duration.ofMillis(TIMEOUT)).build();
    }

}
