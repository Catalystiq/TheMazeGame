import java.awt.*;

public class Barrier extends Rectangle{
   Barrier(int x, int y, int w, int h){
      super(x, y, w, h);
   }
   
   public void draw(Graphics g){
      g.setColor(new Color(152, 3, 252));
      g.fillRect(x, y, width, height);
   }
}