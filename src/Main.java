import swingEngine.SwingEngine;
import swingEngine.util.Animation;
import swingEngine.util.Position;
import swingEngine.drawer.Sprite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Main {
    public static void main(String[] args){
        SwingEngine engine = new SwingEngine(new String("Test"), 800, 600);

        Sprite test = new Sprite("test.png", new Position(0, 0), 128, 128);
        test.addAnimation("basic", new Animation(0, 100, 8, 100, 1));
        test.setActualState("basic");
        engine.addSprite(test);


        engine.addController(KeyEvent.VK_LEFT, "left", 0, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                test.setPosition(new Position(test.getPosition().getX() + 1, test.getPosition().getY()));
            }
        });

        engine.run();
    }
}