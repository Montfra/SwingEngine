package swingEngine;

import swingEngine.drawer.Sprite;

import javax.swing.*;
import java.awt.*;

public class SwingEngine {
    private JFrame window;
    private DrawPanel panel;

    public SwingEngine(String name, int width, int height) {
        this.window = new JFrame();

        window.setTitle(name);
        window.setSize(width, height);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new DrawPanel(width, height);
        panel.setLayout(new BorderLayout());

        panel.setVisible(true);
        window.getContentPane().add(panel);
        window.setVisible(true);

    }

    public void run() {
        long now;
        long updateTime;
        long wait;

        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        while (true) {
            now = System.nanoTime();

            panel.validate();
            panel.repaint();

            updateTime = System.nanoTime() - now;
            wait = (OPTIMAL_TIME - updateTime) / 1000000;

            try {
                Thread.sleep(wait);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addController(int key, String name, int keyRelease, AbstractAction action){
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, keyRelease), name);
        panel.getActionMap().put(name, action);
    }

    public void addSprite(Sprite sprite) {
        panel.addDrawer(sprite);
    }

}
