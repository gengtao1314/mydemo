package com.gtao.demo.config.second;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "gtao.datasource")
public class GtaoDataSourceProperties {
    private String driverClassName;
    private String url;
    private String username;
    private String password;
}
