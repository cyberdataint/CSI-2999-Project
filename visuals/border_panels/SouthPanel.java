package visuals.border_panels;

import javax.swing.*;
import java.awt.*;

import visuals.user_interface.*;

public class SouthPanel extends JPanel {
    
    private static JPanel returnToMainMenuPanel;
    private static JPanel turnIndicatorPanel;
    private static JPanel restartGameButtonPanel;
    public static JPanel whitePanel;
    public static JPanel blackPanel;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color lightShadowColor = new Color(140, 170, 140);
    private static Color darkShadowColor = new Color(60, 70, 60);
    private static Color textColor = new Color(255, 240, 240);

    public SouthPanel() {

        setBackground(backgroundColor);
        setLayout(new BorderLayout(25, 25));

        returnToMainMenuPanel = new JPanel(); // WEST
        turnIndicatorPanel = new JPanel(); // CENTER
        restartGameButtonPanel = new JPanel(); // EAST

        // RETURN TO MAIN MENU PANEL
            // RTMM PANEL SETTINGS
            returnToMainMenuPanel.setPreferredSize(new Dimension(300, 50));
            returnToMainMenuPanel.setBackground(shadowColor);

            returnToMainMenuPanel.setLayout(new BorderLayout());
            returnToMainMenuPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // RTMM SHADOW SETTINGS
            JPanel returnToMainMenuShadow = new JPanel();
            returnToMainMenuShadow.setBackground(darkShadowColor);
            returnToMainMenuShadow.setLayout(new BorderLayout());
            returnToMainMenuShadow.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            // RTMM BUTTON
            ReturnToMainMenuButton returnToMainMenuButton = new ReturnToMainMenuButton("Return to Main Menu");
            returnToMainMenuButton.setBackground(lightShadowColor);
            returnToMainMenuButton.setForeground(textColor);
            returnToMainMenuButton.setBorderPainted(false);
            setTextFont(returnToMainMenuButton, "Roboto", Font.BOLD, 18);

            // .ADD CALLS
            returnToMainMenuShadow.add(returnToMainMenuButton);
            returnToMainMenuPanel.add(returnToMainMenuShadow);
            add(returnToMainMenuPanel, BorderLayout.WEST);
        // -------------

        // TURN INDICATOR PANEL
            // TURN INDICATOR PANEL SETTINGS
            turnIndicatorPanel.setPreferredSize(new Dimension(800, 50));
            turnIndicatorPanel.setBackground(shadowColor);

            turnIndicatorPanel.setLayout(new BorderLayout());
            turnIndicatorPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // TURN INDICATOR SHADOW SETTINGS
            JPanel turnIndicatorShadow = new JPanel();
            turnIndicatorShadow.setBackground(darkShadowColor);
            turnIndicatorShadow.setLayout(new BorderLayout());
            turnIndicatorShadow.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            // LABEL PANEL
            JPanel labelPanel = new JPanel();
            labelPanel.setPreferredSize(new Dimension(50, 25));
            labelPanel.setBackground(darkShadowColor);

                JLabel whiteLabel = new JLabel("White", SwingConstants.CENTER);
                whiteLabel.setForeground(textColor);
                setTextFont(whiteLabel, "Roboto", Font.BOLD, 14);

                JLabel blackLabel = new JLabel("Black", SwingConstants.CENTER);
                blackLabel.setForeground(textColor);
                setTextFont(blackLabel, "Roboto", Font.BOLD, 14);

            labelPanel.setLayout(new BorderLayout());
            labelPanel.setBorder(BorderFactory.createEmptyBorder(0, 140, 10, 140));
            labelPanel.add(whiteLabel, BorderLayout.WEST);
            labelPanel.add(blackLabel, BorderLayout.EAST);

            // WHITE PANEL
            whitePanel = new JPanel();
            whitePanel.setPreferredSize(new Dimension(325, 50));
            whitePanel.setBackground(lightShadowColor);

            // implement gridlayout[2][8] holds pictures of claimed pieces

            // BLACK PANEL
            blackPanel = new JPanel();
            blackPanel.setPreferredSize(new Dimension(325, 50));
            blackPanel.setBackground(lightShadowColor);

            // implement gridlayout[2][8] holds pictures of claimed pieces

            // .ADD CALLS
            turnIndicatorShadow.add(labelPanel, BorderLayout.NORTH);
            turnIndicatorShadow.add(whitePanel, BorderLayout.WEST);
            turnIndicatorShadow.add(blackPanel, BorderLayout.EAST);
            turnIndicatorPanel.add(turnIndicatorShadow);
            add(turnIndicatorPanel, BorderLayout.CENTER);
        // -------------

        // RESTART GAME BUTTON PANEL
            // RESTART GAME BUTTON PANEL SETTINGS
            restartGameButtonPanel.setPreferredSize(new Dimension(300, 50));
            restartGameButtonPanel.setBackground(shadowColor);

            restartGameButtonPanel.setLayout(new BorderLayout());
            restartGameButtonPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // RESTART GAME BUTTON SHADOW SETTINGS
            JPanel restartGameButtonShadow = new JPanel();
            restartGameButtonShadow.setBackground(darkShadowColor);
            restartGameButtonShadow.setLayout(new BorderLayout());
            restartGameButtonShadow.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            // RESTART GAME BUTTON
            RestartGameButton restartGameButton = new RestartGameButton("Restart Game");
            restartGameButton.setBackground(lightShadowColor);
            restartGameButton.setForeground(textColor);
            restartGameButton.setBorderPainted(false);
            setTextFont(restartGameButton, "Roboto", Font.BOLD, 24);

            // .ADD CALLS
            restartGameButtonShadow.add(restartGameButton);
            restartGameButtonPanel.add(restartGameButtonShadow);
            add(restartGameButtonPanel, BorderLayout.EAST);
        // -------------

    }

    private static void setTextFont(JLabel label, String fontFamily, int fontStyle, int fontSize) {

        Font newFont = new Font(fontFamily, fontStyle, fontSize);
        label.setFont(newFont);

    }

    private static void setTextFont(JButton button, String fontFamily, int fontStyle, int fontSize) {

        Font newFont = new Font(fontFamily, fontStyle, fontSize);
        button.setFont(newFont);

    }
    
}
