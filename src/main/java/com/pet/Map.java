package com.pet;

import com.pet.Coordinates;
import com.pet.Entity.Entity;
import com.pet.utils.EntityFactory;

import java.util.HashMap;

public class Map {
    private final HashMap<Coordinates, Entity> entities = new HashMap<>();
    private final int x;
    private final int y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    public Map(int x, int y) {
        this.x = x;
        this.y = y;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                Entity entity = (new EntityFactory(this)).getRandomEntity();
                if (entity != null) {
                    entity.setCoordinates(new Coordinates(i, j));
                }
                entities.put(new Coordinates(i, j), entity);
            }
        }
    }

    public HashMap<Coordinates, Entity> getAllEntities() {
        return this.entities;
    }

    public Entity getEntity(Coordinates coordinates) {
        return entities.get(coordinates);
    }

    public void AddEntity(Coordinates coordinates, Entity entity) {
        entities.put(coordinates, entity);
    }

    public void removeFromMap(Coordinates coordinates) {
        entities.remove(coordinates);
    }

}
