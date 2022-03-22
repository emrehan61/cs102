package clss;

public class Package extends Delivery {
    
    Item packedItem;//property
    /**
     * constructor which uses delivery
     * content to packedItem
    */
    public Package(Item content, Customer sender, Customer receiver, int packageNo){
        
        super(sender , receiver, packageNo);
        packedItem = content;
        
    }
    /**
     * @return weight
    */
    public double getWeight(){
        
        return packedItem.getWeight();
        
    }
    @Override
    public String toString(){
        
        String s = "";
        return s+"Content of package is: " + packedItem.getContent() + " Sender: "+sender+ " sent to: "+receiver+" no:"+packageNo+" weight of package "+packedItem.getWeight();
    }
    
}
