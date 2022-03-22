package clss;

public class Item {
    
    protected double weight;//properties
    protected String content;
    /**
     * constructor set weight and content
    */
    public Item(double weight, String content){
        
        this.weight = weight;
        this.content = content;
        
    }
    
    /**
     * @return weight
    */
    public double getWeight(){
        
        return weight;
    
    }
     
    /**
     * @return content
    */
    public String getContent(){
        
        return content;
        
    }
    @Override
    public String toString(){
        
        String s= "";
        
        return s + "Weight of item: "+weight +"and content of it: " + content ;
        
        
    }
    
}
