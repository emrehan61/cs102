package clss;

public abstract class Person implements Locatable {
    
    String name;
    int posX;
    int posY;
    
    public Person(String name, int posx, int posy){
        
        this.name = name;
        posX = posx;
        posY = posy;
        
        
    }
    public Person(String name){
        
        this.name = name;
        posX = 0;
        posY = 0;
        
    }
    
    public String getName(){
        
        return name;
        
    }
    
    public void setName(String x ){
        
        name = x;
        
    }
    
    public abstract int getx();
    
    public abstract int gety();
    
    public abstract void setPos(int x, int y);
    
}
