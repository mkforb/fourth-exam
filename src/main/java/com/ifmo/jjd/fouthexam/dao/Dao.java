package com.ifmo.jjd.fouthexam.dao;

import java.util.List;

/**
 * Created by User on 13.06.2021.
 */
public interface Dao<T, PK> {
    void add(T entity);
    T getByPK(PK pk);
    List<T> getAll();
    void update(T entity);
    void deleteByPK(PK pk);
}
