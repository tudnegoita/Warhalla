package controller;

import input.Input;

import java.awt.event.KeyEvent;

public class PlayerSpawnController implements SpawnController {
    private final Input input;

    public PlayerSpawnController(Input input) {
        this.input = input;
    }

    @Override
    public boolean requestUp() {
        if(input.peekInput()==KeyEvent.VK_UP){
            input.dequeueTop();
            return true;
        }
        return false;
    }

    @Override
    public boolean requestDown() {
        if(input.peekInput()==KeyEvent.VK_DOWN){
            input.dequeueTop();
            return true;
        }
        return false;
    }

    @Override
    public int requestEntity() {
        if(input.isPressed(KeyEvent.VK_1))
            return 1;
        if(input.isPressed(KeyEvent.VK_2))
            return 2;
        if(input.isPressed(KeyEvent.VK_3))
            return 3;
        return -1;
    }
}
