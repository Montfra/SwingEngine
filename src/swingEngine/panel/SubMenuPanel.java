package swingEngine.panel;

import swingEngine.SwingEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubMenuPanel extends JPanel {
    private JLabel title;
    private Boolean isHorizontalAlign;
    private JPanel horizontalAlign;
    private HashMap<String, Component[]> subMenu;
    private List<Component[]> back;

    public SubMenuPanel(String title) {
        super();
        this.subMenu = new HashMap<>();
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        this.back = new ArrayList<>();

        this.title = new JLabel(title);
        this.title.setAlignmentX(Component.CENTER_ALIGNMENT);
        this.add(new JPanel());
        this.add(this.title);

        this.horizontalAlign = new JPanel();
        this.horizontalAlign.setVisible(true);
        setVerticalAlignement();

        this.add(new JPanel());
        this.add(horizontalAlign);

        this.setVisible(true);
    }
    public void setHorizontalAlignement(){
        this.isHorizontalAlign = true;
    }

    public void setVerticalAlignement() {
        this.isHorizontalAlign = false;
    }

    public void addPlayButton(SwingEngine game) {
        JButton play = new JButton("Play");
        play.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                game.chowGame();
            }
        });

        play.setAlignmentX(Component.CENTER_ALIGNMENT);

        addComponent(play);
    }

    public void addComponent(Component component) {
        if (isHorizontalAlign) {
            this.horizontalAlign.add(component);
        }
        else {
            JPanel j = new JPanel();
            j.add(component);
            this.add(j);
        }
    }

}
