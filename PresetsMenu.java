import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PresetsMenu extends JPanel {
    
    private JComboBox<String> dropDown;

    // Standard Color Preset
    private Color lightCoral = new Color(177, 228, 185);
    private Color darkCoral = new Color(112, 162, 163);
    private Color smoke = new Color(132, 136, 132);

    // Nonstandard Color Preset
    private Color lightDusk = new Color(204, 183, 174);
    private Color darkDusk = new Color(112, 102, 119);
    private Color sageGreen = new Color(138, 154, 91);

    public PresetsMenu() {

        String[] presets = {"Standard", "Nonstandard"};
        dropDown = new JComboBox<>(presets);
        
        dropDown.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String selected = (String) dropDown.getSelectedItem();
                performAction(selected);

            }

        });

        add(dropDown);

    }


    private void performAction(String selectedPreset) {

        if ("Default".equals(selectedPreset)) {

            Board.changeColor(lightCoral, darkCoral);
            Screen.changeColor(smoke);
            
        }
        else if ("Alternative".equals(selectedPreset)) {

            Board.changeColor(lightDusk, darkDusk);
            Screen.changeColor(sageGreen);

        }

    }

}
