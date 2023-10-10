package entity;

import controller.SpawnController;
import core.Position;
import game.Game;

import java.util.List;

public abstract class EntitySpawner {
    private int laneSelection;
    private int cooldown=0;
    private final int maxCooldown;
    protected List<Position> positions;
    private final SpawnController controller;


    protected EntitySpawner(int maxCooldown, SpawnController controller) {
        this.maxCooldown = maxCooldown;
        this.controller = controller;
    }
    public void update(Game game){
        if (controller.requestUp()) {
            laneSelection = laneSelection - 1;
            if(laneSelection<0)
                laneSelection+=3;
        }
        if (controller.requestDown())
            laneSelection=(laneSelection+1)%3;
        if (cooldown!=0) {
            cooldown-=1;
            return;
        }
        int request= controller.requestEntity();
        if (request!=-1) {
            var entity = spawn(request);
            var p=positions.get(laneSelection);
            entity.position=new Position(p.getX(),p.getY());
            game.getGameObjects().add(entity);
            cooldown=maxCooldown;
        }
    }
    public abstract MovingEntity spawn(int code);
}
