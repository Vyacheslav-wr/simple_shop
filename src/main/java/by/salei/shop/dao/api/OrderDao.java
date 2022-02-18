package by.salei.shop.dao.api;

import by.salei.shop.entity.Order;
import by.salei.shop.entity.Product;

import java.util.List;
import java.util.Optional;

public interface OrderDao {

    void save(Order order);

    void update(Order order);

    void delete(Long id);

    Optional<Order> getById(Long id);

    List<Order> getAll();
}
