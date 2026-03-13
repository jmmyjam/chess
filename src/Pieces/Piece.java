package Pieces;

import java.awt.Color;
import java.awt.Graphics2D;
import main.GamePanel;

public class Piece {

    public String name;
    public String color;
    public int col;
    public int row;

    public Piece(String name, String color, int col, int row) {
        this.name = name;
        this.color = color;
        this.col = col;
        this.row = row;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public String getPosition() {
        return col + "," + row;
    }

    public void setPosition(int col, int row) {
        this.col = col;
        this.row = row;
    }

    public void draw(Graphics2D g2) {
        int x = col * GamePanel.tileSize;
        int y = row * GamePanel.tileSize;
        g2.setColor(color.equalsIgnoreCase("white") ? Color.WHITE : Color.BLACK);
        g2.fillOval(x + 10, y + 10, GamePanel.tileSize - 20, GamePanel.tileSize - 20);
        g2.setColor(color.equalsIgnoreCase("white") ? Color.BLACK : Color.WHITE);
        g2.drawString(name, x + 30, y + 55);
    }
}
