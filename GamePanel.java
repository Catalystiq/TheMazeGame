import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {
    
    //global variables
    static final int GAME_WIDTH = 1000;
    static final int GAME_HEIGHT = 556;

    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);

    static final int PADDLE_WIDTH = 50;
    static final int PADDLE_HEIGHT = 50;
    static int deaths = 0;
    static int level = 0;

    //instances
    Thread gameThread;
    Image image;
    Graphics graphics;
    Player player;
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
    Obstacle wallThree;
    Obstacle wallFour;
    Door firstDoor;

    Barrier barrierBottom;
    Barrier barrierTop;
    Barrier barrierLeft;
    Barrier barrierRight;

    Barrier barrierOne;
    Barrier barrierTwo;
    MovingBarrier moveOne;
    MovingBarrier moveTwo;
    MovingBarrier moveThree;
    MovingBarrier moveFour;
    MovingBarrier moveFive;
    Door secondDoor;

    Enemy enemyOne;
    Enemy enemyTwo;
    Enemy enemyThree;
    Enemy enemyFour;
    EnemyLatitude latitudeOne;
    EnemyLatitude latitudeTwo;
    EnemyLatitude latitudeThree;
    EnemyLatitude latitudeFour;
    EnemyLatitude latitudeFive;
    EnemyLatitude latitudeSix;

    EnemyLongitude longitudeOne;
    EnemyLongitude longitudeTwo;
    EnemyLongitude longitudeThree;
    Door thirdDoor;

    GamePanel() {
        newPlayers();
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
        wallThree = new Obstacle(625, 85, 285, 60);
        wallFour = new Obstacle(GAME_WIDTH-285, 245, 285, 60);
        firstDoor = new Door(GAME_WIDTH-85, GAME_HEIGHT-85, 65, 65);

        barrierBottom = new Barrier(0, GAME_HEIGHT-6, 0, 0);
        barrierTop = new Barrier(0, 0, 0, 0);
        barrierLeft = new Barrier(0, 0, 0, 0);
        barrierRight = new Barrier(GAME_WIDTH-6, 0, 0, 0);

        barrierOne = new Barrier(85, 85, 0, 0);
        barrierTwo = new Barrier(85, GAME_HEIGHT-140, 0, 0);
        moveOne = new MovingBarrier(85, GAME_HEIGHT/2, 0, 0, 0);
        moveTwo = new MovingBarrier(85, GAME_HEIGHT/2, 0, 0, 0);
        moveThree = new MovingBarrier(85, GAME_HEIGHT/2, 0, 0, 0);
        moveFour = new MovingBarrier(85, GAME_HEIGHT/2, 0, 0, 0);
        moveFive = new MovingBarrier(85, GAME_HEIGHT/2, 0, 0, 0);
        secondDoor = new Door(GAME_WIDTH-85, GAME_HEIGHT-85, 65, 65);

        enemyOne = new Enemy(0, GAME_HEIGHT-6, 0, 0);
        enemyTwo = new Enemy(0, 0, 0, 0);
        enemyThree = new Enemy(0, 0, 0, 0);
        enemyFour = new Enemy(GAME_WIDTH-6, 0, 0, 0);
        latitudeOne = new EnemyLatitude(85, GAME_HEIGHT/2, 0, 0, 0);
        latitudeTwo = new EnemyLatitude(248, GAME_HEIGHT/2, 0, 0, 0);
        latitudeThree = new EnemyLatitude(411, GAME_HEIGHT/2, 0, 0, 0);
        latitudeFour = new EnemyLatitude(574, GAME_HEIGHT/2, 0, 0, 0);
        latitudeFive = new EnemyLatitude(737, GAME_HEIGHT/2, 0, 0, 0);
        latitudeSix = new EnemyLatitude(900, GAME_HEIGHT/2, 0, 0, 0);

        longitudeOne = new EnemyLongitude(GAME_HEIGHT/2, 411, 0, 0, 0);
        longitudeTwo = new EnemyLongitude(GAME_HEIGHT/2, 248, 0, 0, 0);
        longitudeThree = new EnemyLongitude(GAME_HEIGHT/2, 85, 0, 0, 0);
        thirdDoor = new Door(GAME_WIDTH-85, 20, 0, 0);
    }

    public void removeObstacles(){
        borderBottom = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        borderTop = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        borderLeft = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        borderRight = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);

        bottomWall = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        bottomBlock = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        sideWall = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        wallOne = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        topWall = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        wallTwo = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        middleWall = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        wallThree = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        wallFour = new Obstacle(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
        firstDoor = new Door(GAME_WIDTH*2, GAME_HEIGHT*2, 0, 0);
    }

    public void newBarriers(){
        barrierBottom = new Barrier(0, GAME_HEIGHT-6, GAME_WIDTH, 6);
        barrierTop = new Barrier(0, 0, GAME_WIDTH, 6);
        barrierLeft = new Barrier(0, 0, 6, GAME_HEIGHT);
        barrierRight = new Barrier(GAME_WIDTH-6, 0, 6, GAME_HEIGHT);

        barrierOne = new Barrier(0, 0, GAME_WIDTH, 160);
        barrierTwo = new Barrier(85, GAME_HEIGHT-140, GAME_WIDTH-185, 160);
        moveOne = new MovingBarrier(85, GAME_HEIGHT/2, 50, 50, 5);
        moveTwo = new MovingBarrier(248, GAME_HEIGHT/2, 50, 50, 7);
        moveThree = new MovingBarrier(411, GAME_HEIGHT/2, 50, 50, 9);
        moveFour = new MovingBarrier(574, GAME_HEIGHT/2, 50, 50, 10);
        moveFive = new MovingBarrier(737, GAME_HEIGHT/2, 50, 50, 11);
        secondDoor = new Door(GAME_WIDTH-85, GAME_HEIGHT-85, 65, 65);
    }

    public void removeBarriers(){
        barrierBottom = new Barrier(0, GAME_HEIGHT-6, 0, 0);
        barrierTop = new Barrier(0, 0, 0, 0);
        barrierLeft = new Barrier(0, 0, 0, 0);
        barrierRight = new Barrier(GAME_WIDTH-6, 0, 0, 0);

        barrierOne = new Barrier(0, 0, 0, 0);
        barrierTwo = new Barrier(85, GAME_HEIGHT-140, 0, 0);
        moveOne = new MovingBarrier(85, GAME_HEIGHT/2, 50, 0, 0);
        moveTwo = new MovingBarrier(248, GAME_HEIGHT/2, 50, 0, 0);
        moveThree = new MovingBarrier(411, GAME_HEIGHT/2, 50, 0, 0);
        moveFour = new MovingBarrier(574, GAME_HEIGHT/2, 50, 0, 0);
        moveFive = new MovingBarrier(737, GAME_HEIGHT/2, 50, 0, 0);
        secondDoor = new Door(GAME_WIDTH-85, GAME_HEIGHT-85, 0, 0);
    }

    public void newEnemies(){
        enemyOne = new Enemy(0, GAME_HEIGHT-6, GAME_WIDTH, 6);
        enemyTwo = new Enemy(0, 0, GAME_WIDTH, 6);
        enemyThree = new Enemy(0, 0, 6, GAME_HEIGHT);
        enemyFour = new Enemy(GAME_WIDTH-6, 0, 6, GAME_HEIGHT);

        latitudeOne = new EnemyLatitude(85, GAME_HEIGHT/2, 50, 50, 11);
        latitudeTwo = new EnemyLatitude(248, GAME_HEIGHT/2, 50, 50, 13);
        latitudeThree = new EnemyLatitude(411, GAME_HEIGHT/2, 50, 50, 15);
        latitudeFour = new EnemyLatitude(574, GAME_HEIGHT/2, 50, 50, 17);
        latitudeFive = new EnemyLatitude(737, GAME_HEIGHT/2, 50, 50, 19);
        latitudeSix = new EnemyLatitude(900, GAME_HEIGHT/2, 50, 50, 21);

        longitudeOne = new EnemyLongitude(GAME_HEIGHT/2, 411, 50, 50, 21);
        longitudeTwo = new EnemyLongitude(GAME_HEIGHT/2, 248, 50, 50, 23);
        longitudeThree = new EnemyLongitude(GAME_HEIGHT/2, 85,  50, 50, 25);
        thirdDoor = new Door(GAME_WIDTH-85, 20, 65, 65);
    }

    public void removeEnemies(){
        enemyOne = new Enemy(0, GAME_HEIGHT-6, 0, 0);
        enemyTwo = new Enemy(0, 0, 0, 0);
        enemyThree = new Enemy(0, 0, 0, 0);
        enemyFour = new Enemy(GAME_WIDTH-6, 0, 0, 0);

        latitudeOne = new EnemyLatitude(85, GAME_HEIGHT/2, 0, 0, 0);
        latitudeTwo = new EnemyLatitude(248, GAME_HEIGHT/2, 0, 0, 0);
        latitudeThree = new EnemyLatitude(411, GAME_HEIGHT/2, 0, 0, 0);
        latitudeFour = new EnemyLatitude(574, GAME_HEIGHT/2, 0, 0, 0);
        latitudeFive = new EnemyLatitude(737, GAME_HEIGHT/2, 0, 0, 0);
        latitudeSix = new EnemyLatitude(900, GAME_HEIGHT/2, 0, 0, 0);

        longitudeOne = new EnemyLongitude(GAME_HEIGHT/2, 411, 0, 0, 0);
        longitudeTwo = new EnemyLongitude(GAME_HEIGHT/2, 248, 0, 0, 0);
        longitudeThree = new EnemyLongitude(GAME_HEIGHT/2, 85,  0, 0, 0);
        thirdDoor = new Door(GAME_WIDTH-85, 20, 0, 0);
    }

    public void newPlayers() {
        player = new Player(GAME_WIDTH-GAME_WIDTH+20,GAME_HEIGHT-70,PADDLE_WIDTH,PADDLE_HEIGHT);
        level += 1;
        System.out.println("level: " + level);
    }

    public void death(){
        player = new Player(GAME_WIDTH-GAME_WIDTH+20,GAME_HEIGHT-70,PADDLE_WIDTH,PADDLE_HEIGHT);
        deaths += 1;
        System.out.println("deaths: " + deaths);
    }
    public void removePlayer(){
        player = new Player(GAME_WIDTH-GAME_WIDTH+20,GAME_HEIGHT-70, 0, 0);
        this.removeAll();
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();
        draw(graphics);
        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        player.draw(g);
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
        wallThree.draw(g);
        wallFour.draw(g);
        firstDoor.draw(g);

        barrierBottom.draw(g);
        barrierTop.draw(g);
        barrierLeft.draw(g);
        barrierRight.draw(g);

        barrierOne.draw(g);
        barrierTwo.draw(g);
        moveOne.draw(g);
        moveTwo.draw(g);
        moveThree.draw(g);
        moveFour.draw(g);
        moveFive.draw(g);
        secondDoor.draw(g);

        enemyOne.draw(g);
        enemyTwo.draw(g);
        enemyThree.draw(g);
        enemyFour.draw(g);

        latitudeOne.draw(g);
        latitudeTwo.draw(g);
        latitudeThree.draw(g);
        latitudeFour.draw(g);
        latitudeFive.draw(g);
        latitudeSix.draw(g);

        longitudeOne.draw(g);
        longitudeTwo.draw(g);
        longitudeThree.draw(g);
        thirdDoor.draw(g);
    }

    public void move() {
        player.move();
        moveOne.move();
        moveTwo.move();
        moveThree.move();
        moveFour.move();
        moveFive.move();

        latitudeOne.move();
        latitudeTwo.move();
        latitudeThree.move();
        latitudeFour.move();
        latitudeFive.move();
        latitudeSix.move();

        longitudeOne.move();
        longitudeTwo.move();
        longitudeThree.move();
    }
    
    public void checkCollision(){
        if(borderBottom.intersects(player)){death();}
        if(borderTop.intersects(player)){death();}
        if(borderLeft.intersects(player)){death();}
        if(borderRight.intersects(player)){death();}
        if(bottomWall.intersects(player)){death();}
        if(bottomBlock.intersects(player)){/*death();*/}
        if(sideWall.intersects(player)){death();}
        if(wallOne.intersects(player)){death();}
        if(topWall.intersects(player)){death();}
        if(wallTwo.intersects(player)){death();}
        if(middleWall.intersects(player)){death();}
        if(wallThree.intersects(player)){death();}
        if(wallFour.intersects(player)){death();}
        if(firstDoor.intersects(player)){
            removeObstacles();
            newPlayers();
            newBarriers();
        }

        if(barrierBottom.intersects(player)){death();}
        if(barrierTop.intersects(player)){death();}
        if(barrierLeft.intersects(player)){death();}
        if(barrierRight.intersects(player)){death();}

        if(barrierOne.intersects(player)){death();}
        if(barrierTwo.intersects(player)){/*death();*/}
        if(moveOne.intersects(player)){death();}
        if(moveTwo.intersects(player)){death();}
        if(moveThree.intersects(player)){death();}
        if(moveFour.intersects(player)){death();}
        if(moveFive.intersects(player)){death();}
        if(secondDoor.intersects(player)){
            removeBarriers();
            newPlayers();
            newEnemies();
        }

        // if(enemyOne.intersects(player)){death();}
        // if(enemyTwo.intersects(player)){death();}
        // if(enemyThree.intersects(player)){death();}
        // if(enemyFour.intersects(player)){death();}
        // if(latitudeOne.intersects(player)){death();}
        // if(latitudeTwo.intersects(player)){death();}
        // if(latitudeThree.intersects(player)){death();}
        // if(latitudeFour.intersects(player)){death();}
        // if(latitudeFive.intersects(player)){death();}
        // if(latitudeSix.intersects(player)){death();}

        // if(longitudeOne.intersects(player)){death();}
        // if(longitudeTwo.intersects(player)){death();}
        // if(longitudeThree.intersects(player)){death();}

        if(thirdDoor.intersects(player)){
            removeEnemies();
            removePlayer();
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
            player.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            player.keyReleased(e);
        }
    }
}
