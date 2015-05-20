
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;


public abstract class Sprite extends Entity{

    /** Animation for the node */
    
    
    protected ImageView image;
    
    protected Rectangle rect;
    /** Current display node */
    /** velocity vector x direction */
        
    public Sprite(int x, int y, int width, int height, String img){
    	rect = new Rectangle(x, y, width, height);
    	image = new ImageView(img);
    	image.setX(x);
    	image.setY(y);
    	node = image;
    }
    
    /**
     * Updates this sprite object's velocity, or animations.
     */
    public abstract void update();
    
    public Rectangle getRect(){
    	return null;
    }

    /**
     * Did this sprite collide into the other sprite?
     *
     * @param other - The other sprite.
     * @return
     */
    public boolean collide(Sprite other){
    	return false;
    }
    
    public abstract Node getNode();
}

