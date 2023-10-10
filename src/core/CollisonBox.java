package core;

import java.awt.*;

public class CollisonBox {
    private Rectangle bounds;

    public CollisonBox(Rectangle bounds) {
        this.bounds = bounds;
    }
    public boolean collidesWith(CollisonBox other){
        return bounds.intersects(other.getBounds());
    }

    private Rectangle getBounds() {
        return bounds;
    }
}
