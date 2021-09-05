package ru.stas.dao;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.stas.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;


@Repository
@Transactional
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> listUsers() {

        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    public User findById(Long id) {
        return entityManager.find(User.class, id);
    }


    public User findUserByUsername(String username) {
        try {
            Query query = entityManager.createQuery("from User where email = :username", User.class);
            query.setParameter("username", username);
            User user = (User) query.getSingleResult();
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
            return user;
        } catch (UsernameNotFoundException e) {
            throw new RuntimeException("User not found");
        }
    }

    public void save(User user) {
        entityManager.persist(user);
    }

    public void update(User user) {
        entityManager.merge(user);
    }

    public void delete(User user) {
        User userDel = entityManager.find(User.class, user.getId());
        entityManager.remove(userDel);
    }
}
