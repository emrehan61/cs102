package DD;

import javax.swing.JButton;

//import java.awt.FlowLayout;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bomb extends JButton implements ActionListener {
    
    
    public Bomb(){
        
        this.addActionListener(this);
        
    }
    
    
    @Override 
    public void paintComponent(Graphics g){
        
        
        
        if(!this.isEnabled()){
        super.paintComponent(g);
        Graphics2D bomb = (Graphics2D ) g;
        bomb.setColor(Color.RED);
        bomb.drawArc(60,20,40,80,90,60);
        bomb.setColor(Color.BLUE);
        bomb.fillRect(60,27,20,10);
        bomb.setColor(Color.BLACK);
        bomb.fillOval(50,30,40,40);
        
       // repaint();
        }
        
        else super.paintComponent(g);
       
        
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setEnabled(false);
		
	}
    
    
}
