package com.ifmo.jjd.fouthexam.dao;

import com.ifmo.jjd.fouthexam.entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
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
        return manager.createQuery("SELECT m FROM Mountain m", Mountain.class).getResultList();
    }

    @Override
    public void update(Mountain entity) {

    }

    @Override
    public void deleteByPK(Integer integer) {

    }

    public List<Mountain> getByHeight(int min, int max) {
        TypedQuery<Mountain> query = manager.createQuery("SELECT m FROM Mountain m WHERE height BETWEEN :min AND :max", Mountain.class)
                .setParameter("min", min)
                .setParameter("max", max);
        return query.getResultList();
    }

    public Mountain getByName(String name) {
        TypedQuery<Mountain> query = manager.createQuery("SELECT m FROM Mountain m WHERE name = :name", Mountain.class)
                .setParameter("name", name);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Mountain not found");
        }
        return null;
    }
}
