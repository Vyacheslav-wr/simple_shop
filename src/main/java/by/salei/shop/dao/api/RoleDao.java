package by.salei.shop.dao.api;

import by.salei.shop.entity.Role;

import java.util.List;
import java.util.Optional;

public interface RoleDao {

    void save(Role role);

    void update(Role role);

    void delete(Long id);

    Optional<Role> getById(Long id);

    List<Role> getAll();
}
