package game;

import javafx.geometry.Bounds;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public abstract class Sprite extends Entity{

    /** Animation for the node */
    
	protected int width, height;
    
    protected ImageView image;
    
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
    
    //public abstract void reset();
=======
    public abstract void reset();
>>>>>>> parent of ce7c33e... Actual working game now is time for fancy images and sounds
    /*
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
    
}

