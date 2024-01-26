package visuals;

import javax.swing.*;
import java.awt.*;

import visuals.border_panels.*;

public class Screen extends JFrame {

    // 6:5 RATIO

    private static JPanel screenPanel;
    private static CenterPanel centerPanel;
    private static NorthPanel northPanel;
    private static SouthPanel southPanel;
    private static EastPanel eastPanel;
    private static WestPanel westPanel;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color darkShadowColor = new Color(60, 70, 60);

    public Screen() {

        // JFRAME SETTINGS
            setTitle("Offline Chess Simulator");
            getContentPane().setBackground(backgroundColor);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            // setResizable(false);

            JPanel screenInsideShadowPanel = new JPanel(new BorderLayout());
            screenInsideShadowPanel.setBorder(BorderFactory.createEmptyBorder(10, 80, 10, 80));
            screenInsideShadowPanel.setBackground(shadowColor);

            JPanel screenOutsideShadowPanel = new JPanel(new BorderLayout());
            screenOutsideShadowPanel.setBorder(BorderFactory.createEmptyBorder(10, 90, 10, 90));
            screenOutsideShadowPanel.setBackground(darkShadowColor);

            screenPanel = new JPanel(new BorderLayout(25, 25));
            screenPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
            screenPanel.setBackground(backgroundColor);
            screenPanel.setSize(new Dimension(1500, 1250));
        // ------------

    
        // BORDER PANELS
            centerPanel = new CenterPanel();
            centerPanel.setSize(new Dimension(500, 500));
            screenPanel.add(centerPanel, BorderLayout.CENTER);

            eastPanel = new EastPanel();
            eastPanel.setPreferredSize(new Dimension(275, 50));
            screenPanel.add(eastPanel, BorderLayout.EAST);

            westPanel = new WestPanel();
            westPanel.setPreferredSize(new Dimension(275, 50));
            screenPanel.add(westPanel, BorderLayout.WEST);

            northPanel = new NorthPanel();
            northPanel.setSize(new Dimension(50, 150));
            screenPanel.add(northPanel, BorderLayout.NORTH);

            southPanel = new SouthPanel();
            southPanel.setSize(new Dimension(50, 150));
            screenPanel.add(southPanel, BorderLayout.SOUTH);
        // -------------

        screenInsideShadowPanel.add(screenPanel);
        screenOutsideShadowPanel.add(screenInsideShadowPanel);
        setContentPane(screenOutsideShadowPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

}
