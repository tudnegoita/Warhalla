package entity;

import com.sun.management.GarbageCollectionNotificationInfo;
import controller.Controller;
import core.CollisonBox;
import core.Movement;
import game.Game;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import javax.swing.plaf.nimbus.State;
import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class MovingEntity extends GameObject {

    private int healthPoints;
    protected final int attackPoints;
    protected Controller controller;
    private Movement movement;
    private boolean dying;
    private int deathCooldown;
    protected AnimationManager animationManager;

    public MovingEntity(int healthPoints,int attackPoints,int deathCooldown, Controller controller, SpriteLibrary spriteLibrary) {
        super();
        this.controller = controller;
        this.movement = new Movement(2);
        this.healthPoints=healthPoints;
        this.attackPoints=attackPoints;
        dying=false;
        this.deathCooldown=deathCooldown;
    }

    public void takeDamage(int attackPoints){
        healthPoints-=attackPoints;
    }
    public abstract void deathEffect();
    @Override
    public void update(Game game) {
        if(dying==false) {
            movement.update(controller);
            position.apply(movement);
            animationManager.update();
            handleCollisions(game);
            if (healthPoints <= 0) {
                dying = true;
                deathEffect();
            }
        }
        else{
            animationManager.update();
            if(deathCooldown==0)
                game.killObject(this);
            deathCooldown-=1;
        }
    }

    private void handleCollisions(Game game) {
        var colliding=game.getCollidingGameObjects(this);
        if(colliding.size()==0)
            resetState();

        colliding.forEach(this::handleCollision);
        verifyAllCollisions(colliding);

    }

    protected abstract void handleCollision(GameObject other);
    protected abstract void resetState();
    protected abstract void verifyAllCollisions(java.util.List<GameObject> colliding);
    @Override
    public boolean collidingWith(GameObject other) {
        if(this==other)

            return false;
        return getCollisionBox().collidesWith(other.getCollisionBox());
    }

    @Override
    public CollisonBox getCollisionBox(){
        if(dying==false) {
            return new CollisonBox(
                    new Rectangle(
                            position.intX(),
                            position.intY(),
                            size.getWidth(),
                            size.getHeight()
                    )

            );
        }
        return new CollisonBox(new Rectangle(0,0,0,0));
    }

    @Override
    public Image getSprite() {
        return animationManager.getSprite();

    }
}
