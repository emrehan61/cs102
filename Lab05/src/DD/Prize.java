package DD;

import javax.swing.JButton;

//import java.awt.FlowLayout;

import java.awt.Font;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Prize extends JButton implements ActionListener {
    
    
    public Prize(){
        
        this.addActionListener(this);
        
    }
    
    @Override 
    public void paintComponent(Graphics g){
        
        
        
       // this.setFont(new Font("Dialog", Font.PLAIN, 50));//to make it bigger
 
        //this.setText("\u2605");
        //this.setForeground(Color.RED);
        
        //this.setEnabled(false);
        
       // repaint();
        }
       
        
    

	@Override
	public void actionPerformed(ActionEvent e) {
		
        this.setFont(new Font("Dialog", Font.PLAIN, 50));//to make it bigger
 
        this.setText("\u2605");
        this.setForeground(Color.RED);
        
        this.setEnabled(false);
		
	}
    
    
}