package visuals.user_interface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresetsMenu extends JPanel {
    
    private JComboBox<String> dropDown;

    // Coral Color Preset
    private Color lightCoral = new Color(177, 228, 185);
    private Color darkCoral = new Color(112, 162, 163);

    // Dusk Color Preset
    private Color lightDusk = new Color(204, 183, 174);
    private Color darkDusk = new Color(112, 102, 119);

    public PresetsMenu() {

        JLabel label = new JLabel("Presets:");
        String[] presets = {"Coral", "Dusk"};
        dropDown = new JComboBox<>(presets);
        
        dropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selected = (String) dropDown.getSelectedItem();
                performAction(selected);

            }

        });

        add(label);
        add(dropDown);

    }


    private void performAction(String selectedPreset) {

        if ("Coral".equals(selectedPreset)) {

            Board.changeColor(lightCoral, darkCoral);
            
        }
        else if ("Dusk".equals(selectedPreset)) {

            Board.changeColor(lightDusk, darkDusk);

        }

    }

}
