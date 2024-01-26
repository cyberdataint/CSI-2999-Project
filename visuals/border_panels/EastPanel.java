package visuals.border_panels;

import javax.swing.*;
import java.awt.*;

import visuals.user_interface.*;

public class EastPanel extends JPanel {

    private static JPanel settingsPanel;
    private static JPanel settingsShadow;
    private static JPanel lightShadow;

    private static Color backgroundColor = new Color(132, 136, 132);
    private static Color shadowColor = new Color(90, 100, 90);
    private static Color lightShadowColor = new Color(140, 170, 140);
    private static Color lightColor = new Color(220, 250, 220);
    private static Color darkShadowColor = new Color(60, 70, 60);

    public EastPanel() {

        setBackground(backgroundColor);
        setLayout(new BorderLayout(25, 25));

        // SETTINGS PANEL
            // SETINGS PANEL SETTINGS
            settingsPanel = new JPanel();
            settingsPanel.setPreferredSize(new Dimension(300, 500));
            settingsPanel.setBackground(shadowColor);

            settingsPanel.setLayout(new BorderLayout());
            settingsPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

            // SETTINGS SHADOW SETTINGS
            settingsShadow = new JPanel();
            settingsShadow.setBackground(darkShadowColor);
            settingsShadow.setLayout(new BorderLayout());
            settingsShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // LIGHT SHADOW SETTINGS
            lightShadow = new JPanel();
            lightShadow.setBackground(lightShadowColor);
            lightShadow.setLayout(new GridLayout(0, 1, 10, 10));
            lightShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            // PRESET MENU
                // PRESET MENU SETTINGS
                PresetsMenu presetsMenu = new PresetsMenu();
                presetsMenu.setBackground(lightColor);

                // .ADD CALL
                lightShadow.add(presetsMenu);
            // -------------

            // SIZE SLIDER
                // SIZE SLIDER SETTINGS
                SizeToggle sizeSlider = new SizeToggle();
                sizeSlider.setBackground(lightColor);

                // .ADD CALL
                // lightShadow.add(sizeSlider);
            // -------------

            // TOGGLE COORDINATES BUTTON
                // TOGGLE COORDINATES BUTTON SETTINGS
                ToggleCoordinatesButton toggleCoordinatesButton = new ToggleCoordinatesButton();
                toggleCoordinatesButton.setBackground(lightColor);

                // .ADD CALL
                lightShadow.add(toggleCoordinatesButton);
            // -------------

            // .ADD CALLS
            settingsShadow.add(lightShadow);
            settingsPanel.add(settingsShadow);
            add(settingsPanel);
        // -------------

    }

    public void changeSize(boolean isToggled) {

        if (isToggled) {

            setLayout(new BorderLayout(25, 25));

            // settingsPanel.setPreferredSize(new Dimension(300, 500));
            settingsPanel.setSize(new Dimension(300, 500));
            settingsPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

            settingsShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            lightShadow.setLayout(new GridLayout(0, 1, 10, 40));
            lightShadow.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        }
        else {

            setLayout(new BorderLayout(20, 20));

            // settingsPanel.setPreferredSize(new Dimension(240, 400));
            settingsPanel.setSize(new Dimension(240, 400));
            settingsPanel.setBorder(BorderFactory.createEmptyBorder(16, 16, 16, 16));

            settingsShadow.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

            lightShadow.setLayout(new GridLayout(0, 1, 8, 32));
            lightShadow.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        }

    }
    
}
