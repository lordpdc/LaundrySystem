package presentation.gui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import presentation.gui.tabs.TabContainer;

import javax.swing.*;

public class WindowManager {
    private JFrame inventory;

    public WindowManager() {
        setSystemProperties();
    }

    public void showInventory(){

        inventory = new JFrame("Inventario");

        final JFXPanel fxPanel = new JFXPanel();
        inventory.add(fxPanel);
        inventory.setSize(900, 640);
        inventory.setLocationRelativeTo(null);
        inventory.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        inventory.setVisible(true);

        Platform.runLater(new Runnable() {
            @Override
            public void run() {
                    fxPanel.setScene(new TabContainer().getMainContanier());
            }
        });

    }

    private void setSystemProperties(){
        // take the menu bar off the jframe
        System.setProperty("apple.laf.useScreenMenuBar", "true");

        // set the name of the application menu item
        System.setProperty("apple.awt.application.name", "Lavanderia");

        // set the look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

}
