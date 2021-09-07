package com.zsw.demo.r2dbc.service;

import com.zsw.demo.r2dbc.entity.ClientUser;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author 19213
 * @ClassName IUserService
 * @Description //TODO
 * @Date 2021/9/5 15:18
 **/
public interface IClientUserService {


    Flux<ClientUser> listAllClientUser();


    Mono<ClientUser> saveClientUser(ClientUser userList);


    Mono<ClientUser> updateClientUser(ClientUser clientUser);


    void deleteClientUser(String userId);

}



