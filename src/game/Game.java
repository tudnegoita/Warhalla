package game;

import controller.AISpawnController;
import controller.PlayerSpawnController;
import display.Display;
import entity.*;
import gfx.SpriteLibrary;
import input.Input;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    public static int SPRITE_SIZE=512;

    private Display display;
    private List<GameObject> gameObjects;
    private List<GameObject> deadObjects;
    private Input input;
    private SpriteLibrary spriteLibrary;
    private AISpawner aiSpawner;
    private PlayerSpawner playerSpawner;
    public Game(int width, int height) {


        input = new Input();
        display = new Display(width, height, input);
        gameObjects = new ArrayList<>();
        spriteLibrary=new SpriteLibrary();
        System.out.println(spriteLibrary);
        gameObjects.add(new PlayerCastle(spriteLibrary));
        gameObjects.add(new AICastle(spriteLibrary));
        aiSpawner=new AISpawner(new AISpawnController(),spriteLibrary);
        playerSpawner=new PlayerSpawner(new PlayerSpawnController(input),spriteLibrary);
        deadObjects=new ArrayList<>();

    }
    public void killObject(GameObject gameObject){
        deadObjects.add(gameObject);
    }

    public void update() {
        if(gameObjects.stream().anyMatch(g->g instanceof PlayerCastle)&&
                gameObjects.stream().anyMatch(g->g instanceof AICastle)) {
            aiSpawner.update(this);
            playerSpawner.update(this);
            gameObjects.forEach(gameObject -> gameObject.update(this));
            deadObjects.forEach(gameObjects::remove);
            deadObjects.clear();
        }
    }

    public void render() {
        display.render(this);
    }

    public List<GameObject> getGameObjects() {
        return gameObjects;
    }

    public List<GameObject> getCollidingGameObjects(GameObject gameObject) {
        return gameObjects.stream()
                .filter(other->other.collidingWith(gameObject))
                .collect(Collectors.toList());
    }
}

