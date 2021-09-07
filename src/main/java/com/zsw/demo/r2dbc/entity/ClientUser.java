package com.zsw.demo.r2dbc.entity;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

/**
 * @Author 19213
 * @ClassName User
 * @Description //TODO
 * @Date 2021/9/5 15:26
 **/
@Data
@Builder
@Table("client_user")
@AllArgsConstructor
@NoArgsConstructor
public class ClientUser {

    @Id
    private String userId;

    private String username;

    private String phoneNumber;

    private Integer gender;

}
