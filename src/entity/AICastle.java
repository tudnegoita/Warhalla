package entity;

import controller.Controller;
import controller.NonMovingController;
import core.Position;
import core.Size;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.util.List;

public class AICastle extends MovingEntity{
    public AICastle(SpriteLibrary spriteLibrary) {
        super(4000, 0, 44, new NonMovingController(), spriteLibrary);
        this.position=new Position(790,100);
        this.size=new Size(300,1000);
        animationManager=new AnimationManager(spriteLibrary.getUnit("aicastle"));
        animationManager.playAnimation("undamaged");
    }

    @Override
    public void deathEffect() {
    }

    @Override
    protected void handleCollision(GameObject other) {

    }

    @Override
    protected void resetState() {

    }

    @Override
    protected void verifyAllCollisions(List<GameObject> colliding) {

    }
}
