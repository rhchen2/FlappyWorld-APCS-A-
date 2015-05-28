package game;

import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public abstract class Sprite extends Entity{

    /** Animation for the node */
    
	protected int width, height;
    protected boolean playing = false;
    protected ImageView image;
    protected boolean gameOver = false;
   
    /** Current display node */
    /** velocity vector x direction */
       
    public Sprite(int x, int y, String img){
    	this.x = x;
    	this.y = y;
    	
    	image = new ImageView(img);
    	image.setX(x);
    	image.setY(y);
    	node = image;
    }
    
    /**
     * Updates this sprite object's velocity, or animations.
     */
    public abstract void update();
    

    /**
     * Did this sprite collide into the other sprite?
     *
     * @param other - The other sprite.
     * @return
     */
    public boolean collide(Sprite other){
    	//return false;
    	return image.getBoundsInParent().intersects(other.getImage().getBoundsInParent());
    	
    }
    public ImageView getImage(){
    	return image;
    }
    public void stop(){
    	image.setTranslateX(0);
    }
    public void setGameOver(boolean gameOver){
    	this.gameOver = gameOver;
    }
    public void setPlaying(boolean playing){
    	this.playing = playing;
    }
    
}

