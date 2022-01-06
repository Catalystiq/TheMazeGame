import java.awt.*;

public class MovingBarrier extends Rectangle{
    int speed = 1;

   MovingBarrier(int x, int y, int w, int h){
      super(x, y, w, h);
   }
   
   public void draw(Graphics g){
      g.setColor(Color.RED);
      g.fillRect(x, y, width, height);
   }

   public void move(){
       if(y >= 160){
            y -= speed;
       }else if(y <= 366){
            y += speed;
       }
   }
}