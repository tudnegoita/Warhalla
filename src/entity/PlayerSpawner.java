package entity;

import controller.SpawnController;
import core.Position;
import gfx.SpriteLibrary;

import java.util.List;

public class PlayerSpawner extends EntitySpawner{

    private final SpriteLibrary spriteLibrary;
    public PlayerSpawner(SpawnController controller, SpriteLibrary spriteLibrary) {
        super(120, controller);
        this.spriteLibrary = spriteLibrary;
        positions= List.of(
                new Position(0,230),
                new Position(0,300),
                new Position(0,370)
        );

    }

    @Override
    public MovingEntity spawn(int code) {
        if (code==1)
            return new Viking1(spriteLibrary);
        if (code==2)
            return new Viking2(spriteLibrary);
        if (code==3)
            return new Viking3(spriteLibrary);
        return null;
    }

}
