package com.zsw.demo.r2dbc.routing;

import com.zsw.demo.r2dbc.handler.ClientUserHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

/**
 * @Author 19213
 * @ClassName ClientUserRuting
 * @Description 相当于 requestMapping
 * @Date 2021/9/5 16:25
 **/
@Configuration
public class ClientUserRuting {


    @Bean
    public RouterFunction<ServerResponse> route(ClientUserHandler webfluxHandle) {
        return RouterFunctions.route()
                .GET(RoutePath.findAll,webfluxHandle::findAllClient)
                .POST(RoutePath.save,webfluxHandle::saveClient)
                .POST(RoutePath.saveMany,webfluxHandle::saveAnyClient)
                .build();
    }


}
