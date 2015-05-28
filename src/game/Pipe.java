package game;

import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;

public class Pipe extends Sprite {
    
	private boolean moving = false;
	private boolean point = true;
	private static int score = 0;
	private int reset = 600;
    private boolean removed = false;
    private Media med;
    private MediaPlayer play;
    
    
    public Pipe(int x, int y, String img){
        super(x, y, img);
        String url = getClass().getResource("/point.mp3").toString();
        med = new Media(url);
        
    }

    public void update() {
    	
    }
    public void update(int y){
    //checking for boundaries
    //update the object
    	
    	
    	if(!gameOver && moving){
    		image.setTranslateX(image.getTranslateX() - 2);
    	}
    	if(image.getX() + image.getTranslateX() < 60 && point){
    		score++;
    		play = new MediaPlayer(med);
    		play.play();
    		point = false;
    	}
    	if(image.getX() + image.getTranslateX() < -52){
    		image.setX(548);
    		image.setTranslateX(0);
    		image.setY(y);
    		this.y = y;
    		
    		point = true;
    	}
    	if(gameOver){
    		
    	}
    
    }
    public void reset(int x, int y){
    	this.x = x;
    	this.y = y;
    	image.setY(y);
    	
    	image.setX(x);
    	image.setTranslateX(0);
    	score = 0;
    	
    	
    }
    public void setMoving(boolean moving){
    	this.moving = moving;
    }
    public static int getScore(){
    	return score / 2;
    }
	    
}
