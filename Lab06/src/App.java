import java.util.Scanner;
import java.util.*;

/**
 * Program Description 
 * @author Emrehan Hoşver
 * @version 13.04.2021
*/ 
public class App
{
    /**
     * @param string to delete all 'r'
     * to do that we have to check one by one 
     * and to not use loops we have to check string as
     * substring
     * and recursion creates inside loop and 
     * accordingly substring without 'r'
     * will be displayed until all 'r' s are gone
     * @return substring which dont include 'r'
    */
    
   public static String  rdel1  (String s)
        {
            if (s.length() == 0 ){
                return "";// to not receive an error index out of bonds
            }             // because at final step substring(1)will not occur due to single character
            
            if(s.charAt(0) == 'r' || s.charAt(0) == 'R'){
                
                return rdel1(s.substring(1));
                
            }
             
               
             return s.charAt(0) + rdel1(s.substring(1));
           
        
        }
      /**
       * @param x represents decimal which will be converted to hexa
       * REMAINDER hold all characters that are needed
       * String s is string to reprsenet hexa
       * program basically finds the remainder from String s 
       * and then divide x to 16 so reach number smaller than 16
       * and every remainder added in front of string 
       * @return String s 
       * 
       * */  
    
    public static String toHexa(int x){
        
        String remainder = "0123456789ABCDEF";
        
        String s = "";
        
        if(x > 0){
            
            s = remainder.charAt(x%16) + s;
            
            x = x / 16;
            s = toHexa(x) + s;
           // return s ;
            
        }
        
        return s;
    }
    /**
     * @param arraylist x 
     * in for loop program checks two neighbour elements alphabetic condition
     * and sort both of them accordingly
     * then use recursion to check again
     * when program ends
     * all of the elements will be compared due to recursion
     * @return sorted arraylist
    */
    
    
    public static ArrayList<String> abcarray (ArrayList<String> x ){
        
        for(int i = 0;i<x.size()-1;i++){
            String s = "";
            
            if(x.get(i+1).compareTo(x.get(i))<0){
                s = x.get(i+1);
                x.set(i+1,x.get(i));
                x.set(i,s);
                abcarray(x);
            }
            
        }
        
        
        return x;
    }
            
    /**
     * @param string to be reversed
     * function print last char of parameter
     * and with recursion it removes that char from  string by substring
     * and again with recursion it prints that substring last character
     * at the end it scans all the string from end to start
     * @return nothing
    */
    
    
    public static void reverseprint (String x ){
        
        if(x.length()<=1) {
            System.out.print(x);
            System.out.println();
        }
        
        else {
            System.out.print(x.charAt(x.length()-1));
            reverseprint(x.substring(0,x.length()-1));
            
        }
        
        
    }    
    /**
     * @param number, s, digit 
     * number to starting number to write so it starts with 1 while initializint method
     * we use number as a parameter because we have to carry out last digit to next recursion
     * to make new digit bigger than last 
     * s represents integer which are going to be written 
     * digit is digit of integers 
     * and program prints even number which are increasing digit by digit with
     * if statement which represents end of digits and being even number
     * @return nothing
     * 
     * */    
    public static void evenWrite(int number, String s, int digit){
        
        if (digit == 0 && Integer.parseInt(s.replaceAll(" ", "")) % 2 == 0)//replace all used to prevent error 
        {                                                                  //while converting string to int
            System.out.print(s + " ");
            
        }
   
        else{
            for (int i = number ; i <= 9; i++)
        {
              
            String z = s + Integer.toString(i);
            
            evenWrite(i + 1, z , digit - 1);
        }
    }
    }    ICRYPEX
    
    
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        
        ArrayList<String> abc = new ArrayList<>();
        abc.add("yastık");
        abc.add("akıl");
        abc.add("kaynak");
        abc.add("zeytin");
        abc.add("bacak");
        
       
        // Variables
        
        // Program Code
        System.out.println("Start...");
        String rdel = scan.nextLine();
        System.out.println(rdel1(rdel));
        System.out.println(toHexa(1764));
        System.out.println(abcarray(abc));
        reverseprint("tesla mclaren lambo");
        evenWrite(1, " ", 3);
        System.out.println("End.");
        scan.close();
    }
    
    
        
   
   
}