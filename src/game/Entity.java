import javafx.scene.Node;



public abstract class Entity {

	protected Node node;
	
	
	public abstract void update();
	
	public abstract Node getNode();
}
