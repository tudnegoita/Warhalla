package controller;

import java.util.Random;

public class AISpawnController implements SpawnController{
    private final Random random;

    public AISpawnController() {
        random = new Random();
        random.setSeed(System.currentTimeMillis());
    }

    @Override
    public boolean requestUp() {

        if(random.nextFloat()<0.25)
            return true;
        return false;
    }

    @Override
    public boolean requestDown() {
        if(random.nextFloat()<0.5)
            return true;
        return false;
    }

    @Override
    public int requestEntity() {
        return Math.abs(random.nextInt())%3+1;
    }
}
