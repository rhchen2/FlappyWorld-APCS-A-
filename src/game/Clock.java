package game;

public class Clock extends Entity{
    
    //the node in this class will be a Text
    
    private long startTime;
    private Text text;
  
    public Clock(){
        startTime = System.currentTimeMillis();
        text = new Text();
        node = text;
    }
  
    public void update(){
      
    }

}
