package com.zsw.demo.r2dbc.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author 19213
 * @ClassName DataSourceModel
 * @Description //TODO
 * @Date 2021/9/6 14:54
 **/
@Data
@Component
@ConfigurationProperties(prefix = "spring.r2dbc")
public class DataSourceModel {

    private String url;
    private String host;
    private int port;
    private String database;
    private String username;
    private String password;
}
