package com.example.hexagonal;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(HexagonalConfigurationProperties.class)
public class HexagonalConfiguration {
}
