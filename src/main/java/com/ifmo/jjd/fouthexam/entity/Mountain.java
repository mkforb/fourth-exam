package com.ifmo.jjd.fouthexam.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by User on 12.06.2021.
 */
@Getter
@Setter
@ToString
@Entity
@Table(name = "tb_mountain")
public class Mountain extends Parent {
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int height;
}
