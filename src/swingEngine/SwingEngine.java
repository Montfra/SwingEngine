package swingEngine;

import swingEngine.drawer.Drawer;
import swingEngine.panel.DrawPanel;
import swingEngine.panel.MenuPanel;

import javax.swing.*;
import java.awt.*;

public class SwingEngine {
    private JFrame window;
    private DrawPanel panel;
    private MenuPanel menu;

    public SwingEngine(String name, int width, int height) {
        this.window = new JFrame();

        window.setTitle(name);
        window.setSize(width, height);
        window.setResizable(false);
        centreWindow(window);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.panel = new DrawPanel(width, height);
    }

    public void setMenu(MenuPanel menu){
        this.menu = menu;
    }

    private static void centreWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }
    public void showMenu(){
        window.setVisible(false);
        window.getContentPane().removeAll();
        window.getContentPane().add(menu);
        window.setVisible(true);
    }

    public void showGame(){
        window.setVisible(false);
        window.getContentPane().removeAll();
        window.getContentPane().add(panel);
        window.setVisible(true);
        window.revalidate();
        window.repaint();
    }

    public void run() {
        long now;
        long updateTime;
        long wait;

        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;

        showMenu();

        while (true) {
            now = System.nanoTime();

            panel.validate();
            panel.repaint();

            updateTime = System.nanoTime() - now;
            wait = (OPTIMAL_TIME - updateTime) / 1000000;

            try {
                if (wait > 0){
                    Thread.sleep(wait);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void addController(int key, int keyRelease, AbstractAction action){
        panel.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(key, keyRelease), key);
        panel.getActionMap().put(key, action);
    }

    public void addDrawer(Drawer drawer) {
        panel.addDrawer(drawer);
    }

}
