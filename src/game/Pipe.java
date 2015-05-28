package game;

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
    
    public Pipe(int x, int y, int width, int height, String img){
        super(x, y, width, height, img);
        String url = getClass().getResource("/point.mp3").toString();
        med = new Media(url);
    }
    public void update(){
    //checking for boundaries
    //update the object
    	rect = new Rectangle(image.getX() + image.getTranslateX(), image.getY() + image.getTranslateY(), width, height);
    	
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
    		image.setX(652);
    		image.setTranslateX(0);
    		point = true;
    	}
    	if(gameOver){
    		//reset(x);
    	}
    
    }
    public void reset(int x){
    	this.x = x;
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
