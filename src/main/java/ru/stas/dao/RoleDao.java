package ru.stas.dao;

import ru.stas.model.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getRoles();
    void save(Role role);
}
