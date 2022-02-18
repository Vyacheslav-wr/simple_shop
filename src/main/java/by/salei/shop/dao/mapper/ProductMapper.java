package by.salei.shop.dao.mapper;

import by.salei.shop.entity.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {

        return Product.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .definition(rs.getLong("definition"))
                .order(rs.getLong("order"))
                .build();
    }
}
