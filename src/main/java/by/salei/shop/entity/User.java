package by.salei.shop.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {

    private Long id;
    private String login;
    private String password;
    private Long role;
    private UserStatus status;

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
