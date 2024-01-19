import javax.swing.*;
import java.awt.*;

public class Screen extends JFrame {

    Board board;
    PresetsMenu presetsMenu;

    public Screen() {

        setTitle("Offline Chess Simulator");
        setMinimumSize(new Dimension(1000, 875));
        getContentPane().setBackground(new Color(132, 136, 132));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // DON'T FORGET!! ACCOUNT FOR MARGIN!!
        setLayout(new BorderLayout(10, 10));
    
        // CENTER PANELS
        board = new Board();
        board.setPreferredSize(new Dimension(500, 500));
        add(board, BorderLayout.CENTER);

        // EAST PANELS
        presetsMenu = new PresetsMenu();
        presetsMenu.setPreferredSize(new Dimension(190, 90));
        add(presetsMenu, BorderLayout.EAST);

        // WEST PANELS
        presetsMenu = new PresetsMenu();
        presetsMenu.setPreferredSize(new Dimension(190, 90));
        add(presetsMenu, BorderLayout.WEST);

        // NORTH PANELS
        presetsMenu = new PresetsMenu();
        presetsMenu.setPreferredSize(new Dimension(190, 90));
        add(presetsMenu, BorderLayout.NORTH);

        // SOUTH PANELS
        presetsMenu = new PresetsMenu();
        presetsMenu.setPreferredSize(new Dimension(190, 115));
        add(presetsMenu, BorderLayout.SOUTH);

        pack();
        setVisible(true);

    }

}
