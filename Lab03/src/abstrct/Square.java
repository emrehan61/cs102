package abstrct;

public class Square extends Shape2d {
    
    private int sideLength;//sidelength of square
    /**
     * super constructor to assign x and y 
    */
    public Square(int x , int y , int sideLength){
        
        super(x, y);
        this.sideLength = sideLength;
        
    }
    
    /**
     * calculate perimeter with formula 
     * @return perimeter of square
    */
    public double calculatePerimeter(){
        
        double perimeter = 4*sideLength;
        return perimeter;
       
   }
   /**
     * calculate area with formula 
     * @return area of rectangle
    */
   public double calculateArea(){
       
        double area = Math.pow(sideLength,2) ;
        return area;
       
   }
   
   @Override
   //typecasting to square class
    public boolean equals (Object o ){
        
        if(o instanceof Square) {
            Square d = (Square) o;
            if(this.x == d.x && this.y == d.y && this.sideLength == d.sideLength) return true;
            else return false;
            
        }
        
        else return false;
        
    }
    
    @Override
    public String toString(){
        
        return  this.getClass().getSimpleName()+" x= "+ x +" y=" + y + " sidelength = "+sideLength ;
        
        
    }

}
