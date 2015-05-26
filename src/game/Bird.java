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
                                return .6 * t - 1.5 * t * t;
                        }
        });
        KeyFrame flap = new KeyFrame(new Duration(2100), kv);
        timeline.getKeyFrames().add(flap);
        timeline.setAutoReverse(false);
		timeline.play();
	}
	public void update(){
		
		rect = new Rectangle(image.getX() + image.getTranslateX(), image.getY() + image.getTranslateY(), width, height);
		
		if(image.getY() + image.getTranslateY() > 320){
			killed = true;
			timeline.pause();
			System.out.println("Gameover");
		}
		
	}
	
	public boolean isKilled(){
		return killed;
	}
	
	
	
}
