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
	
	private FlappyBird game = new FlappyBird(60, "Flappy Bird");
    
	@Override
	public void start(Stage primaryStage) throws Exception {
		game.initialize(primaryStage);
		game.beginGameLoop();
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
