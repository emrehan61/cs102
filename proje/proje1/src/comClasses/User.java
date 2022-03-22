package comClasses;
import java.time.LocalDate;
import java.util.ArrayList;
import java.io.*;

/**
 * A class of Users who use the activity summarizer
 */
public class User implements Serializable
{
    // Properties
    String name;
    ArrayList<String> categories;
    ArrayList<String> typeNames;
    ArrayList<ActivityType> types;
    ArrayList<Entry> entries;

    // Constructor
    /**
     * A constructor that initializes the properties of the user
     * @param name is the name of the user
     */
    public User( String name )
    {
        this.name = name;
        categories = new ArrayList<String>();
        typeNames = new ArrayList<String>(); //Name of types, for quick lookup
        types = new ArrayList<ActivityType>(); //The actual type objects
        entries = new ArrayList<Entry>();
    }

    /**
     * A method that adds an activity category if it does not already exist
     * @param categoryName the name of the category
     */
    public void addActivityCategory( String categoryName )
    {
        // Reduce redundancy by ensuring uppercase-lowercase variants of the same category dont exist
        String normalizedCategoryName = categoryName.toUpperCase();

        // Check if name exists
        if( categories.contains(normalizedCategoryName) == false )
        {
            categories.add(normalizedCategoryName);
        }

    }
    
    /**
     * A method that adds an activity type 
     * @param activityTypeName the name of the type of the activity
     * @param activityCategoryname the name of the type of the category
     */
    public void addActivityType( String activityTypeName, String activityCategoryName )
    {
        // Reduce redundancy
        String normalizedActivityTypeName = activityTypeName.toUpperCase();
        String normalizedActivityCategoryName = activityCategoryName.toUpperCase();
        
        // Check if the activity type already exists(no need for another one) and whether the category name exists(if not create one)
        if( typeNames.contains(normalizedActivityTypeName) == false )
        {
            if( typeNames.contains(normalizedActivityCategoryName) == false )
            {
                addActivityCategory(normalizedActivityCategoryName);
            }

            // Add to String ArrayList and the Type ArrayList
            typeNames.add(normalizedActivityTypeName);
            types.add( new ActivityType(normalizedActivityTypeName, normalizedActivityCategoryName) );
        }
    }    

    /**
     * A method that adds an activity type 
     * @param activityTypeName the name of the type of the activity
     * @param activityCategoryname the name of the type of the category
     */
    public void addActivityType( ActivityType activityType )
    {
        // Reduce redundancy
        if(activityType.getName() != null){
            String normalizedActivityTypeName = activityType.getName().toUpperCase();
        String normalizedActivityCategoryName = activityType.getCategory().toUpperCase();
        
        // Check if the activity type already exists(no need for another one) and whether the category name exists(if not create one)
        if( typeNames.contains(normalizedActivityTypeName) == false )
        {
            if( typeNames.contains(normalizedActivityCategoryName) == false )
            {
                addActivityCategory(normalizedActivityCategoryName);
            }

            // Add to String ArrayList and the Type ArrayList
            typeNames.add(normalizedActivityTypeName);
            types.add( activityType );
        }
    }
}
    
    /** 
    * Adds entry to the user's entry list
    * @param x entry which will be added 
    */   
    public void addEntry(Entry x)
    {
        if(entries.contains(x) == false)
        {
            entries.add(x);
        }
        else 
        {
            System.out.println("Already added");
        }
    }

    /**
     * Prints out the user's entries
     * @param start is the starting date
     * @param end is the ending date
     */
    public String displayEntries( LocalDate start, LocalDate end )
    {   
        String entries = "";
        LocalDate startClone = start;
        LocalDate endClone = end;

        while( startClone.compareTo(endClone) <= 0 )
        {
            // Prints out every entry from that day
            for( int i = 0; i < this.entries.size(); i++ )
            {
                if( this.entries.get(i).getDate().equals(startClone)  )
                {
                    entries += this.entries.get(i).toString() + "\n" ;
                }
            }
            
            startClone = startClone.plusDays(1);
        }
        return entries;
    }

    /**
     * Prints out the user's categories
     */
    public void displayCategories()
    {
        for( int i = 0; i < categories.size(); i++ )
        {
            System.out.println( categories.get(i) );
        }
    }

    /**
     * Prints out the user's activity types
     */
    public void displayActivityTypes()
    {
        for( int i = 0; i < types.size(); i++ )
        {
            System.out.println( types.get(i) );
        }        
    }
    
    /**
     * Returns the String representation of the User
     * @return the User as a String
     */
    public String toString()
    {
        return this.name;  
    }
    
    /**
     * Reports the ArrayList containing the User's entries
     * @return the User's entries
     */
    public ArrayList<Entry> getEntries()
    {
        return entries;
    }   
    
    /**
     * Reports the name of the User
     * @return the User's name
     */
    public String getName()
    {
        return name;
    } 
}