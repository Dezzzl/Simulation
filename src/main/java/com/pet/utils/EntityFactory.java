package com.pet.utils;

import com.pet.Entity.*;
import com.pet.Map;

import java.util.Random;

public class EntityFactory {
    private Map map;

    public EntityFactory(Map map) {
        this.map = map;
    }

    public Entity getRandomEntity() {
        int rand = new Random().nextInt(20);
        switch (rand) {

            case 1 -> {
                return new Rock();
            }
            case 2 -> {
                return new Tree();
            }
            case 3 -> {
                return new Predator(new Random().nextInt(25) + 1, new Random().nextInt(3) + 1, new Random().nextInt(5) + 1, this.map);
            }
            case 4, 5 -> {
                return new Herbivore(new Random().nextInt(15) + 1, new Random().nextInt(2) + 1, this.map);
            }
            case 6, 7, 8, 9, 10 -> {
                return new Grass(new Random().nextInt(8) + 1);
            }
            default -> {
                return null;
            }
        }
    }
}
