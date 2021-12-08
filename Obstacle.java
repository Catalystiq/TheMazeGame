import java.awt.*;
import java.awt.event.*;

public class Obstacle extends Rectangle{
   Obstacle(int x, int y, int w, int h){
      super(x, y, w, h);
   }
   
   public void draw(Graphics g){
      g.setColor(Color.BLUE);
      g.fillRect(x, y, width, height);
   }
}