package visuals;

import javax.swing.*;
import java.awt.*;

import visuals.border_panels.*;

public class Screen extends JFrame {

    public static int frameWidth = 1500;
    public static int frameHeight = 1200;

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
            setMinimumSize(new Dimension(6, 5)); // 6:5 RATIO

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            GraphicsDevice gd = ge.getDefaultScreenDevice();
            Rectangle monitorBounds = gd.getDefaultConfiguration().getBounds();
            int monitorVerticalMargins = ((int) monitorBounds.getHeight() - frameHeight) / 2;
            int monitorHorizontalMargins = ((int) monitorBounds.getWidth() - frameWidth) / 2;

            screenShadowPanel = new JPanel(new BorderLayout());
            screenShadowPanel.setBorder(BorderFactory.createEmptyBorder(monitorVerticalMargins-50, monitorHorizontalMargins, monitorVerticalMargins-25, monitorHorizontalMargins));
            screenShadowPanel.setBackground(shadowColor);

            screenPanel = new JPanel(new BorderLayout(25, 25));
            screenPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));
            screenPanel.setBackground(backgroundColor);
            screenPanel.setPreferredSize(new Dimension(1500, 1200));
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

        screenShadowPanel.add(screenPanel, BorderLayout.CENTER);
        setContentPane(screenShadowPanel);
        pack();
        setVisible(true);
        setLocationRelativeTo(null);

    }

}
