package BrickBreakerGame;

import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GamePlay  extends JPanel implements ActionListener, KeyListener {
    private boolean play = false;
    private Timer timer;
    private int delay = 8;
    private int ballposX = 120;
    private int ballposY = 350;
    private int ballXdir = -1;
    private int ballYdir = -2;
    private int playerX = 20;

    public GamePlay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        timer = new Timer(delay, this);
        timer.start();
    }
    public void paint(Graphics graphics){
        //background
        graphics.setColor(Color.black);
        graphics.fillRect(1,1,692,592);

        //border
        graphics.setColor(Color.yellow);
        graphics.fillRect(0,0,685,3);
        graphics.fillRect(0,3,3,592);
        graphics.fillRect(681,3,3,592);

        //paddle
        graphics.setColor(Color.green);
        graphics.fillRect(playerX,550,100,8);

        //ball
        graphics.setColor(Color.red);
        graphics.fillOval(ballposX,ballposY,20,20);



    }

    private void moveLeft(){
        play = true;
        playerX-=20;
    }
    private void moveRight(){
        play = true;
        playerX+=20;
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            if(playerX <= 3){
                playerX=3;
            }else{
                moveLeft();
            }
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            if(playerX >= 580){
                playerX = 580;
            }else{
                moveRight();
            }
        }
        repaint();

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(play){
            if(ballposX <= 0){
                ballXdir =- ballXdir;
            }
            if(ballposX >= 670){
                ballXdir =- ballXdir;
            }
            if(ballposY <= 0){
                ballYdir =- ballYdir;
            }
            Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
            Rectangle paddleRect = new Rectangle(playerX,550,100,8);

            if(ballRect.intersects(paddleRect)){
                ballYdir =- ballYdir;
            }
            ballposX += ballXdir;
            ballposY += ballYdir;
        }
        repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}
