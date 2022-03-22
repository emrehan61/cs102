package comClasses;

import java.awt.*;
import javax.swing.*;
import java.time.LocalDate;
import java.util.*;

/**
 * A class that draws the summary graphs of the user
 */
public class SummaryGUI extends JComponent
{
    /**
	 * mandatory constant
	 */
    private static final long serialVersionUID = 1L;
    
	// Properties
    User user;
    Summary sum;
    ArrayList<LocalDate> dates;
    JFrame frame; 
    JPanel panel;
    
    // Constructors
    /**
     * A constructor that initializes the properties of the SummaryGUI
     * @param user is the user
     * @param dates is the dates that will be used to calculate the summary
     */
    public SummaryGUI( User user, ArrayList<LocalDate> dates )
    {
        this.user = user;
        this.dates = dates;
        sum = new Summary( user.getEntries() );
        
        frame = new JFrame();
        panel = new JPanel();   
        
    }
    
    // Methods    
    /**
     * Overriden version of JComponent's paintComponent method to draw the graphs of each category
     * @param g is a Graphics object
     */
    @Override
    public void paintComponent( Graphics g )
    {        
        // Declaring some constants and variables
        final int widthCons = 400;
        final int height = 25;
        final int x = 100;
        final int y = 50;
        ArrayList<String> categories = sum.getDifferentCategoriesFromDate( dates );
        double ratio;
        double width;
        
        // For each category, a rectangle is drawn according to its ratio 
        for ( int i = 0; i < categories.size(); i++ )
        {
            ratio = sum.calculateRatio( categories.get( i ), dates );
            width = widthCons * ratio;
            String s = String.format("%.2f", ratio * 100);
            g.drawString(categories.get( i ), x - 90 , y * ( i + 1 ) + height/2 );
            g.drawString(s + "%" ,( int ) width + x + 15, y * ( i + 1 ) + height/2);
            g.fillRect( x, y * ( i + 1 ), ( int ) width, height );
        }
    }
    
    /**
     * Reports the Summary object of the SummaryGUI
     * @return the Summary object
     */
    public Summary getSummary()
    {
        return sum;
    }
}