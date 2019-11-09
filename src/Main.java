import swingEngine.SwingEngine;
import swingEngine.panel.MenuPanel;
import swingEngine.panel.SubMenuPanel;
import swingEngine.util.Animation;
import swingEngine.util.Position;
import swingEngine.drawer.Sprite;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;


public class Main {
    public static void main(String[] args){
        SwingEngine engine = new SwingEngine(new String("Test"), 800, 600);

        MenuPanel menu = new MenuPanel("MainMenu");
        menu.addComponent(new JButton("qsd"));
        menu.addComponent(new JButton("qsd"));
        menu.addComponent(new JButton("qsd"));

        SubMenuPanel tmp = new SubMenuPanel("Sub");
        tmp.setHorizontalAlignement();
        tmp.addComponent(new JButton("qsdd"));
        tmp.addComponent(new JButton("qsdd"));
        tmp.addComponent(new JButton("qsdd"));
        tmp.addComponent(new JButton("qsdd"));

        SubMenuPanel tmp2 = new SubMenuPanel("Sub2");
        tmp2.addPlayButton(engine);

        menu.addButtonGoToSubMenu("Sub", "Sub");
        menu.addButtonGoToSubMenu(tmp, "Sub2", "Sub2");

        menu.addSubMenu("Sub", tmp);
        menu.addSubMenu("Sub2", tmp2);

        engine.setMenu(menu);


        Sprite test = new Sprite("test.png", new Position(0, 0), 128, 128);
        test.addAnimation("basic", new Animation(0, 100, 8, 100, 1));
        test.addAnimation("basse", new Animation(0, 500, 8, 100, -2));
        test.setActualState("basic");
        engine.addDrawer(test);


        engine.addController(KeyEvent.VK_LEFT, "left", 0, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                test.setPosition(new Position(test.getPosition().getX() + 1, test.getPosition().getY()));
                test.setActualState("basse", 2, "basic");
            }
        });

        engine.run();
    }
}