package by.salei.shop.dao.mapper;

import by.salei.shop.entity.Role;
import by.salei.shop.entity.RoleType;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Role.builder()
                .id(rs.getLong("id"))
                .role(RoleType.valueOf(rs.getString("role")))
                .build();
    }
}
