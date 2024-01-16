import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ChessBoard {
    
    public ChessBoard() {

        JFrame frame = new JFrame("Offline Chess Simulator");
        frame.setSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel board = new JPanel(new GridLayout(8, 8));
        
        JButton grid[][] = new JButton[8][8];

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                JButton square = new JButton();
                square.setPreferredSize(new Dimension(50, 50));
                square.addActionListener(new SquareButtonListener(x, y));
                grid[x][y] = square;

                if ((x + y) % 2 == 0) {
                    square.setBackground(Color.WHITE);
                } else {
                    square.setBackground(Color.BLACK);
                }

                board.add(square);
            }
        }

        frame.getContentPane().add(board);
        frame.setVisible(true);

    }


    static class SquareButtonListener implements ActionListener {
        private int x;
        private int y;

        public SquareButtonListener(int xCoord, int yCoord) {
            this.x = xCoord;
            this.y = yCoord;
        }

        // example use where it prints the coordinates of the button clicked
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println("(" + x + ", " + y + ")");
        }
    }

}
