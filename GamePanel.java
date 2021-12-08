
/*Imports*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;// Alright so the reason that there is a static and final is to make sure
                                       // everything is just one variable and does not turn into many
    static final int GAME_HEIGHT = 556;

    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);// WTF

    //static final int BALL_DIAMETER = 20;// Setting demesions for the objects in the game
    static final int PADDLE_WIDTH = 50;
    static final int PADDLE_HEIGHT = 50;

    //Planning instances
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Obstacle borderBottom;
    Obstacle borderTop;
    Obstacle borderLeft;
    Obstacle borderRight;
    
    Obstacle bottomWall;
    Obstacle bottomBlock;

    GamePanel() {
        newPaddles();
        newObstacles();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);//Making a thread
        gameThread.start();
    }
    
    public void newObstacles(){
      borderBottom = new Obstacle(0, GAME_HEIGHT-6, GAME_WIDTH, 6);
      borderTop = new Obstacle(0, 0, GAME_WIDTH, 6);
      borderLeft = new Obstacle(0, 0, 6, GAME_HEIGHT);
      borderRight = new Obstacle(GAME_WIDTH-6, 0, 6, GAME_HEIGHT);
      
      bottomWall = new Obstacle(85, GAME_HEIGHT-140, GAME_WIDTH-185, 60);
      bottomBlock = new Obstacle(GAME_WIDTH-185, GAME_HEIGHT-85, 85, 85);
      
    }



    public void newPaddles() {
        //Calling new paddles using the instances and the constructer to make it fast and shit
        paddle1 = new Paddle(GAME_WIDTH-GAME_WIDTH+20,GAME_HEIGHT-70,PADDLE_WIDTH,PADDLE_HEIGHT);//X,Y,W,H
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();

        draw(graphics);

        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        paddle1.draw(g);
        borderBottom.draw(g);
        borderTop.draw(g);
        borderLeft.draw(g);
        borderRight.draw(g);
        
        bottomWall.draw(g);
        bottomBlock.draw(g);
    }

    public void move() {
        paddle1.move();
    }
    
    public void checkCollision(){
      if(borderBottom.intersects(paddle1)){
         newPaddles();
      }
      if(borderTop.intersects(paddle1)){
         newPaddles();
      }
      if(borderLeft.intersects(paddle1)){
         newPaddles();
      }
      if(borderRight.intersects(paddle1)){
         newPaddles();
      }
      if(bottomWall.intersects(paddle1)){
         newPaddles();
      }
      if(bottomBlock.intersects(paddle1)){
         newPaddles();
      }
    }

    public void run() {
        //game loop
        long lastTime = System.nanoTime();//This makes a long value of shit
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;

        while(true){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            if(delta >=1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
        }
    }
}
