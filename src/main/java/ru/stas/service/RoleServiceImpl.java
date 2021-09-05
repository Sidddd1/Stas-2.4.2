package ru.stas.service;


import org.springframework.stereotype.Service;
import ru.stas.dao.RoleDao;
import ru.stas.model.Role;
import ru.stas.model.User;

import javax.annotation.PostConstruct;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    final
    RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public List<Role> getRoles() {
        return roleDao.getRoles();
    }

    @Override
    public void setRoles(User user, String[] role) {
        Set<Role> roleSet = new HashSet<>();
        for (int i = 0; i < role.length; i++) {
            if (role[i].equals("ROLE_ADMIN")) {
                roleSet.add(new Role(1L, "ROLE_ADMIN"));

            } else {
                roleSet.add(new Role(2L, "ROLE_USER"));
            }
            user.setRoles(roleSet);
        }
    }

    @PostConstruct
    public void setDate() {
        Role role = new Role(1L, "ROLE_ADMIN");
        Role role2 = new Role(2L, "ROLE_USER");
        roleDao.save(role);
        roleDao.save(role2);
    }


}
