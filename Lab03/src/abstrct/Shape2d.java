package abstrct;
/**
 * abstract class to use methods without body in subclasses
 * some methods to use in all subclasses
*/

public abstract class Shape2d{
    
    protected int x;
    
    protected int y;
    
    public Shape2d(int x, int y){
        
        this.x = x;
        
        this.y = y;
        
    }
    
    public abstract double calculatePerimeter();
    
    public abstract double calculateArea();
    
    /**
     * @param object of any class which is subclass of shape2d  
     * @return distance between two shape's centers
     * with typecasting
    */
    
    
    public double calculateDistance(Object anyShape){
        
        if(anyShape instanceof Shape2d){
            
            Shape2d anyShape2 = (Shape2d) anyShape;
            
            double distance = Math.sqrt(Math.pow(this.x-anyShape2.x,2)+Math.pow(this.y - anyShape2.y,2));
            
            return distance;
        }
        
        else return -1;
        
    }
    
    
    @Override
    public String toString(){
        
        return "Cordinates of the shape is ( "+ x +", " + y +" ). ";
        
        
    }
    /**
     * @param object 
     * checks if its instance of shape2d class
     * @return boolean value 
    */
    @Override
    public boolean equals (Object o ){
        
        if(o instanceof Shape2d) {
            Shape2d d = (Shape2d) o;
            if(this.equals(d)) return true;
            else return false;
            
        }
        
        else return false;
        
    }
    
}