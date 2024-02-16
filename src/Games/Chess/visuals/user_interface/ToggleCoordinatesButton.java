package visuals.user_interface;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToggleButton;

public class ToggleCoordinatesButton extends JToggleButton {
    
    public ToggleCoordinatesButton() {

        setText("<html><center>Toggle<br>Coordinates</center></html>");
        Font font = new Font("Roboto", Font.BOLD, 20);
        setFont(font);
        setBorderPainted(false);
        setFocusPainted(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSelected()) {
                    Board.toggleCoordinates(true);
                }
                else {
                    Board.toggleCoordinates(false);
                }
            }
        });

    }

}
