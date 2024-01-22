package visuals;

import javax.swing.*;
import java.awt.*;

import visuals.border_panels.*;

public class Screen extends JFrame {

    public static int frameWidth = 1500;
    public static int frameHeight = 1250;

    // SCALING VARIABLES
    // MORE EASILY ACCESSIBLE AND LEGIBLE FOR OTHER CLASSES
    public static int scaleVar10 = frameWidth / 150;
    public static int scaleVar15 = frameWidth / 100;
    public static int scaleVar20 = frameWidth / 75;
    public static int scaleVar25 = frameWidth / 60;
    public static int scaleVar50 = frameWidth / 30;
    public static int scaleVar100 = frameWidth / 15;
    public static int scaleVar150 = frameWidth / 10;
    public static int scaleVar200 = (frameWidth * 2) / 15;
    public static int scaleVar250 = frameWidth / 6;
    public static int scaleVar300 = frameWidth / 5;

    private static JPanel screenPanel;
    private static CenterPanel centerPanel;
    private static NorthPanel northPanel;
    private static SouthPanel southPanel;
    private static EastPanel eastPanel;
    private static WestPanel westPanel;

    private static Object[] jpanels;

    public Screen() {

        // JFRAME SETTINGS
            setTitle("Offline Chess Simulator");
            Color backgroundColor = new Color(132, 136, 132); // SMOKE
            getContentPane().setBackground(backgroundColor);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setMinimumSize(new Dimension(frameWidth, frameHeight)); // 6:5 RATIO
            setResizable(false);

            screenPanel = new JPanel(new BorderLayout());
            screenPanel.setLayout(new BorderLayout(scaleVar25, scaleVar25)); // LARGE: 25
            screenPanel.setBorder(BorderFactory.createEmptyBorder(scaleVar50, scaleVar50, (frameHeight/25), (frameWidth/30))); // LARGE: 50
            screenPanel.setBackground(backgroundColor);
        // ------------

    
        // BORDER PANELS
            centerPanel = new CenterPanel();
            centerPanel.setPreferredSize(new Dimension((frameWidth/3), ((frameHeight*2)/5))); // LARGE: 500 x 500
            screenPanel.add(centerPanel, BorderLayout.CENTER);

            eastPanel = new EastPanel();
            eastPanel.setPreferredSize(new Dimension((frameWidth/5), 50)); // LARGE: 300
            screenPanel.add(eastPanel, BorderLayout.EAST);

            westPanel = new WestPanel();
            westPanel.setPreferredSize(new Dimension((frameWidth/5), 50)); // LARGE: 300
            screenPanel.add(westPanel, BorderLayout.WEST);

            northPanel = new NorthPanel();
            northPanel.setPreferredSize(new Dimension(50, ((frameHeight*3)/25))); // LARGE: 150
            screenPanel.add(northPanel, BorderLayout.NORTH);

            southPanel = new SouthPanel();
            southPanel.setPreferredSize(new Dimension(50, ((frameHeight*4)/25))); // LARGE: 200
            screenPanel.add(southPanel, BorderLayout.SOUTH);
        // -------------

        jpanels = new Object[] { screenPanel, northPanel, southPanel, westPanel, eastPanel, centerPanel };

        setContentPane(screenPanel);

        setLocationRelativeTo(null);
        pack();
        setVisible(true);

    }

    public static void changeFrameDimensions(int width, int height) {

        frameWidth = width;
        frameHeight = height;

        for (Object obj : jpanels) {

            ((Component) obj).revalidate();
            ((Component) obj).repaint();

        }

    }

}
