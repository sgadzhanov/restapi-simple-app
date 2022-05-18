package com.example.simplerestapiprojectplayers.view;

import com.example.simplerestapiprojectplayers.model.entity.enums.PositionEnum;

public class PlayerViewModel {
    private Long id;
    private String name;
    private String nationality;
    private Integer shirtNumber;
    private PositionEnum position;

    public Long getId() {
        return id;
    }

    public PlayerViewModel setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public PlayerViewModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getNationality() {
        return nationality;
    }

    public PlayerViewModel setNationality(String nationality) {
        this.nationality = nationality;
        return this;
    }

    public Integer getShirtNumber() {
        return shirtNumber;
    }

    public PlayerViewModel setShirtNumber(Integer shirtNumber) {
        this.shirtNumber = shirtNumber;
        return this;
    }

    public PositionEnum getPosition() {
        return position;
    }

    public PlayerViewModel setPosition(PositionEnum position) {
        this.position = position;
        return this;
    }
}