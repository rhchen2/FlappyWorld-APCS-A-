package game;

import java.util.ArrayList;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;


public abstract class GameWorld {

	protected ArrayList<Entity> entities;
	
	//List of objects that will kill Bird
	protected ArrayList<Sprite> enemies;
	
    /** The JavaFX Scene as the game surface */
    private Scene gameSurface;
    /** All nodes to be displayed in the game window. */
    private Group sceneNodes;
    /** The game loop using JavaFX's <code>Timeline</code> API.*/
    private static Timeline gameLoop;

    /** Number of frames per second. */
    //private final int framesPerSecond;

    /** Title in the application window.*/
    private final String windowTitle;
    
    private boolean gameOver = false;

    /**
     * The sprite manager.
     */

    /**
     * Constructor that is called by the derived class. This will
     * set the frames per second, title, and setup the game loop.
     * @param fps - Frames per second.
     * @param title - Title of the application window.
     */
    public GameWorld(final int fps, final String title) {
    	entities = new ArrayList<Entity>();
    	enemies = new ArrayList<Sprite>();
        //framesPerSecond = fps;
        windowTitle = title;
        // create and set timeline for the game loop
        buildAndSetGameLoop();
    }
	
    
    /**
     * Builds and sets the game loop ready to be started.
     */
    protected void buildAndSetGameLoop() {
    	/*
    	Duration frames = Duration.millis(1000/framesPerSecond);
    	
    	KeyFrame loop = new KeyFrame(frames, new EventHandler<ActionEvent>(){
    		public void handle(ActionEvent event){
    			updateEntities();
    			checkCollisions();
    		}
    	});
    	
    	Timeline timeLine = new Timeline();
    	timeLine.setCycleCount(Timeline.INDEFINITE);
    	timeLine.getKeyFrames().add(loop);
    	setGameLoop(timeLine);
    	*/
       
    }

    /**
     * Initialize the game world by update the JavaFX Stage.
     * @param primaryStage
     */
    public abstract void initialize(final Stage primaryStage);

    /**Kicks off (plays) the Timeline objects containing one key frame
     * that simply runs indefinitely with each frame invoking a method
     * to update sprite objects, check for collisions, and cleanup sprite
     * objects.
     *
     */
    /*
    public void beginGameLoop() {
        gameLoop.play();
    }
    */

    /**
     * Updates each game sprite in the game world. This method will
     * loop through each sprite and passing it to the handleUpdate()
     * method. The derived class should override handleUpdate() method.
     *
     */
    protected void updateEntities() {
        for(Entity entity: entities){
        	entity.update();
        }
    }

    /** Updates the sprite object's information to position on the game surface.
     * @param sprite - The sprite to update.
     */
    
    /**
     * Checks each game sprite in the game world to determine a collision
     * occurred. The method will loop through each sprite and
     * passing it to the handleCollision()
     * method. The derived class should override handleCollision() method.
     *
     */
    protected void checkCollisions() {
        for(int i = 0; i < entities.size() - 1; i++){
        	for(int j = 0; j < enemies.size(); j++){
        		Entity a = entities.get(i);
        		Sprite b = enemies.get(j);
        		if(a instanceof Bird){
        			if(((Sprite)a).collide(b)){
        				gameOver = true;
        				
        				System.out.println("Collide");
        			}
        		}
        	}
        }
        
    }
    
    public void addEntity(Entity entity){
    	entities.add(entity);
    	if(entity instanceof Sprite && !(entity instanceof Bird)){
    		enemies.add((Sprite)entity);
    	}
    }
    public void removeEntity(Entity entity){
    	entities.remove(entity);
    }
    /**
     * When two objects collide this method can handle the passed in sprite
     * objects. By default it returns false, meaning the objects do not
     * collide.
     * @param spriteA - called from checkCollision() method to be compared.
     * @param spriteB - called from checkCollision() method to be compared.
     * @return boolean True if the objects collided, otherwise false.
     */
    
    /**
     * entities to be cleaned up.
     */
    

    /**
     * Returns the frames per second.
     * @return int The frames per second.
     */
    /*
    protected int getFramesPerSecond() {
        return framesPerSecond;
    }
    */

    /**
     * Returns the game's window title.
     * @return String The game's window title.
     */
    public String getWindowTitle() {
        return windowTitle;
    }

    /**
     * The game loop (Timeline) which is used to update, check collisions, and
     * cleanup sprite objects at every interval (fps).
     * @return Timeline An animation running indefinitely representing the game
     * loop.
     */
    protected Timeline getGameLoop() {
        return gameLoop;
    }

    /**
     * The sets the current game loop for this game world.
     * @param gameLoop Timeline object of an animation running indefinitely
     * representing the game loop.
     */
    protected void setGameLoop(Timeline gameLoop) {
    	this.gameLoop = gameLoop;
    }

    /**
     * Returns the sprite manager containing the sprite objects to
     * manipulate in the game.
     * @return SpriteManager The sprite manager.
     */
    

    /**
     * Returns the JavaFX Scene. This is called the game surface to
     * allow the developer to add JavaFX Node objects onto the Scene.
     * @return
     */
    public Scene getGameSurface() {
        return gameSurface;
    }

    /**
     * Sets the JavaFX Scene. This is called the game surface to
     * allow the developer to add JavaFX Node objects onto the Scene.
     * @param gameSurface The main game surface (JavaFX Scene).
     */
    protected void setGameSurface(Scene gameSurface) {
        this.gameSurface = gameSurface;
    }

    /**
     * All JavaFX nodes which are rendered onto the game surface(Scene) is
     * a JavaFX Group object.
     * @return Group The root containing many child nodes to be displayed into
     * the Scene area.
     */
    public Group getSceneNodes() {
        return sceneNodes;
    }

    /**
     * Sets the JavaFX Group that will hold all JavaFX nodes which are rendered
     * onto the game surface(Scene) is a JavaFX Group object.
     * @param sceneNodes The root container having many children nodes
     * to be displayed into the Scene area.
     */
    protected void setSceneNodes(Group sceneNodes) {
        this.sceneNodes = sceneNodes;
    }

}

