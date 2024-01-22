package visuals.user_interface;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visuals.border_panels.NorthPanel;

public class EndTurnButton extends JButton {
    
    public EndTurnButton(String text) {

        setText(text);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
        
                NorthPanel.restartTurnTimer();
        
            }
        });

    }

}
