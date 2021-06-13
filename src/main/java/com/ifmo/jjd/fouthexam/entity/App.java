package com.ifmo.jjd.fouthexam.entity;

import com.ifmo.jjd.fouthexam.dao.MountainDao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 * Created by User on 13.06.2021.
 */
public class App {
    public static void main(String[] args) {
        EntityManager manager = Persistence.createEntityManagerFactory("dbConfig").createEntityManager();

        Mountain mountain1 = new Mountain();
        mountain1.setName("Elbrus");
        mountain1.setHeight(5600);

        Mountain mountain2 = new Mountain();
        mountain2.setName("Everest");
        mountain2.setHeight(8600);

        MountainDao mountainDao = new MountainDao(manager);

        manager.getTransaction().begin();
        mountainDao.add(mountain1);
        mountainDao.add(mountain2);
        manager.getTransaction().commit();
    }
}
