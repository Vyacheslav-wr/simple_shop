package by.salei.shop.dao.api;

import by.salei.shop.entity.Product;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductDao {

    void save(Product product);

    void update(Product product);

    void delete(Long id);

    Optional<Product> getById(Long id);

    List<Product> getAll();
}
