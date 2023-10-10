package controller;

public class NonMovingController implements Controller{
    @Override
    public boolean isRequestingLeft() {
        return false;
    }

    @Override
    public boolean isRequestingRight() {
        return false;
    }

    @Override
    public void Move() {

    }

    @Override
    public void Stop() {

    }
}
