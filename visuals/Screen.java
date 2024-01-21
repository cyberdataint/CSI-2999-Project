package visuals;

import javax.swing.*;
import java.awt.*;

import visuals.border_panels.*;

public class Screen extends JFrame {

    CenterPanel centerPanel;
    NorthPanel northPanel;

    public Screen() {

        // JFRAME SETTINGS
            setTitle("Offline Chess Simulator");
            Color backgroundColor = new Color(132, 136, 132); // SMOKE
            getContentPane().setBackground(backgroundColor);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            // SETS 6:5 RATIO
            setMinimumSize(new Dimension(1500, 1250));
            // possibly implement a way to maintain above ratio

            // MARGINS // DON'T FORGET!! ACCOUNT FOR MARGIN!!
            JPanel screenPanel = new JPanel(new BorderLayout());
            screenPanel.setLayout(new BorderLayout(25, 25)); // PANEL MARGINS
            screenPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // FRAME MARGINS
            screenPanel.setBackground(backgroundColor);
        // ------------

    
        // CENTER PANELS
            centerPanel = new CenterPanel();
            centerPanel.setPreferredSize(new Dimension(500, 500));
            screenPanel.add(centerPanel, BorderLayout.CENTER);
        // -------------

        // EAST PANELS
            // PLACE HOLDER
            JLabel labelEast = new JLabel("test", SwingConstants.CENTER);
            labelEast.setPreferredSize(new Dimension(300, 50)); // ONLY NEED TO MODIFY WIDTH
            labelEast.setOpaque(true);
            labelEast.setBackground(Color.WHITE);
            screenPanel.add(labelEast, BorderLayout.EAST);
            // ------------

            // implement later (EastPanel.java)
        // -------------

        // WEST PANELS
            // PLACE HOLDER
            JLabel labelWest = new JLabel("test", SwingConstants.CENTER);
            labelWest.setPreferredSize(new Dimension(300, 50)); // ONLY NEED TO MODIFY WIDTH
            labelWest.setOpaque(true);
            labelWest.setBackground(Color.WHITE);
            screenPanel.add(labelWest, BorderLayout.WEST);
            // ------------

            // implement later (WestPanel.java)
        // -------------

        // NORTH PANELS
            northPanel = new NorthPanel();
            northPanel.setPreferredSize(new Dimension(50, 150));
            screenPanel.add(northPanel, BorderLayout.NORTH);
        // -------------

        // SOUTH PANELS
            // PLACE HOLDER
            JLabel labelSouth = new JLabel("test", SwingConstants.CENTER);
            labelSouth.setPreferredSize(new Dimension(50, 200)); // ONLY NEED TO MODIFY HEIGHT
            labelSouth.setOpaque(true);
            labelSouth.setBackground(Color.WHITE);
            screenPanel.add(labelSouth, BorderLayout.SOUTH);
            // ------------

            // implement later (SouthPanel.java)
        // -------------

        setContentPane(screenPanel);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }

}
