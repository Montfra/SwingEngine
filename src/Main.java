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
        // Create the window
        SwingEngine engine = new SwingEngine("Test", 800, 600);

        // Create a main menu
        MenuPanel menu = new MenuPanel("MainMenu");
        menu.addComponent(new JButton("qsd"));
        menu.addComponent(new JButton("qsd"));
        menu.addComponent(new JButton("qsd"));

        // Create sub menu for the main menu
        SubMenuPanel tmp = new SubMenuPanel("Sub");
        tmp.setHorizontalAlignement();
        tmp.addComponent(new JButton("qsdd"));
        tmp.addComponent(new JButton("qsdd"));
        tmp.addComponent(new JButton("qsdd"));
        tmp.addComponent(new JButton("qsdd"));

        SubMenuPanel tmp2 = new SubMenuPanel("Sub2");
        tmp2.addPlayButton(engine);

        // Add sub menus to the main menu
        menu.addSubMenu(tmp);
        menu.addSubMenu(tmp2);

        // Add button to navigate between sub menu
        menu.addSubMenuButton("Sub", tmp);
        menu.addSubMenuButtonOnSubMenu(tmp, "Sub2", tmp2);

        // Add menus to the engine
        engine.setMenu(menu);


        // Create the main character
        Sprite test = new Sprite("test.png", new Position(0, 0), 128, 128);
        test.addAnimation("basic", new Animation(0, 100, 8, 100, 1));
        test.addAnimation("basse", new Animation(0, 500, 8, 100, -2));
        test.setActualState("basic");
        engine.addDrawer(test);

        // When we click Left button, the main character go to right
        engine.addController(KeyEvent.VK_LEFT, 0, new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                test.setPosition(new Position(test.getPosition().getX() + 1, test.getPosition().getY()));
                test.setActualState("basse", 2, "basic");
            }
        });

        // All done, we can launch the game
        engine.run();
    }
}