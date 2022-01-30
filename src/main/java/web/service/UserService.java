package web.service;

import web.model.User;
import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(long id);

    void add(User user);

    void update(User user);

    void delete(long id);
}