package abstrct;

public class Rectangle extends Shape2d {
    
    private int width;//properites of rectangel
    private int height;
    
    /**
     * super constructor to assign x and y 
    */
    
    public Rectangle(int x, int y, int width, int height){
        
        super(x,y);
        this.width = width;
        this.height = height;
        
    }
    
    /**
     * calculate perimeter with formula 
     * @return perimeter of rectangle
    */
    public double calculatePerimeter(){
        
        double perimeter = 2*(width + height);
        return perimeter;
       
   }
   
    /**
     * calculate area with formula 
     * @return area of rectangle
    */
   public double calculateArea(){
       
        double area = width*height ;
        return area;
       
   }
   
   /**
    * same as other equals methods
    * typecasting to rectangle class
   */
   
   @Override
    public boolean equals (Object o ){
        
        if(o instanceof Rectangle) {
            Rectangle d = (Rectangle) o;
            if(this.x == d.x && this.y == d.y && this.width == d.width && this.height == d.height) return true;
            else return false;
            
        }
        
        else return false;
        
    }
    
    @Override
    public String toString(){
        
        return  this.getClass().getSimpleName()+" x= "+ x +" y=" + y +"  "+" width =  "+width +" height = "+height ;
        
        
    }

}