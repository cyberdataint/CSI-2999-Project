package visuals.border_panels;

import javax.swing.*;

import visuals.Screen;
import visuals.user_interface.GameLog;

import java.awt.*;

public class WestPanel extends JPanel {
    
    private static JPanel gameLogPanel;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color lightShadowColor = new Color(140, 170, 140);
    private static Color lightColor = new Color(220, 250, 220);
    private static Color darkShadowColor = new Color(60, 70, 60);

    public WestPanel() {

        setBackground(backgroundColor);
        setLayout(new BorderLayout(25, 25));

        gameLogPanel = new JPanel();

        // WEST PANEL
            // WEST PANEL SETTINGS
            gameLogPanel.setPreferredSize(new Dimension(300, 50));
            gameLogPanel.setBackground(shadowColor);

            gameLogPanel.setLayout(new BorderLayout());
            gameLogPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // WEST SHADOW SETTINGS
            JPanel gameLogShadow = new JPanel();
            gameLogShadow.setBackground(darkShadowColor);
            gameLogShadow.setLayout(new BorderLayout());
            gameLogShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // LIGHT SHADOW SETTINGS
            JPanel lightShadow = new JPanel();
            lightShadow.setBackground(lightShadowColor);
            lightShadow.setLayout(new BorderLayout());
            lightShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // GAME LOG PANEL
                // GAME LOG PANEL SETTINGS
                GameLog gameLog = new GameLog();
                gameLog.setBackground(lightColor);

                // .ADD CALL
                lightShadow.add(gameLog);
            // -------------

            // .ADD CALLS
            gameLogShadow.add(lightShadow);
            gameLogPanel.add(gameLogShadow);
            add(gameLogPanel);
        // -------------

    }

}
