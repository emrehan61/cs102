package comClasses;

import Buttons.Menu;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * A GUI class that asks the user to enter a date in order to calculate the daily, weekly or monthly summary 
 * starting from that date
*/
public class AskForDate implements ActionListener
{
    // Properties
    JFrame frame;
    JPanel panel1;
    JPanel panel2;
    JPanel panel3;
    JLabel label;
    JTextField textField;
    JButton daily;
    JButton weekly;
    JButton monthly;
    JButton menu;
    ArrayList<LocalDate> dates;
    User user;
    
    // Constructors
    /**
     * A constructor that initializes the properties of AskForDate class
     * @param user is the user of the program
     */
    public AskForDate( User user )
    {
        frame = new JFrame();
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        label = new JLabel();
        textField = new JTextField(LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        daily = new JButton( "Daily Summary" );
        weekly = new JButton( "Weekly Summary" );
        monthly = new JButton( "Monthly Summary" );
        menu = new JButton( "Menu" );
        dates = new ArrayList <LocalDate>();
        this.user = user;
    }
    
    // Methods
    /**
     * Decides what the program will do when an ActionEvent happens 
     * @param e is the ActionEvent
     */
    @Override
    public void actionPerformed( ActionEvent e ) 
    {
        // If the textField is used, the String is converted to a LocalDate object
        if ( e.getSource() == textField )
        {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate start = LocalDate.parse( textField.getText(), formatter );
            dates.add( start );
        }
        // If the daily button is pressed, the program displays the daily summary
        if ( e.getSource() == daily )
        {
            // Check whether there is a starting date
            if ( dates.size() > 0)
            {   
                
                frame.dispose();
                SummaryFrame dailySum = new SummaryFrame( user, dates );
                dailySum.run();
                
            }
            else
            {
                JFrame error = new JFrame();
                JLabel msg = new JLabel( "Please enter a date" );
                
                msg.setHorizontalAlignment( JLabel.CENTER );
                
                error.add( msg );
                error.setSize( new Dimension( 200, 100 ) );
                error.setTitle( "Error" );
                error.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
                error.setVisible( true );
            }
        }
        // If the weekly button is pressed, the program displays the weekly summary
        else if ( e.getSource() == weekly )
        {
            // Check whether there is a starting date
            if ( dates.size() > 0)
            {
                frame.dispose();
                
                for ( int i = 1; i <= 7; i++ )
                {
                    dates.add( dates.get( 0 ).plusDays( i ) );
                }
                
                SummaryFrame weeklySum = new SummaryFrame( user, dates );
                weeklySum.run();
            }
            else
            {
                JFrame error = new JFrame();
                JLabel msg = new JLabel( "Please enter a date" );
                
                msg.setHorizontalAlignment( JLabel.CENTER );
                
                error.add( msg );
                error.setSize( new Dimension( 200, 100 ) );
                error.setTitle( "Error" );
                error.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
                error.setVisible( true );
            }
        }
        // If the monthly button is pressed, the program displays the monthly summary
        else if ( e.getSource() == monthly )
        {
            // Check whether there is a starting date
            if ( dates.size() > 0)
            {
                frame.dispose();
            
                for ( int i = 1; i <= 30; i++ )
                {
                dates.add( dates.get( 0 ).plusDays( i ) );
            }
            
                SummaryFrame monthlySum = new SummaryFrame( user, dates );
                monthlySum.run();
            }
            else
            {
                JFrame error = new JFrame();
                JLabel msg = new JLabel( "Please enter a date" );
                
                msg.setHorizontalAlignment( JLabel.CENTER );
                
                error.add( msg );
                error.setSize( new Dimension( 200, 100 ) );
                error.setTitle( "Error" );
                error.setDefaultCloseOperation( JFrame.HIDE_ON_CLOSE );
                error.setVisible( true );
            }
        }
        // If the menu button is pressed, the program opens the menu page
        else if ( e.getSource() == menu )
        {
            frame.dispose();
        }
		
    }
    
    /**
     * Runs the program, asks the user to enter a date and choose a summary type
     */
    public void run()
    {
        // Arranging the colors
        panel1.setBackground( new Color( 51, 204, 255 ) );
        panel2.setBackground( new Color( 51, 204, 255 ) );
        panel3.setBackground( new Color( 51, 204, 255 ) );
        label.setForeground( new Color( 255, 255, 255 ) );
        label.setFont( new Font( "Serif", Font.BOLD, 15) );
        daily.setBackground( new Color( 255, 255, 255 ) );
        weekly.setBackground( new Color( 255, 255, 255 ) );
        monthly.setBackground( new Color( 255, 255, 255 ) );
        menu.setBackground( new Color( 255, 255, 255 ) );
        daily.setFont( new Font( "Serif", Font.BOLD, 14) );
        weekly.setFont( new Font( "Serif", Font.BOLD, 14) );
        monthly.setFont( new Font( "Serif", Font.BOLD, 14) );
        menu.setFont( new Font( "Serif", Font.BOLD, 14) );        
        
        // Arranging the settings of the components
        label.setText( "Enter the starting date of the summary:" );
        label.setHorizontalAlignment( JLabel.CENTER );
        daily.setFocusable( false );
        weekly.setFocusable( false );
        monthly.setFocusable( false );
        menu.setFocusable( false );
        daily.addActionListener( this );
        weekly.addActionListener( this );
        monthly.addActionListener( this );
        textField.addActionListener( this );
        menu.addActionListener( this );        
        
        // Setting the sizes of the components
        label.setPreferredSize( new Dimension( 275, 50 ) );
        textField.setPreferredSize( new Dimension( 200, 40 ) );
        daily.setPreferredSize( new Dimension( 160, 25 ) );
        weekly.setPreferredSize( new Dimension( 160, 25 ) );
        monthly.setPreferredSize( new Dimension( 160, 25 ) );
        menu.setPreferredSize( new Dimension( 160, 25 ) );
        panel3.setPreferredSize( new Dimension( 150, 300 ) );
        
        // Adding components to the appropriate panels
        panel1.add( label );
        panel2.add( textField );
        panel3.add( daily );
        panel3.add( weekly );
        panel3.add( monthly );
        panel3.add( menu );
        
        
        // Frame settings
        frame.add( panel1, BorderLayout.NORTH );
        frame.add( panel2, BorderLayout.CENTER );
        frame.add( panel3, BorderLayout.SOUTH );
        frame.setSize( new Dimension( 700, 500 ) );
        frame.setTitle( "Add Category" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }
}