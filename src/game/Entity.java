package game;

import javafx.scene.Node;



public abstract class Entity {

	protected int x, y;
	
	protected Node node;
	
	
	public abstract void update();
	
	public Node getNode(){
		return node;
	}
}
