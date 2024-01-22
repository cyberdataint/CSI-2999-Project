package visuals.border_panels;

import javax.swing.*;

import visuals.Screen;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NorthPanel extends JPanel {

    private static JPanel scorePanel;
    private static JPanel titlePanel;
    private static JPanel clockPanel;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color darkShadowColor = new Color(60, 70, 60);
    private static Color textColor = new Color(255, 240, 240);

    private static JLabel whiteScoreLabel;
    private static JLabel blackScoreLabel;
    private static JLabel gameClockLabel;

    private static int whiteScore = 0;
    private static int blackScore = 0;
    private static int gameSecondsElapsed = 0;

    public NorthPanel() {

        setBackground(backgroundColor);
        setLayout(new BorderLayout(Screen.scaleVar25, Screen.scaleVar25));

        scorePanel = new JPanel(); // WEST
        titlePanel = new JPanel(); // CENTER
        clockPanel = new JPanel(); // EAST

        // SCORE PANEL
            // SCORE PANEL SETTINGS
            scorePanel.setPreferredSize(new Dimension(Screen.scaleVar300, 50));
            scorePanel.setBackground(shadowColor);

            scorePanel.setLayout(new BorderLayout());
            scorePanel.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20));

            // SCORE SHADOW SETTINGS
            JPanel scoreShadow = new JPanel();
            scoreShadow.setBackground(darkShadowColor);
            scoreShadow.setLayout(new BorderLayout());
            scoreShadow.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20));

            // SCORE LABELS
            whiteScoreLabel = new JLabel("White Score: " + whiteScore, SwingConstants.CENTER);
            whiteScoreLabel.setForeground(textColor);
            setLabelFont(whiteScoreLabel, "Roboto", Font.BOLD, Screen.scaleVar24);

            blackScoreLabel = new JLabel("Black Score: " + blackScore, SwingConstants.CENTER);
            blackScoreLabel.setForeground(textColor);
            setLabelFont(blackScoreLabel, "Roboto", Font.BOLD, Screen.scaleVar24);

            // .ADD CALLS
            scoreShadow.add(whiteScoreLabel, BorderLayout.NORTH);
            scoreShadow.add(blackScoreLabel, BorderLayout.SOUTH);
            scorePanel.add(scoreShadow);
            add(scorePanel, BorderLayout.WEST);
        // -------------
            
        // TITLE PANEL
            // TITLE PANEL SETTINGS
            titlePanel.setPreferredSize(new Dimension(Screen.scaleVar800, 50));
            titlePanel.setBackground(shadowColor);

            titlePanel.setLayout(new BorderLayout());
            titlePanel.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar25, Screen.scaleVar25, Screen.scaleVar25, Screen.scaleVar25));

            // TITLE SHADOW SETTINGS
            JPanel titleShadow = new JPanel();
            titleShadow.setBackground(darkShadowColor);
            titleShadow.setLayout(new BorderLayout());
            titleShadow.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar5, Screen.scaleVar5, Screen.scaleVar5, Screen.scaleVar5));

            // TITLE LABEL
            JLabel title = new JLabel("Offline Chess Simulator", SwingConstants.CENTER);
            title.setForeground(textColor);
            setLabelFont(title, "Roboto", Font.BOLD, Screen.scaleVar56);
            
            // .ADD CALLS
            titleShadow.add(title);
            titlePanel.add(titleShadow);
            add(titlePanel, BorderLayout.CENTER);
        // -------------

        // CLOCK PANEL
            // CLOCK PANEL SETTINGS
            clockPanel.setPreferredSize(new Dimension(Screen.scaleVar300, 50));
            clockPanel.setBackground(shadowColor);

            clockPanel.setLayout(new BorderLayout());
            clockPanel.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20));

            // CLOCK SHADOW SETTINGS
            JPanel clockShadow = new JPanel();
            clockShadow.setBackground(darkShadowColor);
            clockShadow.setLayout(new GridLayout(2, 1));
            clockShadow.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20));

            // CLOCK LABELS
            gameClockLabel = new JLabel("Game Time:", SwingConstants.CENTER);
            gameClockLabel.setForeground(textColor);
            setLabelFont(gameClockLabel, "Roboto", Font.BOLD, Screen.scaleVar30);

            // GAME CLOCK
            JLabel gameClock = new JLabel("00:00:00", SwingConstants.CENTER);
            gameClock.setForeground(textColor);
            setLabelFont(gameClock, "Roboto", Font.BOLD, Screen.scaleVar30);

            Timer gameTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    gameSecondsElapsed++;
                    String formattedTime = formatTime(gameSecondsElapsed);
                    gameClock.setText(formattedTime);

                }
            });

            gameTimer.start();

            // .ADD CALLS
            clockShadow.add(gameClockLabel);
            clockShadow.add(gameClock);
            clockPanel.add(clockShadow);
            add(clockPanel, BorderLayout.EAST);
        // -------------

    }

    public static void updateScore(Boolean isWhite, int score) {

        if (isWhite) {
            whiteScoreLabel.setText("White Score: " + (whiteScore + score));
        }
        else {
            blackScoreLabel.setText("Black Score: " + (blackScore + score));
        }
        
    }

    private static String formatTime(int totalSeconds) {

        int hours = totalSeconds / 3600;
        int minutes = (totalSeconds % 3600) / 60;
        int seconds = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);

    }

    private static void setLabelFont(JLabel label, String fontFamily, int fontStyle, int fontSize) {

        Font newFont = new Font(fontFamily, fontStyle, fontSize);
        label.setFont(newFont);

    }
    
}