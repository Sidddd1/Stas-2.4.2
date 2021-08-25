package ru.stas.service;



import ru.stas.model.User;

import java.util.List;

public interface UserService {
    List<User> listUsers();
    User findById(int id);
    void save(User user);
    void update(User user);
    void delete(User user);
}