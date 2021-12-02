//TheMazeGame
//James Nelson
//December 1, 2021
//Computer Programming I
//A game where you must move through a series of mazes to win!

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Main {

    //Basic Game Variables
    static final int GAME_HEIGHT = 550;
    static final int GAME_WIDTH = 1000;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);//Making it into a Diemension form for the pannal
    static final Color FIELD = new Color(0,0,0);
    
    public static void main(String args[]){   
      ImageIcon icon = new ImageIcon("Images/splashImg.png");
      JLabel splashImg = new JLabel(icon);
      Main main = new Main();
      
      
      //Making our components
      JFrame frame= new JFrame();
      JPanel splashPanel = new JPanel();
      JPanel gamePanel = new JPanel();
      JButton start = new JButton("Play");
      
      //Default settings
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      //Splash screen
      frame.add(splashPanel);
      frame.setTitle("24/7 Studios");
      frame.setLocationRelativeTo(null);
      frame.setBackground(Color.BLACK);
      splashPanel.add(splashImg);
      splashPanel.add(start);
      frame.pack();
      
      
      start.addActionListener(e -> main.play(frame, splashPanel, gamePanel));
      //I guess we needed a try and catch thing so yeah this exits, but really only to wait a couple of seconds
//       try {
//          Thread.sleep(5000);//Splash Screen cooldown
//       } catch (Exception e) {
//          System.out.println(e);
//       }
//       

      

      

   }
   
   public void play(JFrame frame, JPanel splashPanel, JPanel gamePanel){
      frame.remove(splashPanel);//Removing the splash panel
      gamePanel = new Game();//Importing a panel from a class
      frame.addKeyListener(new Game());
      gamePanel.setFocusable(true);
      gamePanel.setPreferredSize(SCREEN_SIZE);
      gamePanel.setBackground(FIELD);
      frame.add(gamePanel);
      frame.setTitle("The Maze Game");
      frame.setLocationRelativeTo(null);
      frame.pack();
   }
}