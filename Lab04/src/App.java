import java.util.Scanner;
import clss.*;

/**
 * Program Description 
 * @author Emrehan Hoşver
 * @version 10.03.2021
*/ 
public class App
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        // Constants
        Customer ee = new Customer("emp1");
        
        Customer bb = new Customer("emp2");
        
        Employee aa = new Employee(0, "adam");
        Employee cc = new Employee(1,"kadın");
        aa.adjustSalary(1000);
        cc.adjustSalary(2000);
        
        ee.setPos(3,4);
        bb.setPos(5,6);
        
        Item dd = new Item (0.01, "door");
        Item d1 = new Item (0.02, "wow");
        Item d2 = new Item (4, "gift");
        Item d3 = new Item (5, "stone");
        Item d4 = new Item (2, "leather");
        Item d5 = new Item (1, "coton");
        Company bos = new Company(10,10);
        
        System.out.println(bos.addEmployee(aa));
        System.out.println(bos.addEmployee(cc));
        bos.addCustomer(ee);
        bos.addCustomer(bb);
        System.out.println(ee.sendItem(bos , dd, bb)); 
        
        System.out.println(ee.sendItem(bos , d1, bb)); 
        
        System.out.println(ee.sendItem(bos , d2, bb)); 
     
        System.out.println(ee.sendItem(bos , d3, bb)); 
        
        System.out.println(ee.sendItem(bos , d4, bb)); 
        System.out.println();
        System.out.println("current item ee "+ee.getcurrentitem());
        System.out.println("current item bb "+bb.getcurrentitem());
        System.out.println();
        //bos.terminateContract(1);
        
        System.out.println(bb.sendItem(bos , d5, ee)); 
        System.out.println();
        System.out.println(bos);
        bos.deliverPackages();
        System.out.println("current item ee "+ee.getcurrentitem());
        System.out.println("current item bb "+bb.getcurrentitem());
        System.out.println(bos);
       
        
      
        // Variables
        
        // Program Code
        System.out.println("Start...");
        
        
        System.out.println("End.");
        scan.close();
    }
    
}