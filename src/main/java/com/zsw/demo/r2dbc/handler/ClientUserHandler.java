package com.zsw.demo.r2dbc.handler;

import com.zsw.demo.r2dbc.entity.ClientUser;
import com.zsw.demo.r2dbc.service.IClientUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.reactive.TransactionalOperator;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

/**
 * @Author 19213
 * @ClassName ClientUserHandler
 * @Description 相当于controller 中的方法
 * @Date 2021/9/5 16:28
 **/
@Configuration
public class ClientUserHandler {

    @Autowired
    IClientUserService clientUserService;

    @Autowired
    TransactionalOperator transactionalOperator;


    public Mono<ServerResponse> findAllClient(ServerRequest serverRequest) {

        return ServerResponse.ok().body(clientUserService.listAllClientUser(), ClientUser.class);

    }

    public Mono<ServerResponse> saveClient(ServerRequest serverRequest) {

        return serverRequest.bodyToMono(ClientUser.class)
                .flatMap(i -> clientUserService.saveClientUser(i))
                .flatMap(o -> ServerResponse.ok().bodyValue(o))
                .as(transactionalOperator::transactional);//手动使用事务

    }


    public Mono<ServerResponse> saveAnyClient(ServerRequest serverRequest) {

        return serverRequest.bodyToFlux(ClientUser.class)
                .flatMap(i -> clientUserService.saveClientUser(i))
                .then(ServerResponse.ok().build())
                .as(transactionalOperator::transactional);//手动使用事务

    }





}
