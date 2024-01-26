package visuals.border_panels;

import javax.swing.*;
import java.awt.*;

import visuals.user_interface.GameLog;

public class WestPanel extends JPanel {
    
    private static JPanel gameLogPanel;
    private static JPanel gameLogShadow;
    private static JPanel lightShadow;

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
            gameLogPanel.setPreferredSize(new Dimension(300, 500));
            gameLogPanel.setBackground(shadowColor);

            gameLogPanel.setLayout(new BorderLayout());
            gameLogPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            // WEST SHADOW SETTINGS
            gameLogShadow = new JPanel();
            gameLogShadow.setBackground(darkShadowColor);
            gameLogShadow.setLayout(new BorderLayout());
            gameLogShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // LIGHT SHADOW SETTINGS
            lightShadow = new JPanel();
            lightShadow.setBackground(lightShadowColor);
            lightShadow.setLayout(new BorderLayout());
            lightShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // GAME LOG PANEL
                // GAME LOG PANEL SETTINGS
                GameLog gameLog = new GameLog();
                gameLog.setBackground(lightColor);

                // .ADD CALL
                lightShadow.add(gameLog, BorderLayout.CENTER);
            // -------------

            // .ADD CALLS
            gameLogShadow.add(lightShadow);
            gameLogPanel.add(gameLogShadow);
            add(gameLogPanel);
        // -------------

    }

    public void changeSize(boolean isToggled) {

        if (isToggled) {

            setLayout(new BorderLayout(20, 20));

            // gameLogPanel.setPreferredSize(new Dimension(240, 400));
            gameLogPanel.setSize(new Dimension(240, 400));
            gameLogPanel.setLayout(new BorderLayout());
            gameLogPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

            gameLogShadow.setLayout(new BorderLayout());
            gameLogShadow.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

            lightShadow.setLayout(new BorderLayout());
            lightShadow.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

            GameLog.changeSize(isToggled);

        }
        else {

            setLayout(new BorderLayout(16, 16));

            // gameLogPanel.setPreferredSize(new Dimension(192, 320));
            gameLogPanel.setSize(new Dimension(192, 320));
            gameLogPanel.setLayout(new BorderLayout());
            gameLogPanel.setBorder(BorderFactory.createEmptyBorder(12, 12, 12, 12));

            gameLogShadow.setLayout(new BorderLayout());
            gameLogShadow.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

            lightShadow.setLayout(new BorderLayout());
            lightShadow.setBorder(BorderFactory.createEmptyBorder(6, 6, 6, 6));

            GameLog.changeSize(!isToggled);

        }

    }

}
