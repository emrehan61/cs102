package Buttons;
import javax.swing.*;

import comClasses.*;

import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A class that allows the user to navigate their pages
*/
public class Menu implements ActionListener
{
    // Properties
    JFrame frame;
    JPanel panel;
    JButton addCategory;
    JButton summary;
    User user;
    
    // Constructors
    /**
     * A constructor that initializes the properties of the Menu
     * @param user is the user of the program
     */
    public Menu( User user )
    {
        frame = new JFrame();
        panel = new JPanel();
        addCategory = new JButton( "Add Category" );
        summary = new JButton( "Check Summary" );
        this.user = user;
    }
    
    // Methods
    /**
     * Runs the program, displays the menu that has severaş options for the user
     */
    public void run()
    {
        addCategory.setFocusable( false );
        summary.setFocusable( false );
        addCategory.setPreferredSize( new Dimension( 150, 25) );
        summary.setPreferredSize( new Dimension( 150, 25) );
        addCategory.addActionListener( this );
        summary.addActionListener( this );
        
        panel.add( addCategory );
        panel.add( summary );
        
        frame.add( panel );
        
        frame.setSize( new Dimension( 700, 500 ) );
        frame.setTitle( "Add Category" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }

    /**
     *Decides what the program will do when an ActionEvent happens 
     * @param e is the ActionEvent
     */
	@Override
    public void actionPerformed(ActionEvent e) 
    {
        if ( e.getSource().equals( addCategory ) )
        {
            frame.dispose();
            AddCategory cat = new AddCategory( user );
            cat.runCategory();
        } 
        else if ( e.getSource() == summary )
        {
            frame.setVisible(false);
            AskForDate askPage = new AskForDate( user );
            askPage.run();
        }
    }   
}