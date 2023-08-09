package com.pet.Entity;

import com.pet.BreadthFirstSearch;
import com.pet.Coordinates;
import com.pet.Map;
import com.pet.config.Sprites;

import java.util.ArrayList;
import java.util.List;

public class Predator extends Creature {
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    private int damage;

    public Predator(int healthPoints, int speed, int damage, Map map) {
        super(healthPoints, speed);
        this.damage = damage;
        this.map = map;
    }

    @Override
    public String getSprite() {
        return Sprites.Predator;
    }

    @Override
    public void makeMove() {
        BreadthFirstSearch breadthFirstSearch = new BreadthFirstSearch();
        List<Coordinates> wayToHerbivore = breadthFirstSearch.breadthFirstSearch(this.getCoordinates(), new Herbivore(1, 1, new Map(0, 0)), map);
        if (wayToHerbivore.size() < this.getSpeed()) {
            attackHerbivore(wayToHerbivore);
        } else {
            moveToHerbivore(wayToHerbivore);
        }
        wayToHerbivore.remove(0);
    }

    private void attackHerbivore(List<Coordinates> way) {
        Coordinates coordinatesOfHerbivore = way.get(way.size() - 1);
        int currentHpOfHerbivore = ((Herbivore) map.getEntity(coordinatesOfHerbivore)).getHealthPoints() - this.getDamage();
        if (currentHpOfHerbivore > 0) {
            ((Herbivore) map.getEntity(coordinatesOfHerbivore)).setHealthPoints(currentHpOfHerbivore);
            Coordinates coordinatesToMove = way.get(way.size() - 1);
            this.setCoordinates(coordinatesToMove);
            map.AddEntity(coordinatesToMove, this);
        } else {
            map.removeFromMap(coordinatesOfHerbivore);
            this.setCoordinates(coordinatesOfHerbivore);
            map.AddEntity(coordinatesOfHerbivore, this);
        }
    }

    private void moveToHerbivore(List<Coordinates> way) {
        Coordinates coordinatesToHerbivore = way.get(this.getSpeed() - 1);
        map.removeFromMap(this.coordinates);
        this.setCoordinates(coordinatesToHerbivore);
        map.AddEntity(coordinatesToHerbivore, this);
    }

}
