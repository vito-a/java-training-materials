package org.caranus.eventticket.dao;

import static org.caranus.eventticket.config.AppConstants.USER_PREFIX;

import org.caranus.eventticket.model.AbstractModel;
import org.caranus.eventticket.model.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Component
public class UserDao extends AbstractDao<User> {

    protected UserDao(MapStorage mapStorage) {
        super(mapStorage, User.class);
    }

    @Override
    public User map(Object o) {
        return (User) o;
    }

    @Override
    public String getPrefix() {
        return USER_PREFIX;
    }

    public List<User> getAllUsers() {
        List<User> userList = new ArrayList<>();
        Map<String, AbstractModel> usersMap = getStorage();

        if (usersMap != null) {
            for (AbstractModel item : usersMap.values()) {
                if (item instanceof User) {
                    userList.add((User) item);
                }
            }
        }

        return userList;
    }
}
