package comClasses;
import java.io.*;
/**
 * A simple Java class!
 */
public class ActivityType implements Serializable
{
    // Properties
    private String name;
    private String category;
    
    // Constructors
    /**
     * A constructor to intialize the name and the category of the ActivityType
     * @param name is the name of the ActivityType
     * @param category is the category of the ActivityType
     */
    public ActivityType( String name, String category )
    {
        this.name = name;
        this.category = category;
    }
    
    // Methods
    /**
     * A method to get the name of the ActivityType
     * @return the name of the ActivityType
     */
    public String getName()
    {
        return name;
    }
    
    /**
     * A method to set the name of the ActivityType
     * @param newName is the new name of the ActivityType
     */
    public void setName( String newName )
    {
        name = newName;
    }
    
    /**
     * A method to get the category of the ActivityType
     * @return the category of the ActivityType
     */
    public String getCategory()
    {
        return category;
    }
    
    /**
     * A method to set the category of the ActivityType
     * @param newCategory is the new category of the ActivityType
     */
    public void setCategory( String newCategory )
    {
        category = newCategory;
    }
    
    /**
     * Returns the String representation of an ActivityType
     * @return ActivityType as String
     */
    @Override
    public String toString( )
    {
        return getName();
    }
}