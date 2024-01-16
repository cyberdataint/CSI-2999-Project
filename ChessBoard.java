import java.awt.*;
import javax.swing.*;
import java.io.IOException;
import javax.imageio.ImageIO;


public class ChessBoard {
    
    public ChessBoard() throws IOException {

        JFrame board = new JFrame();
        board.setTitle("Offline Chess Simulator");
        board.setSize(new Dimension(500, 500));
        board.setLayout(new GridLayout(8, 8));

        JButton grid[][] = new JButton[8][8];

        ImageIcon empty = new ImageIcon(ImageIO.read(getClass().getResource("/pieces/EmptySqaure.jpg")));

        for(int x = 0; x < 8; x++) {
            for(int y = 0; y < 8; y++) {

                ChessSquare s = new ChessSquare(empty, x, y);
                JButton square = new JButton(s.sprite);
                grid[x][y] = square;
                board.add(grid[x][y]);

            }
        }

    }

}
