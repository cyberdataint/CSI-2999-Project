import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;


public class HomePage extends JFrame {

    // Color schemes for different themes
    private static final Map<String, ColorScheme> colorSchemes = new HashMap<>();

    static {
        // Define color schemes with button color, button text color, title color, and background color
        colorSchemes.put("Midnight", new ColorScheme(new Color(44, 62, 80), Color.BLUE, Color.blue, new Color(52, 73, 94)));
        colorSchemes.put("Ruby Red", new ColorScheme(new Color(155, 17, 30), Color.BLACK, new Color(123, 13, 23), new Color(192, 57, 43)));
        colorSchemes.put("Sapphire", new ColorScheme(new Color(15, 66, 137), Color.WHITE, new Color(12, 52, 131), new Color(25, 181, 254)));
        colorSchemes.put("Lime Twist", new ColorScheme(new Color(205, 220, 57), Color.BLACK, new Color(140, 160, 40), new Color(243, 156, 18)));
        colorSchemes.put("Default", new ColorScheme(Color.GRAY, Color.BLACK, new Color(128, 128, 128), Color.darkGray));
    }

    // GUI components
    private JLabel titleLabel;
    private JPanel mainPanel;

    // Inner class to represent a color scheme
    private static class ColorScheme {
        private Color buttonColor;
        private Color buttonTextColor;
        private Color titleColor;
        private Color backgroundColor;

        public ColorScheme(Color buttonColor, Color buttonTextColor, Color titleColor, Color backgroundColor) {
            this.buttonColor = buttonColor;
            this.buttonTextColor = buttonTextColor;
            this.titleColor = titleColor;
            this.backgroundColor = backgroundColor;
        }

        public Color getButtonColor() {
            return buttonColor;
        }

        public Color getButtonTextColor() {
            return buttonTextColor;
        }

        public Color getTitleColor() {
            return titleColor;
        }

        public Color getBackgroundColor() {
            return backgroundColor;
        }
    }

    // ActionListener for color scheme changes
    private class ColorSchemeActionListener implements ActionListener {
        private String scheme;

        public ColorSchemeActionListener(String scheme) {
            this.scheme = scheme;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            setColors(colorSchemes.get(scheme));
        }
    }

    // ActionListener for game button clicks
private class GameButtonActionListener implements ActionListener {
    private String fileName;
    private Process runningProcess; // To keep track of the running process

    public GameButtonActionListener(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (runningProcess == null || !runningProcess.isAlive()) {
            // Execute the selected game in a separate thread
            new Thread(() -> {
                try {
                    ProcessBuilder pb = new ProcessBuilder("java", "-cp", ".", fileName);
                    pb.directory(new java.io.File("."));
                    runningProcess = pb.start();

                    int exitCode = runningProcess.waitFor();

                    SwingUtilities.invokeLater(() -> {
                        if (exitCode != 0) {
                            // Handle error if needed
                            String errorMsg = getErrorMessage(runningProcess);
                            JOptionPane.showMessageDialog(
                                    HomePage.this,
                                    "Failed to execute the game. Error: " + errorMsg,
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE
                            );
                        }
                        // setState(Frame.NORMAL);
                    });
                } catch (IOException | InterruptedException ex) {
                    ex.printStackTrace();
                    SwingUtilities.invokeLater(() -> {
                        JOptionPane.showMessageDialog(
                                HomePage.this,
                                "Failed to execute the game. Exception: " + ex.getMessage(),
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    });
                }
            }).start();
        } else {
            JOptionPane.showMessageDialog(
                    HomePage.this,
                    "The game is already running.",
                    "Warning",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private String getErrorMessage(Process process) {
        try (java.util.Scanner scanner = new java.util.Scanner(process.getErrorStream()).useDelimiter("\\A")) {
            return scanner.hasNext() ? scanner.next() : "";
        }
    }
}

// ActionListener for instructions menu item
private class InstructionsActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        displayHelpPage("<html><b>Instructions:</b><br><br>"
                + "1. Click on the 'Chess', 'Game 2', or 'Game 3' to launch the respective games.<br>");
    }
}

// ActionListener for about menu item
private class AboutActionListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        displayHelpPage("<html><b>CSI 2999 Project</b><br><br>"
                + "This project showcases a simple game launcher with three games.<br>"
                + "Developed for CSI 2999 course.</html>");
    }
}

