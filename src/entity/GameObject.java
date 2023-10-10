package entity;

import core.CollisonBox;
import core.Position;
import core.Size;
import game.Game;

import java.awt.*;

public abstract class GameObject {
    protected Position position;
    protected Size size;

    public GameObject() {
        position = new Position(50, 300);
        size = new Size(50, 50);
    }

    public abstract void update(Game game);
    public abstract Image getSprite();
    public abstract CollisonBox getCollisionBox();
    public abstract boolean collidingWith(GameObject other);

    public Position getPosition() {
        return position;
    }

    public Size getSize() {
        return size;
    }
}