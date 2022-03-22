package comClasses;

import Buttons.Menu;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.time.LocalDate;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * A class that shows the summary of categories on the given interval of dates
 */
public class SummaryFrame implements ActionListener
{
    // Properties
    ArrayList<LocalDate> dates;
    SummaryGUI sum;
    User user;
    JButton menu;
    JFrame frame;
    JPanel panel;
    JLabel label;
    
    // Constructors
    /**
     * A constructor that initializes the properties of the SummaryFrame
     * @param user is the user
     * @param theDates is the interval of dates that will be used in the summary
     */
    SummaryFrame( User user, ArrayList<LocalDate> theDates )
    {
        this.user = user;
        frame = new JFrame();
        panel = new JPanel();
        label = new JLabel();
        menu = new JButton( "Menu" );
        this.dates = theDates;
        sum = new SummaryGUI( this.user, dates );
    }
    
    // Methods
    /**
     * Runs the program, displays the categories of the user and a graph for each category
     */
    public void run()
    {
        String categoryNames = "";
        ArrayList<String> allCategories = sum.getSummary().getDifferentCategoriesFromDate( dates );
        
        for ( int i = 0; i < allCategories.size(); i++ )
        {
            categoryNames = categoryNames + ( i + 1 ) + ". \n" + allCategories.get( i ) + "  ";
        }
        
        // Color and font
        panel.setBackground( new Color( 51, 204, 255 ) );
        label.setForeground( new Color( 255, 255, 255 ) );
        label.setFont( new Font( "Serif", Font.BOLD, 15) );
        menu.setBackground( new Color( 255, 255, 255 ) );
        
        // Other settings
        label.setText( categoryNames );
        menu.setFocusable( false );
        menu.addActionListener( this );
        panel.setPreferredSize( new Dimension( 150, 150 ) );
        
        // Adding components
        panel.add( label );
        panel.add( menu );
        
        // The settings of the frame
        frame.add( panel, BorderLayout.SOUTH );
        frame.add( sum, BorderLayout.CENTER );
        sum.repaint();
        
        frame.getContentPane().setBackground( new Color( 51, 204, 255 ) );
        frame.setSize( new Dimension( 700, 500 ) );
        frame.setTitle( "Summary Viewer" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }

    /**
     * Decides what the program will do when an ActionEvent happens 
     * @param e is the ActionEvent
     */
	@Override
    public void actionPerformed( ActionEvent e ) 
    {
        // Opens the menu page when menu button is pressed
        if ( e.getSource() == menu )
        {
            frame.dispose();
           // Menu menu = new Menu( user );
            //menu.run();
        }    
		
	}
}