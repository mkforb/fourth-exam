package com.ifmo.jjd.fouthexam.dao;

import com.ifmo.jjd.fouthexam.entity.ClimbingGroup;
import com.ifmo.jjd.fouthexam.entity.Mountain;

import javax.persistence.EntityManager;
import java.time.LocalDateTime;
import java.util.List;

public class ClimbingGroupDao implements Dao<ClimbingGroup, Integer> {
    private final EntityManager manager;

    public ClimbingGroupDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(ClimbingGroup entity) {
        manager.persist(entity);
    }

    @Override
    public ClimbingGroup getByPK(Integer integer) {
        return manager.find(ClimbingGroup.class, integer);
    }

    @Override
    public List<ClimbingGroup> getAll() {
        return manager.createQuery("SELECT cg FROM ClimbingGroup cg", ClimbingGroup.class).getResultList();
    }

    @Override
    public void update(ClimbingGroup entity) {

    }

    @Override
    public void deleteByPK(Integer integer) {

    }

    public List<ClimbingGroup> getNotStarted() {
        return manager.createQuery("SELECT cg FROM ClimbingGroup cg WHERE start > :start", ClimbingGroup.class)
                .setParameter("start", LocalDateTime.now())
                .getResultList();
    }
}
