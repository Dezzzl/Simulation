package utils;
import Entity.*;

import java.util.Random;

public class EntityFactory {
    public static Entity getRandomEntity(){
        int rand= new Random().nextInt(20);
        switch(rand){
            case 1->{
                return new Grass();
            }
            case 2->{
                return new Rock();
            }
            case 3->{
                return new Tree();
            }
            case 4->{
                return new Predator();
            }
            case 5->{
                return new Herbivore();
            }
            default -> {
                return null;
            }
        }
    }
}
