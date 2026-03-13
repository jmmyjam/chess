import javax.swing.JFrame;
import java.awt.Dimension;
import main.GamePanel;

public class Main {
    public static void main(String[] args) {
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setTitle("Chess");
        window.setResizable(false);

        GamePanel gamePanel = new GamePanel();
        gamePanel.setPreferredSize(new Dimension(GamePanel.boardSize, GamePanel.boardSize));
        window.add(gamePanel);
        window.pack();

        window.setLocationRelativeTo(null);
        window.setVisible(true);

        gamePanel.startGameThread();
    }
}
