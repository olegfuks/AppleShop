package ua.com.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.dao.impl.UserDAOimpl;
import ua.com.entity.Authority;
import ua.com.entity.User;
import ua.com.service.UserService;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService {
    @Autowired
    UserDAOimpl userDAO;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Enumerated(EnumType.STRING)
    private Authority authority = Authority.ROLE_ADMIN;

    public void save(User user) {
        if(user.getUsername().equals("admin")){
            user.setAuthority(authority);
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userDAO.save(user);
    }

    public User findByUserName(String username) {
        return userDAO.findByUserName(username);
    }

    public List<User> findAll() {
        return userDAO.findAll();
    }

    public void lockedNonLocked(Boolean iflocked, int id) {
        userDAO.lockedNonLocked(iflocked,id);
    }

    public List<User> findlockedNonLocked(Boolean iflocked) {
        return userDAO.findlockedNonLocked(iflocked);
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return findByUserName(username);
    }

}
