package System;

import javax.swing.*;

public class Settings {

    private static JFrame screen = new JFrame();
    private static GameCycles gameCycle ;
    public static void initGame(){

        new Ball();
        new Platform();


        gameCycle = new GameCycles();

        screen.setBounds(10,10,640,480);
        screen.setTitle("Arkanoid");
        screen.setVisible(true);
        screen.setResizable(false);

        screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        screen.add(gameCycle);

        System.out.println("Press space to begin");
    }
    public static void resetGame(){

        screen.remove(gameCycle);

        new Ball();
        new Platform();

        gameCycle = new GameCycles();
        screen.add(gameCycle);
        screen.setVisible(true);
    }
    public static void quitGame(){
        System.exit(0);
    }

    public static void gameOver(){
        System.out.println("Game over.");
        Settings.quitGame();
    }
}
