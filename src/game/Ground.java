package game;
public class Ground extends Sprite{
<<<<<<< HEAD

    
	
	
    /*public Ground(int x, int y, int width, int height, String img){
       // super(x, y, width, height, img);

    }
    */
=======
      
>>>>>>> parent of ce7c33e... Actual working game now is time for fancy images and sounds
    public Ground(int x, int y, String img){
        super(x, y, img);

    }
    
    public void update(){
<<<<<<< HEAD
    	if(!gameOver){
    		image.setTranslateX(image.getTranslateX() - 1);
    	}
=======
    	image.setTranslateX(image.getTranslateX() - 2);
>>>>>>> parent of ce7c33e... Actual working game now is time for fancy images and sounds
    	if(image.getX() + image.getTranslateX() < -400){
    		image.setX(400);
    		image.setTranslateX(0);
    	}
    }
    public void reset(){
    	
    }
    
  
}
