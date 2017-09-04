package ua.com.dao;


import java.util.List;

public interface GeneralDAO<E> {
    void save(E e);
    List<E> findAll();
}
