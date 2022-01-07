import java.awt.*;

public class MovingBarrier extends Rectangle{
   int speed = 5;
   boolean up = false;
   boolean down = true;

   MovingBarrier(int x, int y, int w, int h){
      super(x, y, w, h);
   }
   
   public void draw(Graphics g){
      g.setColor(Color.RED);
      g.fillRect(x, y, width, height);
   }

   public void move(){
      //System.out.println(y);
      if(down){
         if(y < 366){
            y += speed;  
         }
         if(y >= 366){
            down = false;
            up = true;
         }
      }
      if(up){
         if(y > 160){
            y -= speed;  
         }
         if(y <= 160){
            down = true;
            up = false;
         }
      }


      //   if(y < 366){
      //       y -= speed;
      //  }
      //   if(y > 160){
      //       y += speed;
      //  }else if(y <= 160){
      //     y -= 5;
      //  } if(y >= 366){
      //    y -= 20;
      // }
   }
}