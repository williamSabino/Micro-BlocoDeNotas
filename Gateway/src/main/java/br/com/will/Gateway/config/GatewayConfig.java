package br.com.will.Gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    @Bean
    public RouteLocator customRouter(RouteLocatorBuilder builder){
        return builder.routes()
                .route(r -> r
                        .path("/usuarios")
                        .filters(f -> f.addRequestHeader("hello", "world"))
                        .uri("http://localhost:8083/usuarios"))
                .route(r -> r
                        .path("/usuarios/qtdeNotas/")
                        .uri("http://localhost:8083/usuarios/qtdeNotas/"))
                .route(r -> r
                        .path("/notas")
                        .filters(f -> f.addRequestHeader("hello", "world"))
                        .uri("http://localhost:8084/notas"))
                .build();
    }
}
