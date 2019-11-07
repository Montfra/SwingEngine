package swingEngine.drawer;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class StaticImageDrawer implements Drawer {

    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;

    public StaticImageDrawer(String url, int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        try {
            image = ImageIO.read(this.getClass().getResourceAsStream(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void draw(BufferedImage im) {
        im.getGraphics().drawImage(this.image, x, y, width, height, null);
    }
}
