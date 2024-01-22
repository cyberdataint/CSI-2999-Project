package visuals.border_panels;

import javax.swing.*;
import java.awt.*;

import visuals.Screen;
import visuals.user_interface.*;

public class SouthPanel extends JPanel {
    
    private static JPanel returnToMainMenuPanel;
    private static JPanel turnIndicatorPanel;
    private static JPanel endTurnPanel;
    public static JPanel whitePanel;
    public static JPanel blackPanel;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color lightShadowColor = new Color(140, 170, 140);
    private static Color lightColor = new Color(220, 250, 220);
    private static Color darkShadowColor = new Color(60, 70, 60);
    private static Color textColor = new Color(255, 240, 240);

    public SouthPanel() {

        setBackground(backgroundColor);
        setLayout(new BorderLayout(Screen.scaleVar25, Screen.scaleVar25));

        returnToMainMenuPanel = new JPanel(); // WEST
        turnIndicatorPanel = new JPanel(); // CENTER
        endTurnPanel = new JPanel(); // EAST

        // RETURN TO MAIN MENU PANEL
            // RTMM PANEL SETTINGS
            returnToMainMenuPanel.setPreferredSize(new Dimension(Screen.scaleVar300, 50));
            returnToMainMenuPanel.setBackground(shadowColor);

            returnToMainMenuPanel.setLayout(new BorderLayout());
            returnToMainMenuPanel.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20));

            // RTMM SHADOW SETTINGS
            JPanel returnToMainMenuShadow = new JPanel();
            returnToMainMenuShadow.setBackground(darkShadowColor);
            returnToMainMenuShadow.setLayout(new BorderLayout());
            returnToMainMenuShadow.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar15, Screen.scaleVar15, Screen.scaleVar15, Screen.scaleVar15));

            // RTMM BUTTON
            ReturnToMainMenuButton returnToMainMenuButton = new ReturnToMainMenuButton("Return to Main Menu");
            returnToMainMenuButton.setBackground(lightShadowColor);
            returnToMainMenuButton.setForeground(textColor);
            returnToMainMenuButton.setBorderPainted(false);
            setTextFont(returnToMainMenuButton, "Roboto", Font.BOLD, Screen.scaleVar18);

            // .ADD CALLS
            returnToMainMenuShadow.add(returnToMainMenuButton);
            returnToMainMenuPanel.add(returnToMainMenuShadow);
            add(returnToMainMenuPanel, BorderLayout.WEST);
        // -------------

        // TURN INDICATOR PANEL
            // TURN INDICATOR PANEL SETTINGS
            turnIndicatorPanel.setPreferredSize(new Dimension(Screen.scaleVar800, 50));
            turnIndicatorPanel.setBackground(shadowColor);

            turnIndicatorPanel.setLayout(new BorderLayout());
            turnIndicatorPanel.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20));

            // TURN INDICATOR SHADOW SETTINGS
            JPanel turnIndicatorShadow = new JPanel();
            turnIndicatorShadow.setBackground(darkShadowColor);
            turnIndicatorShadow.setLayout(new BorderLayout());
            turnIndicatorShadow.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar15, Screen.scaleVar15, Screen.scaleVar15, Screen.scaleVar15));

            // LABEL PANEL
            JPanel labelPanel = new JPanel();
            labelPanel.setPreferredSize(new Dimension(50, Screen.scaleVar25));
            labelPanel.setBackground(darkShadowColor);

                JLabel whiteLabel = new JLabel("White", SwingConstants.CENTER);
                whiteLabel.setForeground(textColor);
                setTextFont(whiteLabel, "Roboto", Font.BOLD, Screen.scaleVar14);

                JLabel blackLabel = new JLabel("Black", SwingConstants.CENTER);
                blackLabel.setForeground(textColor);
                setTextFont(blackLabel, "Roboto", Font.BOLD, Screen.scaleVar14);

            labelPanel.setLayout(new BorderLayout());
            labelPanel.setBorder(BorderFactory.createEmptyBorder(0, Screen.scaleVar140, Screen.scaleVar10, Screen.scaleVar140));
            labelPanel.add(whiteLabel, BorderLayout.WEST);
            labelPanel.add(blackLabel, BorderLayout.EAST);

            // WHITE PANEL
            whitePanel = new JPanel();
            whitePanel.setPreferredSize(new Dimension(Screen.scaleVar325, 50));

            // implement gridlayout[2][8] holds pictures of claimed pieces

            // BLACK PANEL
            blackPanel = new JPanel();
            blackPanel.setPreferredSize(new Dimension(Screen.scaleVar325, 50));
            blackPanel.setBackground(lightShadowColor);

            // implement gridlayout[2][8] holds pictures of claimed pieces

            // .ADD CALLS
            turnIndicatorShadow.add(labelPanel, BorderLayout.NORTH);
            turnIndicatorShadow.add(whitePanel, BorderLayout.WEST);
            turnIndicatorShadow.add(blackPanel, BorderLayout.EAST);
            turnIndicatorPanel.add(turnIndicatorShadow);
            add(turnIndicatorPanel, BorderLayout.CENTER);
        // -------------

        // END TURN PANEL
            // END TURN PANEL SETTINGS
            endTurnPanel.setPreferredSize(new Dimension(Screen.scaleVar300, 50));
            endTurnPanel.setBackground(shadowColor);

            endTurnPanel.setLayout(new BorderLayout());
            endTurnPanel.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20));

            // END TURN SHADOW SETTINGS
            JPanel endTurnShadow = new JPanel();
            endTurnShadow.setBackground(darkShadowColor);
            endTurnShadow.setLayout(new BorderLayout());
            endTurnShadow.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar15, Screen.scaleVar15, Screen.scaleVar15, Screen.scaleVar15));

            // END TURN BUTTON
            EndTurnButton endTurnButton = new EndTurnButton("End Turn");
            endTurnButton.setBackground(lightShadowColor);
            endTurnButton.setForeground(textColor);
            endTurnButton.setBorderPainted(false);
            setTextFont(endTurnButton, "Roboto", Font.BOLD, Screen.scaleVar24);

            // .ADD CALLS
            endTurnShadow.add(endTurnButton);
            endTurnPanel.add(endTurnShadow);
            add(endTurnPanel, BorderLayout.EAST);
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
