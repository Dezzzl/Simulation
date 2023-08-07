package Entity;

public abstract class Creature extends Entity {
    int healthPoints=10;
    int speed=1;
    public abstract void makeMove();
}
