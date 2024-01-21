package visuals.border_panels;

import javax.swing.*;
import java.awt.*;

import visuals.user_interface.*;

public class NorthPanel extends JPanel {

    JPanel scorePanel;
    JPanel titlePanel;
    JPanel clockPanel;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color darkShadowColor = new Color(60, 70, 60);
    private static Color textColor = new Color(255, 240, 240);

    public NorthPanel() {

        setBackground(backgroundColor);
        setLayout(new BorderLayout(25, 25));

        scorePanel = new JPanel(); // WEST
        titlePanel = new JPanel(); // CENTER
        clockPanel = new JPanel(); // EAST

        // SCORE PANEL
            // SCORE PANEL SETTINGS
            scorePanel.setPreferredSize(new Dimension(300, 50));
            scorePanel.setBackground(shadowColor);

            scorePanel.setLayout(new BorderLayout());
            scorePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // SCORE SHADOW SETTINGS
            JPanel scoreShadow = new JPanel();
            scoreShadow.setBackground(darkShadowColor);
            scoreShadow.setLayout(new BorderLayout());
            scoreShadow.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // SCORE LABELS
            JLabel whiteScoreLabel = new JLabel("White Score: 0", SwingConstants.CENTER);
            whiteScoreLabel.setForeground(textColor);
            setLabelFont(whiteScoreLabel, "Roboto", Font.BOLD, 24);

            JLabel blackScoreLabel = new JLabel("Black Score: 0", SwingConstants.CENTER);
            blackScoreLabel.setForeground(textColor);
            setLabelFont(blackScoreLabel, "Roboto", Font.BOLD, 24);

            // implement

            // .ADD CALLS
            scoreShadow.add(whiteScoreLabel, BorderLayout.NORTH);
            scoreShadow.add(blackScoreLabel, BorderLayout.SOUTH);
            scorePanel.add(scoreShadow);
            add(scorePanel, BorderLayout.WEST);
        // -------------
            
        // TITLE PANEL
            // TITLE PANEL SETTINGS
            titlePanel.setPreferredSize(new Dimension(800, 50));
            titlePanel.setBackground(shadowColor);

            titlePanel.setLayout(new BorderLayout());
            titlePanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            // TITLE SHADOW SETTINGS
            JPanel titleShadow = new JPanel();
            titleShadow.setBackground(darkShadowColor);
            titleShadow.setLayout(new BorderLayout());
            titleShadow.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

            // TITLE LABEL
            JLabel title = new JLabel("Offline Chess Simulator", SwingConstants.CENTER);
            title.setForeground(textColor);
            setLabelFont(title, "Roboto", Font.BOLD, 56);
            
            // .ADD CALLS
            titleShadow.add(title);
            titlePanel.add(titleShadow);
            add(titlePanel, BorderLayout.CENTER);
        // -------------

        // CLOCK PANEL
            // CLOCK PANEL SETTINGS
            clockPanel.setPreferredSize(new Dimension(300, 50));
            clockPanel.setBackground(shadowColor);

            clockPanel.setLayout(new BorderLayout());
            clockPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // CLOCK SHADOW SETTINGS
            JPanel clockShadow = new JPanel();
            clockShadow.setBackground(darkShadowColor);
            clockShadow.setLayout(new BorderLayout());
            clockShadow.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // CLOCK LABELS
            JLabel gameClockLabel = new JLabel("Game Time: 00:00:00", SwingConstants.CENTER);
            gameClockLabel.setForeground(textColor);
            setLabelFont(gameClockLabel, "Roboto", Font.BOLD, 20);

            JLabel turnClockLabel = new JLabel("Turn Time: 00:00", SwingConstants.CENTER);
            turnClockLabel.setForeground(textColor);
            setLabelFont(turnClockLabel, "Roboto", Font.BOLD, 24);

            // implement

            // .ADD CALLS
            clockShadow.add(gameClockLabel, BorderLayout.NORTH);
            clockShadow.add(turnClockLabel, BorderLayout.SOUTH);
            clockPanel.add(clockShadow);
            add(clockPanel, BorderLayout.EAST);
        // -------------

    }

    public static void updateScore(Boolean isWhite, int score) {

        //
        
    }

    private static void setLabelFont(JLabel label, String fontFamily, int fontStyle, int fontSize) {

        Font newFont = new Font(fontFamily, fontStyle, fontSize);
        label.setFont(newFont);

    }
    
}