package com.ifmo.jjd.fouthexam.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by User on 12.06.2021.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_climber")
public class Climber extends Parent {
    @Column(nullable = false)
    private String fullName;
    @Column
    private int age;
    @Column
    private String email;
    @Column
    private UUID uuid;
    @ManyToMany(mappedBy = "climbers")
    private List<ClimbingGroup> climbingGroups = new ArrayList<>();
}
