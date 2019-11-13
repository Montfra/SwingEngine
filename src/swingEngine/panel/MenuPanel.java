package swingEngine.panel;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MenuPanel extends SubMenuPanel {
    private HashMap<String, Component[]> subMenu;
    private List<Component[]> back;

    public MenuPanel(String title) {
        super(title);
        this.subMenu = new HashMap<>();
        back = new ArrayList<>();
    }

    public void addSubMenu(SubMenuPanel subMenu){
        this.subMenu.put(subMenu.getTitle(), subMenu.getComponents());
    }

    private void changeCurrentMenu(String nameSubMenu){
        this.back.add(this.getComponents());

        this.removeAll();

        JPanel pbuton = new JPanel();
        pbuton.setLayout(null);
        JButton back = new JButton("Back");
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                goBack();
            }
        });
        Dimension size = back.getPreferredSize();
        back.setBounds(0, 0, size.width, size.height);
        pbuton.add(back);

        this.add(pbuton);

        Component[] newMenu = this.subMenu.get(nameSubMenu);
        for (Component c : newMenu){
            this.add(c);
        }

        this.revalidate();
        this.repaint();
    }

    public void goBack(){
        this.removeAll();

        for (Component c : back.get(back.size()-1)){
            this.add(c);
        }

        back.remove(back.size()-1);
        this.revalidate();
        this.repaint();
    }

    public void addSubMenuButton(String nameButton, SubMenuPanel subMenu) {
        JButton button = new JButton(nameButton);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                changeCurrentMenu(subMenu.getTitle());
            }
        });

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        addComponent(button);

    }

    public void addSubMenuButtonOnSubMenu(SubMenuPanel on, String nameButton, SubMenuPanel goTo) {
        JButton button = new JButton(nameButton);
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                changeCurrentMenu(goTo.getTitle());
            }
        });

        button.setAlignmentX(Component.CENTER_ALIGNMENT);

        on.addComponent(button);
    }

}
