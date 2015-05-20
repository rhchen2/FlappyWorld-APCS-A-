import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.effect.Reflection;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class FlappyBird extends GameWorld{
	
	private Sprite bird;
	private MediaPlayer flap;
	
	public FlappyBird(int fps, String title) {
		super(fps, title);
	}

	public void initialize(Stage primaryStage){
		
		Group root = new Group();
		ImageView bkg = new ImageView("background.png");
		bird = new Bird(50, 50, 34, 24, "flappy.png");
		String url = getClass().getResource("/flap.mp3").toString();
		final Media media = new Media(url);
		bkg.setOnMousePressed(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				flap = new MediaPlayer(media);
				flap.play();
				((Bird)bird).jump();
			}
		});
		addEntity(bird);
		
		root.getChildren().add(bkg);
		root.getChildren().add(bird.getNode());
		
		
		setSceneNodes(root);
		setGameSurface(new Scene(getSceneNodes(), 400, 400));
		
		primaryStage.setTitle(getWindowTitle());
		primaryStage.setScene(getGameSurface());
		
	}
	public void updateSprites(){
		bird.update();
	}

}
