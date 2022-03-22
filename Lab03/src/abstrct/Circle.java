package abstrct;

public class Circle extends Shape2d {
    
    private int radius;// radius of circle
    /**
     * super constructor for cordinates of center
     * and radius of circle assigned to z
    */
    public Circle(int x , int y, int z){
        
        super(x,y);
        radius = z;
        
    }
    /**
     * calculate perimeter with formula 
     * @return perimeter of circle
    */
    
    public double calculatePerimeter(){
        
         double perimeter = 2*Math.PI*radius;
         return perimeter;
        
    }
     
    /**
     * calculate area with formula 
     * @return area of circle
    */
    
    public double calculateArea(){
        
         double area = Math.PI*Math.pow(radius, 2);
         return area;
        
    }
    
    /**
     * @param object again
     * @return boolean value
     * typecasting to circle subclass
    */
    
    @Override
    public boolean equals (Object o ){
        
        if(o instanceof Circle) {
            Circle d = (Circle) o;
           
            if(this.x == d.x && this.y == d.y && this.radius == d.radius) return true;
            else return false;
            
        }
        
        else return false;
        
    }
    
    @Override
    public String toString(){
        
        return  this.getClass().getSimpleName()+" x= "+ x +" y=" + y + " "+"and radius: "+ radius;
        
        
    }
    
}
