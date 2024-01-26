package visuals.border_panels;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NorthPanel extends JPanel {

    private static JPanel scorePanel;
    private static JPanel titlePanel;
    private static JPanel clockPanel;
    private static JPanel scoreShadow;
    private static JPanel titleShadow;
    private static JPanel clockShadow;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color darkShadowColor = new Color(60, 70, 60);
    private static Color textColor = new Color(255, 240, 240);

    private static JLabel whiteScoreLabel;
    private static JLabel blackScoreLabel;
    public static JLabel gameClockLabel;
    public static JLabel gameClock;

    public static int whiteScore = 0;
    public static int blackScore = 0;
    public static int gameSecondsElapsed = 0;

    public static Timer gameTimer;

    public NorthPanel() {

        setBackground(backgroundColor);
        setLayout(new BorderLayout(25, 25));

        scorePanel = new JPanel(); // WEST
        titlePanel = new JPanel(); // CENTER
        clockPanel = new JPanel(); // EAST

        // SCORE PANEL
            // SCORE PANEL SETTINGS
            scorePanel.setSize(new Dimension(300, 50));
            scorePanel.setBackground(shadowColor);

            scorePanel.setLayout(new BorderLayout());
            scorePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // SCORE SHADOW SETTINGS
            scoreShadow = new JPanel();
            scoreShadow.setBackground(darkShadowColor);

            scoreShadow.setLayout(new GridLayout(2, 1));
            scoreShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // SCORE LABELS
            whiteScoreLabel = new JLabel("White Score: " + whiteScore, SwingConstants.CENTER);
            whiteScoreLabel.setForeground(textColor);
            setLabelFont(whiteScoreLabel, "Roboto", Font.BOLD, 20);

            blackScoreLabel = new JLabel("Black Score: " + blackScore, SwingConstants.CENTER);
            blackScoreLabel.setForeground(textColor);
            setLabelFont(blackScoreLabel, "Roboto", Font.BOLD, 20);

            // .ADD CALLS
            scoreShadow.add(whiteScoreLabel);
            scoreShadow.add(blackScoreLabel);
            scorePanel.add(scoreShadow);
            add(scorePanel, BorderLayout.WEST);
        // -------------
            
        // TITLE PANEL
            // TITLE PANEL SETTINGS
            titlePanel.setSize(new Dimension(800, 50));
            titlePanel.setBackground(shadowColor);

            titlePanel.setLayout(new BorderLayout());
            titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // TITLE SHADOW SETTINGS
            titleShadow = new JPanel();
            titleShadow.setBackground(darkShadowColor);
            titleShadow.setLayout(new BorderLayout());
            titleShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // TITLE LABEL
            JLabel title = new JLabel("Offline Chess Simulator", SwingConstants.CENTER);
            title.setForeground(textColor);
            setLabelFont(title, "Roboto", Font.BOLD, 42);
            
            // .ADD CALLS
            titleShadow.add(title);
            titlePanel.add(titleShadow);
            add(titlePanel, BorderLayout.CENTER);
        // -------------

        // CLOCK PANEL
            // CLOCK PANEL SETTINGS
            clockPanel.setSize(new Dimension(300, 50));
            clockPanel.setBackground(shadowColor);

            clockPanel.setLayout(new BorderLayout());
            clockPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            // CLOCK SHADOW SETTINGS
            clockShadow = new JPanel();
            clockShadow.setBackground(darkShadowColor);
            clockShadow.setLayout(new GridLayout(2, 1));
            clockShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // CLOCK LABELS
            gameClockLabel = new JLabel("Game Time:", SwingConstants.CENTER);
            gameClockLabel.setForeground(textColor);
            setLabelFont(gameClockLabel, "Roboto", Font.BOLD, 20);

            // GAME CLOCK
            gameClock = new JLabel("00:00:00", SwingConstants.CENTER);
            gameClock.setForeground(textColor);
            setLabelFont(gameClock, "Roboto", Font.BOLD, 20);

            gameTimer = new Timer(1000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    gameSecondsElapsed++;
                    String formattedTime = formatTime(gameSecondsElapsed);
                    gameClock.setText(formattedTime);

                }
            });

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

    public void changeSize(boolean isToggled) {

        if (isToggled) {

            setLayout(new BorderLayout(25, 25));

            // scorePanel.setPreferredSize(new Dimension(300, 50));
            scorePanel.setSize(new Dimension(300, 50));
            scorePanel.setLayout(new BorderLayout());
            scorePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            scoreShadow.setLayout(new BorderLayout());
            scoreShadow.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
            
            titlePanel.setLayout(new BorderLayout());
            titlePanel.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

            titleShadow.setLayout(new BorderLayout());
            titleShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // clockPanel.setPreferredSize(new Dimension(300, 50));
            clockPanel.setSize(new Dimension(300, 50));
            clockPanel.setLayout(new BorderLayout());
            clockPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            clockShadow.setLayout(new GridLayout(2, 1));
            clockShadow.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        }
        else {

            setLayout(new BorderLayout(20, 20));

            // scorePanel.setPreferredSize(new Dimension(240, 40));
            scorePanel.setSize(new Dimension(240, 40));
            scorePanel.setLayout(new BorderLayout());
            scorePanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

            scoreShadow.setLayout(new BorderLayout());
            scoreShadow.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));
            
            titlePanel.setLayout(new BorderLayout());
            titlePanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            titleShadow.setLayout(new BorderLayout());
            titleShadow.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

            // clockPanel.setPreferredSize(new Dimension(240, 40));
            clockPanel.setSize(new Dimension(240, 40));
            clockPanel.setLayout(new BorderLayout());
            clockPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

            clockShadow.setLayout(new GridLayout(2, 1));
            clockShadow.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

        }

    }
    
}