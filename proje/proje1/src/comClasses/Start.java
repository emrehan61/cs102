package comClasses;

import java.awt.*;
import javax.swing.*;
import Buttons.*;
import java.awt.event.*;
import java.util.*;
import java.io.*;

public class Start implements ActionListener {
    ArrayList<User> users;
    JComboBox<User> userselect;
    User selectedUser;
    JFrame frame1 = null;
    JPanel panel1 = null;
    Gbut but1 = null;
    Gbut but2 = null;
    JLabel welcome = null;
    JLabel cho = null;
    FileInputStream load ;
    ObjectInputStream load2;
    File bum;
   User x;
    
    /**
     * constructor
     * to create and display entry screen of app
    */
    public Start () throws IOException, ClassNotFoundException{
        
        users = new ArrayList<>();
        bum = new File("Userinfo.ser");
        load = new FileInputStream(bum);
       // load2 = new ObjectInputStream(load);
       if(bum.length() > 0){
        load = new FileInputStream(bum);
        load2 = new ObjectInputStream(load);
        x = (User) load2.readObject();
        users.add(x);
        }
       // User x = (User) load2.readObject();
    //users.add(x);

        System.out.println("Hello, World!");
        frame1 = new JFrame("Activity Summarizer");
        frame1.setSize(800, 500);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame1.getContentPane().setBackground(new Color(51,204,255));
       // frame1.setLayout(new BorderLayout());
        
        panel1 = new JPanel();
        panel1.setBackground(new Color(51,204,255));
        panel1.setLayout(new FlowLayout());
        
        but1 = new Gbut("Add User");
        but1.addActionListener(this);
        
        but2 = new Gbut("Continue");
        but2.addActionListener(this);
        
        welcome = new JLabel("Welcome to Activity Summarizer", JLabel.CENTER);
        welcome.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 30));
        welcome.setForeground(new Color(255,255,255));
        
        cho = new JLabel("Choose User: ");
        cho.setFont(new Font("Serif", Font.BOLD | Font.ITALIC, 17));
        cho.setForeground(new Color(0,0,0));
        
        userselect = new JComboBox<User>(users.toArray(new User [0]));
        userselect.setModel(new DefaultComboBoxModel<User>());
        userselect.addItem(new User ("Choose User"));
        userselect.addItem(x);
        userselect.addActionListener(this );
         
        panel1.setPreferredSize(new Dimension (50,200));
        frame1.add(welcome);
        panel1.add(but1);
        panel1.add(cho);
        panel1.add(userselect);
        panel1.add(but2);

        frame1.add( panel1 , BorderLayout.SOUTH);
        
       
        
        frame1.setVisible(true);
        
        
        
    }
    /**
     * overrided actionPerformed
     * to create and choose user and 
     * open main screen of app
    */
	@Override
	public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == userselect){
            
            if(userselect.getSelectedIndex() > 0 ){
                
                selectedUser = (User) userselect.getSelectedItem();
                
            }
            
        
        }
        else if (e.getSource() == but1){
            
            String s = JOptionPane.showInputDialog("Add a new user");
            
            userselect.removeActionListener(this);
            
            if(s != null){
            users.add(new User(s));
            userselect.addActionListener(this);
            userselect.addItem(new User(s));
            JOptionPane.showMessageDialog(null , "User Added");
            }
            
            else JOptionPane.showMessageDialog(null , "Canceled");
            //userselect.addItem(new User(s));
           // userselect.setSelectedIndex(-1);
            
        }
        
        else if(e.getSource() == but2){
            
            if(selectedUser == null)
            {
                
            JOptionPane.showMessageDialog(null, "Please choose user");
            
        }    
        
        else{
            
            Screen dxd = new Screen(selectedUser);
            frame1.setVisible(false);
            
        }
    }
            
    }
    
}
