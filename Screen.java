import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    private static Container contentPane;

    public Screen() {

        Board board = new Board();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(board);

        PresetsMenu presetMenu = new PresetsMenu();
        add(presetMenu);

        setTitle("Offline Chess Simulator");
        setMinimumSize(new Dimension(800, 800));
        changeColor(new Color(132, 136, 132));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

    public static void changeColor(Color backgroundColor) {

        if(contentPane != null) {
            contentPane.setBackground(backgroundColor);
            contentPane.repaint();
        }

    }

    public Container getContentPane() {

        contentPane = super.getContentPane();
        return contentPane;

    }

}
