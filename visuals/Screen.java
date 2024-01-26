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

    public static void changeSize(boolean isToggled) {

        if (isToggled) { // make big

            screenShadowPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
                
            screenPanel.setLayout(new BorderLayout(25, 25));
            screenPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
            // screenPanel.setPreferredSize(new Dimension(1500, 1250));
            screenPanel.setSize(new Dimension(1500, 1250));

            centerPanel.changeSize(isToggled);
            eastPanel.changeSize(isToggled);
            westPanel.changeSize(isToggled);
            northPanel.changeSize(isToggled);
            southPanel.changeSize(isToggled);

        }
        else { // make small

            screenShadowPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
                
            screenPanel.setLayout(new BorderLayout(20, 20));
            screenPanel.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
            // screenPanel.setPreferredSize(new Dimension(1200, 1000));
            screenPanel.setSize(new Dimension(1200, 1000));

            centerPanel.changeSize(!isToggled);
            eastPanel.changeSize(!isToggled);
            westPanel.changeSize(!isToggled);
            northPanel.changeSize(!isToggled);
            southPanel.changeSize(!isToggled);

        }

    }

}
