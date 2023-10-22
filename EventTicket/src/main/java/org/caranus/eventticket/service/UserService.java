package org.caranus.eventticket.service;


import java.util.List;

import org.caranus.eventticket.model.User;

public interface UserService {

    User getUserById(long eventId);

    User getUserByEmail(String email);

    List<User> getUsersByName(String name);

    User createUser(User user);

    User updateUser(User user);

    boolean deleteUser(long userId);
}
