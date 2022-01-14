import javax.swing.*;

public class Main extends JFrame{
    public static void main(String[] args){
        ImageIcon splash = new ImageIcon("./img/MazeSplashScreen.png");
        JOptionPane.showMessageDialog(null,
               " Welcome to The Maze Game \n This is my final project for Computer Programming I \n You are in a maze and avoid obstacles to reach the doors. \n There are 3 levels that more difficult as you go on. \n Control your character with WASD \n Click OK to begin! \n Have Fun and Enjoy!", "TheMazeGame",
               JOptionPane.INFORMATION_MESSAGE, splash);

        GameFrame frame = new GameFrame();
    }
}
