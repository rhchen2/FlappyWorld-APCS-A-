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
import javafx.scene.input.KeyEvent;
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
	private boolean clicked = false;
	private boolean restar = false;
	private boolean noise = true;
	private Button restart;
	private boolean gameOver = false;
	private boolean playing = false;
	private ImageView title;
	private int pipeDistanceWidth;
	private int pipeDistanceHeight;
	private int pipeOriginX;
	public FlappyBird(int fps, String title) {
		super(fps, title);
		gameOver = false;
	}
	public static Timeline loops;
	//private int framesPerSecond;
	private Button button = null;
	private Group root = null;
	private ImageView bkg = null ;
	private Node flappy = null;
	private Pipe p1;
	private Pipe p2;
	private Pipe p3;
	private Pipe p4;
	
	/*
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
   */
	protected void checkCollisions() {
        for(int i = 0; i < entities.size() - 1; i++){
        	for(int j = 0; j < enemies.size(); j++){
        		Entity a = entities.get(i);
        		Sprite b = enemies.get(j);
        		if(a instanceof Bird){
        			if(((Sprite)a).collide(b) || bird.isKilled()){
        				String url = getClass().getResource("/death.mp3").toString();
        				Media u = new Media(url);
        				MediaPlayer death = new MediaPlayer(u);
        				if(noise){
        					death.play();
        					noise = false;
        				}
        				gameOver = true;
        				bird.setKilled(false);
        				
        			}
        		}
        	}
        }
        
    }
   public void beginGameLoop(){
	   loops.play();
   }
   public Timeline getGameLoop(){
	   return loops;
   }
   /*
    private void addMouseEventHandler(){
        root.onMouseClickedProperty().set(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	//Play MP3 File (Flap Sound)
				String url = getClass().getResource("/mario_ow_3.mp3").toString();
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
    */
   public void restart(){
	   gameOver = false;
	   playing = false;
	   noise = true;
	   setGameOver(false);
	   movePipes(false);
	   title.setY(70);
	   restart.setLayoutY(-145);
	   reset();
   }
   public void setGameOver(boolean gameOver){
	   for(Sprite sprite: enemies){
		   sprite.setGameOver(gameOver);
	   }
   }
   public void gameOver(){
	   restart.setLayoutY(145);
	   setGameOver(true);
	   movePipes(false);
	   gameOver = false;
   }
   public void movePipes(boolean move){
	   p1.setMoving(move);
	   p2.setMoving(move);
	   p3.setMoving(move);
	   p4.setMoving(move);

   }

        protected void buildAndSetGameLoop() {
    	Duration frames = Duration.millis(1000/60);
    	
    	KeyFrame loop = new KeyFrame(frames, new EventHandler<ActionEvent>(){
    		public void handle(ActionEvent event){
    			updateEntities();
    			if(!gameOver){
    				checkCollisions();
    			}
    			else{
    				gameOver();
    				//if(restar)
    				//restart();
    				//restar = false;
    			}
    			
    		}
    	});
    	
    	Timeline timeLine = new Timeline();
    	timeLine.setCycleCount(Timeline.INDEFINITE);
    	timeLine.getKeyFrames().add(loop);
    	loops = timeLine;
    	/*
    	loops.setOnFinished(new EventHandler<ActionEvent>(){
    		public void handle(ActionEvent event){
    			loops.playFromStart();
    		}
    	});
    	*/
       
        }
    public boolean checkGameOver(){
    	return bird.isKilled();
    }
    public void reset(){
    	
    	bird.reset(150);
    	p1.reset(452);
    	p2.reset(452);
    	p3.reset(652);
    	p4.reset(652);
    }
    public void setPlaying(boolean playing){
    	for(Sprite sprite: enemies){
    		sprite.setPlaying(playing);
    	}
    }
	public void initialize(Stage primaryStage){
		pipeDistanceWidth = 200;
		pipeDistanceHeight = 140;
		pipeOriginX = 452;
		root = new Group();
		bkg = new ImageView("background.png");
<<<<<<< HEAD
		title = new ImageView("clickrun.png");
		title.setX(70);
		title.setY(70);
		restart = new Button("Restart");
		restart.setLayoutX(140);
		restart.setLayoutY(-145);
		bird = new Bird(50, 150, 34, 24, "flappy.png");
		ground = new Ground(0, 352, 400, 48, "ground.png");
		ground2 = new Ground(400, 352, 400, 48, "ground.png");
		 p1 = new Pipe(452, 200, 52, 320, "obstacle_bottom.png");
		 p2 = new Pipe(452, -240, 52, 320, "obstacle_top.png");
		 p3 = new Pipe(652, 260, 52, 320, "obstacle_bottom.png");
		 p4 = new Pipe(652, -180, 52, 320, "obstacle_top.png");
=======
		bird = new Bird(50, 100, "flappy.png");
		ground = new Ground(0, 352, "ground.png");
		ground2 = new Ground(400, 352, "ground.png");
		 p1 = new Pipe(452, 200, "obstacle_bottom.png");
		 p2 = new Pipe(452, -240, "obstacle_top.png");
		 p3 = new Pipe(652, 260, "obstacle_bottom.png");
		 p4 = new Pipe(652, -180, "obstacle_top.png");
>>>>>>> 7285e09ce36f02ec2ae3bb0b67931db649b8ac2c
		String url = getClass().getResource("/flap.mp3").toString();
		final Media media = new Media(url);
		bkg.setOnMousePressed(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				title.setY(-100);

				flap = new MediaPlayer(media);
				flap.play();
				if(!playing){
					playing = true;
					setPlaying(true);
					movePipes(true);
					
				}
				if(!gameOver){
					bird.jump();
				}
				bird.setDrop(true);
				loops.play();
				bird.setAccel(0);
			}
		});
		title.setOnMousePressed(new EventHandler<MouseEvent>(){
			public void handle(MouseEvent event){
				restart();
			}
		});
		restart.setOnMousePressed(new EventHandler<MouseEvent>(){
			
			public void handle(MouseEvent event){
				restart.setLayoutY(-145);
				restart();
			}
		});
		/*
		bkg.setOnKeyPressed(new EventHandler<KeyEvent>(){
			public void handle(KeyEvent event){
				flap = new MediaPlayer(media);
				flap.play();
				bird.jump();
				bird.setDrop(true);
				loops.play();
				bird.setAccel(0);
			}
		});
		*/
		
				/*
		if(bird.isKilled()){
			startGame();
		}
		*/
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
		root.getChildren().add(title);
		root.getChildren().add(restart);
		
		setSceneNodes(root);
		setGameSurface(new Scene(getSceneNodes(), 400, 400));
		
		primaryStage.setTitle(getWindowTitle());
		primaryStage.setScene(getGameSurface());
		
	}
	
	

}
