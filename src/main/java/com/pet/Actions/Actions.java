package com.pet.Actions;

import com.pet.Coordinates;
import com.pet.Entity.Creature;
import com.pet.Entity.Entity;
import com.pet.Entity.Grass;
import com.pet.Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Actions {
    private final Map map;

    public Actions(Map map) {
        this.map = map;
    }

    public void turnActions() {
        List<Coordinates> creatureCoordinates = map.getCreatureCoordinates();
        List<Coordinates> newCoordinates = new ArrayList<>();
        for (Coordinates coordinates : creatureCoordinates) {
            if (newCoordinates.contains(coordinates)) {
                continue;
            } else if (map.getEntity(coordinates) == null) continue;
            Creature creature = (Creature) map.getEntity(coordinates);
            creature.makeMove();
            newCoordinates.add(creature.getCoordinates());
        }
        SetNewGrass();
    }
    private void SetNewGrass(){
        int countOfGrass=new Random().nextInt(8);
        int a=0;
        while (a!=countOfGrass){
            int x=new Random().nextInt(map.getX());
            int y=new Random().nextInt(map.getY());
            Coordinates coordinates=new Coordinates(x,y);
            if(map.getEntity(coordinates)==null){
                a++;
                map.AddEntity(coordinates, new Grass(new Random().nextInt(1000)+1));
            }
        }
    }
}
