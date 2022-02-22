package by.salei.shop.dao;

import by.salei.shop.dao.api.UserDao;
import by.salei.shop.dao.mapper.UserMapper;
import by.salei.shop.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDaoImpl implements UserDao {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public UserDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void save(User user) {
        jdbcTemplate.update("INSERT INTO users(login, password, role, status) VALUES(?,?,?,?)",
                user.getLogin(), user.getPassword(), user.getRole(), user.getStatus());
    }

    @Override
    public void update(User user) {
        jdbcTemplate.update("UPDATE users SET login=?, password=?, role=?, status=? WHERE id=?",
                user.getLogin(), user.getPassword(), user.getRole(), user.getStatus(), user.getId());
    }

    @Override
    public void delete(Long id) {
        jdbcTemplate.update("DELETE FROM users WHERE id=?", id);
    }

    @Override
    public Optional<User> getById(Long id) {
        return jdbcTemplate.query("SELECT * FROM users WHERE id=?", new UserMapper(), id)
                .stream()
                .findFirst();
    }

    @Override
    public List<User> getAll() {
        return jdbcTemplate.query("SELECT * FROM users", new UserMapper());
    }
}
