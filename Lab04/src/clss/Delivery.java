package clss;

public abstract class Delivery {
    /**
     * abstract class
    */
    int packageNo;
    //properties
    Customer sender;
    Customer receiver;
    /**
     * consturtor to set properties
    */
    public Delivery(Customer sender, Customer receiver, int packageNo ){
        
        this.sender = sender;
        this.receiver = receiver;
        this.packageNo = packageNo;
        
    }
    /**
     * @return sender customer
    */
    
    public Customer getSender(){
        
        return sender;
     
    }
     /**
     * @return receiver customer
    */
    public Customer getReceiver(){
        
        return receiver;
        
    }
     /**
     * @return packageno
    */
    public int getPackageNo(){
        
        return packageNo;
        
    }
    
    
    public abstract double getWeight();//to use in subclasses
    
}
