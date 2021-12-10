import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    
    //global variables
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = 556;

    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

    static final int PADDLE_WIDTH = 50;
    static final int PADDLE_HEIGHT = 50;

    //instances
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
    Obstacle sideWall;
    Obstacle wallOne;
    Obstacle topWall;
    Obstacle wallTwo;
    Obstacle middleWall;

    GamePanel() {
        newPaddles();
        newObstacles();
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);
        gameThread.start();
    }
    
    public void newObstacles(){
      borderBottom = new Obstacle(0, GAME_HEIGHT-6, GAME_WIDTH, 6);
      borderTop = new Obstacle(0, 0, GAME_WIDTH, 6);
      borderLeft = new Obstacle(0, 0, 6, GAME_HEIGHT);
      borderRight = new Obstacle(GAME_WIDTH-6, 0, 6, GAME_HEIGHT);
      
      bottomWall = new Obstacle(85, GAME_HEIGHT-140, GAME_WIDTH-185, 60);
      bottomBlock = new Obstacle(GAME_WIDTH-185, GAME_HEIGHT-85, 85, 85);
      sideWall = new Obstacle(85, 85, 60, GAME_HEIGHT-200);
      wallOne = new Obstacle(85, 85, 285, 60);
      topWall = new Obstacle(GAME_WIDTH/2-50, 0, 60, 305);
      wallTwo = new Obstacle(225, 245, 285, 60);
      middleWall = new Obstacle(GAME_WIDTH/2+85, 85, 60, 335);
    }



    public void newPaddles() {
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
        sideWall.draw(g);
        wallOne.draw(g);
        topWall.draw(g);
        wallTwo.draw(g);
        middleWall.draw(g);
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
      if(sideWall.intersects(paddle1)){
         newPaddles();
      }
      if(wallOne.intersects(paddle1)){
          newPaddles();
      }
      if(topWall.intersects(paddle1)){
          newPaddles();
      }
      if(wallTwo.intersects(paddle1)){
          newPaddles();
      }
      if(middleWall.intersects(paddle1)){
          newPaddles();
      }
    }

    public void run() {
        //game loop
        long lastTime = System.nanoTime();
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
