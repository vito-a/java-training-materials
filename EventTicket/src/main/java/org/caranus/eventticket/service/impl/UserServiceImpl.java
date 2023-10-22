package org.caranus.eventticket.service.impl;

import org.caranus.eventticket.dao.UserDao;
import org.caranus.eventticket.model.User;
import org.caranus.eventticket.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

import static java.util.stream.Collectors.toList;

@Service
public class UserServiceImpl implements UserService
{

    private UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User getUserById(long userId) {
        return userDao.get(userId);
    }

    @Override
    public User getUserByEmail(String email){
        return userDao.getAllUsers().stream()
                                    .filter(user -> user.getEmail().equals(email))
                                    .findFirst()
                                    .orElse(null);
    }

    @Override
    public List<User> getUsersByName(String name){
        return userDao.getAllUsers().stream()
                                    .filter(user -> user.getName()
                                    .equals(name))
                                    .collect(toList());
    }

    @Override
    public User createUser(User user){
        userDao.save(user);
        return userDao.get(user.getId());
    }

    @Override
    public User updateUser(User user){
        return userDao.update(user, user);
    }

    @Override
    public boolean deleteUser(long userId){
        userDao.delete(userId);
        return true;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
