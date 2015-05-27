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
    protected Rectangle rect;
    /** Current display node */
    /** velocity vector x direction */
        
    public Sprite(int x, int y, String img){
    	this.x = x;
    	this.y = y;
    	//rect = new Rectangle(x, y, width, height);
    	image = new ImageView(img);
    	image.setX(x);
    	image.setY(y);
    	node = image;
    }
    
    /**
     * Updates this sprite object's velocity, or animations.
     */
    public abstract void update();
    
<<<<<<< HEAD
    //public abstract void reset();
    
=======
    public abstract void reset();
    /*
>>>>>>> 7285e09ce36f02ec2ae3bb0b67931db649b8ac2c
    public Rectangle getRect(){
    	return rect;
    }
    public Bounds getBounds(){
    	return rect.getBoundsInParent();
    }
    */
    /**
     * Did this sprite collide into the other sprite?
     *
     * @param other - The other sprite.
     * @return
     */
    public boolean collide(Sprite other){
    	return image.getBoundsInParent().intersects(other.getImage().getBoundsInParent());
    	//return this.getBounds().intersects(other.getBounds());
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

