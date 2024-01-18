import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Board extends JPanel {

    private static Color lightColor = new Color(177, 228, 185);
    private static Color darkColor = new Color(112, 162, 163);

    private static JButton[][] squares;
    
    public Board() {

        intializeBoard();

    }


    private void intializeBoard() {

        setLayout(new GridLayout(8, 8));
        setPreferredSize(new Dimension(400, 400));
        createChessBoard();

    }

    private void createChessBoard() {

        removeAll();

        for (int y = 0; y < 8; y++) {
            for (int x = 0; x < 8; x++) {

                JButton button = createChessButton(x, y);
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
        }
        else {
            button.setBackground(darkColor);
        }

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                System.out.println("(" + x + ", " + y + ")");

            }
        });

        return button;

    }


    public static void changeColor(Color newLightColor, Color newDarkColor) {

        lightColor = newLightColor;
        darkColor = newDarkColor;

        for(JButton[] y : squares) {
            for (JButton square : y) {

                square.setBackground((square.getBackground() == lightColor) ? lightColor : darkColor);

            }
        }

    }


}
