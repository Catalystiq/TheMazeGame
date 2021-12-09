/*Imports*/
import java.awt.*;
import java.awt.event.*;

public class Paddle extends Rectangle{
    
    int id;//This is for paddles like 1 or 2
    int yVelocity;//How fast the paddle is moving up or down
    int xVelocity;
    int speed = 3;//This keeps track on what speed the paddles move, this is only for more stability but is not neccesary

    Paddle(int x, int y, int PADDLE_WIDTH, int PADDLE_HEIGHT){
        super(x,y,PADDLE_WIDTH,PADDLE_HEIGHT);
        //this.id=id;
    }

    public void keyPressed(KeyEvent e){
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    setXDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    setXDirection(speed);
                    move();
                } 
    }
    public void keyReleased(KeyEvent e) {
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    setXDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    setXDirection(0);
                    move();
                }
    }
    public void setYDirection(int yDirection){
        yVelocity = yDirection;
    }
    public void setXDirection(int xDirection){
        xVelocity = xDirection;
    }
    public void move(){
        y = y + yVelocity;
        x = x + xVelocity;
    }
    public void draw(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
    }
}