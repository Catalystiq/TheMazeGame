/*Imports*/
import java.awt.*;

public class Text extends Rectangle{
    
    int GAME_WIDTH;
    int GAME_HEIGHT;

    int level;
    int deaths;
    int time;
    boolean win;

    Text(boolean win, int time, int level, int deaths, int GAME_WIDTH, int GAME_HEIGHT){
        this.level = level;
        this.deaths = deaths;
        this.time = time;
        this.win = win;
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_WIDTH;
    }
    public void draw(Graphics g){
        g.setColor(Color.white);
        g.setFont(new Font("Arial",Font.PLAIN,20));


        g.drawString("level: " + level, 15, GAME_HEIGHT/2+30);
        g.drawString("deaths:" + deaths, 15, GAME_HEIGHT/2);
        g.drawString("time: " + time/60, 15, GAME_HEIGHT/2-30);
        if(win == true){
            g.drawString("You Win!", GAME_WIDTH/2, GAME_HEIGHT/2);
            g.drawString("Thanks For Playing!", GAME_WIDTH/2, GAME_HEIGHT/2+30);
        }
    }
}