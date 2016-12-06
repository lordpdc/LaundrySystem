package presentation.gui.elements;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import presentation.gui.tabs.TabContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class WindowManager {
    private JFrame inventory;

    public WindowManager( ) {
        setSystemProperties( );
    }

    public void showInventory( ) {
        inventory = new JFrame("Lavandería H. Express");

        final JFXPanel fxPanel = new JFXPanel( );
        inventory.add( fxPanel );
        inventory.setSize( 900, 640 );
        inventory.setLocationRelativeTo( null );
        inventory.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        inventory.setVisible( true );
        setMenuElement();

        Platform.runLater( new Runnable( ) {
            @Override
            public void run( ) {

                fxPanel.setScene( new TabContainer( ).getScene( ) );
            }
        } );

    }

    private void setSystemProperties( ) {
        // take the menu bar off the jframe

        // set the name of the application menu item
        System.setProperty( "apple.awt.application.name", "Lavanderia" );

        // set the look and feel
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName( ) );
        }catch( ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e ) {
            e.printStackTrace( );
        }
    }

    private void setMenuElement( ) {
        JMenuBar menuBar = new JMenuBar( );
        JButton reportes = new JButton( "Reportes" );
        reportes.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    JFrame frame = new JFrame();
                    JFXPanel panel = new JFXPanel();
                    Parent root = new FXMLLoader().load(getClass().getResourceAsStream("../../window/ReportWindow.fxml"));
                    panel.setScene(new Scene(root));
                    frame.add(panel);
                    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    frame.setSize(600,300);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } );
        menuBar.add( reportes );
        JButton correos = new JButton( "Correos" );
        correos.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed( ActionEvent e ) {
                try {
                    JFrame frame = new JFrame();
                    JFXPanel panel = new JFXPanel();
                    Parent root = new FXMLLoader().load(getClass().getResourceAsStream("../../window/SendEmailWindow.fxml"));
                    panel.setScene(new Scene(root));
                    frame.add(panel);
                    frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                    frame.setSize(600,420);
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        } );
        menuBar.add( correos );
        inventory.setJMenuBar( menuBar );

    }

}
