package Launcher;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class Home {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Directory");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null); // Center the frame

        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu helpMenu = new JMenu("Help");
        JMenuItem instructionsItem = new JMenuItem("Instructions");
        instructionsItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                        JOptionPane.showMessageDialog(frame, "BlackJack:\n" +
                                "1. Click on 'Offline BlackJack' button\n" +
                                "2. Follow the instructions in the console\n" +
                                "\n" +
                                "Chess:\n" +
                                "1. Click on 'Offline Chess' button\n" +
                                "2. Chess game uses normal Chess rules\n" +
                                "3. Develop with threats.\n" +
                                "4. Knights before Bishops.\n" +
                                "5. Don't move the same piece twice.\n" +
                                "6. Make as few pawn moves as possible in the opening.\n" +
                                "7. Don't bring out your Queen too early.\n" +
                                "8. Castle as soon as possible, preferably on the King side.\n" +
                                "9. Always play to gain control of the center.\n" +
                                "\n" +
                                "Godot Game:\n" +
                                "1. Click on 'Godot Game' button\n" +
                                "2. Arrow keys to move left and right\n" +
                                "3. Press space to jump\n" +
                                "4. Avoid obstacles by maneuvering between them\n" +
                                "5. Obstacles become harder as the game progresses" );
                    }
                });
                helpMenu.add(instructionsItem);
                menuBar.add(helpMenu);

        JPanel panel = new JPanel();
        frame.add(panel);
        placeComponents(panel);

        frame.setVisible(true);
    }

    private static void placeComponents(JPanel panel) {
        panel.setLayout(null);

        JButton swingButton = createGameButton("Offline BlackJack", "/path/to/Blackjack.exe");
        swingButton.setBounds(50, 20, 200, 20);
        panel.add(swingButton);

        JButton javafxButton = createGameButton("Offline Chess", "src/Games/Chess/visuals/Driver.java");
        javafxButton.setBounds(50, 60, 200, 20);
        panel.add(javafxButton);

        JButton godotButton = createGameButton("Godot Game", "src/Games/OfflineDinosaurGame/Offline Dinosaur Game.exe");
        godotButton.setBounds(50, 100, 200, 20);
        panel.add(godotButton);
    }

    private static JButton createGameButton(String gameName, String filePath) {
        JButton gameButton = new JButton(gameName);
        gameButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    if (filePath.endsWith(".java")) {

                        String directory = filePath.substring(0, filePath.lastIndexOf("/"));
                        String fileName = filePath.substring(filePath.lastIndexOf("/") + 1, filePath.lastIndexOf(".")); // Remove .java extension
                        ProcessBuilder pb = new ProcessBuilder("cmd.exe", "/c", "cd " + directory + " && javac " + fileName + ".java && java " + fileName);
                        pb.redirectErrorStream(true);
                        Process process = pb.start();
                        printStream(process.getInputStream());
                    } else if (filePath.endsWith(".exe")) {

                        ProcessBuilder pb = new ProcessBuilder(filePath);
                        pb.redirectErrorStream(true);
                        Process process = pb.start();
                        printStream(process.getInputStream());
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        return gameButton;
    }

    private static void printStream(InputStream input) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));
        String line;
        while ((line = reader.readLine()) != null) {
            System.out.println(line);
        }
    }
}
