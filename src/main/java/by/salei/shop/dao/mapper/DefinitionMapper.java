package by.salei.shop.dao.mapper;

import by.salei.shop.entity.Definition;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DefinitionMapper implements RowMapper<Definition> {
    @Override
    public Definition mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Definition.builder()
                .id(rs.getLong("id"))
                .definition(rs.getString("definition"))
                .build();
    }
}
