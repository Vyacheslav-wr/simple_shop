package by.salei.shop.dao;

import by.salei.shop.dao.api.DefinitionDao;
import by.salei.shop.dao.mapper.DefinitionMapper;
import by.salei.shop.entity.Definition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class DefinitionDaoImpl implements DefinitionDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DefinitionDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Definition definition) {
        jdbcTemplate.update("INSERT INTO definitions (definition) VALUES (?)", definition.getDefinition());
    }

    @Override
    public void update(Definition definition) {
        jdbcTemplate.update("UPDATE definitions SET definition=?", definition.getDefinition());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM definitions WHERE id=?", id);
    }

    @Override
    public Optional<Definition> getById(Long id) {
        return jdbcTemplate.query("SELECT * FROM definitions WHERE id=?", new DefinitionMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Definition> getAll() {
        return jdbcTemplate.query("SELECT * FROM definitions", new DefinitionMapper());
    }
}
