package entity;

import controller.Controller;
import controller.NonMovingController;
import core.Position;
import core.Size;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.util.List;

public class PlayerCastle extends MovingEntity{
    public PlayerCastle(SpriteLibrary spriteLibrary) {
        super(4000, 0, 44, new NonMovingController(), spriteLibrary);
        this.size=new Size(350,1000);
        this.position=new Position(-230,100);
        animationManager=new AnimationManager(spriteLibrary.getUnit("playercastle"));
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
