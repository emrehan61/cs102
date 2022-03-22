package comClasses;

import Buttons.Menu;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * A class that allows the user to add categories
*/
public class AddCategory implements ActionListener
{    
    // Properties
    User user;
    JFrame frame;
    JPanel panelTop;
    JPanel panelMiddle;
    JPanel panelBottom;
    JLabel label;
    JTextField nameOfCategory;
    JButton done;
    JButton backToMenu;

    // Constructors
    /**
     * A constructor that initializes the properties of AddCategory
     * @param theUser is the user of the program
     */
    public AddCategory( User theUser )
    {
        user = theUser;
        frame = new JFrame();
        panelTop = new JPanel();
        panelMiddle = new JPanel();
        panelBottom = new JPanel();
        label = new JLabel( "Enter Category's Name" );
        nameOfCategory = new JTextField();
        done = new JButton( "Done" );
        backToMenu = new JButton( "Menu" );
    }

    // Methods
    /**
     * Decides what the program will do when an ActionEvent happens 
     * @param e is the ActionEvent
     */
    @Override
	public void actionPerformed(ActionEvent e) {
        
        if (  e.getSource().equals( done )  )
        {
            user.addActivityCategory( nameOfCategory.getText() );
            nameOfCategory.setText( "" );
        }
        else if ( e.getSource().equals( backToMenu ) )
        {
            frame.dispose();
            Menu menuPage = new Menu( user );
            menuPage.run();
        }
    }
    
    /**
     * Runs the program, allows the user to add a new category
     */
    public void runCategory()
    {
        // Arranging the colors
        panelTop.setBackground( new Color( 51, 204, 255 ) );
        panelMiddle.setBackground( new Color( 51, 204, 255 ) );
        panelBottom.setBackground( new Color( 51, 204, 255 ) );
        label.setForeground( new Color( 255, 255, 255 ) );
        label.setFont( new Font( "Serif", Font.BOLD, 15) );
        done.setBackground( new Color( 255, 255, 255 ) );
        backToMenu.setBackground( new Color( 255, 255, 255 ) );
        done.setFont( new Font( "Serif", Font.BOLD, 14) );
        backToMenu.setFont( new Font( "Serif", Font.BOLD, 14) );
        
        // Arranging the settings of the components
        label.setText( "Enter the name of the category:" );
        label.setHorizontalAlignment( JLabel.CENTER );
        done.setFocusable( false );
        backToMenu.setFocusable( false );
        done.addActionListener( this );
        backToMenu.addActionListener( this );
        
        // Setting the sizes of the components
        label.setPreferredSize( new Dimension( 250, 50 ) );
        nameOfCategory.setPreferredSize( new Dimension( 200, 40 ) );
        done.setPreferredSize( new Dimension( 100, 25 ) );
        backToMenu.setPreferredSize( new Dimension( 100, 25 ) );
        panelBottom.setPreferredSize( new Dimension( 150, 300 ) );
        
        // Adding components to the appropriate panels
        panelTop.add( label );
        panelMiddle.add( nameOfCategory  );
        panelBottom.add( done );
        panelBottom.add( backToMenu );
        
        // Organizing the frame
        frame.add( panelTop, BorderLayout.NORTH  );
        frame.add( panelMiddle, BorderLayout.CENTER );
        frame.add( panelBottom, BorderLayout.SOUTH );
        frame.setSize( new Dimension( 700, 500 ) );
        frame.setTitle( "Add Category" );
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        frame.setVisible( true );
    }    
}