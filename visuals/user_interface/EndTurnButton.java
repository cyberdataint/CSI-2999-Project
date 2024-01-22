package visuals.user_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visuals.border_panels.*;

public class EndTurnButton extends JButton {
    
    public EndTurnButton(String text) {

        Color lightShadowColor = new Color(140, 170, 140);
        Color lightColor = new Color(220, 250, 220);

        setText(text);

        SouthPanel.whitePanel.setBackground(lightColor);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                NorthPanel.restartTurnTimer();

                // if (!GameOver) {
                    if (SouthPanel.whitePanel.getBackground() == lightColor) {
                        SouthPanel.whitePanel.setBackground(lightShadowColor);
                        SouthPanel.blackPanel.setBackground(lightColor);
                    }
                    else {
                        SouthPanel.blackPanel.setBackground(lightShadowColor);
                        SouthPanel.whitePanel.setBackground(lightColor);
                    }
                // }
                // else {

                    // implement game restart
                    
                // }
        
            }
        });

    }

}
