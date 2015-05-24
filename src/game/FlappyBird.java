package game;

import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import javafx.util.Duration;

public class FlappyBird extends GameWorld{
	
	private Bird bird;
	private MediaPlayer flap;
	private Ground ground;
	private Ground ground2;
	
	public FlappyBird(int fps, String title) {
		super(fps, title);
	}
	private Button button = null;
	private Group root = null;
	private ImageView bkg = null ;
	private Node flappy = null;
	
	private void addActionEventHandler(){
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //TODO: start the drop animation of the bird
               
                Timeline tl = new Timeline();
                tl.setCycleCount(1);
                KeyValue kv = new KeyValue(flappy.translateYProperty(), 1000, new Interpolator() {
                        @Override
                                protected double curve(double t) {
                                return 1.5 * t * t;
                                }
                });
                KeyFrame drop = new KeyFrame(new Duration(2750), kv);
                tl.getKeyFrames().add(drop);
                tl.setAutoReverse(false);
                tl.play();
        
            }
        });
    }
 
   
    private void addMouseEventHandler(){
        root.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	//Play MP3 File (Flap Sound)
				String url = getClass().getResource("/flap.mp3").toString();
				Media m = new Media(url);
				MediaPlayer player = new MediaPlayer(m);
				player.play();
				
                //To click the screen should lift bird
                Timeline tl = new Timeline();
                tl.setCycleCount(1);
                KeyValue kv = new KeyValue(flappy.translateYProperty(), -1000, new Interpolator() {
                        @Override
                                protected double curve(double t) {
                                        return .75 * t - 1.5 * t * t;
                                }
                });
                KeyFrame flap = new KeyFrame(new Duration(3000), kv);
                tl.getKeyFrames().add(flap);
                tl.setAutoReverse(false);
                tl.play();

            }
        });
    }
	public void initialize(Stage primaryStage){
		
		root = new Group();
		bkg = new ImageView("background.png");
		bird = new Bird(50, 100, 34, 24, "flappy.png");
		ground = new Ground(0, 352, 400, 48, "ground.png");
		ground2 = new Ground(400, 352, 400, 48, "ground.png");
		Pipe p1 = new Pipe(300, 60, 52, 320, "obstacle_bottom.png");
		String url = getClass().getResource("/flap.mp3").toString();
		final Media media = new Media(url);
		bkg.setOnMousePressed(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				flap = new MediaPlayer(media);
				flap.play();
				bird.jump();
			}
		});
		addEntity(bird);
		addEntity(p1);
		addEntity(ground);
		addEntity(ground2);
		
		root.getChildren().add(bkg);
		root.getChildren().add(bird.getNode());
		root.getChildren().add(p1.getNode());
		root.getChildren().add(ground.getNode());
		root.getChildren().add(ground2.getNode());
		
		setSceneNodes(root);
		setGameSurface(new Scene(getSceneNodes(), 400, 400));
		
		primaryStage.setTitle(getWindowTitle());
		primaryStage.setScene(getGameSurface());
		
	}
	public void updateEntities(){
		super.updateEntities();
	}
	

}
