package visuals.user_interface;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import visuals.Screen;

public class SizeToggle extends JToggleButton {
    
    public SizeToggle() {

        setText("<html><center>Set Large</center></html>");
        Font font = new Font("Roboto", Font.BOLD, 20);
        setFont(font);
        setBorderPainted(false);
        setFocusPainted(false);

        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isSelected()) {
                    Screen.changeSize(true);
                    setText("<html><center>Set Small</center></html>");
                }
                else {
                    Screen.changeSize(false);
                    setText("<html><center>Set Large</center></html>");
                }
            }
        });

    } 

}
