package Buttons;
import java.awt.*;
import javax.swing.*;



public class Gbut extends JButton {
    
    public Gbut(String s){
        
        this.setBackground(new Color(51,204,255));
        this.setForeground(new Color(0, 0, 0));
        this.setFont((new Font("Serif", Font.BOLD | Font.ITALIC, 18)));
        
        setText(s);
        setBorderPainted(false);
        //setContentAreaFilled(false);
        setFocusPainted(false);
    }

	
}
    
    

