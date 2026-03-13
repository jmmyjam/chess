package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import Pieces.Piece;
import Pieces.Pawn;

public class GamePanel extends JPanel implements Runnable {

    public static final int tileSize = 100;
    public static final int boardSize = tileSize * 8;

    Thread gameThread;
    ArrayList<Piece> pieces = new ArrayList<>();
    Piece selectedPiece = null;

    public GamePanel() {
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                int col = e.getX() / tileSize;
                int row = e.getY() / tileSize;

                selectedPiece = null;
                for (Piece p : pieces) {
                    if (p.col == col && p.row == row) {
                        selectedPiece = p;
                        break;
                    }
                }
                System.out.println("Clicked: col=" + col + " row=" + row
                        + " piece=" + (selectedPiece != null ? selectedPiece.color + " " + selectedPiece.name : "none"));
            }
        });

        newGame();
    }

    public void newGame() {
        pieces.clear();
        for (int i = 0; i < 8; i++) {
            pieces.add(new Pawn("Pawn", "Black", i, 1));
            pieces.add(new Pawn("Pawn", "White", i, 6));
        }
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

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        // Draw board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                g2.setColor((row + col) % 2 == 0 ? Color.WHITE : new Color(118, 150, 86));
                g2.fillRect(col * tileSize, row * tileSize, tileSize, tileSize);
            }
        }

        // Draw pieces
        for (Piece p : pieces) {
            p.draw(g2);
        }
    }
}
