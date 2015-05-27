package game;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Bird extends Sprite{

	private boolean jumped = false;
	public double startY;
	private double velocity;
	private boolean drop;
	private double accel;
	private boolean killed = false;
	private Timeline timeline;
	private KeyValue kv;
	
	public Bird(int x, int y, String img){
		super(x, y, img);
		 
		velocity = 0;
		accel = 0;
		
	}		
		
	
	public void reset(int y){
		image.setY(y);
		image.setTranslateY(0);
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
        timeline.setOnFinished(new EventHandler<ActionEvent>(){
        	public void handle(ActionEvent event){
        		image.setY(100);
        		image.setTranslateY(0);
        	}
        });
		//timeline.play();
		
		velocity = 6;
		
	}
	public void update(){
		
		//rect = new Rectangle(image.getX() + image.getTranslateX(), image.getY() + image.getTranslateY(), width, height);
		image.setTranslateY(image.getTranslateY() - (velocity + accel));
		if(drop){
		velocity-=.25;
		//accel -= .01;
		}
		if(image.getY() + image.getTranslateY() > 320){
			killed = true;
			image.setY(320);
			image.setTranslateY(0);
			//timeline.onFinishedProperty();
			//FlappyBird.loops.stop();
			//System.out.println("Gameover");
		}
		
	}
	public void setAccel(double accel){
		this.accel = accel;
	}
	public void setDrop(boolean drop){
		this.drop = drop;
	}
	public ImageView getImage(){
		return image;
	}
	public Timeline getJump(){
		return timeline;
	}
	public boolean isKilled(){
		return killed;
	}


	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
