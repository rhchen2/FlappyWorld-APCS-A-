package game;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
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


public class Main extends Application{
	
	private Button button = null;
	private Group root = null;
	private ImageView bkgrd = null ;
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
               
                /*
                TranslateTransition trans = new TranslateTransition(new Duration(3000), flappy);
                trans.setToY(1000);
                trans.setCycleCount(1);                
                trans.setInterpolator(new Interpolator() {
                                @Override
                                protected double curve(double t) {
                                        return 1.5 * t * t;
                                }
                        });  
                        trans.play();
                        */
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
               
                /*
                TranslateTransition trans = new TranslateTransition(new Duration(3000), flappy);
                trans.setByY(-1000);
                trans.setCycleCount(1);
                trans.setInterpolator(new Interpolator() {
                                @Override
                                protected double curve(double t) {
                                        //acceleration = 1.5 (same as initial drop)
                                        return .9 * t - 1.5 * t * t;
                                }
                        });  
               
                        trans.play();
                */

            }
        });
    }
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		//Create a Group 
		root = new Group();

		bkgrd = new ImageView("background.png");
		
		flappy = new ImageView("flappy.png");
		flappy.layoutXProperty().set(150);
		flappy.layoutYProperty().set(50);
		
		button = new Button("Start");
        button.layoutXProperty().set(150);
		
		
		//Add controls
		root.getChildren().add( bkgrd );
		root.getChildren().add( flappy );
		root.getChildren().add( button );

		addActionEventHandler();

		addMouseEventHandler();
		
		//Create scene and add to stage
		Scene scene = new Scene(root, 400, 400);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		Application.launch(args);
	}

}
