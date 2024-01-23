package visuals.border_panels;

import javax.swing.*;
import java.awt.*;

import visuals.user_interface.Board;

public class CenterPanel extends JPanel {

    public CenterPanel() {

        Color shadowColor = new Color(90, 100, 90);
        Color darkShadowColor = new Color(60, 70, 60);

        setBackground(shadowColor);
        setLayout(new BorderLayout());
        setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel boardShadow = new JPanel();
        boardShadow.setBackground(darkShadowColor);
        boardShadow.setLayout(new BorderLayout());
        boardShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        Board board = new Board();
        board.setBackground(darkShadowColor);

        boardShadow.add(board);
        add(boardShadow, BorderLayout.CENTER);

    }
    
}
