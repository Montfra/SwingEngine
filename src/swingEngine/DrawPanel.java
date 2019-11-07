package swingEngine;

import swingEngine.drawer.Drawer;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

public class DrawPanel extends JPanel {

    private BufferedImage image;
    private List<Drawer> drawers;

    public DrawPanel(int width, int height) {
        super();
        this.image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        this.drawers = new ArrayList<>();
    }

    public void addDrawer(Drawer drawer){
        drawers.add(drawer);
    }

    @Override
    public void paintComponent(Graphics g) {
        this.image.getGraphics().fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
        for (Drawer d : drawers) {
            d.draw(image);
        }
        g.drawImage(this.image, 0, 0, getWidth(), getHeight(), 0, 0, getWidth(), getHeight(), null);
    }
}
