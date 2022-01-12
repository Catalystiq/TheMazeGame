import java.awt.*;

public class EnemyLongitude extends Rectangle{
   int speed = 5;
   boolean right = false;
   boolean left = true;

   EnemyLongitude(int x, int y, int w, int h, int speed){
      super(x, y, w, h);
      this.speed = speed;
   }
   
   public void draw(Graphics g){
      g.setColor(Color.RED);
      g.fillRect(x, y, width, height);
   }

   public void move(){
      if(left){
         if(x < 950){
            x += speed;  
         }
         if(x >= 950){
            left = false;
            right = true;
         }
      }
      if(right){
         if(x > 0){
            x -= speed;  
         }
         if(x <= 0){
            left = true;
            right = false;
         }
      }
   }
}