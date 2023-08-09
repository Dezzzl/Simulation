package com.pet;

import com.pet.BreadthFirstSearch;
import com.pet.Coordinates;
import com.pet.Entity.Entity;
import com.pet.Entity.Grass;
import com.pet.Entity.Herbivore;
import com.pet.Entity.Tree;

import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Map map = new Map(10, 10);

        Renderer renderer = new Renderer();
        BreadthFirstSearch bfs = new BreadthFirstSearch();
        for (int i = 0; i < map.getX(); i++) {
            for (int j = 0; j < map.getY(); j++) {
                Entity entity = map.getEntity(new Coordinates(i, j));
                if (entity == null) {
                    continue;
                }
                if (entity.getClass() == Herbivore.class) {

//                    List<Coordinates> coordinates = (new BreadthFirstSearch()).breadthFirstSearch(new Coordinates(i, j), new Grass(), map);
//                    System.out.println(coordinates);
//                    for (Coordinates coordinates1 : coordinates) {
//                        System.out.println(coordinates1.getX() + " " + coordinates1.getY());
//                    }


                    ((Herbivore) entity).makeMove();
                    Thread.sleep(5000);
                    System.out.println();
                    renderer.render(map);


                }

            }
        }


    }
}

