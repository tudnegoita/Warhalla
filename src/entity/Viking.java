/*package entity;

import controller.Controller;
import controller.PlayerController;
import core.Position;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class Viking extends MovingEntity {

    public Viking(int healthPoints,int attackPoints, SpriteLibrary spriteLibary) {

        super(healthPoints,attackPoints,44,new PlayerController(),spriteLibary);
        position = new Position(50, 300);
        animationManager=new AnimationManager(spriteLibary.getUnit("viking"));
        animationManager.playAnimation("run");
    }

    @Override
    public void deathEffect() {
        animationManager.playAnimation("die");
    }

    @Override
    protected void handleCollision(GameObject other) {
        controller.Stop();
        if(other instanceof Knight){
            animationManager.playAnimation("attack");
            ((Knight) other).takeDamage(attackPoints);
        }
    }

    @Override
    protected void resetState() {
        controller.Move();
        animationManager.playAnimation("run");
    }

}*/
package entity;

import controller.AIController;
import controller.PlayerController;
import gfx.AnimationManager;
import gfx.SpriteLibrary;

import java.util.List;

public abstract class Viking extends MovingEntity {


    private boolean attacking;
    public Viking(int healthPoints,int attackPoints,String unitName, SpriteLibrary spriteLibary) {

        super(healthPoints,attackPoints,44,new PlayerController(),spriteLibary);
        animationManager=new AnimationManager(spriteLibary.getUnit(unitName));
        attacking=false;
        animationManager.playAnimation("run");
    }


    @Override
    protected void handleCollision(GameObject other) {
        if(!(other instanceof PlayerCastle)) {
            controller.Stop();
        }
        if(other instanceof Knight){
            attacking=true;
            animationManager.playAnimation("attack");
            ((Knight) other).takeDamage(attackPoints);
        }
        if(other instanceof AICastle){
            attacking=true;
            animationManager.playAnimation("attack");
            ((AICastle) other).takeDamage(attackPoints);
        }
    }
    @Override
    protected void verifyAllCollisions(List<GameObject> colliding) {
        if(!colliding.stream().allMatch(g->g instanceof Viking))
            return;
        if(colliding.stream().noneMatch(g-> ((Viking)g).attacking))
            resetState();
    }

    @Override
    protected void resetState() {
        controller.Move();
        attacking=false;
        animationManager.playAnimation("run");
    }

    @Override
    public void deathEffect() {
        attacking=false;
        animationManager.playAnimation("die");
    }
}

