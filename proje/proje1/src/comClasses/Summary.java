package comClasses;
import java.util.*;
import java.time.LocalDate;
/**
 * Summary class calculates the summary of the user's activities
*/
public class Summary
{
    // Properties
    ArrayList<Entry> entryList;
    
    // Constructors
    /**
     * A constructor to initialize the properties of a Summary object
     * @param entries is an ArrayList that contains Entry objects
     */
    public Summary( ArrayList <Entry> entries )
    {
        entryList = entries;
    }
    
    // Methods
    /**
     * A method to calculate the summary of the activities that were done in the wanted day
     * @param date is the date of the wanted day
     */
    public void calculateSummary( ArrayList<LocalDate> date )
    {
        ArrayList<String> categories = getDifferentCategoriesFromDate( date );
        
        for ( int i = 0; i < categories.size(); i++ )
        {
            System.out.println( "Category: " + categories.get( i ) + " Ratio: " + calculateRatio( categories.get( i ), date ) );
        }
    }
    
    /**
     * A private method to calculate the total time spent on doing activities
     * @return the total time (as minutes)
     */
    private int getTotalTime( ArrayList<LocalDate> dates )
    {
        int totalTime = 0;
        ArrayList<Entry> copyEntry = getEntriesOfDate( dates );
        
        for ( int i = 0; i < copyEntry.size(); i++ )
        {
            totalTime = totalTime + copyEntry.get( i ).getDuration();
        }
        
        return totalTime;
    }
    
    /**
     * A method to calculate the time spent on a specific category during specified dates
     * @param category is the category
     * @param dates contains the dates
     * @return the total time spent on the category
     */
    public int calculateTimeOfCategory( String category, ArrayList<LocalDate> dates )
    {
        ArrayList<Entry> copyEntry = getEntriesOfDate( dates );
        int totalTime = 0;
    
        if ( checkCategory( category, dates ) )
        {
            for ( int i = 0; i < copyEntry.size(); i++ )
            {
                if ( copyEntry.get( i ).getActivityCategory().equalsIgnoreCase( category ) )
                {
                    totalTime = totalTime + copyEntry.get( i ).getDuration();
                }
            }
        }
        
        return totalTime;
    }
    
    /**
     * A method to calculate the ratio of a specific category (to total time) on specified dates
     * @param category is the category
     * @param dates contains the dates
     * @return the ratio: time spent on the category to total time spent on activities
     */
    public double calculateRatio( String category, ArrayList<LocalDate> dates )
    {
        if ( checkCategory( category, dates ) )
        {
            return ( ( double ) calculateTimeOfCategory( category, dates ) ) / getTotalTime( dates );
        }
        return -1;
    }
    
    /**
     * A method to check whether any activities that belong to a specified category was done on some dates
     * @param category is the category
     * @param dates contains the dates
     * @return true if the category exists on the specified dates
     */
    private boolean checkCategory( String category, ArrayList<LocalDate> dates )
    {
        ArrayList<String> categories = getDifferentCategoriesFromDate( dates );
        
        for ( int i = 0; i < categories.size(); i++ )
        {
            if ( categories.get( i ).equalsIgnoreCase( category ) )
            {
                return true;
            }
        }
        
        return false;
    }
    
    /**
     * A method to determine the distict categories of the activities that were done on some interval of dates
     * @param dates contains the dates
     * @return an ArrayList of different categories
     */
    ArrayList<String> getDifferentCategoriesFromDate( ArrayList<LocalDate> dates )
    {
        ArrayList<String> categories = new ArrayList <String>();
        ArrayList<Entry> copyList = getEntriesOfDate( dates );     
                
        for ( int i = 0; i < copyList.size(); i++ )
        {
            categories.add( copyList.get( i ).getActivityCategory().toUpperCase() );
        }
        
        for ( int i = 0; i < categories.size(); i++ )
        {
            for ( int j = 0; j < categories.size(); j++ )
            {
                if ( i != j && categories.get( j ).equalsIgnoreCase( categories.get( i ) ) )
                {
                    categories.remove( j );
                }
            }
        }
        
        return categories;
    }
    
    /**
     * A method to find the entries done on a specific interval of time
     * @param dates contains the dates
     * @return an ArrayList of Entry objects
     */    
    private ArrayList<Entry> getEntriesOfDate( ArrayList<LocalDate> dates )
    {
        ArrayList<Entry> copyEntryList = new ArrayList <Entry>();
        
        for ( int i = 0; i < entryList.size(); i++ )
        {
            for ( int j = 0; j < dates.size(); j++ )
            {
                if ( entryList.get( i ).getDate().equals( dates.get( j ) ) )
                {
                    copyEntryList.add( entryList.get( i ) );
                }
            }
        }
        
        return copyEntryList;
    }
}