package System;

import java.awt.*;

public class Bricks {

    public int brickMap[][];
    public int brickWidth;
    public int brickHeight;

    public Bricks(int row, int col){
        brickMap = new int[row][col];
        for (int i =0;i < brickMap.length; i++){
            for(int j=0;j< brickMap[0].length; j++){
                brickMap[i][j]= 1;
            }
        }
        brickWidth =520/col;
        brickHeight = 120/row;
    }
    public void draw(Graphics2D g){
        for (int i =0;i < brickMap.length; i++) {
            for (int j = 0; j < brickMap[0].length; j++) {
                if( brickMap[i][j]==1) {
                    g.setColor(Color.green);
                    g.fillRect(j * brickWidth + 50, i * brickHeight + 30, brickWidth, brickHeight);

                    g.setStroke(new BasicStroke(3));
                    g.setColor(Color.black);
                    g.drawRect(j * brickWidth + 50, i * brickHeight + 30, brickWidth, brickHeight);
                }else{
                    g.setColor(Color.black);
                    g.fillRect(j * brickWidth + 50, i * brickHeight + 30, brickWidth, brickHeight);
                }
            }
        }
    }

    public void brickDestroyed(int row,int col){

        brickMap[row][col]= 0;
    }
}
