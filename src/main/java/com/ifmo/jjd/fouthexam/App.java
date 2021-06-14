package com.ifmo.jjd.fouthexam;

import com.ifmo.jjd.fouthexam.dao.ClimberDao;
import com.ifmo.jjd.fouthexam.dao.ClimbingGroupDao;
import com.ifmo.jjd.fouthexam.dao.MountainDao;
import com.ifmo.jjd.fouthexam.entity.Climber;
import com.ifmo.jjd.fouthexam.entity.ClimbingGroup;
import com.ifmo.jjd.fouthexam.entity.Mountain;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by User on 13.06.2021.
 */
public class App {
    public static void main(String[] args) {
        EntityManager manager = Persistence.createEntityManagerFactory("dbConfig").createEntityManager();
        ClimberDao climberDao = new ClimberDao(manager);
        MountainDao mountainDao = new MountainDao(manager);
        ClimbingGroupDao climbingGroupDao = new ClimbingGroupDao(manager);

        Climber climber1 = new Climber();
        climber1.setFullName("Василий");
        climber1.setAge(23);
        climber1.setEmail("test@test.ru");
        climber1.setUuid(UUID.randomUUID());

        List<Climber> climbers = new ArrayList<>();
        climbers.add(climber1);

        Mountain mountain1 = new Mountain();
        mountain1.setName("Elbrus");
        mountain1.setHeight(5600);

        Mountain mountain2 = new Mountain();
        mountain2.setName("Everest");
        mountain2.setHeight(8600);

        ClimbingGroup group = new ClimbingGroup();
        group.setMountain(mountain1);
        group.setStart(LocalDateTime.of(2021, 6, 15, 10, 0));
        group.setClimbers(climbers);

        manager.getTransaction().begin();
        climberDao.add(climber1);
        mountainDao.add(mountain1);
        mountainDao.add(mountain2);
        climbingGroupDao.add(group);
        manager.getTransaction().commit();

        System.out.println(mountainDao.getByHeight(5000, 6000));
        System.out.println(climbingGroupDao.getNotStarted());
        System.out.println(climberDao.getByFullNameEmail("Василий", "test@test.ru"));
        System.out.println(mountainDao.getByName("Everest1"));
    }
}
