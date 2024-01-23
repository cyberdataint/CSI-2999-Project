package visuals.border_panels;

import javax.swing.*;
import java.awt.*;

import visuals.user_interface.*;

public class SouthPanel extends JPanel {
    
    private static JPanel returnToMainMenuPanel;
    private static JPanel turnIndicatorPanel;
    private static JPanel restartGameButtonPanel;

    public static JPanel whitePanelOne;
    public static JPanel whitePanelTwo;
    public static JPanel blackPanelOne;
    public static JPanel blackPanelTwo;

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
            returnToMainMenuButton.setFocusPainted(false);
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
            turnIndicatorShadow.setLayout(new GridLayout(3, 2, 15, 0));
            turnIndicatorShadow.setBorder(BorderFactory.createEmptyBorder(5, 15, 15, 15));

            // LABEL PANELS
            JLabel whiteLabel = new JLabel("White", SwingConstants.CENTER);
            whiteLabel.setForeground(textColor);
            setTextFont(whiteLabel, "Roboto", Font.BOLD, 24);

            JLabel blackLabel = new JLabel("Black", SwingConstants.CENTER);
            blackLabel.setForeground(textColor);
            setTextFont(blackLabel, "Roboto", Font.BOLD, 24);

            // WHITE PANEL
            whitePanelOne = new JPanel();
            whitePanelOne.setPreferredSize(new Dimension(350, 50));
            whitePanelOne.setBackground(lightShadowColor);

            whitePanelTwo = new JPanel();
            whitePanelTwo.setPreferredSize(new Dimension(350, 50));
            whitePanelTwo.setBackground(lightShadowColor);

            // implement gridlayout[2][8] holds pictures of claimed pieces

            // BLACK PANEL
            blackPanelOne = new JPanel();
            blackPanelOne.setPreferredSize(new Dimension(350, 50));
            blackPanelOne.setBackground(lightShadowColor);

            blackPanelTwo = new JPanel();
            blackPanelTwo.setPreferredSize(new Dimension(350, 50));
            blackPanelTwo.setBackground(lightShadowColor);

            // implement gridlayout[2][8] holds pictures of claimed pieces

            // .ADD CALLS
            turnIndicatorShadow.add(whiteLabel);
            turnIndicatorShadow.add(blackLabel);
            turnIndicatorShadow.add(whitePanelOne);
            turnIndicatorShadow.add(blackPanelOne);
            turnIndicatorShadow.add(whitePanelTwo);
            turnIndicatorShadow.add(blackPanelTwo);
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
            restartGameButton.setFocusPainted(false);
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
