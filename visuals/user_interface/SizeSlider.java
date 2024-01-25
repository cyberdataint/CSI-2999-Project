package visuals.user_interface;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import visuals.Screen;

public class SizeSlider extends JPanel {
    
    public SizeSlider() {

        setLayout(new GridLayout(2, 1));

        JSlider sizeSlider = new JSlider();
        JLabel label = new JLabel("Size Presets:", SwingConstants.CENTER);
        Color lightColor = new Color(220, 250, 220);

        sizeSlider.setMinimum(1);
        sizeSlider.setMaximum(2);
        sizeSlider.setValue(2);
        sizeSlider.setMajorTickSpacing(1);
        sizeSlider.setPaintTicks(true);
        sizeSlider.setPaintLabels(true);
        sizeSlider.setSnapToTicks(true);
        sizeSlider.setBackground(lightColor);

        sizeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {

                int value = sizeSlider.getValue();
                // Screen.changeSize(value);

            }
        });

        add(label);
        add(sizeSlider);

    } 

}
