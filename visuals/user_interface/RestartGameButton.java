package visuals.user_interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartGameButton extends JButton {
    
    public RestartGameButton(String text) {

        setText(text);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // implement

            }
        });

    }

}