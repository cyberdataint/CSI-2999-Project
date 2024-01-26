package visuals.user_interface;

import java.awt.*;
import javax.swing.*;

import InputHandling.HandleInput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import InputHandling.HandleInput;

public class Board extends JPanel {

    private static Color lightColor = new Color(177, 228, 185);
    private static Color darkColor = new Color(112, 162, 163);

    private static JButton[][] squares;
    
    public Board() {

        squares = new JButton[8][8];
        setBackground(new Color(132, 136, 132));
        createChessBoard();

    }


    private void createChessBoard() {

        setLayout(new GridLayout(8, 8));

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {

                JButton button = createChessButton(x, y);
                squares[x][y] = button;
                add(button);

            }
        }

        revalidate();
        repaint();

    }


    private JButton createChessButton(int x, int y) {

        JButton button = new JButton();
        
        if ((x + y) % 2 == 0) {
            button.setBackground(lightColor);
            button.setBorderPainted(false);
        }
        else {
            button.setBackground(darkColor);
            button.setBorderPainted(false);
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("(" + x + ", " + y + ")");

                HandleInput.handleButtonPress(x, y);

            }
        });

        return button;

    }


    public static void changeColor(Color newLightColor, Color newDarkColor) {

        lightColor = newLightColor;
        darkColor = newDarkColor;

        for(int y = 0; y < 8; y++) {
            for(int x = 0; x < 8; x++) {

                JButton square = squares[x][y];
                if ((x + y) % 2 == 0) {
                    square.setBackground(lightColor);
                }
                else {
                    square.setBackground(darkColor);
                }

            }
        }

    }


}
