package game;

public class Pipe extends Sprite {
    
    private boolean removed = false;
    
    public Pipe(int x, int y, int width, int height, String img){
        super(x, y, width, height, img);
    }
    public void update(){
    //checking for boundaries
    //update the object
    	image.setTranslateX(image.getTranslateX() - 2);
    	if(image.getX() + image.getTranslateX() < -52){
    		image.setX(452);
    		image.setTranslateX(0);
    	}
    
    }
    
}
