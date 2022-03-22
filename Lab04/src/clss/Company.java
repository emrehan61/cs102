package clss;
import java.util.ArrayList;
public class Company implements Locatable {
    /**
     * company class
     * to combine all classes
     * 
    */
    final int EMPLOYEE_CAPACITY = 15;
    Employee[] employees = new Employee[EMPLOYEE_CAPACITY];
    ArrayList<Customer> customers = new ArrayList<>();
    int numOfEmployee;
    int employeeNo;
    int packageNo = 0;
    int posX;
    int posY;
    
    /**
     * @param integers to fill properties
     * 
    */
    
    public Company(int x , int y ){
        
        setPos(x , y);
        numOfEmployee = 0;
                
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
    
    /**
     * add employee if there is a space for it
     * @param employee
     * @return boolean
    */
    
    public boolean addEmployee(Employee candidate){
        if(numOfEmployee<EMPLOYEE_CAPACITY){
            
            numOfEmployee++;
            employees[numOfEmployee-1] = candidate;
            System.out.print("employee added ");
            return true;
            
        }
        
        else {
           
            System.out.print("cant add employee ");
            return false;
        }
    
    }
    /**
     * adds customer
     * @param customer
    */
    public void addCustomer(Customer customer){
        
        customers.add(customer);
        
    }
    
    /**
     * terminates contract of employee
     * @param int index
     * @return boolean 
    */
    public boolean terminateContract(int employeeindex){
        
        if(employees[employeeindex] != null){
            
            employees[employeeindex] = null;
            return true;
        }
        
        else return false;
        
    }
    /**
     * creats delivery system 
     * @param item and customer
     * add job to available employee
     * @return boolean 
     * 
    */
    public boolean createDeliverable(Item sendItem, Customer sender, Customer receiver){
        int adding = 0;
        while (adding == 0){
            for(int i = 0;i<employees.length;i++){
                
                if(employees[i] != null &&employees[i].getAvailability()){
                    packageNo ++;
                    employees[i].addJob(sendItem, sender, receiver, packageNo);
                    adding ++;
                    break;
                }
               
            }
            break;
            
        }
        if(adding == 1 ){
            
            System.out.print("Delivere is taken. ");
            return true;
        }
        else {
            
           System.out.print("All employees are busy.");
            return false;
        }
        
  }
    /**
     * delivers packages
    */
    public void deliverPackages(){
        
        for(Employee a : employees){
            
            if(a != null){
            a.deliverPackages();
            }
        }
    }
    
    @Override
    public String toString(){
        String s = "";
        s += "Customer of company \n";
        for (Customer customer : customers) {
            
            s += customer+"\n";
        
        }
        s+="\n";
        s += "Employees of company \n";
        for (Employee ee : employees) {
            if(ee != null){
            s += ee+"\n";
            }
        }
        
        return s;
    
        
    }
    
}
