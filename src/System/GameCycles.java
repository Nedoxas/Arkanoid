package System;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

import static System.Settings.quitGame;

public class GameCycles extends JPanel implements KeyListener, ActionListener {

    private Boolean running = false;
    private int brickCount = 27;

    private Timer time;
    private int delay = 4;
    private Bricks layout;

    public GameCycles(){
        layout = new Bricks(3,9);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay,this);
        time.start();
    }

    public void paint(Graphics g){

        Background.drawBackground((Graphics)g);

        layout.draw((Graphics2D)g);

        Platform.drawPlatform((Graphics)g);

        Background.drawBorders((Graphics)g);

        Ball.drawBall((Graphics)g);


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Ball.checkPlatformCollision();

        for(int i=0;i<layout.brickMap.length;i++){
            for(int j=0;j<layout.brickMap[0].length;j++){
                if(layout.brickMap[i][j]>0){
                    int brickX = j*layout.brickWidth +50;
                    int brickY = i*layout.brickHeight +30;
                    int brickWidth = layout.brickWidth;
                    int brickHeight = layout.brickHeight;

                    Rectangle brick = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                    Rectangle ballBounds = new Rectangle(Ball.xPos,Ball.yPos,15,15);
                    Rectangle brickBounds = brick;

                    if(ballBounds.intersects(brickBounds)){
                        layout.brickDestroyed(i,j);
                        brickCount -=1;
                        System.out.println("Bricks remaining: "+brickCount);

                        if(brickCount==0){
                            Settings.gameOver();
                        }

                        if(Ball.xPos+14<=brickBounds.x || Ball.xPos +1 >=brickBounds.x + brickBounds.width){
                            Ball.xDir = -Ball.xDir;
                        }else{
                            Ball.yDir= -Ball.yDir;
                        }
                        break;
                    }


                }
            }
        }

        if(running){
            Ball.moveBall();

            Ball.checkBorders();
        }

        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(Platform.checkRightBorder()){
                Platform.xPos = 540;
            }else{
                Platform.moveRight();
            }
        }

        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(Platform.checkLeftBorder()){
                Platform.xPos = 10;
            }else{
               Platform.moveLeft();
            }
        }
        if(e.getKeyCode()== KeyEvent.VK_SPACE){
            beginGame();
        }
        if(e.getKeyCode()==KeyEvent.VK_R){
            resetGame();
        }
        if(e.getKeyCode()==KeyEvent.VK_Q){
            quitGame();
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void resetGame(){
        running = false;
        Settings.resetGame();
    }
    public void beginGame(){
        running=true;
    }

}
