package com.zsw.demo.r2dbc.dao;

import com.zsw.demo.r2dbc.entity.ClientUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.r2dbc.core.R2dbcEntityTemplate;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

/**
 * @Author 19213
 * @ClassName UserDAO
 * @Description //TODO
 * @Date 2021/9/5 15:17
 **/
@Component
@Repository
public interface UserDAO extends ReactiveCrudRepository<ClientUser,Long> {


//    @Autowired
//    R2dbcEntityTemplate r2dbcEntityTemplate;


    @Query("SELECT * FROM client_user")
    Flux<ClientUser> listAllClient();



}
