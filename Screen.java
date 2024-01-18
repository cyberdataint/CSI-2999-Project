import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    UserInterface ui;
    Board board;
    PresetsMenu presetsMenu;

    public Screen() {

        ui = new UserInterface();
        add(ui);
    
        board = new Board();
        // add(board);

        presetsMenu = new PresetsMenu();
        // add(presetsMenu);

        setTitle("Offline Chess Simulator");
        setMinimumSize(new Dimension(800, 800));
        setBackground(new Color(132, 136, 132));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);

    }

}
