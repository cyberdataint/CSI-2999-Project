package Games.Chess.Visuals.border_panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import Games.Chess.Visuals.user_interface.PresetsMenu;
import Games.Chess.Visuals.user_interface.ToggleCoordinatesButton;

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
    
}
