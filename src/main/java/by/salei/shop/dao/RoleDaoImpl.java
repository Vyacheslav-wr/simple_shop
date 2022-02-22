package by.salei.shop.dao;

import by.salei.shop.dao.api.RoleDao;
import by.salei.shop.dao.mapper.RoleMapper;
import by.salei.shop.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class RoleDaoImpl implements RoleDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RoleDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(Role role) {
        jdbcTemplate.update("INSERT INTO roles (name) VALUES (?)", role.getRole());
    }

    @Override
    public void update(Role role) {
        jdbcTemplate.update("UPDATE roles SET role=? WHERE id=?", role.getRole(), role.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM roles where id=?", id);
    }

    @Override
    public Optional<Role> getById(Long id) {
        return jdbcTemplate.query("SELECT * FROM roles WHERE id=?", new RoleMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Role> getAll() {
        return jdbcTemplate.query("SELECT * FROM roles", new RoleMapper());
    }
}
