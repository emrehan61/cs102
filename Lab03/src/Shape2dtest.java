//import java.util.Scanner;
import abstrct.*;
/**
 * Program Description 
 * @author Program Author
 * @version 27.02.2021
*/ 
public class Shape2dtest
{
    public static void main(String[] args)
    {
        
        
        
        System.out.println("Start...");
        
        Circle c1 = new Circle(3,4,5);
        
        Circle c2 = new Circle(4,5,6);
        
        Circle c3 = c1;
        
        Square s1 = new Square(7,1,4);
        
        Rectangle r1 = new Rectangle(2,3,4,7);
        
        Shape2d[] shapes = {c1,s1,r1};
        
       
        System.out.println(c1.equals(c2));
        
        System.out.println(c1.equals(c3));
        
        System.out.println(c1.equals(s1));
        
        System.out.println();
        
        System.out.println("members of array");
        
        for (Shape2d shape2d : shapes) {
            System.out.println(shape2d);
        }
        
        System.out.println();
        
        System.out.println(Shape2dtest.findMaxArea(shapes) + "  has largest area");
        
        System.out.println(Shape2dtest.findMaxPerimeter(shapes) + "  has longest perimeter");
        
        System.out.println();
        
        for(int i = 0; i+1<shapes.length;i++){
            for(int j = i+1;j<shapes.length;j++){
                System.out.println("distance between shape"+(i+1)+" shape"+(j+1)+"is  "+ shapes[i].calculateDistance(shapes[j]));
            }
        }
        
        System.out.println("End.");
    }
    
    /**
     * @param shape2d object array
     * find shape with max area
     * @return array at index of object with max area
    */
    
    public static Shape2d findMaxArea(Shape2d[] ss){
        int y = -1;
        double max = 0;
        for(int i = 0; i<ss.length; i++){
            
            if(ss[i].calculateArea() > max) {
                max = ss[i].calculateArea();
                y = i;
            }
        }
        return ss[y];
            
    }
    
    /**
     * @param shape2d object array
     * find shape with max perimeter
     * @return array at index of object with max perimeter
    */
    
    public static Shape2d findMaxPerimeter(Shape2d[] ss){
        int y = -1;
        double max = 0;
        for(int i = 0; i<ss.length; i++){
            
            if(ss[i].calculatePerimeter() > max) {
                max = ss[i].calculatePerimeter();
                y = i;
            }
        }
        
        return ss[y];
            
    }
    
    
}