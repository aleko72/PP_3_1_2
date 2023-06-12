package org.example.PP_3_2_1.services;
import org.example.PP_3_2_1.models.User;

import java.util.List;


public interface UserService {

    List<User> getUsers();

    User getUserById(long id);

    void save(User user);

    void update(User user);

    void delete(long id);
}
