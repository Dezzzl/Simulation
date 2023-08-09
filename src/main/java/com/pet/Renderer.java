package com.pet;

import com.pet.Coordinates;
import com.pet.Entity.Entity;
import com.pet.config.Sprites;

import java.util.HashMap;

public class Renderer {
    public void render(Map map) {
        HashMap<Coordinates, Entity> allEntities = map.getAllEntities();

        for (int i = 0; i < map.getX(); i++) {
            for (int j = 0; j < map.getY(); j++) {
                Entity entity = map.getEntity(new Coordinates(i, j));
                System.out.print(entity == null ? Sprites.EmptyCell : " " + entity.getSprite() + " ");
            }
            System.out.println(System.lineSeparator());
        }
    }
}
