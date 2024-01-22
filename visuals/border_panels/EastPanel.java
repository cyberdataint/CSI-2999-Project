package visuals.border_panels;

import javax.swing.*;
import java.awt.*;

import visuals.Screen;
import visuals.user_interface.*;

public class EastPanel extends JPanel {

    private static JPanel settingsPanel;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color lightShadowColor = new Color(140, 170, 140);
    private static Color lightColor = new Color(220, 250, 220);
    private static Color darkShadowColor = new Color(60, 70, 60);
    // private static Color textColor = new Color(255, 240, 240);

    public EastPanel() {

        setBackground(backgroundColor);
        setLayout(new BorderLayout(Screen.scaleVar25, Screen.scaleVar25));

        settingsPanel = new JPanel();

        // SETTINGS PANEL
            // SETINGS PANEL SETTINGS
            settingsPanel.setPreferredSize(new Dimension(Screen.scaleVar300, 50));
            settingsPanel.setBackground(shadowColor);

            settingsPanel.setLayout(new BorderLayout());
            settingsPanel.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20, Screen.scaleVar20));

            // SETTINGS SHADOW SETTINGS
            JPanel settingsShadow = new JPanel();
            settingsShadow.setBackground(darkShadowColor);
            settingsShadow.setLayout(new BorderLayout());
            settingsShadow.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar10, Screen.scaleVar10, Screen.scaleVar10, Screen.scaleVar10));

            // LIGHT SHADOW SETTINGS
            JPanel lightShadow = new JPanel();
            lightShadow.setBackground(lightShadowColor);
            lightShadow.setLayout(new GridLayout(0, 1, Screen.scaleVar10, Screen.scaleVar10));
            lightShadow.setBorder(BorderFactory.createEmptyBorder(Screen.scaleVar10, Screen.scaleVar10, Screen.scaleVar10, Screen.scaleVar10));

            // PRESET MENU PANEL
                // PRESET MENU PANEL SETTINGS
                PresetsMenu presetsMenu = new PresetsMenu();
                presetsMenu.setPreferredSize(new Dimension(50, Screen.scaleVar25));
                presetsMenu.setBackground(lightColor);

                // .ADD CALL
                lightShadow.add(presetsMenu);
            // -------------

            // SIZE PRESET SELECTOR PANEL
                // SIZE PRESET SELECTOR SETTINGS
                SizePresetSelector sizePresetSelector = new SizePresetSelector();
                sizePresetSelector.setBackground(lightColor);
                sizePresetSelector.setPreferredSize(new Dimension(50, Screen.scaleVar25));

                // .ADD CALLS
                lightShadow.add(sizePresetSelector);
            // -------------

            // .ADD CALLS
            settingsShadow.add(lightShadow);
            settingsPanel.add(settingsShadow);
            add(settingsPanel);
        // -------------

    }
    
}
