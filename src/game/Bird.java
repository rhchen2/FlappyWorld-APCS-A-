package game;

public class Bird extends Sprite {
	private Double xpos;
	private Double ypos;
	private String state;
	
	public Bird(Double xpos, Double ypos){
		this.xpos = xpos;
		this.ypos = ypos;
	}
	public double getXPos(){
		return xpos;
	}
	public double getYPos(){
		return ypos;
	}
}
