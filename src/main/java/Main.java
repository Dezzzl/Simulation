import Entity.*;

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
                    renderer.render(map);
                    List<Coordinates> coordinates = (new BreadthFirstSearch()).breadthFirstSearch(new Coordinates(i, j), new Grass(), map);
                    System.out.println(coordinates);
                    for (Coordinates coordinates1 : coordinates) {
                        System.out.println(coordinates1.getX() + " " + coordinates1.getY());
                    }

                }

            }
        }
            renderer.render(map);
    }
}

