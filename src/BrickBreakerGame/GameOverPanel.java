package BrickBreakerGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GameOverPanel extends JFrame implements ActionListener {

    // Buttons
    private JButton restartButton;
    private JButton exitButton;

    // Constructor
    public GameOverPanel() {
        // Set JFrame properties
        setSize(700, 600);
        setResizable(false);
        setTitle("End Game");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background image
        ImageIcon backgroundImg = new ImageIcon("./src/background1.png");
        JLabel backgroundLabel = new JLabel(backgroundImg);
        backgroundLabel.setBounds(0, 0, backgroundImg.getIconWidth(), backgroundImg.getIconHeight());
        add(backgroundLabel);

        // Create buttons
        restartButton = new JButton("Restart");
        restartButton.setBounds(250, 500, 100, 50);
        restartButton.addActionListener(this);
        backgroundLabel.add(restartButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(350, 500, 100, 50);
        exitButton.addActionListener(this);
        backgroundLabel.add(exitButton);

        // Show JFrame
        setVisible(true);
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == restartButton) {
            System.out.println("Restarting game...");
        } else if (e.getSource() == exitButton) {
            dispose();
            System.exit(0);
        }
    }

    // Main method to start program
    public static void main(String[] args) {
        new GameOverPanel();
    }
}
