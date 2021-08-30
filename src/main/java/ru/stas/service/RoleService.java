package ru.stas.service;

import ru.stas.model.Role;
import ru.stas.model.User;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
    void setRoles(User user, String[] role);
}
