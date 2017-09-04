package ua.com.service;

import ua.com.entity.User;

import java.util.List;

public interface UserService {
    void save(User user);
    User findByUserName(String username);
    List<User> findAll();
    void lockedNonLocked(Boolean iflocked, int id);
    List<User> findlockedNonLocked(Boolean iflocked);
}
