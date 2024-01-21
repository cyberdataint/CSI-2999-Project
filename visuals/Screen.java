package visuals;

import javax.swing.*;
import java.awt.*;

import visuals.border_panels.*;

public class Screen extends JFrame {

    CenterPanel centerPanel;
    NorthPanel northPanel;
    SouthPanel southPanel;
    EastPanel eastPanel;
    WestPanel westPanel;

    public Screen() {

        // JFRAME SETTINGS
            setTitle("Offline Chess Simulator");
            Color backgroundColor = new Color(132, 136, 132); // SMOKE
            getContentPane().setBackground(backgroundColor);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setMinimumSize(new Dimension(1500, 1250)); // 6:5 RATIO
            setResizable(false);

            JPanel screenPanel = new JPanel(new BorderLayout());
            screenPanel.setLayout(new BorderLayout(25, 25)); // PANEL MARGINS
            screenPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50)); // FRAME MARGINS
            screenPanel.setBackground(backgroundColor);
        // ------------

    
        // BORDER PANELS
            centerPanel = new CenterPanel();
            centerPanel.setPreferredSize(new Dimension(500, 500));
            screenPanel.add(centerPanel, BorderLayout.CENTER);

            eastPanel = new EastPanel();
            eastPanel.setPreferredSize(new Dimension(300, 50));
            screenPanel.add(eastPanel, BorderLayout.EAST);

            westPanel = new WestPanel();
            westPanel.setPreferredSize(new Dimension(300, 50));
            screenPanel.add(westPanel, BorderLayout.WEST);

            northPanel = new NorthPanel();
            northPanel.setPreferredSize(new Dimension(50, 150));
            screenPanel.add(northPanel, BorderLayout.NORTH);

            southPanel = new SouthPanel();
            southPanel.setPreferredSize(new Dimension(50, 200));
            screenPanel.add(southPanel, BorderLayout.SOUTH);
        // -------------

        setContentPane(screenPanel);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }

}
