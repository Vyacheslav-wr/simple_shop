package by.salei.shop.dao.mapper;

import by.salei.shop.dao.api.OrderDao;
import by.salei.shop.entity.Order;
import by.salei.shop.entity.OrderStatus;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OrderMapper implements RowMapper<Order> {

    @Override
    public Order mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Order.builder()
                .id(rs.getLong("id"))
                .date(rs.getDate("date"))
                .status(OrderStatus.valueOf(rs.getString("status")))
                .build();
    }
}
