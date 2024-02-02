package visuals.user_interface;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ReturnToMainMenuButton extends JButton {
    
    public ReturnToMainMenuButton(String text) {

        setText(text);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                // implement
        
            }
        });

    }

}