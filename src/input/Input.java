package input;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;

public class Input implements KeyListener {

    private boolean[] pressed;
    private final Deque<Integer> inputQueue;
    private static final List<Integer> handledInputs=List.of(
            KeyEvent.VK_UP,
            KeyEvent.VK_DOWN
    );

    public Input() {
        pressed = new boolean[255];
        inputQueue = new ArrayDeque<>();
    }

    public boolean isPressed(int keyCode) {
        return pressed[keyCode];
    }

    public int peekInput(){
        if(inputQueue.peek()==null)
            return -1;
        return inputQueue.peek();

    }
    public void dequeueTop(){
        inputQueue.poll();
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        pressed[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        pressed[e.getKeyCode()] = false;
        if(handledInputs.contains(e.getKeyCode()))
            inputQueue.add(e.getKeyCode());
    }
}
