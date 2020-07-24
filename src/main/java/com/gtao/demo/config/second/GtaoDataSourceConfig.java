package com.gtao.demo.config.second;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class GtaoDataSourceConfig {
    @Autowired
    GtaoDataSourceProperties dataSourceProperties;

    @Bean(name = "gtaoDataSource")
    public DataSource goodsCenterDataSource() {
        return getDataSource(dataSourceProperties.getDriverClassName(), dataSourceProperties.getUrl(), dataSourceProperties.getUsername(), dataSourceProperties.getPassword());
    }

    @Bean(name = "gtaoTransactionManager")
    public DataSourceTransactionManager goodsCenterTransactionManager(@Qualifier("gtaoDataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    private DataSource getDataSource(String driverClassName, String url, String username, String password) {
        HikariDataSource dataSource = new HikariDataSource();
        dataSource.setDriverClassName(driverClassName);
        dataSource.setJdbcUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }
}
