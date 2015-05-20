import javafx.animation.Interpolator;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;


public class Bird extends Sprite{

	private boolean jumped = false;
	public double startY;
	private TranslateTransition jump;
	
	public Bird(int x, int y, int width, int height, String img){
		super(x, y, width, height, img);
		jump = new TranslateTransition(Duration.millis(2000), image);
		jump.setCycleCount(Timeline.INDEFINITE);
		jump.setInterpolator(new Interpolator(){
			protected double curve(double t){
				double a = 0.9;
				return a * t * t + (1 - a) * t;
			}
		});

		
	}		
		
	
	
	public void jump(){
		jump.play();
	}
	public void update(){
		jump.setToY(image.getY());

		if(image.getY() > 400){
		}
		
	}
	
	public Rectangle getRect(){
		return rect;
	}
	
		
	public Node getNode(){
		return node;
	}
	
}
