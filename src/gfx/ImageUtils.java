package gfx;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ImageUtils {

    public static Image loadImage(String filePath){
        try{
            if(filePath.contains("castle"))
                return ImageIO.read(ImageUtils.class.getResource(filePath));
            return resize(ImageIO.read(ImageUtils.class.getResource(filePath)),150);

        } catch(IOException e){
            System.out.println("Could not load image from path: "+filePath);

        }
        return null;
    }
    public static BufferedImage resize(BufferedImage img, int newH) {
        int newW=newH*img.getWidth()/img.getHeight();
        Image tmp = img.getScaledInstance(newW, newH, Image.SCALE_SMOOTH);
        BufferedImage dimg = new BufferedImage(newW, newH, BufferedImage.TYPE_INT_ARGB);

        Graphics2D g2d = dimg.createGraphics();
        g2d.drawImage(tmp, 0, 0, null);
        g2d.dispose();

        return dimg;
    }
}
