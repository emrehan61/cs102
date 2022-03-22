package comClasses;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Buttons.*;


public class Frr implements ActionListener {
    User userx;
    JFrame entryadd;
    Gbut but4;
    Gbut but3;
    Gbut but2;
    JTextField dur;
    JLabel text;
    JComboBox <ActivityType> atype;
    JComboBox <String> acategory;
    JPanel panel1;
    JPanel panel2;
    JPanel panel4;
    JPanel panel3;
    //int x; //duration
    //ActivityType y;//activity type 
    String z = "";//category
    //String d;//name 
    ActivityType choosen = null;
    
    /**
     * @param userd represents user who is adding activity
     * constructor displays aentry adding screen 
     * user can add entry, category, and activity type and choose them
     * accordingly
    */
    public Frr(User userd ){
        
        userx = userd;
    
        entryadd = new JFrame("Add Entry");
        entryadd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        entryadd.setSize(600, 400);
        entryadd.getContentPane().setBackground(new Color(51, 204, 255));
        entryadd.setLayout(new GridLayout(4, 1));
        but2 = new Gbut("Add Category");
        but3 = new Gbut ("Add Activity Type");
        but4 = new Gbut("Done");
        dur = new JTextField();
        text = new JLabel("Duration: ");
        dur.setPreferredSize(new Dimension(200, 25));
        dur.addActionListener(this);
        
        userx.addActivityType(new ActivityType("Choose ActivityType", "Choose Category"));
        userx.addActivityCategory("Choose Category");  
        
        atype = new JComboBox<>(userx.types.toArray(new ActivityType [0]));
        acategory = new JComboBox<>(userx.categories.toArray(new String [0]));
                
        atype.setPreferredSize(new Dimension(140, 25));
        acategory.setPreferredSize(new Dimension(140,25));
                
        //acategory.addItem("Choose Category");
        //userx.addActivityCategory("Choose Category");
        //atype.addItem(new ActivityType("Choose ActivityType", null));
        //userx.types.add(new ActivityType("Choose ActivityType", null));
                
        but2.addActionListener(this);
        but3.addActionListener(this);
        but4.addActionListener(this);
                
        
                
        atype.addActionListener(this);
        acategory.addActionListener(this);
                
        panel1 = new JPanel();
        panel1.setBackground(new Color(51,204,255));
        panel1.setLayout(new FlowLayout());
        panel1.add(acategory);
        panel1.add(but2);
                
        panel2 = new JPanel();
        panel2.setBackground(new Color(51,204,255));
        panel2.setLayout(new FlowLayout());
        panel2.add(atype);
        panel2.add(but3);
                
        panel3 = new JPanel();
        panel3.setBackground(new Color(51,204,255));
        panel3.setLayout(new FlowLayout());
        panel3.add(text);
        panel3.add(dur);
                
                
        panel4 = new JPanel();
        panel4.setBackground(new Color(51,204,255));
        panel4.setLayout(new FlowLayout());
        entryadd.setVisible(true);
        panel4.add(but4);
                
        entryadd.add(panel1);
        entryadd.add(panel2);
        entryadd.add(panel3);
        entryadd.add(panel4);
                
        entryadd.setVisible(true);
        
        
    }
    /**
     * overrided actionPerformed
     * add and choose entry, activitytype and category
     * via combobox and buttons
     */
	@Override
	public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == but2){
                    
            String z = JOptionPane.showInputDialog("Add a new category");
            
            acategory.removeActionListener(this);
            if(z != null)
            {
                acategory.addItem(z);
                JOptionPane.showMessageDialog(null , "Category Added");
                userx.addActivityCategory(z);
                acategory.setSelectedItem(z);
                acategory.addActionListener(this);
            }
            else JOptionPane.showMessageDialog(null, "It's Empty");
        }
        
        else if (e.getSource() == but3){
            
            
            if(acategory.getSelectedItem() != "" && acategory.getSelectedIndex() > 0){
                
                String d = JOptionPane.showInputDialog("Add ActivityType");
                
                
                if(d != null){
                    ActivityType y = new ActivityType(d,(String) acategory.getSelectedItem());
                atype.removeActionListener(this);
                if(y != null){
                atype.addItem(y);
                JOptionPane.showMessageDialog(null , "Activity Type Added");
                atype.setSelectedItem(y);
                userx.addActivityType(y);
                atype.addActionListener(this);
                }
            }
                else JOptionPane.showMessageDialog(null, "It's Empty");
            
            }
            else JOptionPane.showMessageDialog(null, "Choose category");
            
        }
        
        //else if (e.getSource() == atype){
            
          //  if(atype.getSelectedIndex() >0){
           //     ActivityType choosen = (ActivityType) atype.getSelectedItem();
            
            //}
       //}
        
        //else if (e.getSource() == acategory){
            
          //  if(acategory.getSelectedIndex() > 0){
            //  String z = (String) acategory.getSelectedItem();
            //}
            
        //}
        
        
        else if(e.getSource() == but4){
            
            if(dur.getText() != null && atype.getSelectedIndex() > 0 && acategory.getSelectedIndex() > 0 ){
                
                int x = Integer.parseInt(dur.getText());
                userx.addEntry(new Entry( (ActivityType) atype.getSelectedItem(), x));
                JOptionPane.showMessageDialog(null, "Entry added");
                atype.setSelectedIndex(0);
                acategory.setSelectedIndex(0);
                entryadd.dispose();
            }
            
            else  {
                JOptionPane.showMessageDialog(null, " Fill the blanks");
            
            }
        }
        
        

}
		
	}
    

