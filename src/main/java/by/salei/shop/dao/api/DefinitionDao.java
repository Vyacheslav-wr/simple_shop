package by.salei.shop.dao.api;

import by.salei.shop.entity.Definition;

import java.util.List;
import java.util.Optional;

public interface DefinitionDao {

    void save(Definition definition);

    void update(Definition definition);

    void delete(Long id);

    Optional<Definition> getById(Long id);

    List<Definition> getAll();
}
