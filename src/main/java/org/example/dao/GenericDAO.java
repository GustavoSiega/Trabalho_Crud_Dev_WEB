package org.example.dao;

import java.util.List;

public interface GenericDAO<T> {

    List<T> getAll();
    T getById(int id);
    void upsert(T entity);
    void deleteById(int id);
}
