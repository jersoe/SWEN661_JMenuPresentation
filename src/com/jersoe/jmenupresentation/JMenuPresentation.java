package com.jersoe.jmenupresentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class JMenuPresentation implements ActionListener {

    private JFrame frame;

    // Constructor
    JMenuPresentation() {
        // Create a new JFrame (windows for desktop application)
        this.frame = new JFrame("Jeroen's Menu Example");

        // Load icons
        ImageIcon shroom1Icon = new ImageIcon(getClass().getResource("shroom1.png"), "");
        ImageIcon shroom2Icon = new ImageIcon(getClass().getResource("shroom2.png"), "");
        ImageIcon shroom3Icon = new ImageIcon(getClass().getResource("shroom3.png"), "");
        ImageIcon flower1Icon = new ImageIcon(getClass().getResource("flower1.png"), "");
        ImageIcon flower2Icon = new ImageIcon(getClass().getResource("flower2.png"), "");
        ImageIcon goombaIcon = new ImageIcon(getClass().getResource("goomba.png"), "");

        // Create new menu bar
        JMenuBar menuBar = new JMenuBar();

        // Create new menu
        JMenu menu = new JMenu("Mario");

        // Create new sub menu
        JMenu subMenu = new JMenu("Shrooms");

        // Set icon for sub menu
        subMenu.setIcon(shroom1Icon);

        // Create main menu items
        JMenuItem flower1MenuItem = new JMenuItem("Flower 1");
        // Add a shortcut.
        flower1MenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F, ActionEvent.ALT_MASK));
        JMenuItem flower2MenuItem = new JRadioButtonMenuItem("Flower 2");
        JMenuItem goombaMenuItem = new JCheckBoxMenuItem("Goomba");

        // Set icons for main menu items
        flower1MenuItem.setIcon(flower1Icon);
        flower2MenuItem.setIcon(flower2Icon);
        goombaMenuItem.setIcon(goombaIcon);

        // Create sub menu items
        JMenuItem shroom2MenuItem = new JMenuItem("Shroom 2");
        JMenuItem shroom3MenuItem = new JMenuItem("Shroom 3");

        // Set icons for sub menu items
        shroom2MenuItem.setIcon(shroom2Icon);
        shroom3MenuItem.setIcon(shroom3Icon);

        // Set event handlers for menu items
        flower1MenuItem.addActionListener(this);
        shroom2MenuItem.addActionListener(this);

        // You can also use lambda methods. 
        shroom3MenuItem.addActionListener((ActionEvent e) -> {
            JOptionPane.showMessageDialog(frame, "Hello from anon.");
        });

        // Add main menu items to main menu
        menu.add(flower1MenuItem);
        menu.add(flower2MenuItem);
        menu.add(goombaMenuItem);

        // Add a separator
        menu.addSeparator();

        // Add sub menu items to sub menu
        subMenu.add(shroom2MenuItem);
        subMenu.add(shroom3MenuItem);

        // Add sub menu to main menu
        menu.add(subMenu);

        // Add main menu to menu bar
        menuBar.add(menu);

        // Set menu bar for frame
        frame.setJMenuBar(menuBar);

        // Set frame size
        frame.setSize(640, 480);

        // Make frame visible
        frame.setVisible(true);
    }

    /* To implement the ActionListener interface you have to override the 
       actionPerformed method.*/
    @Override
    public void actionPerformed(ActionEvent e) {
        JOptionPane.showMessageDialog(this.frame, "You clicked on " + e.getActionCommand());
    }

    public static void main(String[] args) {
        new JMenuPresentation();
    }

}
