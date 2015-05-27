package game;

public abstract class Powerup extends Sprite{

	private String name;
	
	public Powerup(String name, int x, int y, String img){
		super(x, y, img);
		this.name = name;
	}
	
	public abstract void update();
}
