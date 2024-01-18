import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    private static Screen currentFrame;

    public Screen() {

        currentFrame = this;

        Board board = new Board();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(board);

        PresetsMenu presetMenu = new PresetsMenu();
        add(presetMenu);

        setTitle("Offline Chess Simulator");
        setExtendedState(Screen.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 800));
        changeColor(new Color(132, 136, 132));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

    public static void changeColor(Color backgroundColor) {

        if (currentFrame != null) {
            currentFrame.getContentPane().setBackground(backgroundColor);
            currentFrame.repaint();
        }
        else {
            System.out.println("Error 404: Frame not found");
        }

    }

}
