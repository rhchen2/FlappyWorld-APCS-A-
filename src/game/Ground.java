package game;
public class Ground extends Sprite{
      
    public Ground(int x, int y, int width, int height, String img){
        super(x, y, width, height, img);

    }
    
    public void update(){
    	image.setTranslateX(image.getTranslateX() - 2);
    	if(image.getX() + image.getTranslateX() < -400){
    		image.setX(400);
    		image.setTranslateX(0);
    	}
    }
    
  
}
