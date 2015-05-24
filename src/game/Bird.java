package game;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Bird extends Sprite{

	private boolean jumped = false;
	public double startY;
	private boolean killed = false;
	private Timeline timeline;
	private KeyValue kv;
	
	public Bird(int x, int y, int width, int height, String img){
		super(x, y, width, height, img);
		 

		
	}		
		
	
	
	public void jump(){
		timeline = new Timeline();
        timeline.setCycleCount(1);
        kv = new KeyValue(image.translateYProperty(), -1000, new Interpolator() {
                @Override
                        protected double curve(double t) {
                                return .75 * t - 1.5 * t * t;
                        }
        });
        KeyFrame flap = new KeyFrame(new Duration(2000), kv);
        timeline.getKeyFrames().add(flap);
        timeline.setAutoReverse(false);
		timeline.play();
	}
	public void update(){
		
		rect = new Rectangle(x, y, width, height);
		
		if(image.getY() + image.getTranslateY() > 400){
			killed = true;
			System.out.println("Gameover");
		}
		
	}
	
	public boolean killed(){
		return killed;
	}
	
	
	
}
