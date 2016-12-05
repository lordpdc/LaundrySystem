package presentation.gui;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import presentation.gui.tabs.TabContainer;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WindowManager {
    private JFrame inventory;

    public WindowManager( ) {
        setSystemProperties( );
    }

    public void showInventory( ) {
        inventory = new JFrame( "Inventario" );

        final JFXPanel fxPanel = new JFXPanel( );
        inventory.add( fxPanel );
        inventory.setSize( 900, 640 );
        inventory.setLocationRelativeTo( null );
        inventory.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        inventory.setVisible( true );
        setMenuElement( inventory );

        Platform.runLater( new Runnable( ) {
            @Override
            public void run( ) {

                fxPanel.setScene( new TabContainer( ).getScene( ) );
            }
        } );

    }

    private void setSystemProperties( ) {
        // take the menu bar off the jframe
        System.setProperty( "apple.laf.useScreenMenuBar", "true" );

        // set the name of the application menu item
        System.setProperty( "apple.awt.application.name", "Lavanderia" );

        // set the look and feel
        try {
            UIManager.setLookAndFeel( UIManager.getSystemLookAndFeelClassName( ) );
        }catch( ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e ) {
            e.printStackTrace( );
        }
    }

    private void setMenuElement( JFrame frame ) {
        JMenuBar menuBar = new JMenuBar( );
        JButton reportes = new JButton( "Reportes" );
        reportes.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        } );
        menuBar.add( reportes );
        JButton correos = new JButton( "Correos" );
        correos.addActionListener( new ActionListener( ) {
            @Override
            public void actionPerformed( ActionEvent e ) {

            }
        } );
        menuBar.add( correos );
        inventory.setJMenuBar( menuBar );

    }

}
