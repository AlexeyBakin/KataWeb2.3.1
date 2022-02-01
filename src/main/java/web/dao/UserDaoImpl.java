package web.dao;

import org.springframework.stereotype.Repository;
import web.model.User;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select u from User u", User.class).getResultList();
    }

    @Override
    public User getUserById(long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    public void add(User user) {
        entityManager.persist(user);
    }

    @Override
    public void update(Long id, User newUser) {
        User oldUser = getUserById(id);
        oldUser.setName(newUser.getName());
        oldUser.setLastname(newUser.getLastname());
        oldUser.setEmail(newUser.getEmail());
    }

    @Override
    public void delete(long id) {
        entityManager.remove(getUserById(id));
    }
}