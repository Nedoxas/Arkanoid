package System;

import java.awt.*;

public class Ball {

    public static int xPos;
    public static int yPos;

    public static int xDir;
    public static int yDir;

    public Ball() {
        xPos=125;
        yPos=255;
        xDir=-1;
        yDir=-3;
    }



    public static void drawBall(Graphics g){

        g.setColor(Color.orange);
        g.fillOval(xPos,yPos,15,15);
    }

    public static void moveBall(){
        xPos+= xDir;
        yPos+= yDir;
    }
    public static void checkBorders(){
        if(xPos< 0){
            xDir = -xDir;
        }

        if(yPos< 0){
            yDir = -yDir;
        }

        if(xPos> 610){
            xDir = -xDir;
        }

        if(yPos > 440){
            Settings.gameOver();
        }
    }
    public static void checkPlatformCollision(){
        if(new Rectangle(Ball.xPos,Ball.yPos,15,15).intersects(
                (new Rectangle(Platform.xPos,420,75,8)))){
            Ball.yDir = -Ball.yDir;
        }
    }
}
