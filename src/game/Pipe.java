package game;

public class Pipe extends Sprite {
    
    private boolean removed = false;
    
    public Pipe(int x, int y, int width, int height, String img){
        super(x, y, width, height, img);
    }
    public void update(){
    //checking for boundaries
    //update the object
    
    }
    public Node getNode(){
      return node;
    }
}
