/*Imports*/
import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle{
    int yVelocity;
    int xVelocity;
    int speed = 5;

    Player(int x, int y, int w, int h){
        super(x, y, w, h);
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
