package swingEngine.drawer;

import swingEngine.util.Animation;
import swingEngine.util.Position;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;

public class Sprite implements Drawer{
    private Position position;
    private int width;
    private int height;
    private BufferedImage image;
    private BufferedImage cropImage;
    private HashMap<String, Animation> animations;
    private Animation actualState;
    private Animation nextAnimation;
    private int animationLenght;
    private int cmpt;

    public Sprite(String path, Position position, int width, int height) {
        this.width = width;
        this.height = height;
        this.position = position;
        try {
            this.image = ImageIO.read(new FileInputStream(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        animations = new HashMap<>();
    }

    public Position getPosition() {
        return position;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void addAnimation(String state, Animation animation) {
        animations.put(state, animation);
    }

    public void setActualState(String state) {
        actualState = animations.get(state);
    }

    public void setActualState(String state, int numberAnimation, String nextState) {
        actualState = animations.get(state);
        nextAnimation = animations.get(nextState);

        if (actualState.getSpeed() > 0) {
            animationLenght = actualState.getLength()/actualState.getSpeed()*numberAnimation;
        }
        else {
            animationLenght = actualState.getLength()*(-actualState.getSpeed())*numberAnimation;
        }

        cmpt = 0;
    }

    @Override
    public void draw(BufferedImage bufferedImage) {
        Position animationPos = actualState.getNextPosition();
        cropImage = image.getSubimage(animationPos.getX(), animationPos.getY(), actualState.getSpriteSize(), actualState.getSpriteSize());
        bufferedImage.getGraphics().drawImage(this.cropImage, position.getX(), position.getY(), width, height, null);

        cmpt++;

        if (cmpt == animationLenght) {
            actualState = nextAnimation;
        }
    }
}
