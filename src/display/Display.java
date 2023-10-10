package display;

import display.Renderer;
import game.Game;
import input.Input;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Display extends JFrame {

    private Canvas canvas;
    private display.Renderer renderer;

    public Display(int width, int height, Input input) {
        setTitle("Warhalla");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);


        this.renderer = new Renderer();

        canvas = new Canvas();
        canvas.setPreferredSize(new Dimension(width, height));
        canvas.setFocusable(false);


        add(canvas);
        addKeyListener(input);
        pack();

        canvas.createBufferStrategy(3);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void render(Game game){
        BufferStrategy bufferStrategy = canvas.getBufferStrategy();
        Graphics graphics = bufferStrategy.getDrawGraphics();

        BufferedImage img=new BufferedImage(1,1,1);
        try {
            img=ImageIO.read(new File("resources/background/Background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        graphics.drawImage(img,0,0,canvas);

        renderer.render(game, graphics);

        graphics.dispose();
        bufferStrategy.show();
    }
}
