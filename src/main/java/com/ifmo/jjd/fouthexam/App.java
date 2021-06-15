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
        climber1.setEmail("vasiliy@test.ru");
        climber1.setUuid(UUID.randomUUID());

        Climber climber2 = new Climber();
        climber2.setFullName("Петр");
        climber2.setAge(32);
        climber2.setEmail("petr@test.ru");
        climber2.setUuid(UUID.randomUUID());

        Mountain mountainElbrus = new Mountain();
        mountainElbrus.setName("Эльбрус");
        mountainElbrus.setHeight(5600);

        Mountain mountainEverest = new Mountain();
        mountainEverest.setName("Эверест");
        mountainEverest.setHeight(8800);

        List<Climber> climbers1 = new ArrayList<>();
        climbers1.add(climber1);
        climbers1.add(climber2);

        ClimbingGroup group1 = new ClimbingGroup();
        group1.setMountain(mountainElbrus);
        group1.setStart(LocalDateTime.of(2021, 6, 20, 10, 0));
        group1.setClimbers(climbers1);

        List<Climber> climbers2 = new ArrayList<>();
        climbers2.add(climber2);

        ClimbingGroup group2 = new ClimbingGroup();
        group2.setMountain(mountainEverest);
        group2.setStart(LocalDateTime.of(2021, 6, 15, 10, 0));
        group2.setClimbers(climbers2);

        manager.getTransaction().begin();
        climberDao.add(climber1);
        climberDao.add(climber2);
        mountainDao.add(mountainElbrus);
        mountainDao.add(mountainEverest);
        climbingGroupDao.add(group1);
        climbingGroupDao.add(group2);
        manager.getTransaction().commit();

        System.out.println(mountainDao.getByHeight(5000, 6000));
        System.out.println(climbingGroupDao.getNotStarted());
        System.out.println(climberDao.getByFullNameEmail("Василий", "vasiliy@test.ru"));
        System.out.println(mountainDao.getByName("Эверест"));
    }
}
