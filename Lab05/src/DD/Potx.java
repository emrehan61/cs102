package DD;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.GridLayout;
//import java.awt.FlowLayout;

import java.awt.BorderLayout;
//import java.awt.Dimension;
//import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Color;

import java.util.ArrayList;


public class Potx extends JFrame implements ActionListener  {
    
    /**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**
	 *
	 */
	//private static final long serialVersionUID = 1L;
	  private JFrame frame1;
    private JPanel panel1;
    private JButton button1;
    private Bomb button2;
    private Bomb button3;
    private JLabel label;
    private ArrayList<JButton> buttons;
    
    
    private final static int ROW = 5;
    private final static int COLUMN = 5;
    
    private final static int FRAME_WIDTH = 700;
    private final static int FRAME_HEIGHT = 500;
    
    private static int counter = 0;
    
    
    private int prize = 0;
    private int bomb1 = 0;
    private int bomb2 = 0;
    /**
     * constructor to create potluck
     * 
    */
    public Potx (){
        buttons = new ArrayList<>();// arraylist to make all buttons disabled
        
        
        frame1 = new JFrame();//frame
        frame1.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        panel1 = new JPanel(new BorderLayout());
        //panel1.add(bb);
        label = new JLabel();//label to print out text
        //panel1.add(label);//to add buttons and label
       // frame1.add(panel1);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        //frame1.add(bbb);
        
        while(prize == bomb1 || prize == bomb2 || bomb1 == bomb2){
            /**
             * assign random value
             * to prize and bomb
            */
            prize = (int)(Math.random()*((ROW*COLUMN)+1));
            bomb1 = (int)(Math.random()*((ROW*COLUMN)+1));
            bomb2 = (int)(Math.random()*((ROW*COLUMN)+1));
            
        }
        
        for(int i = 0; i < (ROW*COLUMN); i++){
          
          //to match assigned prize and bom values with related button
          
          if(prize == i){
                button1 = new JButton();
                button1.setText(""+i);
              // button1.setPreferredSize(new Dimension(40,40));
                button1.addActionListener(this);
                buttons.add(button1);
                panel1.add(button1);
                
                
            }
            else if  (bomb1 == i ){
              button2= new Bomb();
              button2.setText(""+i);
            // button2.setPreferredSize(new Dimension(40,40));
              button2.addActionListener(this);
              buttons.add(button2);
              panel1.add(button2);
            }
            else if  (bomb2 ==i ){
              button3 = new Bomb();
              button3.setText(""+i);
             // button3.setPreferredSize(new Dimension(40,40));
              button3.addActionListener(this);
              buttons.add(button3);
              panel1.add(button3);
            }
            else{
              JButton temp = new JButton();
              temp.setText(""+i);
              //temp.setPreferredSize(new Dimension(40,40));
              temp.addActionListener(this);
              buttons.add(temp);
              panel1.add(temp);

            }
          }
          
          panel1.setLayout(new GridLayout(ROW+1, COLUMN));
          

          
          frame1.add(panel1, BorderLayout.CENTER);
          frame1.add(label, BorderLayout.SOUTH);
  
          
          
          frame1.setVisible(true);
        
        
    }
    
 // public void paintComponent(Graphics g){
    
    
    
    
 // }
 
	@Override
	public void actionPerformed(ActionEvent e) {
    
    if(e.getSource() == button1){
      
      button1.setEnabled(true);
      button1.setText("\u2605");
      button1.setFont(new Font("Dialog", Font.PLAIN, 50));//to make it bigger
      button1.setForeground(Color.RED);
      
		  button1.setEnabled(false);
      button1.setOpaque(true);
      
      button2.setEnabled(false);
      button3.setEnabled(false);
      
    }
    
    else if(e.getSource() == button2){
      
      
      button1.setText("\u2605");
      button1.setFont(new Font("Dialog", Font.PLAIN, 50));
      button1.setForeground(Color.RED);
      button1.setOpaque(true);
      button1.setEnabled(false);
     // button2.setText("bomb");
      button2.setEnabled(false);
      button2.setOpaque(true);
      
      
      
    }
    else if(e.getSource() == button3){
      
      
      button1.setText("\u2605");
      button1.setFont(new Font("Dialog", Font.PLAIN, 50));
      button1.setForeground(Color.ORANGE);
      button1.setEnabled(false);
      button1.setOpaque(true);
     // button3.setText("bomb");
      button3.setEnabled(false);
      button2.setEnabled(false);
      button3.setOpaque(true);
      
      
    }
    
   
    counter ++;
    if(e.getSource() instanceof JButton){
      //to count attempts
      JButton temp = (JButton) e.getSource();
      //type casting
      label.setVisible(true);
      if(temp == button1){
          
        label.setText("You have found the star in " + counter + " attemp");
        
        //button2.setText("\u1F4A3");//bomb unicode
        //button3.setText("\u1F4A3");
        
        for(JButton x : buttons){
          
          x.setEnabled(false);
          
      }
            
      }
      else if (temp == button2 || temp == button3){
        
        
        //button3.setText("\u1F4A3");
        //button2.setText("\u1F4A3");
        
        label.setText("OOpps you are dead in "+ counter +" attemp");
        
        for(JButton x : buttons){
          
          x.setEnabled(false);
        
      }
    }
      
      else {
        
        label.setText("Its your " + counter + " attempt");
        
        
        temp.setEnabled(false);
        
      
        
      }
      
    }
    
  }
}
