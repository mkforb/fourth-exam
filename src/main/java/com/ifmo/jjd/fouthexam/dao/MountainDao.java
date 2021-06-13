package com.ifmo.jjd.fouthexam.dao;

import com.ifmo.jjd.fouthexam.entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Created by User on 13.06.2021.
 */
public class MountainDao implements Dao<Mountain, Integer> {
    private final EntityManager manager;

    public MountainDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Mountain entity) {
        manager.persist(entity);
    }

    @Override
    public Mountain getByPK(Integer integer) {
        return manager.find(Mountain.class, integer);
    }

    @Override
    public List<Mountain> getAll() {
        Query query = manager.createQuery("SELECT m FROM Mountain m", Mountain.class);
        return query.getResultList();
    }

    @Override
    public void update(Mountain entity) {

    }

    @Override
    public void deleteByPK(Integer integer) {

    }
}
