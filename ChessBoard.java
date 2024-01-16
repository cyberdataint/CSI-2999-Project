import java.awt.*;
import javax.swing.*;


public class ChessBoard {
    
    public ChessBoard() {

        JFrame board = new JFrame();
        board.setTitle("Offline Chess Simulator");
        board.setSize(new Dimension(500, 500));
        board.setLayout(new GridLayout(8, 8));
        board.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        board.setVisible(true);

        JButton grid[][] = new JButton[8][8];

        ImageIcon empty = new ImageIcon("https://upload.wikimedia.org/wikipedia/commons/8/83/Solid_white_bordered.svg");

        
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if ((x + y) % 2 == 0) {
                    ChessSquare s = new ChessSquare(empty, x, y);
                    JButton square = new JButton();
                    square.setBackground(Color.BLACK);
                    grid[x][y] = square;
                    board.add(grid[x][y]);
                }
                else {
                    ChessSquare s = new ChessSquare(empty, x, y);
                    JButton square = new JButton();
                    square.setBackground(Color.WHITE);
                    grid[x][y] = square;
                    board.add(grid[x][y]);
                }
            }
        }

    }

}
