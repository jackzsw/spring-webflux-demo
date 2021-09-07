package com.zsw.demo.r2dbc.service;

import com.zsw.demo.r2dbc.dao.UserDAO;
import com.zsw.demo.r2dbc.entity.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * @Author 19213
 * @ClassName ClientUserService
 * @Description //TODO
 * @Date 2021/9/5 15:30
 **/
@Component
public class ClientUserService implements IClientUserService {

    @Autowired
    private UserDAO userDAO;


    @Override
    public Flux<ClientUser> listAllClientUser() {

        return userDAO.listAllClient();


    }

    @Override
    public Mono<ClientUser> saveClientUser(ClientUser clientUser) {

        Mono<ClientUser> save = userDAO.save(clientUser);
        return save;

    }

    @Override
    public Mono<ClientUser> updateClientUser(ClientUser clientUser) {
        return null;
    }

    @Override
    public void deleteClientUser(String userId) {

    }

}
