import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Board extends JPanel {
    
    public Board() {

        /*
        JFrame frame = new JFrame("Offline Chess Simulator");
        frame.setSize(new Dimension(500, 500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        */

        setLayout(new GridLayout(8, 8));
        setPreferredSize(new Dimension(400, 400));
        
        JButton grid[][] = new JButton[8][8];

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {
                JButton square = new JButton();
                square.addActionListener(new SquareButtonListener(x, y));
                square.setBorderPainted(false);
                grid[x][y] = square;

                if ((x + y) % 2 == 0) {
                    square.setBackground(new Color(177, 228, 185)); // LIGHT
                } else {
                    square.setBackground(new Color(112, 162, 163)); // DARK
                }

                add(square);
            }
        }

        /*
        frame.getContentPane().add(board);
        frame.setVisible(true);
        */

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
