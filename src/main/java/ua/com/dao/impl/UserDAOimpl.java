package ua.com.dao.impl;

import org.springframework.stereotype.Repository;
import ua.com.dao.GeneralDAO;
import ua.com.dao.UserDAO;
import ua.com.entity.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.LinkedList;
import java.util.List;

@Repository
public class UserDAOimpl implements GeneralDAO<User>,UserDAO {
    @PersistenceContext
    private EntityManager manager;

    public EntityManager getManager() {
        return manager;
    }

    public void setManager(EntityManager manager) {
        this.manager = manager;
    }

    public void save(User user) {
        manager.persist(user);
    }

    @SuppressWarnings("unchecked")
    public User findByUserName(String name) {
//        return (User) manager.createQuery("select u from User u where u.username=:uname").setParameter("uname", name);
        List<User> users = new LinkedList<User>();
        users = manager
                .createQuery("from User where username=?")
                .setParameter(0, name)
                .getResultList();

        if (users.size() > 0) {
            return users.get(0);
        } else {
            return null;
        }
    }

    public List<User> findAll() {
        return manager.createQuery("select u from User u",User.class).getResultList();
    }

    public void lockedNonLocked(Boolean iflocked,int id) {
        manager.createQuery("update User u set u.accountNonLocked="+iflocked+" where u.id=?").setParameter(0,id).executeUpdate();
    }


    @SuppressWarnings("unchecked")
    public List<User> findlockedNonLocked(Boolean iflocked) {
        return manager.createQuery("select u from User u where u.accountNonLocked=?").setParameter(0,iflocked).getResultList();
    }
}
