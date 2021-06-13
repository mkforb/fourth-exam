package com.ifmo.jjd.fouthexam.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 12.06.2021.
 */
@Getter
@Setter
@Entity
@Table(name = "tb_mountain")
public class Mountain extends Parent {
    @Column
    private String name;
    @Column
    private int height;
}
