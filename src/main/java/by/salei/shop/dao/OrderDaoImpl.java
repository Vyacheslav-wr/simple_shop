package by.salei.shop.dao;

import by.salei.shop.dao.api.OrderDao;
import by.salei.shop.dao.mapper.OrderMapper;
import by.salei.shop.entity.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class OrderDaoImpl implements OrderDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public OrderDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Order order) {
        jdbcTemplate.update("INSERT INTO orders(id, order_date, status, user) VALUES (?,?,?,?)",
                order.getId(),order.getDate(), order.getStatus(), order.getUser());
    }

    @Override
    public void update(Order order) {
        jdbcTemplate.update("UPDATE orders SET date=?, status=?, user=? WHERE id=?",
                order.getDate(), order.getStatus() ,order.getId(), order.getUser());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM orders WHERE id=?", id);
    }

    @Override
    public Optional<Order> getById(Long id) {
        return jdbcTemplate.query("SELECT * FROM orders WHERE id=?",
                new OrderMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Order> getAll() {
        return jdbcTemplate.query("SELECT * FROM orders", new OrderMapper());
    }
}
