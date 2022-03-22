package clss;

public class Employee extends Person {
    /**
     * properties of class
    */
    final int MAX_JOBS = 5;
    int currentJobs = 0;
    Delivery[] deliveries = new Delivery[MAX_JOBS];
    double salary;
    int employeeNo;
    boolean avaible;
    /**
     * consturtor to set name and no to employee
    */
    public Employee(int employeeNo , String name){
        
        super(name);
        this.employeeNo = employeeNo;
        
    }
    //to set salary
    public void adjustSalary(double salary){
        
        this.salary = salary;
     
    }
    /**
     * @return boolean if employee available true if not false
    */
    public boolean getAvailability(){
        
        if(currentJobs >= MAX_JOBS) return false;
        
        else return true;
    
    }
    /**
     * @param sendItem, sender, receiver, packageNo
     * add job to employee if he/she is available
    */
    public void addJob(Item sendItem, Customer sender , Customer receiver, int packageNo){
        
        if(getAvailability()){
            
            currentJobs++;
        
            if(sendItem.getWeight()>0.1){
                deliveries[currentJobs-1] = new Package(sendItem, sender, receiver, packageNo);
                
            }
        
             else {
            
                deliveries[currentJobs-1] = new Mail(sendItem.getContent(), sender, receiver, packageNo);
               
             }
        }
    }
    //deliver packages and set deliveries to null 
    public void deliverPackages(){
        
        for (int i = 0; i<MAX_JOBS;i++){
            
            if(deliveries[i] != null){
                System.out.println(deliveries[i]);
                currentJobs --;
               // deliveries[i].getReceiver().setcurrentitem(deliveries[i].getSender().getcurrentitem().getWeight(), deliveries[i].getSender().getcurrentitem().getContent());
                // deliveries[i].getSender().setcurrentitem(0, null);
                deliveries[i] = null;
               
            }
        }
        
    }
    
    /**
     * @return position x 
    */
    public int getx(){
        
        return posX;
        
        }
    /**
     * @return position y
    */
    public int gety(){
        
        return posY;
        
    }
    /**
     * @param integers to set x and y again 
    */
    public void setPos(int x, int y){
        
        posX = x;
        
        posY = y;
        
    }
    @Override
    public String toString(){
        
        String s = "";
        return s+"Name: "+name +" No: "+employeeNo+" salary: "+salary+" currenjobs: "+currentJobs  +" available: "+getAvailability();
        
        
    }
    
}
