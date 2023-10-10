package controller;

public interface Controller {

    boolean isRequestingLeft();
    boolean isRequestingRight();
    void Move();
    void Stop();
}
