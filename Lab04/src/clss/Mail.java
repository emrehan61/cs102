package clss;

public class Mail extends Delivery {
    
    String content;//property
    /**
     * constructor which uses super constructor of delivery 
     * and set content 
    */
    public Mail(String content, Customer sender, Customer receiver , int packageNo){
        
        super(sender,receiver,packageNo);    
        this.content = content;
      
    }
    /**
     * @return 0.1 because it is given 
    */
    public double getWeight(){
        
        return 0.1;
    }
    @Override
    public String toString(){
        
        String s = "";
        
        return s+"Content of mail is: " + content + " Sender: "+sender+ "sent to: "+receiver+" no:"+packageNo+ "Type of item: "+getClass().getSimpleName();
        
        
    }
}
