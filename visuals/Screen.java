package visuals;

import javax.swing.*;
import java.awt.*;
import visuals.user_interface.*;

public class Screen extends JFrame {

    Board board;
    PresetsMenu presetsMenu;
    JLabel label;

    public Screen() {

        // JFRAME SETTINGS
            Color backgroundColor = new Color(132, 136, 132); // SMOKE
            setTitle("Offline Chess Simulator");
            getContentPane().setBackground(backgroundColor);
            setLocationRelativeTo(null);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // SETS 6:5 RATIO
            setMinimumSize(new Dimension(1500, 1250));
            // POTENTIALLY ADD A WAY TO MAINTAIN THAT RATIO? ~implement

            // FRAME MARGINS
            setLayout(new BorderLayout(25, 25)); // DON'T FORGET!! ACCOUNT FOR MARGIN!!
            JPanel screenPanel = new JPanel(new BorderLayout());
            screenPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
            screenPanel.setBackground(backgroundColor);
        // ------------

    
        // CENTER PANELS
            board = new Board();
            board.setPreferredSize(new Dimension(500, 500));
            screenPanel.add(board, BorderLayout.CENTER);
        // -------------

        // EAST PANELS
            // PLACE HOLDER
            label = new JLabel("test", SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(300, 50)); // ONLY NEED TO MODIFY WIDTH
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            screenPanel.add(label, BorderLayout.EAST);
            // ------------

            // implement
        // -------------

        // WEST PANELS
            // PLACE HOLDER
            label = new JLabel("test", SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(300, 50)); // ONLY NEED TO MODIFY WIDTH
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            screenPanel.add(label, BorderLayout.WEST);
            // ------------

            // implement
        // -------------

        // NORTH PANELS
            // PLACE HOLDER
            label = new JLabel("test", SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(50, 150)); // ONLY NEED TO MODIFY HEIGHT
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            screenPanel.add(label, BorderLayout.NORTH);
            // ------------

            // implement
        // -------------

        // SOUTH PANELS
            // PLACE HOLDER
            label = new JLabel("test", SwingConstants.CENTER);
            label.setPreferredSize(new Dimension(50, 200)); // ONLY NEED TO MODIFY HEIGHT
            label.setOpaque(true);
            label.setBackground(Color.WHITE);
            screenPanel.add(label, BorderLayout.SOUTH);
            // ------------

            // implement
        // -------------

        setContentPane(screenPanel);

        pack();
        setVisible(true);

    }

}
