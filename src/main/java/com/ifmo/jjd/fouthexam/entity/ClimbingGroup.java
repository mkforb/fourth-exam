package com.ifmo.jjd.fouthexam.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 12.06.2021.
 */
@Entity
@Table(name = "tb_climbing_group")
public class ClimbingGroup extends Parent {
    @ManyToOne
    @JoinColumn
    private Mountain mountain;
    @Column
    private LocalDateTime start;
    @ManyToMany
    @JoinTable(name = "tb_climbing_group_climber",
            joinColumns = @JoinColumn(name = "climbing_group_id"),
            inverseJoinColumns = @JoinColumn(name = "climber_id"))
    private List<Climber> climbers = new ArrayList<>();
}
