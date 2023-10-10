package entity;

import controller.AIController;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.util.List;

public abstract class Knight extends MovingEntity {

    private boolean attacking;

    public Knight(int healthPoints,int attackPoints,String unitName, SpriteLibrary spriteLibary) {

        super(healthPoints,attackPoints,44,new AIController(),spriteLibary);
        animationManager=new AnimationManager(spriteLibary.getUnit(unitName));
        animationManager.playAnimation("WALK_00");
    }


    @Override
    protected void handleCollision(GameObject other) {
        if(!(other instanceof AICastle)) {
            controller.Stop();
        }
        if(other instanceof Viking){
            attacking=true;
            animationManager.playAnimation("ATTACK_00");
            ((Viking) other).takeDamage(attackPoints);
        }
        if(other instanceof PlayerCastle){
            attacking=true;
            animationManager.playAnimation("ATTACK_00");
            ((PlayerCastle) other).takeDamage(attackPoints);
        }
    }

    @Override
    protected void verifyAllCollisions(List<GameObject> colliding) {
        if(!colliding.stream().allMatch(g->g instanceof Knight))
            return;
        if(colliding.stream().noneMatch(g-> ((Knight)g).attacking))
            resetState();
    }

    @Override
    protected void resetState() {
        controller.Move();
        attacking=false;
        animationManager.playAnimation("WALK_00");
    }

    @Override
    public void deathEffect() {
        attacking=false;
        animationManager.playAnimation("DIE_00");
    }

}
