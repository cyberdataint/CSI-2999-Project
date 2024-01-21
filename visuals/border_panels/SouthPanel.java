package visuals.border_panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SouthPanel extends JPanel {
    
    JPanel returnToMainMenuPanel;
    JPanel turnIndicatorPanel;
    JPanel endTurnPanel;

    JButton returnToMainMenuButton;
    JButton endTurnButton;

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
        endTurnPanel = new JPanel(); // EAST

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
            returnToMainMenuButton = new JButton("Return to Main Menu");
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
            JPanel whitePanel = new JPanel();
            whitePanel.setPreferredSize(new Dimension(325, 50));
            whitePanel.setBackground(lightShadowColor);

            // BLACK PANEL
            JPanel blackPanel = new JPanel();
            blackPanel.setPreferredSize(new Dimension(325, 50));
            blackPanel.setBackground(lightShadowColor);

            // .ADD CALLS
            turnIndicatorShadow.add(labelPanel, BorderLayout.NORTH);
            turnIndicatorShadow.add(whitePanel, BorderLayout.WEST);
            turnIndicatorShadow.add(blackPanel, BorderLayout.EAST);
            turnIndicatorPanel.add(turnIndicatorShadow);
            add(turnIndicatorPanel, BorderLayout.CENTER);
        // -------------

        // END TURN PANEL
            // END TURN PANEL SETTINGS
            endTurnPanel.setPreferredSize(new Dimension(300, 50));
            endTurnPanel.setBackground(shadowColor);

            endTurnPanel.setLayout(new BorderLayout());
            endTurnPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // END TURN SHADOW SETTINGS
            JPanel endTurnShadow = new JPanel();
            endTurnShadow.setBackground(darkShadowColor);
            endTurnShadow.setLayout(new BorderLayout());
            endTurnShadow.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            // END TURN BUTTON
            endTurnButton = new JButton("End Turn");
            endTurnButton.setBackground(lightShadowColor);
            endTurnButton.setForeground(textColor);
            endTurnButton.setBorderPainted(false);
            setTextFont(endTurnButton, "Roboto", Font.BOLD, 24);

            endTurnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    NorthPanel.restartTurnTimer();

                }
            });

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
