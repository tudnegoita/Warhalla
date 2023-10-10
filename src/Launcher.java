import game.Game;
import game.GameLoop;

public class Launcher {

    public static void main(String[] args) {
        new Thread(new GameLoop(new Game(1024, 576))).start();
    }
}
