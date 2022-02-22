package by.salei.shop.dto;

import by.salei.shop.entity.UserStatus;
import lombok.Data;

@Data
public class UserDto {

    private String login;
    private String password;
    private Long role;
    private UserStatus status;
}
