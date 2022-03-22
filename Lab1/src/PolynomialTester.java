import java.util.Scanner;
import poly.Polynomial;
/**
 * Program Description 
 * @author Program Author
 * @version 06.02.2021
*/ 
public class PolynomialTester
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Start...");
        
        
        double[] coef = {3,4,1,3};//defining new array to creat poly object 
        //with a parameter as a array 
       
        Polynomial object1 = new Polynomial(coef);//creating new object 
        
        double[] coeffs2 = {2,4,1};
        
        Polynomial object2 = new Polynomial();
        
        Polynomial object3 = new Polynomial(coeffs2);
        
        
        System.out.println(object1.add(object3));
        
        System.out.println(object1.sub(object3));
        
        System.out.println(object1.mult(object3));
        
        System.out.println(object1.compose(object3));
        
        System.out.println(object1.div(object3));
        
        System.out.println(object1);
        
        System.out.println(object3);
        
        System.out.println("End.");
        
        scan.close();
    }
    
}