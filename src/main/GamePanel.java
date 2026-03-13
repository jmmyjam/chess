package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class GamePanel extends JPanel implements Runnable {

    public static final int tileSize = 100;
    public static final int boardSize = tileSize * 8;

    Thread gameThread;

    public GamePanel() {
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (gameThread != null) {
            // UPDATE SCREEN
            update();
            // DRAW
            repaint();
        }
    }

    public void update() {

    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if ((row + col) % 2 == 0) {
                    g2.setColor(Color.WHITE);
                } else {
                    g2.setColor(new Color(118, 150, 86));
                }
                g2.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
            }
        }
    }
}
