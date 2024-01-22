package visuals.user_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import visuals.Screen;

public class SizePresetSelector extends JPanel {

    public SizePresetSelector() {

        JLabel label = new JLabel("Size Presets:", SwingConstants.CENTER);
        JButton smallButton = new JButton("Small");
        JButton largeButton = new JButton("Large");

        setLayout(new GridLayout(2, 1, Screen.scaleVar5, Screen.scaleVar5));
        setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar10, Screen.scaleVar10, Screen.scaleVar10, Screen.scaleVar10));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 0));
        buttonPanel.add(smallButton);
        buttonPanel.add(largeButton);

        add(label);
        add(buttonPanel);

        smallButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Screen.changeFrameDimensions(960, 800);

            }
        });

        largeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Screen.changeFrameDimensions(1500, 1250);

            }
        });

    }

}
