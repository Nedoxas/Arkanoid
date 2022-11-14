package System;

import java.awt.*;

public class Platform {

    public static int xPos;

    public Platform() {
        xPos=210;
    }

    public static void drawPlatform(Graphics g){

        g.setColor(Color.blue);
        g.fillRect(xPos,420,75,8);
    }

    public static void moveRight(){
        xPos+=15;

    }
    public static void moveLeft(){
        xPos-=15;

    }

    public static Boolean checkLeftBorder(){
        if(xPos<= 10) {return true;}
        else {return false;}
    }
    public static Boolean checkRightBorder(){
        if(xPos>= 540) {return true;}
        else {return false;}
    }
}
