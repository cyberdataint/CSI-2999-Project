import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class Screen extends JFrame {
    
    private Board board;

    public Screen() {

        board = new Board();
        setLayout(new FlowLayout(FlowLayout.CENTER));
        add(board);

        setTitle("Offline Chess Simulator");
        setExtendedState(Screen.MAXIMIZED_BOTH);
        setMinimumSize(new Dimension(800, 800));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        addComponentListener(new ComponentAdapter() {

            public void componentResized(ComponentEvent e) {

                centerPanel();

            }    
        });


        setVisible(true);

    }

    private void centerPanel() {

        Dimension screenSize = getSize();
        Dimension boardSize = board.getPreferredSize();

        int x = (screenSize.width - boardSize.width) / 2;
        int y = (screenSize.height - boardSize.height) / 2;

        board.setBounds(x, y, boardSize.width, boardSize.height);

    }



}
