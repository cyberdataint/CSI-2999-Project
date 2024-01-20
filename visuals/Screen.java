package visuals;

import javax.swing.*;
import java.awt.*;
import visuals.user_interface.*;

public class Screen extends JFrame {

    Board board;
    PresetsMenu presetsMenu;

    public Screen() {

        Color backgroundColor = new Color(132, 136, 132); // SMOKE

        setTitle("Offline Chess Simulator");
        setMinimumSize(new Dimension(1000, 875));
        getContentPane().setBackground(backgroundColor);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // DON'T FORGET!! ACCOUNT FOR MARGIN!!
        setLayout(new BorderLayout(10, 10));

        JPanel screenPanel = new JPanel(new BorderLayout());
        screenPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        screenPanel.setBackground(backgroundColor);

        JLabel label = new JLabel("Test");
        screenPanel.add(label, BorderLayout.CENTER); 

    
        // CENTER PANELS
            board = new Board();
            board.setPreferredSize(new Dimension(500, 500));
            // add(board, BorderLayout.CENTER);
        // -------------

        // EAST/RIGHT PANELS
            // implement
        // -------------

        // WEST/LEFT PANELS
            // implement
        // -------------

        // NORTH/TOP PANELS
            // implement
        // -------------

        // SOUTH/BOTTOM PANELS
            // implement
        // -------------

        setContentPane(screenPanel);

        pack();
        setVisible(true);

    }

}
