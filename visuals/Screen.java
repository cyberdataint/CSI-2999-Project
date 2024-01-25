package visuals;

import javax.swing.*;
import java.awt.*;

import visuals.border_panels.*;

public class Screen extends JFrame {

    // 6:5 RATIO

    private static JPanel screenPanel;
    private static JPanel screenShadowPanel;
    private static CenterPanel centerPanel;
    private static NorthPanel northPanel;
    private static SouthPanel southPanel;
    private static EastPanel eastPanel;
    private static WestPanel westPanel;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);

    public Screen() {

        // JFRAME SETTINGS
            setTitle("Offline Chess Simulator");
            getContentPane().setBackground(backgroundColor);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setResizable(false);

            screenShadowPanel = new JPanel(new BorderLayout());
            screenShadowPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            screenShadowPanel.setBackground(shadowColor);

            screenPanel = new JPanel(new BorderLayout(25, 25));
            screenPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            screenPanel.setBackground(backgroundColor);
            screenPanel.setSize(new Dimension(1500, 1250));
        // ------------

    
        // BORDER PANELS
            centerPanel = new CenterPanel();
            centerPanel.setSize(new Dimension(500, 500));
            screenPanel.add(centerPanel, BorderLayout.CENTER);

            eastPanel = new EastPanel();
            eastPanel.setSize(new Dimension(300, 50));
            screenPanel.add(eastPanel, BorderLayout.EAST);

            westPanel = new WestPanel();
            westPanel.setSize(new Dimension(300, 50));
            screenPanel.add(westPanel, BorderLayout.WEST);

            northPanel = new NorthPanel();
            northPanel.setSize(new Dimension(50, 150));
            screenPanel.add(northPanel, BorderLayout.NORTH);

            southPanel = new SouthPanel();
            southPanel.setSize(new Dimension(50, 200));
            screenPanel.add(southPanel, BorderLayout.SOUTH);
        // -------------

        screenShadowPanel.add(screenPanel, BorderLayout.CENTER);
        setContentPane(screenShadowPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

    public static void changeSize(boolean isToggled) {

        if (isToggled) { // make big

            // SCREEN
                screenShadowPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                
                screenPanel.setLayout(new BorderLayout(25, 25));
                screenPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
                screenPanel.setSize(new Dimension(1500, 1250));
            // ------

            // CALLS
                centerPanel.changeSize(isToggled);
                eastPanel.changeSize(isToggled);
                westPanel.changeSize(isToggled);
                northPanel.changeSize(isToggled);
                southPanel.changeSize(isToggled);
            // ------

        }
        else { // make small

            // make small (default)

        }

    }

}
