package CC;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.BorderLayout;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bb implements ActionListener {
    
    JFrame f;
    
    JPanel p;
    
    JLabel l1,l2,l3;
    
    JTextField t1,t2,t3;
    
    public Bb(){
    
    f = new JFrame();
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    p = new JPanel();
    
    f.setSize(350,350);
    
    //create label 
    l1 = new JLabel("Decimal");
    l1.setBounds(30,10,50,30);
    l1.setVisible(true);
    
    t1 = new JTextField();
    t1.setBounds(100,10,100,30);
    t1.addActionListener(this);
    
    l2 = new JLabel("Hex");
    l2.setBounds(30,55,50,30);
    l2.setVisible(true);
    
    t2 = new JTextField();
    t2.setBounds(100,55,100,30);
    t2.addActionListener(this);
    
    l3 = new JLabel("Binary");
    l3.setVisible(true);
    l3.setBounds(30,100,50,30);
    
    t3 = new JTextField();
    t3.setBounds(100,100,100,30);
    t3.addActionListener(this);
    
    p.add(l1);
    p.add(t1);
    p.add(l2);
    p.add(t2);
    p.add(l3);
    p.add(t3);
    
    p.setLayout(new GridLayout(5,5));
    
    f.add(p, BorderLayout.CENTER);
    f.setVisible(true);
    
    }
    /**
     * @param n is value to convert to hexadecimal
     * it convert decimals to hexa 
     * @return stribng s to print out in textfield
     * 
    */
    public static String dectohexa(int n){
        
        String s = "";
        
        
        char[] hexaDeciNum = new char[100];

        int i = 0;
        while (n != 0) {
            // temporary variable to store remainder
            int temp = 0;
 
            // storing remainder in temp variable.
            temp = n % 16;
 
            // check if temp < 10
            if (temp < 10) {
                hexaDeciNum[i] = (char)(temp + 48);
                i++;
            }
            else {
                hexaDeciNum[i] = (char)(temp + 55);
                //using ascii code UPPER case letters start from 65
                i++;
            }
 
            n = n / 16;
        }
 
        // printing hexadecimal number array in reverse
        // order
        for (int j = i - 1; j >= 0; j--)
            s += hexaDeciNum[j];
        
        return s;
    }
    /**
     * @param n is value to convert to binary
     * methods find remainder for each 2 
     * then add them to array
     * and add to s
     * @return string s 
    */
    public static String decToBinary(long n)
    {
        
        String s = "";
        
        int[] binaryNum = new int[1000];
  
        
        int i = 0;
        while (n > 0) {
            binaryNum[i] = (int) n % 2;
            n = n / 2;
            i++;
        }
  
        // printing binary array in reverse 
        for (int j = i - 1; j >= 0; j--)
            s += binaryNum[j];
            
        return s;
    }
    /**
     * @param n is binary to convert to decimal
     * @return decimal 
     * 
    */
    public static String binaryToDecimal(long n)
    {
        String s = "";
        
        long number = n;
        int decimal = 0;
        int base = 1;
 
        long temp = number;
        while (temp > 0) {
            int last = (int) temp % 10;
            temp = temp / 10;
 
            decimal += last * base;
 
            base = base * 2;
        }
 
        return s+=decimal;
    }
    
    /**
     * @param n
     * uses others methods first binary to decimal
     * then decimal to hexa
     * @return string s
    */
    
    public static String binaryToHexa(int n){
        
        String s = "";
        int x = Integer.parseInt(Bb.binaryToDecimal(n));
        
        x = Integer.parseInt(dectohexa(x));
        
        s += x;
        
        return s;
    }
    
    public static String hexadecimalToDecimal(String hexVal)
    {
        
        String s = "";
        
        int len = hexVal.length();
 
        
        int base = 1;
 
        long decval = 0;
 
        // Extracting characters as digits from last
        // character
        for (int i = len - 1; i >= 0; i--) {
            // if character lies in '0'-'9', converting
            // it to integral 0-9 by subtracting 48 from
            // ASCII value
            if (hexVal.charAt(i) >= '0'
                && hexVal.charAt(i) <= '9') {
                decval += (hexVal.charAt(i) - 48) * base;//ascii value of numbers starts 48
 
                // incrementing base by power
                base = base * 16;
            }
 
            // if character lies in 'A'-'F' , converting
            // it to integral 10 - 15 by subtracting 55
            // from ASCII value
            else if (hexVal.charAt(i) >= 'A'
                     && hexVal.charAt(i) <= 'F') {
                decval += (hexVal.charAt(i) - 55) * base;
 
                // incrementing base by power
                base = base * 16;
            }
        }
        return s+=decval;
    }
    /**
     * @param string hexa value to binary
     * uses others methods
     * @return string which represent binary
     * 
    */
    public static String hexadeciamLToBinary(String hexval){
        
        String s = "";
        
        long x = Integer.parseInt(Bb.hexadecimalToDecimal(hexval));
        
        x = Long.parseLong(Bb.decToBinary(x));
        
        return s+=x;
    }
    /**
     * 
     * action performed make the work when you pressed enter key
     * 
    */

	@Override
	public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == t1){
            
            t2.setText(Bb.dectohexa(Integer.parseInt(t1.getText())));
            
            t3.setText(Bb.decToBinary(Integer.parseInt(t1.getText())));
            
        }
        
        else if(e.getSource() == t2){
            
            t1.setText(Bb.hexadecimalToDecimal(t2.getText()));
            
            t3.setText(Bb.hexadeciamLToBinary(t2.getText()));
            
        }
        
        else if(e.getSource() == t3){
            
            t1.setText(Bb.binaryToDecimal(Integer.parseInt(t3.getText())));
            
            t2.setText(Bb.binaryToHexa(Integer.parseInt(t3.getText())));
            
        }
        
		
	}
}