    public HomePage() {
        setTitle("CSI 2999 Project");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame to start in a maximized state
        setExtendedState(JFrame.MAXIMIZED_BOTH);

        // Create a title with a centered and styled font
        titleLabel = new JLabel("CSI 2999 Project", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 48));

        // Create colorful buttons for each game
        JButton game1Button = createGameButton("Chess", "visuals\\Driver.java");
        JButton game2Button = createGameButton("Game 2", "Game2.java");
        JButton game3Button = createGameButton("Game 3", "Game3.java");

        // Add buttons to the main panel with spacing
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(4, 1, 20, 20));
        mainPanel.add(titleLabel);
        mainPanel.add(game1Button);
        mainPanel.add(game2Button);
        mainPanel.add(game3Button);

        // Create a Help menu with dropdown options
        JMenuBar menuBar = new JMenuBar();
        JMenu helpMenu = new JMenu("Help");
        JMenu colorSchemeMenu = new JMenu("Color Scheme");

        // Add color scheme options to the menu
        addColorSchemeMenuItems(colorSchemeMenu);

        // Create menu items for instructions and about
        JMenuItem instructionsItem = new JMenuItem("Instructions");
        JMenuItem aboutItem = new JMenuItem("About");

        // Add menu items to the Help menu
        helpMenu.add(instructionsItem);
        helpMenu.add(aboutItem);

        // Add menus to the menu bar
        menuBar.add(helpMenu);
        menuBar.add(colorSchemeMenu);

        // Add listeners for menu items
        addHelpMenuListeners(instructionsItem, aboutItem);

        // Set the menu bar for the frame
        menuBar.add(Box.createHorizontalGlue()); // Add space to the right
        setJMenuBar(menuBar);

        // Add the main panel to the frame with additional spacing
        add(mainPanel, BorderLayout.CENTER);

        // Center the frame on the screen
        setLocationRelativeTo(null);

        // Set the initial color scheme
        setColors(colorSchemes.get("Default"));

        // Make the frame visible
        setVisible(true);
    }

    // Create a game button with specified text and file name
    private JButton createGameButton(String buttonText, final String fileName) {
        JButton button = new JButton(buttonText);
        button.setFont(new Font("Arial", Font.BOLD, 28));

        // Set the background and text color based on the default color scheme
        button.setBackground(colorSchemes.get("Default").getButtonColor());
        button.setForeground(colorSchemes.get("Default").getButtonTextColor());

        // Add an ActionListener to the button for handling clicks
        button.addActionListener(new GameButtonActionListener(fileName));

        // Ensure that the background color is set
        button.setOpaque(true);
        button.setBorderPainted(false);

        return button;
    }

    // Add color scheme options to the specified menu
    private void addColorSchemeMenuItems(JMenu colorSchemeMenu) {
        for (String scheme : colorSchemes.keySet()) {
            JMenuItem schemeItem = new JMenuItem(scheme);
            colorSchemeMenu.add(schemeItem);

            // Add ActionListener to the color scheme menu items
            schemeItem.addActionListener(new ColorSchemeActionListener(scheme));
        }
    }

    // Add ActionListener to help menu items
    private void addHelpMenuListeners(JMenuItem instructionsItem, JMenuItem aboutItem) {
        instructionsItem.addActionListener(new InstructionsActionListener());
        aboutItem.addActionListener(new AboutActionListener());
    }

    // Display a help page with the specified content
    private void displayHelpPage(String content) {
        JOptionPane.showMessageDialog(this, content, "Help", JOptionPane.INFORMATION_MESSAGE);
    }

    // Update the color scheme for the GUI components
    private void setColors(ColorScheme colorScheme) {
        // Update the color scheme for title, buttons, background, and title panel
        titleLabel.setForeground(colorScheme.getTitleColor());
        mainPanel.setBackground(colorScheme.getBackgroundColor());

        // Update color scheme for each button in the main panel
        for (Component component : mainPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                button.setForeground(colorScheme.getButtonTextColor());
                button.setBackground(colorScheme.getButtonColor());
            }
        }
    }

    // Main method to start the application
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }

        // Create an instance of the HomePage class
        SwingUtilities.invokeLater(() -> {
            new HomePage();
        });
    }
}
