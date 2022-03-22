package comClasses;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import Buttons.*;
import java.time.LocalDate;
import java.io.*;

public class Screen extends JFrame implements ActionListener{
    private User userx;
    private JMenuBar menu;
    private JMenu setting;
    private JMenu help;
    private JMenu profile;
    private JMenu tdlist;
    private JMenu summary;
    private JMenuItem summarize;
    private JPanel panel1;
    private Gbut save;
    FileOutputStream save1;
    ObjectOutputStream save2;
  
    private JMenuItem lang;
    private JMenuItem theme;
    private Gbut addent;
    /**
     * @param x represents user which is choosen in entry screen
     * constructor displays general view of screen 
     * with menu bar at the top 
     * user can create an entry and 
     * see summary of entries which is created 
     * by categories 
    */
    public Screen(User x){ 
        
        userx = x;
        setTitle(userx.getName() +"   "  +LocalDate.now());
        
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(51,204,255));
        
        menu = new JMenuBar();
        
         setting = new JMenu("Settings");
        setting.setFont((new Font("Serif", Font.BOLD | Font.ITALIC, 18)));
        setting.setBackground(new Color(51,204,255));
        setting.setForeground(new Color(0, 0, 0));
        
         help = new JMenu("Help");
        help.setFont((new Font("Serif", Font.BOLD | Font.ITALIC, 18)));
        help.setBackground(new Color(51,204,255));
        help.setForeground(new Color(0, 0, 0));
        
         profile = new JMenu("Profile");
        profile.setFont((new Font("Serif", Font.BOLD | Font.ITALIC, 18)));
        profile.setBackground(new Color(51,204,255));
        profile.setForeground(new Color(0, 0, 0));
        
         tdlist = new JMenu("To-Do List");
        tdlist.setFont((new Font("Serif", Font.BOLD | Font.ITALIC, 18)));
        tdlist.setBackground(new Color(51,204,255));
        tdlist.setForeground(new Color(0, 0, 0));
        
         summary = new JMenu("Summarize");
        summary.setFont((new Font("Serif", Font.BOLD | Font.ITALIC, 18)));
        summary.setBackground(new Color(51,204,255));
        summary.setForeground(new Color(0, 0, 0));
        //summary.addActionListener(this);
        menu.setBackground(new Color(51,204,255));
        
        summarize = new JMenuItem ("Check Summary");
         lang = new JMenuItem("Language");
         theme = new JMenuItem("Theme");
        summary.add(summarize);
        summarize.addActionListener(this);
        setting.add(lang);
        setting.add(theme);
        
        panel1 = new JPanel();
        panel1.setBackground(new Color(51,204,255));
        panel1.setLayout(new FlowLayout());
        
        menu.add(setting);
        menu.add(help);
        menu.add(profile);
        menu.add(tdlist);
        menu.add(summary);
        this.setJMenuBar(menu);
        //this.setLayout(new FlowLayout());
        addent = new Gbut("Add Entry");
        save = new Gbut("Save");
        
        panel1.add(addent);
        panel1.add(save);
        
        panel1.setPreferredSize(new Dimension(50,200));
        this.add(panel1, BorderLayout.SOUTH);
        
        save.addActionListener(new ActionListener(){
            

			@Override
			public void actionPerformed(ActionEvent e) {
				
                 try {
					save1 = new FileOutputStream("Userinfo.ser");
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
                 try {
					save2 = new ObjectOutputStream(save1);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
                if(userx != null ){try {
					save2.writeObject(userx);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        }
        }  );
        
        addent.addActionListener(new ActionListener(){
            /**
             * anonymous inner class 
             * to add entry with cateogry and activitytype
            */
            @Override
	        public void actionPerformed(ActionEvent e) {
                
                Frr abc = new Frr (userx) ;
		
	}
            });
        
        this.setVisible(true);
    }
    
    /** 
     * @param e
     */
    /*
     * overrided actionPerformed
     * which creates sumary screen
     * */
    
	@Override
	public void actionPerformed(ActionEvent e) {
        if(e.getSource() == summarize){
            
            AskForDate summed = new AskForDate(userx);
            summed.run();
            
        }
        
		
	}
}
