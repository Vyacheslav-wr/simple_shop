package by.salei.shop.dao.api;

import by.salei.shop.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao {

    void save(User user);

    void update(User user);

    void delete(Long id);

    Optional<User> getById(Long id);

    List<User> getAll();
}
