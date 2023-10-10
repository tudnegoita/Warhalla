package gfx;

import game.Game;

import java.awt.*;
import java.awt.image.BufferedImage;

public class AnimationManager {
    private SpriteSet spriteSet;
    private BufferedImage currentAnimationSheet;
    private int currentFrameTime;
    private int updatesPerFrame;
    private int frameIndex;
    private String currentAnimationName;

    public AnimationManager(SpriteSet spriteSet){
        this.spriteSet=spriteSet;
        this.updatesPerFrame=5;
        this.frameIndex=0;
        this.currentFrameTime=0;



    }

    public Image getSprite(){

        return currentAnimationSheet;

    }
    public void update() {
        frameIndex++;
        if(frameIndex==updatesPerFrame) {
            currentFrameTime++;
            frameIndex=0;
        }
        if(!spriteSet.has(currentAnimationName+currentFrameTime))
            currentFrameTime=0;
        this.currentAnimationSheet=(BufferedImage) spriteSet.get(currentAnimationName+currentFrameTime);
    }
    public void playAnimation(String name){
        if(currentAnimationName!=null&& !currentAnimationName.equals(name))
            currentFrameTime=0;
        currentAnimationName=name;
    }
}
