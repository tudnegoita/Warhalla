package controller;

import input.Input;

import java.awt.event.KeyEvent;

public class AIController implements Controller {
    private boolean moving;



    public AIController() {
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
        return moving;
    }

    @Override
    public boolean isRequestingRight() {
        return false;
    }
}
