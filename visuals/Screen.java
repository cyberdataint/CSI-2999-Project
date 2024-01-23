package visuals;

import javax.swing.*;
import java.awt.*;

import visuals.border_panels.*;

public class Screen extends JFrame {

    public static int frameWidth = 1500;
    public static int frameHeight = 1250;

    // SCALING VARIABLES // NUMBERS MEAN SIZE FOR LARGE PRESET
    // MORE EASILY ACCESSIBLE AND LEGIBLE FOR OTHER CLASSES
    // 1-9
        public static int scaleVar5 = frameWidth / 300;
    // 10-19
        public static int scaleVar10 = frameWidth / 150;
        public static int scaleVar14 = (frameWidth * 7) / 750;
        public static int scaleVar15 = frameWidth / 100;
        public static int scaleVar18 = (frameWidth * 3) / 250;
    // 20-29
        public static int scaleVar20 = frameWidth / 75;
        public static int scaleVar24 = (frameWidth * 2) / 125;
        public static int scaleVar25 = frameWidth / 60;
    // 30-39
        public static int scaleVar30 = frameWidth / 50;
    // 50-59
        public static int scaleVar50 = frameWidth / 30;
        public static int scaleVar56 = (frameWidth * 14) / 375;
    // 100-199
        public static int scaleVar100 = frameWidth / 15;
        public static int scaleVar140 = (frameWidth * 7) / 75;
        public static int scaleVar150 = frameWidth / 10;
    // 200-299
        public static int scaleVar200 = (frameWidth * 2) / 15;
        public static int scaleVar250 = frameWidth / 6;
    // 300-399
        public static int scaleVar300 = frameWidth / 5;
        public static int scaleVar325 = (frameWidth * 13) / 60;
    // 400+
        public static int scaleVar500 = frameWidth / 3;
        public static int scaleVar800 = (frameWidth * 8) / 15;
    // ------------

    private static JPanel screenPanel;
    private static CenterPanel centerPanel;
    private static NorthPanel northPanel;
    private static SouthPanel southPanel;
    private static EastPanel eastPanel;
    private static WestPanel westPanel;

    public Screen() {

        // JFRAME SETTINGS
            setTitle("Offline Chess Simulator");
            Color backgroundColor = new Color(132, 136, 132);
            getContentPane().setBackground(backgroundColor);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setMinimumSize(new Dimension(frameWidth, frameHeight)); // 6:5 RATIO
            setResizable(false);

            screenPanel = new JPanel(new BorderLayout());
            screenPanel.setLayout(new BorderLayout(scaleVar25, scaleVar25));
            screenPanel.setBorder(BorderFactory.createEmptyBorder(scaleVar50, scaleVar50, scaleVar50, scaleVar50));
            screenPanel.setBackground(backgroundColor);
        // ------------

    
        // BORDER PANELS
            centerPanel = new CenterPanel();
            centerPanel.setPreferredSize(new Dimension(scaleVar500, scaleVar500));
            screenPanel.add(centerPanel, BorderLayout.CENTER);

            eastPanel = new EastPanel();
            eastPanel.setPreferredSize(new Dimension(scaleVar300, 50));
            screenPanel.add(eastPanel, BorderLayout.EAST);

            westPanel = new WestPanel();
            westPanel.setPreferredSize(new Dimension(scaleVar300, 50));
            screenPanel.add(westPanel, BorderLayout.WEST);

            northPanel = new NorthPanel();
            northPanel.setPreferredSize(new Dimension(50, scaleVar150));
            screenPanel.add(northPanel, BorderLayout.NORTH);

            southPanel = new SouthPanel();
            southPanel.setPreferredSize(new Dimension(50, scaleVar200));
            screenPanel.add(southPanel, BorderLayout.SOUTH);
        // -------------

        setContentPane(screenPanel);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }

    public static void changeFrameDimensions(int width, int height) {

        // setSize(width, height);
        // revalidate();
        // repaint();

    }

}
