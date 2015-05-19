package game;
import javafx.animation.Interpolator;
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
            	 
            	TranslateTransition transTransition = new TranslateTransition(Duration.millis(2000), flappy);
                transTransition.setToY(400);
                transTransition.setInterpolator(new Interpolator() {
    				protected double curve(double t) {
    					double a = 1.2;
    					return a * t *t + (1-a)*t ;
    				}
                   });    
                transTransition.setCycleCount(Timeline.INDEFINITE);
                transTransition.play();
	
            }
        });
    }
    
    private void addMouseEventHandler(){
    	root.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	
            	//To click the screen should lift bird 
            	        	
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
