import java.awt.*;

public class EnemyLatitude extends Rectangle{
   int speed = 5;
   boolean up = false;
   boolean down = true;

   EnemyLatitude(int x, int y, int w, int h, int speed){
      super(x, y, w, h);
      this.speed = speed;
   }
   
   public void draw(Graphics g){
      g.setColor(Color.RED);
      g.fillRect(x, y, width, height);
   }

   public void move(){
      if(down){
         if(y < 506){
            y += speed;  
         }
         if(y >= 506){
            down = false;
            up = true;
         }
      }
      if(up){
         if(y > 0){
            y -= speed;  
         }
         if(y <= 0){
            down = true;
            up = false;
         }
      }
   }
}