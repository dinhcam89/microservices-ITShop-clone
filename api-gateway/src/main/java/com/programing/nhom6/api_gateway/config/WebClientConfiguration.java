package com.programing.nhom6.api_gateway.config;


import com.programing.nhom6.api_gateway.repository.IdentityClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@ControllerAdvice
public class WebClientConfiguration {
    @Bean
    WebClient webClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:8087")
                .build();
    }

    @Bean
    IdentityClient identityClient(WebClient webClient) {
        HttpServiceProxyFactory httpServiceProxyFactory = HttpServiceProxyFactory
                .builderFor(WebClientAdapter.create(webClient)).build();

        return httpServiceProxyFactory.createClient(IdentityClient.class);

    }
}
