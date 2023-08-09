package com.pet.Entity;

import com.pet.BreadthFirstSearch;
import com.pet.Coordinates;
import com.pet.Map;
import com.pet.config.Sprites;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Herbivore extends Creature {
    public Herbivore(int healthPoints, int speed, Map map) {
        super(healthPoints, speed);
        this.map = map;
    }

    @Override
    public String getSprite() {
        return Sprites.Herbivore;
    }

    @Override
    public void makeMove() {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        List<Coordinates> wayToGrass = new ArrayList<>();
        wayToGrass = breadthFirstSearch.breadthFirstSearch(this.getCoordinates(), new Grass(1), map);
        if (wayToGrass.size() < this.getSpeed()) {
            eatGrass(wayToGrass);
        } else {
            moveToGrass(wayToGrass);
        }
    }

    private void eatGrass(List<Coordinates> way) {

        Coordinates coordinatesOfGrass = way.get(way.size() - 1);
        map.removeFromMap(coordinatesOfGrass);
        map.removeFromMap(this.getCoordinates());
        this.setCoordinates(coordinatesOfGrass);
        this.setHealthPoints(this.getHealthPoints() + 5);
        map.AddEntity(coordinatesOfGrass, this);
    }

    private void moveToGrass(List<Coordinates> way) {
        Coordinates coordinatesToGrass = way.get(getSpeed() - 1);
        map.removeFromMap(this.coordinates);
        this.setCoordinates(coordinatesToGrass);
        map.AddEntity(coordinatesToGrass, this);
    }

}
