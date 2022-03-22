package comClasses;
import java.time.LocalDate;
import java.io.*;
/**
 * An Entry object contains an ActivityType, duration and the day's date
 */
public class Entry implements Serializable
{
    // Properties
    private ActivityType activity;
    private int duration;
    private LocalDate todaysDate;
    
    // Constructors
    /**
     * A constructor to initialize the properties of the Entry (date is initialized as that day's date)
     * @param object is the ActivityType of the Entry
     * @param duration is the duration of the Entry
     */
    public Entry( ActivityType object, int duration )
    {
        this.activity = object;
        this.duration = duration;
        todaysDate = LocalDate.now();
    }
    /**
     * A constructor to initialize the properties of the Entry (date is initialized as the specified date)
     * @param activity is the ActivityType of the Entry
     * @param duration is the duration of the Entry
     * @param date is the date of the Entry
     */
     public Entry( ActivityType activity, int duration, String date  )
    {
        this( activity, duration );
        todaysDate = LocalDate.parse( date );
    }
    
    // Methods
    /**
     * A method to get the ActivityType of the Enrytry
     * @return the ActivityType
     */
    public ActivityType getActivity()
    {
        return activity;
    }
    
    /**
     * A method to get the Category of the Entry's ActivityType
     * @return the Category of the Entry
     */
    public String getActivityCategory()
    {
        return activity.getCategory();
    }
    
    /**
     * A method to get the duration of the Entry
     * @return the duration of the Entry
     */
    public int getDuration()
    {
        return duration;
    }
    
    /**
     * A method to get the date of the Entry
     * @return the date of the Entry
     */
    public LocalDate getDate()
    {
        return todaysDate;
    }

    /**
     * Shows date, category type, activity type, and duration
     * @return String
     */
    @Override
    public String toString()
    {
        return "Date: " + getDate() + " Category: " + getActivityCategory() + " Type: " + getActivity() + " Duration: " + getDuration();
    }
}