package controller;

import input.Input;

import java.awt.event.KeyEvent;

public class PlayerController implements Controller {

    private boolean moving;

    public PlayerController() {
        moving=true;

    }
    @Override
    public void Move() {
        moving=true;
    }

    @Override
    public void Stop() {
        moving=false;
    }


    @Override
    public boolean isRequestingLeft() {
        return false;
    }

    @Override
    public boolean isRequestingRight() {
        return moving;
    }
}
