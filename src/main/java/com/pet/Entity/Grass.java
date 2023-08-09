package com.pet.Entity;

import com.pet.config.Sprites;

public class Grass extends Entity {
    private int givenHealth;

    public Grass(int givenHealth) {
        this.givenHealth = givenHealth;
    }

    public void setGivenHealth(int givenHealth) {
        this.givenHealth = givenHealth;
    }

    public int getGivenHealth() {
        return givenHealth;
    }

    @Override
    public String getSprite() {
        return Sprites.Grass;
    }
}
