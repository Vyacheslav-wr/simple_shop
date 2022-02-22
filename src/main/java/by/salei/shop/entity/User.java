package by.salei.shop.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Long id;
    private String login;
    private String password;
    private Long role;
    private UserStatus status;

    public String getStatus() {
        return status.toString();
    }
}
