package mechanics;

import java.awt.Color;

import visuals.border_panels.*;
import visuals.user_interface.*;

public class Game {

    private static Color lightColor = new Color(220, 250, 220);
    private static Color lightShadowColor = new Color(140, 170, 140);
    
    public Game() {

        // pass

    }

    public static void startGame() {

        // starts game clock, highlights turnindicator, places chess pieces, sends game start message in game log
        NorthPanel.gameTimer.start();
    
        SouthPanel.whitePanelTop.setBackground(lightColor);
        SouthPanel.whitePanelBottom.setBackground(lightColor);
    
        // Board.intializePieces();
    
        GameLog.textArea.append("[" + NorthPanel.gameClock.getText() + "] " + "Game Start!\n\n");
    
    }
    
    public static void restartGame() {
    
        // to be called by RestartGameButton
        // restarts game clock, highlights and clears TI, replaces chess pieces, send new game start message in GL
        NorthPanel.gameSecondsElapsed = -1;
        NorthPanel.gameTimer.restart();
    
        SouthPanel.whitePanelTop.setBackground(lightColor);
        SouthPanel.whitePanelBottom.setBackground(lightColor);
        SouthPanel.blackPanelTop.setBackground(lightShadowColor);
        SouthPanel.blackPanelBottom.setBackground(lightShadowColor);
    
        // Board.intializePieces();
    
        GameLog.textArea.append("\n\n[" + NorthPanel.gameClock.getText() + "] " + "New Game Start!\n\n\n");
        GameLog.textArea.setCaretPosition(GameLog.textArea.getDocument().getLength());;
    
    }

}
