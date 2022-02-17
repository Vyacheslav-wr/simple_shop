package by.salei.shop.entity;

import lombok.Data;

@Data
public class User {

    private Long id;
    private String login;
    private String password;
    private Long role;
}
