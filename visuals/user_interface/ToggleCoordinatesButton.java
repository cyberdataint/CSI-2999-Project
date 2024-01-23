package visuals.user_interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToggleCoordinatesButton extends JToggleButton {
    
    public ToggleCoordinatesButton() {

        setText("Toggle Coordinates");
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
