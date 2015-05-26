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
		bird = new Bird(50, 100, 34, 24, "SuperMarioJumping.png");
		ground = new Ground(0, 352, 400, 48, "ground.png");
		ground2 = new Ground(400, 352, 400, 48, "ground.png");
		Pipe p1 = new Pipe(452, 200, 52, 320, "obstacle_bottom.png");
		Pipe p2 = new Pipe(452, -240, 52, 320, "obstacle_top.png");
		Pipe p3 = new Pipe(652, 260, 52, 320, "obstacle_bottom.png");
		Pipe p4 = new Pipe(652, -180, 52, 320, "obstacle_top.png");
		String url = getClass().getResource("/mario_ya-hoo.mp3").toString();
		String url2 = getClass().getResource("/mario_mamma-mia.mp3").toString();
		String url3 = getClass().getResource("/mario_okey-dokey.mp3").toString();
		String url4 = getClass().getResource("/mario_open_salami.mp3").toString();
		String url5 = getClass().getResource("/mario_ow_3.mp3").toString();
		String url6 = getClass().getResource("/mario_ow_4.mp3").toString();
		String url7 = getClass().getResource("/mario_way_to_go.mp3").toString();
		final Media media = new Media(url);
		final Media media2 = new Media(url2);
		final Media media3 = new Media(url3);
		final Media media4 = new Media(url4);
		final Media media5 = new Media(url5);
		final Media media6 = new Media(url6);
		final Media media7 = new Media(url7);
		bkg.setOnMousePressed(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				
				flap = new MediaPlayer(media);
				flap.play();
				bird.jump();
				// !!!LAGGY IMPLEMENTATION!!!
				/*double random = Math.random() * 20;
					if ( random <= 1.00){
						flap = new MediaPlayer(media);
						flap.play();
						bird.jump();
					}
					else if( random <= 2.00){
						flap = new MediaPlayer(media2);
						flap.play();
						bird.jump();
					}
					else if( random <= 3.00){
						flap = new MediaPlayer(media3);
						flap.play();
						bird.jump();
					}
					else if( random <= 4.00){
						flap = new MediaPlayer(media4);
						flap.play();
						bird.jump();
					}
					else if( random <= 5.00){
						flap = new MediaPlayer(media5);
						flap.play();
						bird.jump();
					}
					else if( random <= 6.00){
						flap = new MediaPlayer(media6);
						flap.play();
						bird.jump();
					}
					else if( random <= 7.00){
						flap = new MediaPlayer(media7);
						flap.play();
						bird.jump();
					}*/
			}
		});
		if(bird.isKilled()){
			//gameLoop.pause();
		}
		addEntity(bird);
		addEntity(p1);
		addEntity(p2);
		addEntity(p3);
		addEntity(p4);
		addEntity(ground);
		addEntity(ground2);
		
		
		root.getChildren().add(bkg);
		root.getChildren().add(bird.getNode());
		root.getChildren().add(p1.getNode());
		root.getChildren().add(p2.getNode());
		root.getChildren().add(p3.getNode());
		root.getChildren().add(p4.getNode());
		root.getChildren().add(ground.getNode());
		root.getChildren().add(ground2.getNode());
		
		setSceneNodes(root);
		setGameSurface(new Scene(getSceneNodes(), 400, 400));
		
		primaryStage.setTitle(getWindowTitle());
		primaryStage.setScene(getGameSurface());
		
	}
	
	

}
