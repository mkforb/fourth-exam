package com.ifmo.jjd.fouthexam.dao;

import com.ifmo.jjd.fouthexam.entity.Climber;
import com.ifmo.jjd.fouthexam.entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;
import java.util.List;

public class ClimberDao implements Dao<Climber, Integer> {
    private final EntityManager manager;

    public ClimberDao(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void add(Climber entity) {
        manager.persist(entity);
    }

    @Override
    public Climber getByPK(Integer integer) {
        return manager.find(Climber.class, integer);
    }

    @Override
    public List<Climber> getAll() {
        return null;
    }

    @Override
    public void update(Climber entity) {

    }

    @Override
    public void deleteByPK(Integer integer) {

    }

    public Climber getByFullNameEmail(String fullName, String email) {
        TypedQuery<Climber> query = manager.createQuery("SELECT c FROM Climber c WHERE fullName = :fullName AND email = :email", Climber.class)
                .setParameter("fullName", fullName)
                .setParameter("email", email);
        try {
            return query.getSingleResult();
        } catch (NoResultException e) {
            System.out.println("Climber not found");
        }
        return null;
    }
}
