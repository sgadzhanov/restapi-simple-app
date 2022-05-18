package com.example.simplerestapiprojectplayers.model.entity;

import com.example.simplerestapiprojectplayers.model.entity.enums.PositionEnum;

import javax.persistence.*;

@Entity
@Table(name = "PLAYERS")
public class PlayerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String nationality;
    @Column
    private Integer shirtNumber;
    @Enumerated(EnumType.STRING)
    private PositionEnum position;

    public Long getId() {
        return id;
    }

    public PlayerEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlayerEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public PlayerEntity setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public PlayerEntity setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
        return this;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public PlayerEntity setPosition(PositionEnum position) {
        this.position = position;
        return this;
    }
}