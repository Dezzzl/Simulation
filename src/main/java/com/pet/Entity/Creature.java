package com.pet.Entity;

import com.pet.Map;

public abstract class Creature extends Entity {
    private int healthPoints;

    public Creature(int healthPoints, int speed) {
        this.healthPoints = healthPoints;
        this.speed = speed;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public int getSpeed() {
        return speed;
    }

    private int speed;

    public Map map;

    public abstract void makeMove();
}
