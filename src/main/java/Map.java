import Entity.Entity;
import utils.EntityFactory;

import java.util.HashMap;

public class Map {
    public HashMap<Coordinates, Entity>entities=new HashMap<>();
    private int x;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private int y;

    public Map(int x, int y) {
        this.x = x;
        this.y = y;
        for(int i=0 ;i<x; i++){
            for(int j=0; j<y; j++){
                entities.put(new Coordinates(i,  j), EntityFactory.getRandomEntity());
            }
        }
    }
    public HashMap<Coordinates, Entity>getAllEntities(){
        return this.entities;
    }
    public Entity getEntity(Coordinates coordinates){
        return entities.get(coordinates);
    }

}
