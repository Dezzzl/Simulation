package com.pet.Entity;

import com.pet.Coordinates;

import java.util.Collections;

public abstract class Entity {

    protected Coordinates coordinates;

    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }


    public abstract String getSprite();
}
