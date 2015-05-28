package game;

import javafx.scene.text.Text;

public class Score extends Entity{
	
	private Text text;
	private int score;
	
	public Score(int x, int y){
		this.x = x;
		this.y = y;
		text = new Text("Score: " + score);
		text.setX(x);
		text.setY(y);
		node = text;
	}
	public void update(){
		text.setText("Score: " + score);
		score = Pipe.getScore();
	}

}
