package game;
public class Ground extends Sprite{
<<<<<<< HEAD
    
	
	
    public Ground(int x, int y, int width, int height, String img){
        super(x, y, width, height, img);
=======
      
    public Ground(int x, int y, String img){
        super(x, y, img);
>>>>>>> 7285e09ce36f02ec2ae3bb0b67931db649b8ac2c

    }
    
    public void update(){
    	if(!gameOver){
    		image.setTranslateX(image.getTranslateX() - 2);
    	}
    	if(image.getX() + image.getTranslateX() < -400){
    		image.setX(400);
    		image.setTranslateX(0);
    	}
    }
    public void reset(){
    	
    }
    
  
}
