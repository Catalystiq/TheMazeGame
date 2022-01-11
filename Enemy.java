import java.awt.*;

public class Enemy extends Rectangle{
   Enemy(int x, int y, int w, int h){
      super(x, y, w, h);
   }
   
   public void draw(Graphics g){
      g.setColor(Color.RED);
      g.fillRect(x, y, width, height);
   }
}