package ua.com.dao;


import ua.com.entity.User;

import java.util.List;

public interface UserDAO {
    User findByUserName(String name);

    List<User> findAll();

    void lockedNonLocked(Boolean iflocked, int id);


    List<User> findlockedNonLocked(Boolean iflocked);

}
