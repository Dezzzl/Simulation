package com.pet;

import com.pet.Entity.*;
import com.pet.Entity.*;

import java.util.*;

public class BreadthFirstSearch {
    private final List<Coordinates> exploredCoordinates = new ArrayList<>();
    private final Queue<Coordinates> queuedCoordinates = new LinkedList<>();
    private final HashMap<Coordinates, Coordinates> predecessorMap = new HashMap<>();
    private Entity objectToFind;

    public List<Coordinates> breadthFirstSearch(Coordinates parent, Entity entityToFind, Map map) {
        queuedCoordinates.add(parent);

        while (!queuedCoordinates.isEmpty()) {
            Coordinates currentCoordinate = queuedCoordinates.remove();
            if (map.getEntity(currentCoordinate) != null && map.getEntity(currentCoordinate).getClass() == entityToFind.getClass()) {
                return findWay(currentCoordinate, parent);
            } else {
                takeTheNeighborsOfTheEntity(currentCoordinate, parent, map);
            }
        }
        return null;
    }

    private void takeTheNeighborsOfTheEntity(Coordinates currentCoordinate, Coordinates parent, Map map) {
        int[][] directions = {
                {-1, 0},
                {1, 0},
                {0, -1},
                {0, 1}
        };
        for (int[] direction : directions) {
            int newX = currentCoordinate.getX() + direction[0];
            int newY = currentCoordinate.getY() + direction[1];
            if (newX < 0 || newY < 0 || newX >= map.getX()
                    || newY >= map.getY() || exploredCoordinates.contains(new Coordinates(newX, newY))
                    || isTheCoordinateAnObstacle(new Coordinates(newX, newY), parent, map)) {
                continue;
            } else {
                Coordinates neighboringCoordinate = new Coordinates(newX, newY);
                queuedCoordinates.add(neighboringCoordinate);
                exploredCoordinates.add(neighboringCoordinate);
                predecessorMap.put(neighboringCoordinate, currentCoordinate);
            }
        }
    }

    private List<Coordinates> findWay(Coordinates entityToFind, Coordinates parent) {
        List<Coordinates> way = new ArrayList<>();

        while (entityToFind != parent) {
            way.add(entityToFind);
            entityToFind = predecessorMap.get(entityToFind);
        }
        Collections.reverse(way);
        return way;
    }

    private boolean isTheCoordinateAnObstacle(Coordinates coordinates, Coordinates parentCoordinate, Map map) {
        Entity entity = map.getEntity(coordinates);
        Entity parent = map.getEntity(parentCoordinate);
        if (entity instanceof Rock || entity instanceof Tree) {
            return true;
        } else if (parent instanceof Herbivore && entity instanceof Creature) {
            return true;
        } else return parent instanceof Predator && (entity instanceof Predator || entity instanceof Grass);
    }
}
