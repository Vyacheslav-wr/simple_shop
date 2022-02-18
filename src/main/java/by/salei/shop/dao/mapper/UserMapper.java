package by.salei.shop.dao.mapper;

import by.salei.shop.entity.User;
import by.salei.shop.entity.UserStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        return User.builder()
                .id(rs.getLong("id"))
                .login(rs.getString("login"))
                .password(rs.getString("password"))
                .role(rs.getLong("role"))
                .status(UserStatus.valueOf(rs.getString("status")))
                .build();
    }
}
