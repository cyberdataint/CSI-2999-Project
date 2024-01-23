package visuals.user_interface;

import javax.swing.*;

import visuals.Screen;

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

    // Marine Color Preset
    private Color lightMarine = new Color(157, 172, 255);
    private Color darkMarine = new Color(111, 115, 210);

    // Wheat Color Preset
    private Color lightWheat = new Color(234, 240, 206);
    private Color darkWheat = new Color(187, 190, 100);

    // Emerald Color Preset
    private Color lightEmerald = new Color(173, 189, 143);
    private Color darkEmerald = new Color(111, 143, 114);

    // Sandcastle Color Preset
    private Color lightSandcastle = new Color(227, 193, 111);
    private Color darkSandcastle = new Color(184, 139, 74);

    public PresetsMenu() {

        JLabel label = new JLabel("Color Presets:");
        String[] presets = {"Coral", "Dusk", "Marine", "Wheat", "Emerald", "Sandcastle"};
        dropDown = new JComboBox<>(presets);

        setLayout(new GridLayout(1, 2, 5, 5));
        setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
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

        switch (selectedPreset) {
            case "Coral":
                Board.changeColor(lightCoral, darkCoral);
                break;
            case "Dusk":
                Board.changeColor(lightDusk, darkDusk);
                break;
            case "Marine":
                Board.changeColor(lightMarine, darkMarine);
                break;
            case "Wheat":
                Board.changeColor(lightWheat, darkWheat);
                break;
            case "Emerald":
                Board.changeColor(lightEmerald, darkEmerald);
                break;
            case "Sandcastle":
                Board.changeColor(lightSandcastle, darkSandcastle);
                break;
            default:
                break;
        }
        
    }

}
