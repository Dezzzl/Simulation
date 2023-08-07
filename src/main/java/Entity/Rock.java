package Entity;

import Entity.Entity;
import config.Sprites;

public class Rock extends Entity {
    @Override
    public String getSprite() {
        return Sprites.Rock;
    }
}
