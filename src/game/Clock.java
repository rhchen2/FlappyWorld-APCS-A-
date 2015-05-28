package game;

import javafx.scene.text.Text;


public class Clock extends Entity{
    
    //the node in this class will be a Text
    
    private long startTime;
    private Text text;
    private int seconds;
    private int minutes;
  
    public Clock(){
        startTime = System.currentTimeMillis();
        text = new Text();
        node = text;
    }
  
    public void update(){
    	long now = System.currentTimeMillis();
    	seconds = (int)(now / startTime);
    	if(seconds > 59){
    		minutes++;
    		seconds = 0;
    	}
    }

}
