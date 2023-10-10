package entity;

import controller.SpawnController;
import core.Position;
import gfx.SpriteLibrary;

import java.util.List;

public class AISpawner extends EntitySpawner{

    private final SpriteLibrary spriteLibrary;
    public AISpawner(SpawnController controller, SpriteLibrary spriteLibrary) {
        super(180, controller);
        this.spriteLibrary = spriteLibrary;
        positions= List.of(
                new Position(824,245),
                new Position(824,315),
                new Position(824,385)
        );

    }

    @Override
    public MovingEntity spawn(int code) {
        System.out.println(code);
        if (code==1)
            return new Knight1(spriteLibrary);
        if (code==2)
            return new Knight2(spriteLibrary);
        if(code==3)
            return new Knight3(spriteLibrary);
        return null;
    }

}
