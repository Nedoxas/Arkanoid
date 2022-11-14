package System;

import java.awt.*;

public class Background {

    public static void drawBackground(Graphics g){
        g.setColor(Color.black);
        g.fillRect(1,1,640,480);

    }

    public static void drawBorders (Graphics g){
        g.setColor(Color.red);
        g.fillRect(0,0,3,480);
        g.fillRect(0,0,624,3);
        g.fillRect(624,0,3,480);
    }
}
