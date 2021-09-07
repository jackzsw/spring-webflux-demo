package com.zsw.demo.r2dbc.config;

import dev.miku.r2dbc.mysql.MySqlConnectionConfiguration;
import dev.miku.r2dbc.mysql.MySqlConnectionFactory;
import io.r2dbc.spi.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySources;
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;

/**
 * @Author 19213
 * @ClassName ApplicationConfiguration
 * @Description //TODO
 * @Date 2021/9/5 14:14
 **/
@Configuration
public class R2dbcApplicationConfiguration extends AbstractR2dbcConfiguration {

    @Autowired
    DataSourceModel dataSourceModel;

    @Override
    @Bean
    public ConnectionFactory connectionFactory() {

        MySqlConnectionConfiguration configuration = MySqlConnectionConfiguration.builder()
                .host(dataSourceModel.getHost())
                .username(dataSourceModel.getUsername())
                .port(dataSourceModel.getPort()) // optional, default 3306
                .password(dataSourceModel.getPassword()) // optional, default null, null means has no password
                .database(dataSourceModel.getDatabase()) // optional, default null, null means not specifying the database
                .build();
        ConnectionFactory connectionFactory = MySqlConnectionFactory.from(configuration);
        return connectionFactory;
    }

    @Bean
    public R2dbcEntityTemplate r2dbcEntityTemplate(ConnectionFactory connectionFactory) {
        return new R2dbcEntityTemplate(connectionFactory);
    }


    @Bean
    public ReactiveTransactionManager transactionManager(ConnectionFactory connectionFactory) {
        return (new R2dbcTransactionManager(connectionFactory));
    }

    @Bean
    public TransactionalOperator transactionalOperator(ReactiveTransactionManager transactionManager) {
        return TransactionalOperator.create(transactionManager);
    }


}
