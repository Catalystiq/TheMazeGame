import java.awt.*;

public class Door extends Rectangle{
   Door(int x, int y, int w, int h){
      super(x, y, w, h);
   }
   
   public void draw(Graphics g){
      g.setColor(Color.GREEN);
      g.fillRect(x, y, width, height);
   }
}