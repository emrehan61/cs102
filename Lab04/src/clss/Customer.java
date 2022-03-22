package clss;
/**
 * class of customer
*/
public class Customer extends Person {
    
    Item currentItem;
    
    public Customer(String name){
        //constructor 
        super(name);
        
    }
    /**
     * @return position x 
    */
    
    public int getx(){
        
        return this.posX;
        
    }
    /**
     * @return position y 
    */
    public int gety(){
        
        return this.posY;
        
    }
    /**
     * @param integers to set x and y again 
    */
    public void setPos(int x, int y){
        
        posX = x;
        
        posY = y;
        
    }
    /**
     *@param double and string to set item 
    */
    public void setcurrentitem(double x, String s){
        
        currentItem = new Item( x, s);
        
    }
    
   /**
    * @return item 
   */
    
    public Item getcurrentitem(){
        
        return currentItem;
        
    }
    
    
    /**
     * @param company item recevier
     * create deliverable if there is a available employee in company
     * and set item as a currentitem of sender
     * @return boolean 
    */
    public boolean sendItem(Company company, Item item , Customer receiver){
        
        receiver.setcurrentitem(item.getWeight() , item.getContent());
      //  setcurrentitem(item.getWeight() , item.getContent());
        
        return company.createDeliverable(item , this , receiver);
    
        
    }
    
    public String toString(){
        String s = "";
        
        return s+getName() +" customer's location: (" +getx()+" ,"+gety()+" )"; 
        
        
    }
    
}
