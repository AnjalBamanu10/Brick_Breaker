package BrickBreakerGame;

import javax.swing.*;

public class MainClass {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        GamePlay gamePlay = new GamePlay();

        frame.setTitle("Brick Breaker");
        frame.add(gamePlay);
        frame.setSize(700,600);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setResizable(false);
    }
}
