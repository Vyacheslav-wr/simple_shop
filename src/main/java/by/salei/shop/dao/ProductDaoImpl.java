package by.salei.shop.dao;

import by.salei.shop.dao.api.ProductDao;
import by.salei.shop.dao.mapper.ProductMapper;
import by.salei.shop.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductDaoImpl implements ProductDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ProductDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Product product) {
        jdbcTemplate.update("INSERT INTO products(name, definition, order)" +
                " VALUE (?,?,?)", product.getName(), product.getDefinition(), product.getOrder());

    }

    @Override
    public void update(Product product) {
        jdbcTemplate.update("UPDATE products SET name=?, definition=?, order=? WHERE id=?",
                product.getName(), product.getDefinition(), product.getOrder(), product.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM Product WHERE id=?", id);
    }

    @Override
    public Optional<Product> getById(Long id) {
        return jdbcTemplate.query("SELECT * FROM products WHERE id=?", new ProductMapper(), id)
                .stream()
                .findFirst();

    }

    @Override
    public List<Product> getAll() {
        return jdbcTemplate.query("SELECT * FROM products", new ProductMapper());
    }
}
