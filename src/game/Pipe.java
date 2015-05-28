package game;

import javafx.scene.shape.Rectangle;

public class Pipe extends Sprite {
    
    private boolean removed = false;
    
    public Pipe(int x, int y, String img){
        super(x, y, img);
    }
    public void update(){
    //checking for boundaries
    //update the object
<<<<<<< HEAD
    	//rect = new Rectangle(image.getX() + image.getTranslateX(), image.getY() + image.getTranslateY(), width, height);
    	if(!gameOver && moving){
    		image.setTranslateX(image.getTranslateX() - 1);
    	}
=======
>>>>>>> parent of ce7c33e... Actual working game now is time for fancy images and sounds
    	//rect = new Rectangle(image.getX() + image.getTranslateX(), image.getY() + image.getTranslateY(), width, height);
    	
    	image.setTranslateX(image.getTranslateX() - 2);
    	if(image.getX() + image.getTranslateX() < -52){
    		image.setX(452);
    		image.setTranslateX(0);
    	}
    
    }
<<<<<<< HEAD
    public void reset(int x){
    	this.x = x;
    	image.setX(x);
    	image.setTranslateX(0);
    }
    public void setMoving(boolean moving){
    	this.moving = moving;
=======
    public void reset(){
    	
>>>>>>> parent of ce7c33e... Actual working game now is time for fancy images and sounds
    }
    
}
